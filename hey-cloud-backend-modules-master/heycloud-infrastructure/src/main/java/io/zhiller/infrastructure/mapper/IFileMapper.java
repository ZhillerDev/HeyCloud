package io.zhiller.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.zhiller.domain.file.FIleModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IFileMapper extends BaseMapper<FIleModel> {
}
