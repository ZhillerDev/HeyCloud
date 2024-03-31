package io.zhiller.infrastructure.service;

import com.baomidou.mybatisplus.extension.service.IService;

import io.zhiller.domain.user.User;

import java.util.List;

public interface IUserService extends IService<User> {
  List<User> getAllUsers();

  User getUser(String nameOrPhone);
}
