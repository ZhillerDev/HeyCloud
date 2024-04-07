package io.zhiller.domain.file;

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
@TableName("fileclassification")
public class FIleClassification {
  @TableId(type = IdType.AUTO)
  private Long fileClassificationId;
  private Integer fileTypeId;
  private String fileExtendName;
}
