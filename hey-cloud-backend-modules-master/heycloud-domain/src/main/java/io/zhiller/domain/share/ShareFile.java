package io.zhiller.domain.share;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("sharefile")
public class ShareFile {
  @TableId(type = IdType.AUTO)
  private String shareFileId;
  private String shareBatchNum;
  private String userFileId;
  private String shareFilePath;
}
