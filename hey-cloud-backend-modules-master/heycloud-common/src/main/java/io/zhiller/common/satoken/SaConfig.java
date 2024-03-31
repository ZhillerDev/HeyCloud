package io.zhiller.common.satoken;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.json.JSONUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaConfig {

  /**
   * 注册 [Sa-Token全局过滤器]
   */
  @Bean
  public SaServletFilter getSaServletFilter() {
    String[] excludes = {
      // 静态资源访问，swagger3+knife4j
      "/swagger-resources/**",
      "/swagger-ui/**",
      "/webjars/**",
      "/v3/**",
      "/error",
      "/doc.html/**",
      "/favicon.ico",

      // 不拦截的测试接口
      "/test/**",
      "/minio/**"
    };

    return new SaServletFilter()

      // 指定 拦截路由 与 放行路由
      .addInclude("/**")
      .addExclude(excludes)

      // 认证函数: 每次请求执行
      .setAuth(obj -> {
        System.out.println("---------- 进入Sa-Token全局认证 -----------");

        // 登录认证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
        SaRouter.match("/**", "/auth/**", StpUtil::checkLogin);

        // 更多拦截处理方式，请参考“路由拦截式鉴权”章节 */
      })

      // 异常处理函数：每次认证函数发生异常时执行此函数
      .setError(e -> {
        // 设置响应头
        SaHolder.getResponse().setHeader("Content-Type", "application/json;charset=UTF-8");
        // 使用封装的 JSON 工具类转换数据格式
        return JSONUtil.toJsonStr(SaResult.error(e.getMessage()));
      })

      // 前置函数：在每次认证函数之前执行（BeforeAuth 不受 includeList 与 excludeList 的限制，所有请求都会进入）
      .setBeforeAuth(r -> {
        // ---------- 设置一些安全响应头 ----------
        SaHolder.getResponse()
          // 服务器名称
          .setServer("sa-server")
          // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
          .setHeader("X-Frame-Options", "SAMEORIGIN")
          // 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
          .setHeader("X-XSS-Protection", "1; mode=block")
          // 禁用浏览器内容嗅探
          .setHeader("X-Content-Type-Options", "nosniff")
        ;
      })
      ;
  }
}
