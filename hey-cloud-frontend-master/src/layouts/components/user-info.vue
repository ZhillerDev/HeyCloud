<template>
  <div>

  </div>
</template>

<script setup>
import {useRouter} from "vue-router";
import {useUserStore} from "@/store/modules/user-store.js";

const store = useUserStore()
const router = useRouter()

const options = [
  {content: '个人中心', value: 1},
  {content: '通知', value: 2, divider: true},
  {
    content: '注销账户', value: 3, onClick: () => {
      store.logout()
      router.push("/login")
    }
  },
]
</script>

<style lang="scss" scoped>

</style>
