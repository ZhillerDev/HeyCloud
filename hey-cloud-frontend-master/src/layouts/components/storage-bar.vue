<template>
  <div class="storage-container">
    <t-progress theme="line" :percentage="fileStore.storage" :label="false" style="width: 150px;"/>
    <div style="color: #606266; font-size: small">
      {{ fileStore.storage.toFixed(2) }}MB/100MB
    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";
import {useFileStore} from "@/store/modules/file-store.js";


const fileStore = useFileStore()

</script>

<style lang="scss" scoped>
.storage-container {
  //background-color: white;
  border-radius: 8px;
  padding: 4px;
  height: 80%;
  display: flex;
  flex-direction: row;
  align-items: center;
}
</style>
