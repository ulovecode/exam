package com.ulovecode.modules.paper.service;

import com.ulovecode.common.base.BaseService;
import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.paper.entity.Paper;

import java.util.List;
import java.util.Optional;

public interface PaperService extends BaseService<Paper> {
    void deleteWithCascade(Optional<Integer> paperIdOptional);

    void addWitCascade(Optional<Paper> recordOptional);

    List<Item> findByPaperId(Optional<Object> paperId);
}
