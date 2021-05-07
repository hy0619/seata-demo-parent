package com.media.storage.mapper;

import org.apache.ibatis.annotations.Param;

public interface StorageMapper {

    Integer decreaseStorage(@Param("commodityCode") String commodityCode
            , @Param("count") Integer count);
}
