import {ref} from "vue"
import store from "@/store/index.js";
import {defineStore} from "pinia"

// 网站设置store
export const useSettingStore = defineStore("setting", () => {
  const isCollapse = ref(false)

  return {isCollapse}
})

/** 在 setup 外使用 */
export function useSettingStoreHook() {
  return useSettingStore(store)
}
