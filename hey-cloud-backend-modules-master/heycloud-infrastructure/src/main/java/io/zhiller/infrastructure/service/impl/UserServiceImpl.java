package io.zhiller.infrastructure.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.zhiller.domain.user.User;
import io.zhiller.domain.utils.ValidateUtils;
import io.zhiller.infrastructure.mapper.IUserMapper;
import io.zhiller.infrastructure.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {
  @Autowired
  private IUserMapper userMapper;


  @Override
  public List<User> getAllUsers() {
    List<User> users = userMapper.selectList(new QueryWrapper<>());
    if (!users.isEmpty()) return users;
    else return new LinkedList<>();
  }

  @Override
  public User getUser(String nameOrPhone) {
    return ValidateUtils.isPhoneNumber(nameOrPhone) ?
      userMapper.selectUserByPhone(nameOrPhone) :
      userMapper.selectUserByName(nameOrPhone);
  }
}
