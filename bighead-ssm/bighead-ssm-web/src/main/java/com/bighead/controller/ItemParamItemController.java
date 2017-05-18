package com.bighead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bighead.service.ItemParamItemService;
import com.bighead.pojoUtils.DataGridResult;

/**
 * 
 * 展示商品规格参数
 * 接收商品id调用Service查询规格参数信息，得到规格参数的html。
 * Model返回一个逻辑视图。把html展示到页面。
 * @author bighead
 *
 */
@Controller
public class ItemParamItemController {

	@Autowired
	private ItemParamItemService itemParamItemService;
    @RequestMapping("/showitem/{itemId}")
  public String showItemParam(@PathVariable Long itemId,Model model){
	String string=itemParamItemService.getItemParamByItemId(itemId);
	model.addAttribute("itemParam", string);
	return "item";
}
    
    

}

