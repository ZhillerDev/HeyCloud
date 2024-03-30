<script setup>
import ErrorPageLayout from "./err-page.vue"
import {placeholderImgs} from "@/utils/image-map-utils.js";

</script>

<template>
  <ErrorPageLayout>
    <t-image :src="placeholderImgs.notFound"/>
  </ErrorPageLayout>
</template>

<style lang="scss">

</style>
