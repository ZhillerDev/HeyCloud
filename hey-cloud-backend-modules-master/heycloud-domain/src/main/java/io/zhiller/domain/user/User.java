package io.zhiller.domain.user;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class User {
  @TableId(type = IdType.AUTO)
  private Long id;
  @TableField("username")
  private String username;
  @TableField("phone")
  private String phone;
  private String password;
  private String role;
  private String permission;

  @TableField(value = "created_at", fill = FieldFill.INSERT)
  private Date createdTime;
  @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
  private Date updatedTime;
}
