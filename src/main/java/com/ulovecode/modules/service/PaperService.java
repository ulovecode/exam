package com.ulovecode.modules.service;

import com.ulovecode.common.base.BaseService;
import com.ulovecode.modules.entity.domain.Paper;

import java.util.Optional;

public interface PaperService extends BaseService<Paper> {
    void deleteWithCascade(Optional<Integer> paperIdOptional);

    void addWitCascade(Optional<Paper> recordOptional);
}
