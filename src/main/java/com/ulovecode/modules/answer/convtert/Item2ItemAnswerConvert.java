package com.ulovecode.modules.answer.convtert;


import com.ulovecode.modules.answer.entity.vo.ItemAnswer;
import com.ulovecode.modules.item.entity.Item;
import org.springframework.beans.BeanUtils;

public class Item2ItemAnswerConvert {

    public static ItemAnswer convert(Item item, String paperId) {
        ItemAnswer itemAnswer = new ItemAnswer();
        BeanUtils.copyProperties(item, itemAnswer);
        itemAnswer.setPaperId(paperId);
        return itemAnswer;
    }


}
