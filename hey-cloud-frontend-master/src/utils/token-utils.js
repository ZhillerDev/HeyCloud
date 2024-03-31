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

export const setLocal = (type, item) => {
  localStorage.setItem(type, item)
}
export const getLocal = (type) => {
  return localStorage.getItem(type)
}
export const removeLocal = (type) => {
  localStorage.removeItem(type)
}
