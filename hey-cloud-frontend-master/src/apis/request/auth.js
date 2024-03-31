import {get, post} from "@/apis/http.js";

// 登录
export const login = (e) => get("/auth/login", e)
// 退出登录
export const logout = (e) => get("/auth/logout", e)
// 注册
export const register = (e) => post("/auth/register", e)
// 获取用户登录状态以及对应信息
export const checkAuthInfo = (e) => get("/auth/info", e)

