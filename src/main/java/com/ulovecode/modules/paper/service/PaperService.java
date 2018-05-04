package com.ulovecode.modules.paper.service;

import com.ulovecode.common.base.BaseService;
import com.ulovecode.modules.paper.entity.Paper;

import java.util.Optional;
import java.util.OptionalInt;

public interface PaperService extends BaseService<Paper> {
    void deleteWithCascade(OptionalInt paperIdOptional);

    void addWitCascade(Optional<Paper> recordOptional);
}
