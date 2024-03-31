// 用户store
import {useCommon} from "@/hooks/useCommon.js";
import {removeToken} from "@/utils/token-utils.js";
import {resetRouter} from "@/router/config/helper-router.js";
import {defineStore} from "pinia"
import store from "@/store/index.js";
import {ref} from "vue"

export const useUserStore = defineStore("user", () => {
  const token = ref(useCommon.getCookies("token") || "")
  const userInfo = ref({})
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

  return {token, userInfo, isLogin, logout, resetToken}
})

/** 在 setup 外使用 */
export function useUserStoreHook() {
  return useUserStore(store)
}
