package io.zhiller.common.satoken.filter;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class StpImpl implements StpInterface {
  @Override
  public List<String> getPermissionList(Object o, String s) {
    return new LinkedList<String>() {{
      add("ADD");
    }};
  }

  @Override
  public List<String> getRoleList(Object o, String s) {
    return new LinkedList<String>() {{
      add("ROLE_ADMIN");
    }};
  }
}
