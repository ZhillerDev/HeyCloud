package io.zhiller.common.satoken.session;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.SaSessionCustomUtil;
import org.springframework.stereotype.Component;

@Component
public class UserSession {
  public void setUserSession(Long userId, String token) {
    SaSession saSession = SaSessionCustomUtil.getSessionById(token);
    saSession.set("userId", String.valueOf(userId));
  }

  public Long getUserIdBySession(String token) {
    SaSession saSession = SaSessionCustomUtil.getSessionById(token);
    return Long.parseLong((String) saSession.get("userId"));
  }
}
