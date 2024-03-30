<template>
  <div class="layout-logo-container" :class="{ collapse: props.collapse }">
    <transition name="layout-logo-fade">
      <router-link v-if="props.collapse" key="collapse" to="/">
        <img src="../../../public/logo/hey-cloud.svg" class="layout-logo" alt="none"/>
      </router-link>
      <router-link v-else key="expand" to="/">
        <img :src="activeThemeName==='dark' ? logoText1 : logoText2" class="layout-logo-text" alt="none"/>
      </router-link>
    </transition>
  </div>
</template>

<script setup>
import {storeToRefs} from 'pinia';
import {useSettingStore} from "@/store/modules/setting-store.js";

// 定义默认属性对象
const defaultProps = {
  collapse: true
};

// 使用withDefaults函数来设置默认属性，这个函数需要在Vue 3的Composition API中定义
const props = withDefaults(defineProps(defaultProps));

// 使用Pinia的状态管理库来获取settingsStore实例
const settingsStore = useSettingStore()
</script>

<style lang="scss" scoped>
.layout-logo-container {
  position: relative;
  width: 100%;
  height: var(--v3-header-height);
  line-height: var(--v3-header-height);
  background-color: transparent;
  text-align: center;
  overflow: hidden;

  .layout-logo {
    display: none;
  }

  .layout-logo-text {
    height: 60%;
    width: 60%;
    vertical-align: middle;
  }
}

.layout-mode-top {
  height: var(--v3-navigationbar-height);
  line-height: var(--v3-navigationbar-height);
}

.collapse {
  .layout-logo {
    width: 32px;
    height: 32px;
    vertical-align: middle;
    display: inline-block;
  }

  .layout-logo-text {
    display: none;
  }
}
</style>
