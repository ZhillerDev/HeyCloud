<template>
  <section class="app-main">
    <div class="app-scrollbar">
      <!-- key 采用 route.path 和 route.fullPath 有着不同的效果，大多数时候 path 更通用 -->
      <router-view v-slot="{ Component, route }">
        <transition name="fade-in" mode="out-in">
          <keep-alive>
            <component :is="Component" :key="route.path" class="app-container-grow"/>
          </keep-alive>
        </transition>
      </router-view>
<!--      <footer-bar/>-->
    </div>
    <!--    <back-to-top class="back-top"/>-->
  </section>
</template>

<script setup>
import FooterBar from './footer-bar/index.vue'
</script>

<style lang="scss" scoped>
@import "@a/styles/mixins";

.app-main {
  width: 100%;
  display: flex;
  padding: 5px 16px 5px 16px;
}

.app-scrollbar {
  flex-grow: 1;
  overflow: auto;
  @extend %scrollbar;
  display: flex;
  flex-direction: column;

  .app-container-grow {
    flex-grow: 1;
  }
}

.back-top {
  position: fixed;
  bottom: 20px;
  right: 20px;
  cursor: pointer;
}
</style>
