<template>
  <div class="app-wrapper">
    <!-- mobile 端侧边栏遮罩层 -->
    <side-bar class="sidebar-container"/>
    <div class="main-container" :style="isCollapse?'margin-left: var(--v3-sidebar-hide-width);':''">
      <div class="layout-header">
        <nav-bar/>
      </div>
      <app-main class="app-main"/>
    </div>
  </div>
</template>

<script setup>
import {AppMain, NavBar, SideBar} from "./structures/exp.js";
import {useSettingStore} from "@/store/modules/setting-store.js";
import {storeToRefs} from "pinia";
const settingStore = useSettingStore()

const {isCollapse} = storeToRefs(settingStore)
</script>

<style lang="scss" scoped>
@import "@a/styles/mixins.scss";

$transition-time: 0.35s;

.app-wrapper {
  @extend %clearfix;
  position: relative;
  width: 100%;
}

.drawer-bg {
  background-color: #000;
  opacity: 0.3;
  width: 100%;
  top: 0;
  height: 100%;
  position: absolute;
  z-index: 999;
}

.sidebar-container {
  transition: width $transition-time;
  background-color: white;
  height: 100vh;
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  z-index: 1001;
  overflow: hidden;
}

.main-container {
  min-height: 100%;
  transition: margin-left $transition-time;
  margin-left: var(--v3-sidebar-width);
  position: relative;
}

.fixed-header {
  position: fixed !important;
  top: 0;
  right: 0;
  z-index: 9;
  width: calc(100% - var(--v3-sidebar-width));
  transition: width $transition-time;
}

.layout-header {
  position: relative;
  z-index: 9;
  box-shadow: var(--el-box-shadow-lighter);
}

.app-main {
  min-height: calc(100vh - var(--v3-navigationbar-height));
  position: relative;
  overflow: hidden;
}

.fixed-header + .app-main {
  padding-top: var(--v3-navigationbar-height);
  height: 100vh;
  overflow: auto;
}

.hasTagsView {
  .app-main {
    min-height: calc(100vh - var(--v3-header-height));
  }

  .fixed-header + .app-main {
    padding-top: var(--v3-header-height);
  }
}

.hideSidebar {
  .sidebar-container {
    width: var(--v3-sidebar-hide-width) !important;
  }

  .main-container {
    margin-left: var(--v3-sidebar-hide-width);
  }

  .fixed-header {
    width: calc(100% - var(--v3-sidebar-hide-width));
  }
}

// 适配 mobile 端
.mobile {
  .sidebar-container {
    transition: transform $transition-time;
    width: var(--v3-sidebar-width) !important;
  }

  .main-container {
    margin-left: 0px;
  }

  .fixed-header {
    width: 100%;
  }

  &.openSidebar {
    position: fixed;
    top: 0;
  }

  &.hideSidebar {
    .sidebar-container {
      pointer-events: none;
      transition-duration: 0.3s;
      transform: translate3d(calc(0px - var(--v3-sidebar-width)), 0, 0);
    }
  }
}

.withoutAnimation {
  .sidebar-container,
  .main-container {
    transition: none;
  }
}
</style>
