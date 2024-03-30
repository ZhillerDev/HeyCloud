<template>
  <div style="width: 350px">
    <t-form ref="form" :data="formData" :colon="true" :label-width="0" @reset="onReset" @submit="onSubmit">
      <t-form-item name="account">
        <t-input v-model="formData.account" clearable placeholder="请输入账户名">
          <template #prefix-icon>
            <desktop-icon/>
          </template>
        </t-input>
      </t-form-item>

      <t-form-item name="password">
        <t-input v-model="formData.password" type="password" clearable placeholder="请输入密码">
          <template #prefix-icon>
            <lock-on-icon/>
          </template>
        </t-input>
      </t-form-item>

      <t-form-item>
        <t-button theme="primary" type="submit" block>登录</t-button>
      </t-form-item>
    </t-form>
  </div>
</template>

<script setup>
import {reactive, ref, computed} from "vue"
import {useRouter} from "vue-router";
import {DesktopIcon, LockOnIcon} from 'tdesign-icons-vue-next';
import {msgSuccess, msgWarning} from "@/utils/msg-utils.js";

const router = useRouter()
const form = ref(null);
/** 登录按钮 Loading */
const loading = ref(false)
/** 验证码图片 URL */
const codeUrl = ref("")
/** 登录表单数据 */
const formData = reactive({
  username: "admin",
  password: "12345678",
  code: ""
})

/** 登录表单校验规则 */
const loginFormRules = {
  username: [{required: true, message: "请输入用户名", trigger: "blur"}],
  password: [
    {required: true, message: "请输入密码", trigger: "blur"},
    {min: 8, max: 16, message: "长度在 8 到 16 个字符", trigger: "blur"}
  ]
}

const onReset = () => {
  msgSuccess('重置成功');
};

const onSubmit = ({validateResult, firstError}) => {
  if (validateResult === true) {
    msgSuccess('提交成功');
  } else {
    console.log('Validate Errors: ', firstError, validateResult);
    msgWarning(firstError);
  }
};

const handleClear = () => {
  form.value.clearValidate();
};
</script>

<style lang="less" scoped>

</style>
