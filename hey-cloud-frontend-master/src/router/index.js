import {createRouter, createWebHashHistory, createWebHistory} from "vue-router";
import {staticRoutes} from "@/router/static-routes.js";
import {globalConfig} from "@/config/index.js";

const routeRule =
  globalConfig.routeHistory === "hash"
    ? createWebHashHistory(globalConfig.publicPath)
    : createWebHistory(globalConfig.publicPath)

const router = createRouter({
  routes: staticRoutes,
  history: routeRule,
})

export default router
