// 请求超时时间
import axios from "axios";
import {globalConfig} from "@/config/index.js";
import {msgError, msgWarning} from "@/utils/msg-utils.js";
import {useCommon} from "@/hooks/useCommon.js";

axios.defaults.timeout = 10000 * 5

// 请求基础 URL
axios.defaults.baseURL = globalConfig.baseContext

// POST 请求头
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'

// 请求携带cookie
axios.defaults.withCredentials = true

// 请求拦截器
axios.interceptors.request.use(
  (config) => {
    config.headers['token'] = useCommon.getCookies(globalConfig.tokenKeyName)
    return config
  },
  (error) => {
    console.log(error)
    return Promise.reject(error)
  }
)

// 响应拦截器
axios.interceptors.response.use(
  (response) => {
    if (response.status === 200) {
      return Promise.resolve(response)
    }
  },
  // 服务器状态码不是200的情况
  (error) => {
    if (error.response.status) {
      console.log(error.response)
      switch (error.response.status) {
        case 404:
          msgWarning('接口不存在，请刷新重试或联系管理员')
          break
        case 401:
          loginTip()
          break
        case 500:
          msgError('服务异常，请稍后刷新重试或联系管理员')
          break
        case 502:
          msgError('服务异常，请稍后刷新重试或联系管理员')
          break
        default:
          msgWarning(error.response.data.message)
          return Promise.reject(error.response)
      }
    }
  }
)

// 封装get
export function get(url, params) {
  return new Promise((resolve, reject) => {
    axios
      .get(url, {
        params: params
      })
      .then((res) => {
        resolve(res.data)
      })
      .catch((err) => {
        reject(err.data)
      })
  })
}

// 封装post
export function post(url, data = {}, info) {
  return new Promise((resolve, reject) => {
    let newData = data
    if (info) {
      //  转formData格式
      newData = new FormData()
      for (let i in data) {
        newData.append(i, data[i])
      }
    }
    axios
      .post(url, newData)
      .then((res) => {
        resolve(res.data)
      })
      .catch((err) => {
        reject(err.data)
      })
  })
}

// 封装put
export function put(url, params = {}) {
  return new Promise((resolve, reject) => {
    axios.put(url, params).then(
      (res) => {
        resolve(res.data)
      },
      (err) => {
        reject(err.data)
      }
    )
  })
}

// 封装delete
export function axiosDelete(url, params = {}) {
  return new Promise((resolve, reject) => {
    axios
      .delete(url, params)
      .then((res) => {
        resolve(res.data)
      })
      .catch((err) => {
        reject(err.data)
      })
  })
}


