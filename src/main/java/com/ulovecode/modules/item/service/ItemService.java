package com.ulovecode.modules.item.service;

import com.ulovecode.common.base.BaseService;
import com.ulovecode.modules.item.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService extends BaseService<Item> {
    Optional<List<Item>> findByPaperId(Optional<Integer> paperIdOptional);
}
