<template>
  <div class="cloud-container">
    <div class="cc-top">
      <t-button style="width: 80px;" :loading="btnStatus.refresh" @click="refreshBtn">刷新</t-button>
      <t-button style="width: 80px;" :disabled="btnStatus.upload" @click="uploadBtn">上传文件</t-button>
      <t-button style="width: 80px; margin-left: 2px;" :disabled="btnStatus.delete">删除文件</t-button>
    </div>

    <div style="height: calc(100vh - var(--v3-navigationbar-height) - 70px); overflow: scroll">
      <t-table
          :loading="formStatus.main"
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
import {formatFileSizeWithUnit, formatSize} from "@/utils/file-utils.js";
import {useFileStore} from "@/store/modules/file-store.js";
import {msgSuccess} from "@/utils/msg-utils.js";
import {fileTypeImgs} from "@/utils/image-map-utils.js";

const selectOnRowClick = ref(true);

const userStore = useUserStore()
const fileStore = useFileStore()

// 按钮组状态
const btnStatus = reactive({
  refresh: false,
  upload: false,
  delete: true
})
// 表格加载状态
const formStatus = reactive({
  main: false
})

// 刷新按钮
const refreshBtn = () => {
  formStatus.main = true
  btnStatus.refresh = true
  fileStore.showStorage(getLocal(CacheKey.Phone))
  getFileList({'userId': getLocal(CacheKey.Phone)})
      .then(e => {
        let datas = e.data
        let sum = 0;
        data.value = []
        for (let value in datas) {
          data.value.push({
            index: sum++,
            pic: ['贾明'],
            filename: datas[value]['fileName'],
            filetype: datas[value]['fileExtension'],
            filesize: formatFileSizeWithUnit(datas[value]['fileSize']),
          });
        }
        msgSuccess("获取数据成功")
      })
      .finally(() => {
        btnStatus.refresh = false
        formStatus.main = false
      })
}

const uploadBtn = () => {
  console.log(fileTypeImgs.get("jpg"))
}

const data = ref([]);


const columns = [
  {
    colKey: 'row-select',
    type: 'single',
    width: 50,
  },
  {
    colKey: 'pic', title: '', width: '100', cell: (h, {row}) => {
      return (
          <t-image src={
            fileTypeImgs.get(row.filetype) !== undefined ? fileTypeImgs.get(row.filetype) : unknownImg
          } style="height: 24px; width:24px;"/>
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
const selectedFileName = ref("")

const rehandleSelectChange = (value, {selectedRowData}) => {
  selectedRowKeys.value = value;
  selectedFileName.value = selectedRowData[0].filename
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
