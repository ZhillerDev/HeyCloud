package io.zhiller.fo.operator.upload.model;

import io.zhiller.fo.domain.constants.StorageTypeEnum;
import io.zhiller.fo.domain.constants.UploadStatusEnum;
import lombok.Data;

import java.awt.image.BufferedImage;

@Data
public class UploadFileResult {
  private String fileName;
  private String extendName;
  private long fileSize;
  private String fileUrl;
  private String identifier;
  private StorageTypeEnum storageType;
  private UploadStatusEnum status;
  private BufferedImage bufferedImage;

}
