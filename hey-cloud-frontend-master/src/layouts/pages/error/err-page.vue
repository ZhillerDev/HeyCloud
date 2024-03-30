<template>
  <div class="error-page">
    <div class="error-page-svg">
      <slot/>
    </div>
    <router-link to="/">
      <t-button>回到首页</t-button>
    </router-link>
  </div>
</template>

<style lang="scss" scoped>
.error-page {
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  &-svg {
    width: 400px;
    margin-bottom: 50px;
  }
}
</style>
