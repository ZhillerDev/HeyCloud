<script setup>
import ErrorPageLayout from "./err-page.vue"
import {placeholderImgs} from "@/utils/image-map-utils.js";
import {msgError} from "@/utils/msg-utils.js";

console.log(placeholderImgs.invalid)
msgError("错误的URL访问")
</script>

<template>
  <ErrorPageLayout>
    <t-image :src="placeholderImgs.notFound"/>
  </ErrorPageLayout>
</template>

<style lang="scss">

</style>
