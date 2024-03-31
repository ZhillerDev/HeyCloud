<template>
  <div class="cloud-container">
    <div class="cc-top">
      <t-button style="width: 80px;" :loading="btnStatus.refresh" @click="refreshBtn">刷新</t-button>
      <t-button style="width: 80px;" :disabled="btnStatus.upload">上传文件</t-button>
    </div>

    <div style="height: calc(100vh - var(--v3-navigationbar-height) - 70px); overflow: scroll">
      <t-table
          max-height="100%"
          row-key="index"
          :columns="columns"
          :data="data"
          :selected-row-keys="selectedRowKeys"
          :active-row-type="activeRow ? 'single' : undefined"
          :select-on-row-click="selectOnRowClick"
          lazy-load
          @select-change="rehandleSelectChange"
      >
      </t-table>
    </div>

  </div>
</template>

<script setup lang="jsx">
import {reactive, ref} from 'vue';
import {unknownImg} from "@/utils/image-map-utils.js";
import {getFileDetail, getFileList} from "@r/file.js";
import {useUserStore} from "@/store/modules/user-store.js";
import {getLocal} from "@/utils/token-utils.js";
import {CacheKey} from "@/domain/constants/app-key.js";
import {formatSize} from "@/utils/file-utils.js";

const selectOnRowClick = ref(true);

const userStore = useUserStore()

// 按钮组状态
const btnStatus = reactive({
  refresh: false,
  upload: false
})

// 刷新按钮
const refreshBtn = () => {
  btnStatus.refresh = true
  console.log(userStore.userInfo)
  getFileList({'userId': getLocal(CacheKey.Phone)})
      .then(e => {
        let datas = e.data
        let sum = 0;
        data.value = []
        for (let value in datas) {
          console.log(datas[value])
          data.value.push({
            index: sum++,
            pic: ['贾明'],
            filename: datas[value]['fileName'],
            filetype: datas[value]['fileType'],
            filesize: formatSize(datas[value]['fileSize']),
          });
        }
        console.log(data)
      })
      .finally(() => {
        btnStatus.refresh = false
      })
}

const data = ref([]);


const columns = [
  {
    colKey: 'row-select',
    type: 'multiple',
    width: 50,
  },
  {
    colKey: 'pic', title: '', width: '100', cell: (h, {row}) => {
      return (
          <t-image src={unknownImg} style="height: 32px; width:32px;"/>
      );
    },
  },
  {
    colKey: 'filename',
    title: '文件名',
    width: '500'
  },
  {colKey: 'filetype', title: '类型', width: '80'},
  {colKey: 'filesize', title: '文件大小', ellipsis: true},
];

const activeRow = ref(false);
const selectedRowKeys = ref([]);

const rehandleSelectChange = (value, ctx) => {
  selectedRowKeys.value = value;
  console.log(value, ctx);
};
</script>

<style lang="scss" scoped>
.cloud-container {
  display: flex;
  flex-direction: column;

  .cc-top {
    display: flex;
    flex-direction: row;
    margin-bottom: 10px;
  }
}
</style>
