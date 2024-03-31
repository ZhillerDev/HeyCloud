export const formatSize = (sizeInBits) => {
  if (sizeInBits < 0) {
    throw new Error("Size must be non-negative");
  }

  // 定义单位常量
  const KB = 1024;
  const MB = KB * 1024;
  const GB = MB * 1024;

  // 计算属于哪个单位范围
  if (sizeInBits < KB) {
    // 小于1KB，直接以比特显示
    return `${sizeInBits} bits`;
  } else if (sizeInBits < MB) {    // 介于1KB和1MB之间，以KB为单位    return `${(sizeInBits / KB).toFixed(2)} KB`;
  } else if (sizeInBits < GB) {
    // 介于1MB和1GB之间，以MB为单位
    return `${(sizeInBits / MB).toFixed(2)} MB`;
  } else {    // 大于等于1GB，以GB为单位    return `${(sizeInBits / GB).toFixed(2)} GB`;
  }
}
