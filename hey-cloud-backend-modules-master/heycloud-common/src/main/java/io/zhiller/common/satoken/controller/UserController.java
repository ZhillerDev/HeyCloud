package io.zhiller.common.satoken.controller;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.zhiller.domain.user.User;
import io.zhiller.domain.user.dto.UserLoginDTO;
import io.zhiller.domain.user.dto.UserRegisterDto;
import io.zhiller.infrastructure.mapper.IUserMapper;
import io.zhiller.infrastructure.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户鉴权", description = "用户登录鉴权与会话保持")
@RestController
@RequestMapping("/auth")
public class UserController {

  @Autowired
  private IUserService userService;
//  @Autowired
//  private IUserMapper userMapper;

  @Operation(summary = "登录请求")
  @PostMapping("login")
  public SaResult doLogin(@RequestBody UserLoginDTO loginDTO) {
    User user = userService.getUser(loginDTO.getUsername());
    if (user == null) return SaResult.error();
    if (!loginDTO.getPassword().equals(user.getPassword())) return SaResult.error();

    if (loginDTO.isRemember())
      StpUtil.login(loginDTO.getUsername(), new SaLoginModel().setIsLastingCookie(true).setTimeout(2592000));
    else StpUtil.login(loginDTO.getUsername());
    SaTokenInfo info = StpUtil.getTokenInfo();
    return SaResult.data(info);
  }

  @Operation(summary = "注销账户")
  @GetMapping("logout")
  public SaResult logout() {
    StpUtil.logout();
    return SaResult.ok();
  }

  @Operation(summary = "用户注册")
  @PostMapping("register")
  public SaResult register(@RequestBody UserRegisterDto registerDto) {
    if (userService.getUser(registerDto.getPhone()) != null) return SaResult.error();
    User user = new User();
    BeanUtils.copyProperties(registerDto, user);
    user.setRole("GUEST");
    if (!userService.save(user)) return SaResult.error();
    return SaResult.ok();
  }


  @Operation(summary = "校验账户角色与权限")
  @GetMapping("check")
  public SaResult checkUser(String username) {
    if (StpUtil.isLogin(username)) {
      List<String> permissionList = StpUtil.getPermissionList(username);
      List<String> roleList = StpUtil.getRoleList(username);
      System.out.println(permissionList);
      System.out.println(roleList);
      return SaResult.ok(permissionList.toString() + roleList.toString());
    }
    return SaResult.error("用户未登录");
  }

  @Operation(summary = "校验用户是否登录")
  @GetMapping("isLogin")
  public String isLogin() {
    return "当前会话是否登录：" + StpUtil.isLogin();
  }
}
