import router from "@/router/index.js";
import {getToken} from "@/utils/token-utils.js";
import {checkAuth} from "@r/auth.js";
import {msgError} from "@/utils/msg-utils.js";

router.beforeEach(async (to, from, next) => {
  console.log("开始路由拦截")
  const token = getToken()

  // 注册用户无需鉴权，直接让用户滚过去
  if (to.path === '/register') next()

  // 校验登录状态，需要判断token是否有效
  if (to.path === '/login') {
    if (token) {
      await checkAuth()
        .then(e=>{
          if(e.code===200) next({path: "/"})
          else {
            msgError("很抱歉您的token过期了，请重新登陆")
            next({path: "/login"})
          }
        })

    } else {
      next()
    }
  }

  if (!token) {
    // router.replace("/login")
    next("/login")
  }

  next()
})

router.afterEach(to => {
  console.log("结束路由拦截")
})
