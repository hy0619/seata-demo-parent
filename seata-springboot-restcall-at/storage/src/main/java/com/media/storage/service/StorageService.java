package com.media.storage.service;

import com.media.storage.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.media.ObjectResponse;

/**
 * @author Administrator
 */
@Service
public class StorageService {
    @Autowired
    StorageMapper storageMapper;

    public ObjectResponse decreaseStorage(String commodityCode , Integer count) {
        return storageMapper.decreaseStorage(commodityCode , count) > 0 ?
                ObjectResponse.success() : ObjectResponse.fail();
    }
}
