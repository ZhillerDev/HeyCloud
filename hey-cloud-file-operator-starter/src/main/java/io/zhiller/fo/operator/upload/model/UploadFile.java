package io.zhiller.fo.operator.upload.model;

import lombok.Data;

@Data
public class UploadFile {

  //切片上传相关参数
  private int chunkNumber;
  private long chunkSize;
  private int totalChunks;
  private String identifier;
  private long totalSize;
  private long currentChunkSize;
}
