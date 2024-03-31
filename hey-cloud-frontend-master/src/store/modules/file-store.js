// 用户store
import {useCommon} from "@/hooks/useCommon.js";
import {removeToken} from "@/utils/token-utils.js";
import {resetRouter} from "@/router/config/helper-router.js";
import {defineStore} from "pinia"
import store from "@/store/index.js";
import {ref} from "vue"
import {getStorage} from "@r/file.js";

export const useFileStore = defineStore("file", () => {
  const storage = ref(0)
  const maxStorage = ref(0)

  const showStorage = () => {
    getStorage()
      .then(e=>{

      })
  }

  return {storage}
})

/** 在 setup 外使用 */
export function useFileStoreHook() {
  return useFileStoreHook(store)
}
