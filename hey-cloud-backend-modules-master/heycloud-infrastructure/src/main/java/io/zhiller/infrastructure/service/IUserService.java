package io.zhiller.infrastructure.service;

import com.baomidou.mybatisplus.extension.service.IService;

import io.zhiller.domain.user.User;
import io.zhiller.infrastructure.constants.common.AjaxResult;

public interface IUserService extends IService<User> {
  AjaxResult getAllUsers();
}
