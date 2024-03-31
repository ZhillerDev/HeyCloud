package io.zhiller.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.zhiller.domain.transmit.StorageModel;
import io.zhiller.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStorageMapper extends BaseMapper<StorageModel> {
}
