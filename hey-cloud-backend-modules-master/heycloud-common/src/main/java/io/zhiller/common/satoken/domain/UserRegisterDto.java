package io.zhiller.common.satoken.domain;

import lombok.Data;

@Data
public class UserRegisterDto {
  private String username;
  private String phone;
  private String password;
  private String code;
}
