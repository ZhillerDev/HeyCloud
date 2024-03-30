<template>
  <div class="navigation-bar">
    <div class="left-menu">
      <storage-bar/>
    </div>
    <div class="right-menu">
      <user-info/>
      <screen-full/>
    </div>
  </div>
</template>

<script setup>

import UserInfo from "@/layouts/components/user-info.vue";
import ScreenFull from "@/layouts/components/screen-full.vue";
import StorageBar from "@/layouts/components/storage-bar.vue";
</script>

<style lang="scss" scoped>
.navigation-bar-big-icon {
  height: var(--v3-navigationbar-bigicon-height) !important;
}

.navigation-bar {
  height: var(--v3-navigationbar-height);
  overflow: hidden;
  //background: var(--v3-header-bg-color);
  display: flex;
  justify-content: space-between;

  .hamburger {
    display: flex;
    align-items: center;
    margin: 8px;
    cursor: pointer;
  }

  .breadcrumb {
    flex: 1;
    margin-left: 10px;
    // 参考 Bootstrap 的响应式设计将宽度设置为 576
    @media screen and (max-width: 576px) {
      display: none;
    }
  }

  .sidebar {
    flex: 1;
    // 设置 min-width 是为了让 Sidebar 里的 el-menu 宽度自适应
    min-width: 0;

    :deep(.el-menu) {
      background-color: transparent;
    }

    :deep(.el-sub-menu) {
      &.is-active {
        .el-sub-menu__title {
          color: var(--el-menu-active-color) !important;
        }
      }
    }
  }

  .left-menu {
    margin-left: 10px;
    height: 100%;
    display: flex;
    align-items: center;
    color: #606266;
  }

  .right-menu {
    margin-right: 10px;
    height: 100%;
    display: flex;
    align-items: center;
    color: #606266;

    .right-menu-item {
      padding: 0 10px;
      cursor: pointer;

      .right-menu-avatar {
        display: flex;
        align-items: center;

        .el-avatar {
          margin-right: 10px;
        }

        span {
          font-size: 16px;
        }
      }
    }
  }
}
</style>
