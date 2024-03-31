// 用户store
import {useCommon} from "@/hooks/useCommon.js";
import {getLocal, removeToken} from "@/utils/token-utils.js";
import {resetRouter} from "@/router/config/helper-router.js";
import {defineStore} from "pinia"
import store from "@/store/index.js";
import {ref} from "vue"
import {CacheKey} from "@/domain/constants/app-key.js";

export const useUserStore = defineStore("user", () => {
  const token = ref(useCommon.getCookies("token") || "")
  const phone = ref(getLocal(CacheKey.Phone) !== null ? getLocal(CacheKey.Phone) : "")
  const isLogin = ref(false)

  const logout = () => {
    removeToken()
    token.value = ""
    isLogin.value = false
    resetRouter()
  }

  /** 重置 Token */
  const resetToken = () => {
    removeToken()
    token.value = ""
  }

  return {token, phone, isLogin, logout, resetToken}
})

/** 在 setup 外使用 */
export function useUserStoreHook() {
  return useUserStore(store)
}
