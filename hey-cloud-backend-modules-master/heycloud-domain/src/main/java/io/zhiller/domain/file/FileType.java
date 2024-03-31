package io.zhiller.domain.file;

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
@TableName("filetype")
public class FileType {
  @TableId(type = IdType.AUTO)
  private Integer fileTypeId;
  private String fileTypeName;
  private Integer orderNum;
}
