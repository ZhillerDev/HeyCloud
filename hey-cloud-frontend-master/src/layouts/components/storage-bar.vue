<template>
  <div class="storage-container">
    <t-progress theme="line" :percentage="perc" :label="false" style="width: 150px;"/>
    <div style="color: #606266; font-size: small">
      {{ userStore.storage }}/100MB
    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";
import {useFiles} from "@/hooks/useFiles.js";
import {useUserStore} from "@/store/modules/user-store.js";

const perc = ref(45)
const userStore = useUserStore()

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
