// 用户store
import {useCommon} from "@/hooks/useCommon.js";
import {removeToken} from "@/utils/token-utils.js";
import {resetRouter} from "@/router/config/helper-router.js";
import {defineStore} from "pinia"
import store from "@/store/index.js";
import {ref} from "vue"
import {getStorage} from "@r/file.js";
import {convertBitToMb} from "@/utils/file-utils.js";

export const useFileStore = defineStore("file", () => {
  const storage = ref(0)
  const maxStorage = ref(100)

  const showStorage = (userId) => {
    getStorage({"userId": userId})
      .then(e => {
        console.log(e)
        storage.value = convertBitToMb(e.data)
      })
  }

  return {storage, maxStorage, showStorage}
})

/** 在 setup 外使用 */
export function useFileStoreHook() {
  return useFileStoreHook(store)
}
