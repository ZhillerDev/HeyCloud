package io.zhiller.domain.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("userdetail")
public class UserDetail {
  private Long userId;
  private String location;
  private Integer available;
  private String info;
  private Integer sex;
  private String position;

  @TableField(fill = FieldFill.INSERT)
  private Date lastLoginTime;
  private Date registerTime;

  private String imageUrl; // 用户头像URL地址

}
