package com.ulovecode.modules.item.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.item.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ItemService itemService;

    @GetMapping("/showlist")
    public Optional<List<Item>> showItem() {
        return itemService.queryList();
    }

    @DeleteMapping("/id/{itemId}")
    public R deleteItem(@PathVariable("itemId") Optional<Integer> itemId) {
        if (!itemId.isPresent()) {
            return R.error("操作失败");
        }
        itemService.delete(Optional.of(itemId.get()));
        log.info("删除试题号id为" + itemId.get());
        return R.ok("操作成功");
    }


    @PostMapping("/id")
    public R saveItem(@RequestBody Optional<Item> itemForm) {
        if (!itemForm.isPresent()) {
            return R.error("操作失败");

        }
        itemService.saveOrUpdate(itemForm);
        log.info("添加或修改试题号" + itemForm.get());
        return R.ok("操作成功");
    }
    @PutMapping("/id")
    public R updateItem(@RequestBody Optional<Item> itemForm) {
        if (!itemForm.isPresent()) {
            return R.error("操作失败");

        }
        itemService.saveOrUpdate(itemForm);
        log.info("添加或修改试题号" + itemForm.get());
        return R.ok("操作成功");
    }

    @GetMapping("/id/{itemId}")
    public R queryById(@PathVariable("itemId") Optional<Integer> itemId) {
        if (!itemId.isPresent()) {
            return R.error("操作失败");
        }
        Optional<Item> Item = itemService.queryObject(Optional.of(itemId.get()));
        log.info("查询到" + Item.get());
        return R.ok("Item", Item.get());
    }


}
