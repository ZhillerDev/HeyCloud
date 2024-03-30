<template>
  <div class="screen-container">
    <t-tooltip
        placement="bottom"
        :content="fullscreenTips"
    >
      <t-button theme="default" variant="text" shape="square" @click="handleFullscreenClick">
        <icon :name="fullscreenSvgName" size="medium"/>
      </t-button>
    </t-tooltip>
  </div>
</template>

<script setup>
import {computed, ref, watchEffect} from "vue"
import screenfull from "screenfull"
import { Icon } from 'tdesign-icons-vue-next';

const props =  {
  element: "html",
  openTips: "全屏",
  exitTips: "退出全屏",
  content: false
}

//#region 全屏
const isFullscreen = ref(false)
const fullscreenTips = computed(() => {
  return isFullscreen.value ? props.exitTips : props.openTips
})
const fullscreenSvgName = computed(() => {
  return isFullscreen.value ? "fullscreen-exit-1" : "fullscreen-1"
})

const handleFullscreenClick = () => {
  const dom = document.querySelector(props.element) || undefined
  screenfull.isEnabled ? screenfull.toggle(dom) : msgError("Sorry，您的浏览器不支持全屏", "top-right", 1500)
}
const handleFullscreenChange = () => {
  isFullscreen.value = screenfull.isFullscreen
}
watchEffect((onCleanup) => {
  // 挂载组件时自动执行
  screenfull.on("change", handleFullscreenChange)
  // 卸载组件时自动执行
  onCleanup(() => {
    screenfull.isEnabled && screenfull.off("change", handleFullscreenChange)
  })
})
</script>

<style lang="scss" scoped>
.screen-container{
  margin-right: 10px;
}
</style>
