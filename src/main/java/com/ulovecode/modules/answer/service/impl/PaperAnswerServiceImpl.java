package com.ulovecode.modules.answer.service.impl;

import com.ulovecode.modules.answer.dao.PaperAnswerMapper;
import com.ulovecode.modules.answer.entity.PaperAnswer;
import com.ulovecode.modules.answer.entity.PaperAnswerExample;
import com.ulovecode.modules.answer.entity.PaperAnswerKey;
import com.ulovecode.modules.answer.service.PaperAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaperAnswerServiceImpl implements PaperAnswerService{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    PaperAnswerMapper paperAnswerMapper;
    @Override
    public void save(Optional<PaperAnswer> paperAnswerOptional) {
        if (paperAnswerOptional.isPresent()) {
            PaperAnswer paperAnswer = paperAnswerOptional.get();
            paperAnswerMapper.insert(paperAnswer);
        }
    }

    @Override
    public int update(Optional<PaperAnswer> paperAnswerOptional) {
        if (paperAnswerOptional.isPresent()) {
            PaperAnswer paperAnswer = paperAnswerOptional.get();
            paperAnswerMapper.updateByPrimaryKeySelective(paperAnswer);
            return  0;
        }
        return -1;
    }

    @Override
    public int delete(Optional<Object> id) {
        if (id.isPresent()) {
            PaperAnswerKey paperAnswerKey = (PaperAnswerKey) id.get();
            //根据主键删除
            paperAnswerMapper.deleteByPrimaryKey(paperAnswerKey);
            return 0;
        }
        return -1;
    }

    @Override
    public Optional<PaperAnswer> queryObject(Optional<Object> id) {
        if (id.isPresent()) {
            PaperAnswerKey paperAnswerKey = (PaperAnswerKey) id.get();
            PaperAnswer paperAnswer = paperAnswerMapper.selectByPrimaryKey(paperAnswerKey);
            return Optional.of(paperAnswer);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<PaperAnswer>> queryList() {
        List<PaperAnswer> paperAnswers = paperAnswerMapper.selectByExample(new PaperAnswerExample());
        if (paperAnswers != null) {
            return Optional.of(paperAnswers);
        }
        return Optional.empty();
    }

    @Override
    public void saveOrUpdate(Optional<PaperAnswer> paperAnswerOptional) {
        if (paperAnswerOptional.isPresent()) {
            PaperAnswer paperAnswer = paperAnswerOptional.get();
            PaperAnswerKey key = paperAnswer;
            Optional<PaperAnswer> answer = queryObject(Optional.ofNullable(key));
            if (Optional.empty().equals(answer)) {
                paperAnswerMapper.insert(paperAnswer);
            } else {
                paperAnswerMapper.updateByPrimaryKeySelective(paperAnswer);
            }

        }
    }
}
