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

export const formatFileSizeWithUnit = (numBytes) => {
  const UNITS = ['bit', 'Kb', 'Mb', 'Gb'];
  const UNIT_CONVERSIONS = [1, 1 / 1024, 1 / (1024 * 1024), 1 / (1024 * 1024 * 1024)];

  let unitIndex = 0;
  let roundedValue = numBytes;

  while (roundedValue >= 1024 && unitIndex < UNITS.length - 1) {
    roundedValue /= 1024;
    unitIndex++;
  }

  // 对最终值进行四舍五入
  roundedValue = Math.min(roundedValue, 1024).toFixed(2); // 限制最大值为1024

  return `${roundedValue} ${UNITS[unitIndex]}`;
}

export const convertBitToMb = (bitValue) => {
  const BITS_PER_MB = 1024 * 1024; // 1 Mb = 8,000,000 bits

  // 直接进行单位转换并返回结果
  return bitValue / BITS_PER_MB;
}
