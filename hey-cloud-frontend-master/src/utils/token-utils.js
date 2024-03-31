import {CacheKey} from "@/domain/constants/app-key.js";
import Cookies from "js-cookie";

export const getToken = () => {
  return localStorage.getItem(CacheKey.Token)
}
export const setToken = (token) => {
  localStorage.setItem(CacheKey.Token, token)
}
export const removeToken = () => {
  localStorage.removeItem(CacheKey.Token)
}
