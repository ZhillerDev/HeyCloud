package io.zhiller.domain.share.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "分享文件保存DTO")
public class ShareFIleSaveDTO {
  @Schema(description = "用户文件id集合", required = true)
  private String userFileIds;
  @Schema(description = "文件路径", required = true)
  private String filePath;
  @Schema(description = "分享批次号", required = true)
  private String shareBatchNum;
}
