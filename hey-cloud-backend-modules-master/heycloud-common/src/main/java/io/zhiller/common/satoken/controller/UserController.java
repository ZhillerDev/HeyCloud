package io.zhiller.common.satoken.controller;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.zhiller.domain.user.dto.UserLoginDTO;
import io.zhiller.domain.user.dto.UserRegisterDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户鉴权", description = "用户登录鉴权与会话保持")
@RestController
@RequestMapping("/auth")
public class UserController {

  @Operation(summary = "登录请求")
  @PostMapping("login")
  public SaResult doLogin(@RequestBody UserLoginDTO loginDTO) {
    // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
    if ("zhillery".equals(loginDTO.getUsername()) && "12345678".equals(loginDTO.getPassword())) {
      if (loginDTO.isRemember())
        StpUtil.login(loginDTO.getUsername(), new SaLoginModel().setIsLastingCookie(true).setTimeout(2592000));
      else StpUtil.login(loginDTO.getUsername());
      SaTokenInfo info = StpUtil.getTokenInfo();
      return SaResult.data(info);
    }
    return SaResult.error();
  }

  @Operation(summary = "注销账户")
  @GetMapping("logout")
  public SaResult logout() {
    StpUtil.logout();
    return SaResult.ok();
  }

  @Operation(summary = "用户注册")
  @PostMapping("reg")
  public SaResult register(@RequestBody UserRegisterDto registerDto) {
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
