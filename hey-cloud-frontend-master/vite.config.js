import {defineConfig, loadEnv} from 'vite'
import vue from '@vitejs/plugin-vue'
import path from "path";

// tdesign包自动引入（因为我懒）
import AutoImport from 'unplugin-auto-import/vite';
import Components from 'unplugin-vue-components/vite';
import { TDesignResolver } from 'unplugin-vue-components/resolvers';


// https://vitejs.dev/config/
export default ({mode})=>{
  const env = loadEnv(mode, process.cwd())
  return{
    base: env.VITE_PUBLIC_PATH,
    plugins: [vue(),
      AutoImport({
        resolvers: [TDesignResolver({
          library: 'vue-next'
        })],
      }),
      Components({
        resolvers: [TDesignResolver({
          library: 'vue-next'
        })],
      }),],
    resolve: {
      alias: {
        "@": path.resolve(__dirname, "./src"), // 路径别名
        "@comp": path.resolve(__dirname, "./src/components"),
        "@assets": path.resolve(__dirname, "./src/assets")
      },
    },

    // 开发服务器配置
    server: {
      // 禁用主机检查
      disableHostCheck: true,
      // 监听的主机地址
      host: env.VITE_FRONTEND_HOST,
      // 端口号
      port: env.VITE_FRONTEND_PORT,
      // 配置代理
      proxy: {
        '/api': {
          target: 'http://localhost:20001',
          ws: true,
          changeOrigin: true,
          pathRewrite: {
            '^/api': '/',
          },
        },
      },
    },

    // 生产环境 source map 配置
    build: {
      // 不生成 source map
      sourcemap: false,
    },
  }
}
