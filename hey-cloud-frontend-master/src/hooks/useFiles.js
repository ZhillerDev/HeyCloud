// 文件操作指令（阉割了一些无用的功能，VIP才可以使用哦~）
export const useFiles = {

  // 把字节型文件大小换算成人类更喜欢看的方式
  calculateFileSize(size, isInteger = false) {
    const B = 1024
    const KB = Math.pow(1024, 2)
    const MB = Math.pow(1024, 3)
    const GB = Math.pow(1024, 4)
    if (isInteger) {
      // 截取为整数
      if (size < B) {
        return `${size}B`
      } else if (size < KB) {
        return `${(size / B).toFixed(0)}KB`
      } else if (size < MB) {
        return `${(size / KB).toFixed(0)}MB`
      } else if (size < GB) {
        return `${(size / MB).toFixed(0)}GB`
      } else {
        return `${(size / GB).toFixed(0)}TB`
      }
    } else {
      // 保留小数位
      if (size < B) {
        return `${size}B`
      } else if (size < KB) {
        return `${(size / B).toFixed(0)}KB`
      } else if (size < MB) {
        return `${(size / KB).toFixed(1)}MB`
      } else if (size < GB) {
        return `${(size / MB).toFixed(2)}GB`
      } else {
        return `${(size / GB).toFixed(3)}TB`
      }
    }
  },

  /**
   * 获取文件查看路径
   * @param {object} row 文件信息
   * @returns {string} 文件路径
   */
  getViewFilePath(row) {
    return `${config.baseContext}/filetransfer/preview?userFileId=${
      row.userFileId
    }&isMin=false&shareBatchNum=${
      row.shareBatchNum == null ? '' : row.shareBatchNum
    }&extractionCode=${row.extractionCode == null ? '' : row.extractionCode}`
  },
  /**
   * 获取文件下载路径
   * @param {object} row 文件信息
   * @returns {string}  文件下载路径
   */
  getDownloadFilePath(row) {
    return `${config.baseContext}/filetransfer/downloadfile?userFileId=${
      row.userFileId
    }&shareBatchNum=${
      row.shareBatchNum == null ? '' : row.shareBatchNum
    }&extractionCode=${row.extractionCode == null ? '' : row.extractionCode}`
  },

  /**
   * 获取分享链接
   * @param {string} shareBatchNum
   * @returns {string} 完整的分享链接
   */
  getShareLink(shareBatchNum) {
    return `${location.protocol}//${location.host}/share/${shareBatchNum}`
  },
  /**
   * 复制分享链接
   * @param {string} shareBatchNum
   * @param {string} extractionCode
   */
  copyShareLink(shareBatchNum, extractionCode) {
    let input = document.createElement('textarea') // 直接构建textarea以保持换行
    input.value =
      extractionCode === null
        ? `分享链接：${this.getShareLink(
          shareBatchNum
        )}\n复制链接到浏览器中并输入提取码即可查看文件`
        : `分享链接：${this.getShareLink(
          shareBatchNum
        )}\n提取码：${extractionCode}\n复制链接到浏览器中并输入提取码即可查看文件` // 设置内容
    document.body.appendChild(input) // 添加临时实例
    input.select() // 选择实例内容
    document.execCommand('Copy') // 执行复制
    document.body.removeChild(input) // 删除临时实例
    Message.success('复制成功')
  },

  /**
   * 根据文件扩展名设置文件图片
   * @param {object} file 文件信息
   */
  setFileImg(file) {
    if (file.isDir === 1) {
      //  文件夹
      return fileImgMap.get('dir')
    } else if (
      Number(router.currentRoute.query.fileType) !== 6 &&
      ['jpg', 'png', 'jpeg', 'gif', 'mp4'].includes(
        file.extendName.toLowerCase()
      )
    ) {
      // 图片、视频类型，直接显示缩略图
      return this.getMinImgStream(file)
    } else if (fileImgMap.has(file.extendName.toLowerCase())) {
      // 可以识别文件类型的文件
      return fileImgMap.get(file.extendName.toLowerCase())
    } else {
      // 无法识别文件类型的文件
      return unknownImg
    }
  },
  /**
   * 判断是否是视频文件
   * @param {object} file 文件信息
   */
  isVideoFile(file) {
    return ['avi', 'mp4', 'mpg', 'mov', 'swf'].includes(
      file.extendName?.toLowerCase()
    );
  },

  /**
   * 文件名称拼接，包括文件名称 + 文件后缀
   * @param {object} file 文件信息
   * @param {boolean} isHighlight 是否需要展示高亮效果，默认不需要
   * @returns {string} 完整文件名称
   */
  getFileNameComplete(file, isHighlight = false) {
    return isHighlight === true && file.highlightFields
      ? `${file.highlightFields}${
        file.isDir === 0 && file.extendName ? `.${file.extendName}` : ''
      }`
      : `${file.fileName}${
        file.isDir === 0 && file.extendName ? `.${file.extendName}` : ''
      }`
  },
  /**
   * 文件类型
   * @param {object} file 文件信息
   */
  getFileType(file) {
    return file.isDir === 1
      ? '文件夹'
      : file.extendName
        ? file.extendName
        : '文件'
  },
  /**
   * 获取文件分享过期状态
   * @param {string} time 日期
   * @returns {boolean} 是否过期
   */
  getFileShareStatus(time) {
    return new Date(time).getTime() <= new Date().getTime();
  }
}
