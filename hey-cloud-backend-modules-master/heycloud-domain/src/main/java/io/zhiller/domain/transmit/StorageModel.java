package io.zhiller.domain.transmit;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("storage")
public class StorageModel {
  @TableId(type = IdType.AUTO)
  private Long storageId;
  private String userId;
  private Long storageSize;
  private Long totalStorageSize;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String modifyTime;
  private Long modifyUserId;
}
