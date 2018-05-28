package com.ulovecode.modules.answer.service;

import com.ulovecode.common.base.BaseService;
import com.ulovecode.modules.answer.entity.PaperAnswer;

import java.util.List;
import java.util.Optional;

public interface PaperAnswerService extends BaseService<PaperAnswer> {
    void BatchSave(Optional<List<PaperAnswer>> answerListOptional);
}
