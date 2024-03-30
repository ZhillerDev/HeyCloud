<template>
  <div class="userinfo-container">
    <t-dropdown :options="options" :min-column-width="88" trigger="hover">
      <t-avatar image="https://tdesign.gtimg.com/site/avatar.jpg"
                shape="round"/>
    </t-dropdown>
  </div>
</template>

<script setup>
import {useRouter} from "vue-router";
import {useUserStore} from "@/store/modules/user-store.js";
import {msgSuccess} from "@/utils/msg-utils.js";

const store = useUserStore()
const router = useRouter()

const options = [
  {content: '个人中心', value: 1},
  {content: '通知', value: 2, divider: true},
  {
    content: '退出登录', value: 3, onClick: () => {
      store.logout()
      router.push("/login")
      msgSuccess("成功退出登录！")
    },
    theme: "error"
  },
]
</script>

<style lang="scss" scoped>
.userinfo-container {
  margin-right: 10px;
}
</style>
