import {get, post} from "@/apis/http.js";

/**
 * 接口前缀介绍
 * 1. file：文件操作接口
 * 2、 storage：存储空间接口
 * 3. share：文件分享接口
 * 4. recovery：回收站接口
 */


/**
 * 文件列表操作
 */
export const getFileList = (e) => get("/file/getFileList", e)
export const getFileRecovery = (e) => get("/file/getFileRecovery", e)
export const getFolderTree = (p) => get('/file/getFolderTree', p)
// 获取我已分享的文件列表
export const getMyShareFileList = (p) => get('/share/shareList', p)
// 获取存储占用
export const getStorage = (p) => get('/storage/total', p)


/**
 * 单文件操作相关接口
 */
// 创建文件
export const createFold = (p) => post('/file/createFold', p)
// 获取文件详细信息
export const getFileDetail = (p) => get('/file/detail', p)
// 删除文件
export const deleteFile = (p) => post('/file/deleteFile', p)
// 复制文件
export const copyFile = (p) => post('/file/copyFile', p)
// 移动文件
export const moveFile = (p) => post('/file/moveFile', p)
// 重命名文件
export const renameFile = (p) => post('/file/renameFile', p)
// 解压文件
export const unzipFile = (p) => post('/file/unzipFile', p)
// 全局搜索文件
export const searchFile = (p) => get('/file/search', p)
// 分享文件
export const shareFile = (p) => post('/share/shareFile', p)
// 校验分享链接过期时间
export const checkShareLinkEndtime = (p) => get('/share/checkDDL', p)
// 校验分享链接是否需要提取码
export const checkShareLinkType = (p) => get('/share/shareType', p)
// 校验分享链接提取码是否正确
export const checkShareLinkCode = (p) => get('/share/checkExtractionCode', p)
// 获取分享文件列表
export const getShareFileList = (p) => get('/share/shareFileList', p)
// 保存分享文件
export const saveShareFile = (p) => post('/share/saveShareFile', p)


/**
 * 文件批量操作相关接口
 */
// 批量删除文件
export const batchDeleteFile = (p) => post('/file/batchDeleteFile', p)
// 批量移动文件
export const batchMoveFile = (p) => post('/file/batchMoveFile', p)


/**
 * 回收站文件操作相关接口
 */
// 回收站文件删除
export const deleteRecoveryFile = (p) =>
  post('/recovery/deleteRecoveryFile', p)
// 回收站文件还原
export const restoreRecoveryFile = (p) => post('/recovery/restoreFile', p)
// 回收站文件批量删除
export const batchDeleteRecoveryFile = (p) =>
  post('/recovery/batchDelete', p)
