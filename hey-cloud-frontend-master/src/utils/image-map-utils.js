const parserUrl = (name) => {
  const base = "../../src/assets"
  return new URL(base + name, import.meta.url).href
}

export const logo = parserUrl("/images/logo/hey-cloud.svg")

// 未知图标
export const unknownImg = parserUrl('/images/file/file_unknown.png')

export const placeholderImgs = {
  notFound: parserUrl("/images/error/not-found.png"),
  invalid: parserUrl("/images/error/invalid.png")
}

// 文件类型图标集合
export const fileTypeImgs = new Map([
  ['avi', parserUrl("/images/file/file_avi.png")],
  ['xls', parserUrl('/images/file/file_excel.svg')],
  ['xlsx', parserUrl('/images/file/file_excel.svg')],
  ['xml', parserUrl('/images/file/file_xml.png')],
  ['zip', parserUrl('/images/file/file_zip.png')],
  ['txt', parserUrl('/images/file/file_txt.png')],
  ['svg', parserUrl('/images/file/file_svg.png')],
  // ['jpg', parserUrl('/images/file/file_unknown.png')],
  ['ppt', parserUrl('/images/file/file_ppt.svg')],
  ['pptx', parserUrl('/images/file/file_ppt.svg')],
  ['pdf', parserUrl('/images/file/file_pdf.png')],
  ['mp3', parserUrl('/images/file/file_music.png')],
  ['java', parserUrl('/images/file/file_java.png')],
  ['doc', parserUrl('/images/file/file_word.svg')],
  ['docx', parserUrl('/images/file/file_word.svg')],
  ['exe', parserUrl('/images/file/file_exe.png')],
  ['html', parserUrl('/images/file/file_html.png')],
  ['md', parserUrl('/images/file/file_markdown.png')],
])

// 以列表显示文件时的列表名
export const allColumnList = [
  'extendName',
  'fileSize',
  'uploadTime',
  'deleteTime'
]



