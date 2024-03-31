<template>
  <div class="login-container">
    <div class="login-card">
      <div class="title">
        <h2>HeyCloud 欢迎注册</h2>
      </div>
      <div class="content">
        <t-form ref="form" :data="formData" :rules="loginFormRules" @submit="onSubmit" label-align="left">
          <t-form-item label="用户名" name="username">
            <t-input v-model="formData.username"></t-input>
          </t-form-item>
          <t-form-item label="手机号" name="phone">
            <t-input v-model="formData.phone"></t-input>
          </t-form-item>
          <t-form-item label="密码" name="password">
            <t-input v-model="formData.password" type="password"></t-input>
          </t-form-item>

          <t-space class="btns">
            <t-button :loading="loading" theme="primary" variant="base" type="submit" style="width: 260px;">注册账户！
            </t-button>
            <t-button theme="default" variant="base" @click="handleClear" type="reset" style="width: 60px;">重填
            </t-button>
          </t-space>
        </t-form>

        <t-button style="width: 100%; margin-top: 10px;" theme="default" variant="outline" @click="backLogin">
          返回登陆
        </t-button>
      </div>
    </div>
  </div>
</template>

<script setup>
import {reactive, ref, computed} from "vue"
import {useRouter} from "vue-router";
import {DesktopIcon, LockOnIcon} from 'tdesign-icons-vue-next';
import {msgError, msgSuccess, msgWarning} from "@/utils/msg-utils.js";
import {login, register} from "@r/auth.js";
import {setToken} from "@/utils/token-utils.js";

const router = useRouter()
const form = ref(null);
/** 登录按钮 Loading */
const loading = ref(false)
/** 验证码图片 URL */
const codeUrl = ref("")
/** 登录表单数据 */
const formData = reactive({
  username: "zhillery",
  phone: "18078911281",
  password: "12345678"
})

const backLogin = () => router.replace("/login")

/** 登录表单校验规则 */
const loginFormRules = {
  username: [{required: true, message: "请输入用户名", trigger: "blur"}],
  phone: [{required: true, message: "请输入手机号", trigger: "blur"}, {
    min: 11,
    max: 11,
    message: "手机号长度不准确",
    trigger: "blur"
  }],
  password: [
    {required: true, message: "请输入密码", trigger: "blur"},
    {min: 6, max: 12, message: "长度在 6 到 12 个字符", trigger: "blur"}
  ],

}

const onReset = () => {
  msgSuccess('重置成功');
};

const onSubmit = ({validateResult, firstError}) => {
  if (validateResult === true) {
    loading.value = true
    register({
      username: formData.username,
      phone: formData.phone,
      password: formData.password
    }).then(e => {
      console.log(e)
      if (e.code === 200) {
        msgSuccess("注册成功，请登录！")
        router.replace("/login")
      } else {
        msgError("注册失败，用户已存在！")
      }
      loading.value = false
    })
  } else {
    console.log('Validate Errors: ', firstError, validateResult);
    msgWarning(firstError);
  }
};

const handleClear = () => {
  form.value.clearValidate();
};
</script>

<style lang="scss" scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  min-height: 100%;

  .theme-switch {
    position: fixed;
    top: 5%;
    right: 5%;
    cursor: pointer;
  }

  .login-card {
    width: 400px;
    border-radius: 6px;
    background-color: #fff;
    overflow: hidden;

    display: flex;
    flex-direction: column;
    align-items: center;

    .title {
      //background-color: #629dff;
      width: 100%;
      padding: 0 0 0 30px;
      display: flex;
      justify-content: start;
      align-items: center;
      margin-top: 32px;

      img {
        height: 50px;
        width: 130px;
      }
    }

    .content {
      border-radius: 6px;
      width: 100%;
      //background-color: white;
      padding: 10px 30px 20px 30px;

      :deep(.el-input-group__append) {
        padding: 0;
        overflow: hidden;
      }

      .btns {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
      }
    }
  }
}
</style>
