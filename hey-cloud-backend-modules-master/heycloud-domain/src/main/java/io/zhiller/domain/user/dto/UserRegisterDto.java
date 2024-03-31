package io.zhiller.domain.user.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
  private String username;
  private String phone;
  private String password;
}
