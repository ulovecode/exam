package com.ulovecode.modules.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.entity.domain.Item;
import com.ulovecode.modules.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ItemService itemService;

    @RequestMapping("/showlist")
    public Optional<List<Item>> showItem() {
        return itemService.queryList();
    }

    @RequestMapping("/delete/{itemId}")
    public R deleteItem(@PathVariable("itemId") Optional<Integer> itemId) {
        try {
            itemService.delete(Optional.of(itemId.get()));
            log.info("删除试题号id为" + itemId.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除失败,试题号id为" + itemId.get() + "编号的试题");
            return R.error("操作失败");
        }
        return R.ok("操作成功");
    }


    @RequestMapping("/merge")
    public R saveOrUpdateItem(@RequestBody Optional<Item> itemForm) {
        try {
            itemService.saveOrUpdate(itemForm);
            log.info("添加或修改试题号" + itemForm.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("添加或修改,试题为" + itemForm.get() + "的试题");
            return R.error("操作失败");
        }
        return R.ok("操作成功");

    }

    @RequestMapping("/id/{itemId}")
    public R queryById(@PathVariable("itemId") Optional<Integer> itemId) {
        try {
            Optional<Item> Item = itemService.queryObject(Optional.of(itemId.get()));
            log.info("查询到" + Item.get());
            return R.ok("Item", Item.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询到失败,试题为" + itemId.get() + "的试题");
            return R.error("操作失败");
        }
    }


}
