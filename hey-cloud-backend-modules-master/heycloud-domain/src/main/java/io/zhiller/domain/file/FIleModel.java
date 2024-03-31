package io.zhiller.domain.file;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("file")
public class FIleModel {
  @TableId(type = IdType.AUTO)
  private String fileId;
  private String fileUrl;
  private Long fileSize;
  private Integer fileStatus;
  private Integer storageType;
  private String identifier;
  @TableField(fill = FieldFill.INSERT)
  private String createTime;
  private String createUserId;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String modifyTime;
  private String modifyUserId;
}
