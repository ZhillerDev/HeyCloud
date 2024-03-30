<template>
  <div :class="{ 'has-logo': isCollapse }">
    <div class="menu-container">
      <t-menu
          default-value="3-2"
          expand-mutex
          :collapsed="isCollapse"
          width="220px"

      >
        <template #logo>
          <section style="cursor: pointer" @click="isCollapse=!isCollapse">
            <div v-if="!isCollapse" style="font-weight: bold; font-size: large;">
              HeyCloud
            </div>
            <img v-else width="32" :src="logo" alt="logo"/>
          </section>
        </template>
        <!--主操作区-->
        <t-submenu value="cloud">
          <template #icon>
            <t-icon name="cloud"/>
          </template>
          <template #title>
            <span>云盘空间</span>
          </template>
          <t-menu-item value="all">
            <template #icon>
              <t-icon name="app"/>
            </template>
            全部文件
          </t-menu-item>
          <t-menu-item value="doc">
            <template #icon>
              <t-icon name="file"/>
            </template>
            文档
          </t-menu-item>
          <t-menu-item value="pic">
            <template #icon>
              <t-icon name="image"/>
            </template>
            图片
          </t-menu-item>
          <t-menu-item value="etc">
            <template #icon>
              <t-icon name="round"/>
            </template>
            其他
          </t-menu-item>
        </t-submenu>

        <!--可操作区-->
        <t-menu-item value="transmit">
          <template #icon>
            <t-icon name="task"/>
          </template>
          传输任务
        </t-menu-item>
        <t-menu-item value="recovery">
          <template #icon>
            <t-icon name="delete"/>
          </template>
          回收站
        </t-menu-item>
        <t-menu-item value="share">
          <template #icon>
            <t-icon name="share"/>
          </template>
          我的分享
        </t-menu-item>

<!--        <template #operations>-->
<!--          <div style="height: 50px; background-color: #629dff">-->
<!--            存储空间-->
<!--          </div>-->
<!--        </template>-->
      </t-menu>
    </div>
  </div>
</template>

<script setup>
import {computed} from 'vue'
import {useRoute} from "vue-router";
import {storeToRefs} from 'pinia'
import SideLogo from "@/layouts/components/side-logo.vue";
import {useSettingStore} from "@/store/modules/setting-store.js";
import {logo} from "@/utils/image-map-utils.js";

const route = useRoute()
const settingStore = useSettingStore()

const {isCollapse} = storeToRefs(settingStore)
</script>

<style lang="scss" scoped>
%tip-line {
  &::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    background-color: var(--v3-sidebar-menu-tip-line-bg-color);
  }
}

.has-logo {
  display: flex;
  flex-direction: column;
}

.menu-container {
  width: 100%;
}
</style>
