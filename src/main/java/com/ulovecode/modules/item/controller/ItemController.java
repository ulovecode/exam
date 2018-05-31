package com.ulovecode.modules.item.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.item.service.ItemService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
@Slf4j
@Api("考试题的api接口")
@ApiResponses({@ApiResponse(code = 0, message = "正常码"), @ApiResponse(code = 500, message = "服务器处理错误")})
public class ItemController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "查询所有试题")
    @GetMapping("/showlist")
    public Optional<List<Item>> showItem() {
        return itemService.queryList();
    }

    @ApiOperation(value = "删除试题",notes = "根据url地址id删除试题")
    @ApiImplicitParam(paramType = "path",value = "试题id",name="itemId",dataType = "int")
    @DeleteMapping("/id/{itemId}")
    public R deleteItem(@PathVariable("itemId") Optional<Integer> itemId) {
        if (!itemId.isPresent()) {
            return R.error("操作失败");
        }
        itemService.delete(Optional.of(itemId.get()));
        log.info("删除试题号id为" + itemId.get());
        return R.ok("操作成功");
    }

    @ApiOperation(value = "保存试题", notes = "根据一个试题信息")
    @ApiImplicitParam(value = "试题信息",name = "itemForm",dataType = "Item")
    @PostMapping("/id")
    public R saveItem(@RequestBody Optional<Item> itemForm) {
        if (!itemForm.isPresent()) {
            return R.error("操作失败");

        }
        itemService.save(itemForm);
        log.info("添加或修改试题号" + itemForm.get());
        return R.ok("操作成功");
    }

    @ApiOperation(value = "修改试题", notes = "根据试题信息修改原来的试题")
    @ApiImplicitParam(value = "试题信息",name = "itemForm",dataType = "Item")
    @PutMapping("/id")
    public R updateItem(@RequestBody Optional<Item> itemForm) {
        if (!itemForm.isPresent()) {
            return R.error("操作失败");

        }
        itemService.update(itemForm);
        log.info("添加或修改试题号" + itemForm.get());
        return R.ok("操作成功");
    }


    @ApiOperation(value = "查询某个试题信息", notes = "根据url传入的itemId查询试题信息")
    @ApiImplicitParam(paramType = "path",value = "试题id",name = "itemId",dataType = "int")
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
