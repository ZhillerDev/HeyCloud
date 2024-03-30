import {createWebHashHistory, createWebHistory} from "vue-router";
import {globalConfig} from "@/config/index.js";

export const routeRule =
  globalConfig.routeHistory === "hash"
    ? createWebHashHistory(globalConfig.publicPath)
    : createWebHistory(globalConfig.publicPath)
