package io.zhiller.domain.share;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("share")
public class Share {
  @TableId(type = IdType.AUTO)
  private String shareId;
  private String userId;
  private String shareTime;
  private String endTime;
  private String extractionCode;
  private String shareBatchNum;
  private Integer shareType;
  private Integer shareStatus;
}
