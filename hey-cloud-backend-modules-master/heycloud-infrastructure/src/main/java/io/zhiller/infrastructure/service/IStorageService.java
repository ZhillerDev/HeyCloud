package io.zhiller.infrastructure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.zhiller.domain.transmit.StorageModel;

public interface IStorageService extends IService<StorageModel> {
  Long getTotalStorageSize(String userId);
  boolean checkStorage(String userId, Long fileSize);
}
