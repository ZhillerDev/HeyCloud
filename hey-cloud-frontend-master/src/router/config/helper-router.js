import {createWebHashHistory, createWebHistory} from "vue-router";
import {globalConfig} from "@/config/index.js";
import router from "@/router/index.js";

export const routeRule =
  globalConfig.routeHistory === "hash"
    ? createWebHashHistory(globalConfig.publicPath)
    : createWebHistory(globalConfig.publicPath)

export function resetRouter() {
  // 注意：所有动态路由路由必须带有 Name 属性，否则可能会不能完全重置干净
  try {
    router.getRoutes().forEach((route) => {
      const {name, meta} = route
      if (name && meta.roles?.length) {
        router.hasRoute(name) && router.removeRoute(name)
      }
    })
  } catch {
    // 强制刷新浏览器也行，只是交互体验不是很好
    window.location.reload()
  }
}
