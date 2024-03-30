import {CacheKey} from "@/domain/constants/app-key.js";
import Cookies from "js-cookie";

export const getToken = () => {
  return Cookies.get(CacheKey.Token)
}
export const setToken = (token) => {
  Cookies.set(CacheKey.Token, token)
}
export const removeToken = () => {
  Cookies.remove(CacheKey.Token)
}
