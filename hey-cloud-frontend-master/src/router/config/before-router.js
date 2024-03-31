import router from "@/router/index.js";
import {getToken} from "@/utils/token-utils.js";

router.beforeEach(async (to, from, next) => {
  console.log("开始路由拦截")
  const token = getToken()

  if (to.path === '/login') {
    if (token) {
      next({path: "/"})
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
