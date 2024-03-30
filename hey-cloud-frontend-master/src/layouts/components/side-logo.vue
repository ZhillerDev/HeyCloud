<template>
  <div class="layout-logo-container" :class="{ collapse: isCollapse }" @click="isCollapse=!isCollapse">
    <transition name="layout-logo-fade">
      <router-link v-if="isCollapse" key="collapse" to="/">
        <img src="../../../public/logo/hey-cloud.svg" class="layout-logo" alt="none"/>
      </router-link>
      <router-link v-else key="expand" to="/">
        <div class="font-bold">
          HeyCloud
        </div>
      </router-link>
    </transition>
  </div>
</template>

<script setup>
import {ref} from "vue";
import {useSettingStore} from "@/store/modules/setting-store.js";
import {storeToRefs} from "pinia";

const settingStore = useSettingStore()

const {isCollapse} = storeToRefs(settingStore)

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
