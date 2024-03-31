import Cookies from 'js-cookie'


export const useCommon = {



  setCookies(name, value) {
    Cookies.set(name, value)
  },
  getCookies(name) {
    return Cookies.get(name)
  },
  removeCookies(name) {
    Cookies.remove(name)
  }
}
