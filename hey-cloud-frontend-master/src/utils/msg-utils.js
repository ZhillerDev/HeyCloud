import {MessagePlacementList, MessagePlugin, DialogPlugin} from "tdesign-vue-next";

// 成功消息提示
export const msgSuccess = (title, placement="bottom-right", duration=1000) => {
  MessagePlugin.success({
    content: title,
    placement: placement,
    duration: duration
  })
}

// 警告消息提示
export const msgWarning = (title, placement="bottom-right", duration=1000) => {
  MessagePlugin.warning({
    content: title,
    placement: placement,
    duration: duration
  })
}

// 错误消息提示
export const msgError = (title, placement="bottom-right", duration=1000) => {
  MessagePlugin.error({
    content: title,
    placement: placement,
    duration: duration
  })
}

// 带确认取消按钮的对话框
// 包含一个回调函数用于确认用户点击状态
export const dialogConfirm = (title, content, onSuccess) => {
  const dialog = DialogPlugin.confirm({
    header: title,
    body: content,
    onConfirm() {
      dialog.destroy()
      console.log("is destryo")
      onSuccess()
    }
  })
  dialog.show()
}
