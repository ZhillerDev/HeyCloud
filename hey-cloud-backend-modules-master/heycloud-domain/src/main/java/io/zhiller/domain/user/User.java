package io.zhiller.domain.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("user")
public class User {
  @TableId
  private Long id;
  private String username;
  private String phone;
  private String password;
  private String role;
  private String permission;

  @TableField("created_at")
  private Date createdTime;
  @TableField("updated_at")
  private Date updatedTime;
}
