<template>
  <div>
    <side-logo />
  </div>
</template>

<script setup>
import {computed} from 'vue'
import {useRoute} from "vue-router";
import {storeToRefs} from 'pinia'
import SideLogo from "@/layouts/components/side-logo.vue";
import {useSettingStore} from "@/store/modules/setting-store.js";

const route = useRoute()
const settingStore = useSettingStore()

const {isCollapse} = storeToRefs(settingStore)
</script>

<style lang="less" scoped>

</style>
