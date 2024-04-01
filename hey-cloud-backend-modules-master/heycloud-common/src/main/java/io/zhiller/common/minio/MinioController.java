package io.zhiller.common.minio;

import io.minio.Result;
import io.minio.messages.Item;
import io.zhiller.basic.constants.common.AjaxResult;
import io.zhiller.basic.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/minio")
public class MinioController {

  @Autowired
  private MinioUtils minioUtils;

  @Autowired
  private MinioProperties minioProperties;

  /**
   * 文件上传
   *
   * @param file
   */
  @PostMapping("/upload")
  public String upload(@RequestParam("file") MultipartFile file) {
    try {

      //文件名
      String fileName = file.getOriginalFilename();
      String newFileName = System.currentTimeMillis() + "." + StringUtils.substringAfterLast(fileName, ".");
      //类型
      String contentType = file.getContentType();
      minioUtils.uploadFile(minioProperties.getBucketName(), file, newFileName, contentType);
      return "上传成功";
    } catch (Exception e) {
      log.error("上传失败");
      return "上传失败";
    }
  }

  @GetMapping("/details")
  public AjaxResult getDetails(@RequestParam String userId) {
    Map<Long, MinioDto> map = new HashMap<>();
    LinkedList<Result<Item>> results = minioUtils.listObjects(minioProperties.getBucketName(), userId + "/", false);
    results.forEach(e -> {
      try {
        Item item = e.get();
        map.put(
          item.size(),
          MinioDto.builder()
            .fileName(FileUtils.getFileName(item.objectName()))
            .fileExtension(FileUtils.getFileExtension(item.objectName()))
            .fileSize(item.size()).build()
        );
      } catch (Exception exception) {
        exception.printStackTrace();
      }
    });
    return AjaxResult.success(map);
  }

  /**
   * 删除
   *
   * @param fileName
   */
  @DeleteMapping("/")
  public void delete(@RequestParam("fileName") String fileName) {
    minioUtils.removeFile(minioProperties.getBucketName(), fileName);
  }

  /**
   * 获取文件信息
   *
   * @param fileName
   * @return
   */
  @GetMapping("/info")
  public String getFileStatusInfo(@RequestParam("fileName") String fileName) {
    return minioUtils.getFileStatusInfo(minioProperties.getBucketName(), fileName);
  }

  /**
   * 获取文件外链
   *
   * @param fileName
   * @return
   */
  @GetMapping("/url")
  public String getPresignedObjectUrl(@RequestParam("fileName") String fileName) {
    return minioUtils.getPresignedObjectUrl(minioProperties.getBucketName(), fileName);
  }

  /**
   * 文件下载
   *
   * @param fileName
   * @param response
   */
  @GetMapping("/download")
  public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
    try {
      InputStream fileInputStream = minioUtils.getObject(minioProperties.getBucketName(), fileName);
      response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
      response.setContentType("application/force-download");
      response.setCharacterEncoding("UTF-8");
      IOUtils.copy(fileInputStream, response.getOutputStream());
    } catch (Exception e) {
      log.error("下载失败");
    }
  }

  @GetMapping("/storage")
  public AjaxResult getAllStorage(@RequestParam String userId) {
    Long storage = minioUtils.getUserFolderStorage(userId);
    return AjaxResult.success(storage);
  }

  @GetMapping("/delete")
  public AjaxResult removeObject(@RequestParam String fileName) {
    minioUtils.removeFile(minioProperties.getBucketName(), fileName);
    return AjaxResult.success();
  }

}
