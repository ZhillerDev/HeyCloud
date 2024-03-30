// 全局设置
import {createApp} from 'vue'
import App from './App.vue'

// 通用组件
import store from "@/store";
import router from "@/router/index.js";

// 样式库
import TDesign from 'tdesign-vue-next';
import 'tdesign-vue-next/es/style/index.css';
import '@a/styles/index.scss'


const app = createApp(App);
app.use(TDesign);
app.use(store)
app.use(router)
app.mount('#app');
