package io.zhiller.domain.file;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("fileextend")
public class FileExtend {
  private String fileExtendName;
  private String fileExtendDesc;
  private String fileExtendImgUrl;
}
