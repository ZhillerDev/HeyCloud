package io.zhiller.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.zhiller.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IUserMapper extends BaseMapper<User> {
  @Select("select * from user where username=#{username}")
  User selectUserByName(String username);

  @Select("select * from user where phone=#{phone}")
  User selectUserByPhone(String phone);
}
