<template>
  <div class="cloud-container">
    <t-button style="width: 80px; margin-bottom: 10px;">
      上传文件
    </t-button>

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
import {ref} from 'vue';
import {ErrorCircleFilledIcon, CheckCircleFilledIcon, CloseCircleFilledIcon} from 'tdesign-icons-vue-next';

const selectOnRowClick = ref(true);

const statusNameListMap = {
  0: {label: '审批通过', theme: 'success', icon: <CheckCircleFilledIcon/>},
  1: {label: '审批失败', theme: 'danger', icon: <CloseCircleFilledIcon/>},
  2: {label: '审批过期', theme: 'warning', icon: <ErrorCircleFilledIcon/>},
};

const data = [];
for (let i = 0; i < 5; i++) {
  data.push({
    index: i + 100,
    pic: ['贾明', '张三', '王芳'],
    filename: i % 3,
    filetype: ['电子签署', '纸质签署', '纸质签署'],
    filesize: [10, 20, 40],
  });
}

const columns = [
  {
    colKey: 'row-select',
    type: 'multiple',
    // 禁用行选中方式一：使用 disabled 禁用行（示例代码有效，勿删）。disabled 参数：{row: RowData; rowIndex: number })
    // 这种方式禁用行选中，当前行会添加行类名 t-table__row--disabled，禁用行文字变灰
    // disabled: ({ rowIndex }) => rowIndex === 1 || rowIndex === 3,

    // 禁用行选中方式二：使用 checkProps 禁用行（示例代码有效，勿删）
    // 这种方式禁用行选中，行文本不会变灰
    width: 50,
  },
  {colKey: 'pic', title: '', width: '100'},
  {
    colKey: 'filename',
    title: '文件名',
    width: '500'
  },
  {colKey: 'filetype', title: '文件类型', width: '80'},
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
}
</style>
