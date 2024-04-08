package io.zhiller.infrastructure.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.zhiller.domain.transmit.StorageModel;
import io.zhiller.infrastructure.mapper.IStorageMapper;
import io.zhiller.infrastructure.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl extends ServiceImpl<IStorageMapper, StorageModel> implements IStorageService {

  @Autowired
  IStorageMapper storageMapper;


  @Override
  public Long getTotalStorageSize(String userId) {
    LambdaQueryWrapper<StorageModel> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(StorageModel::getUserId, userId);

    StorageModel storageModel = storageMapper.selectOne(wrapper);

    return null;
  }

  @Override
  public boolean checkStorage(String userId, Long fileSize) {
    return false;
  }
}
