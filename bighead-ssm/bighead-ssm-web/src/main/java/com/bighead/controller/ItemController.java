package com.bighead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bighead.pojo.TbItem;
import com.bighead.service.ItemService;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.TaotaoResult;

/**
 * 
 * 商品管理Controller
 * @author bighead
 *
 */
@Controller
public class ItemController {

	//注入ItemService
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId){
		 TbItem item = itemService.getItemById(itemId);
		 return item;
		
	}
	
	//接收页面传递过来的参数
	@RequestMapping("/item/list")
	@ResponseBody
	public DataGridResult getItemList(Integer page,Integer rows){
		DataGridResult result=itemService.getItemList(page, rows);
	    return result;
	}
	//接收添加商品表单的内容(包括商品的描述，商品的规格参数)，调用service
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(TbItem item,String desc,String itemParams) throws Exception{
		TaotaoResult result = itemService.createItem(item,desc,itemParams);
	    return result;
	}
	//删除商品
	@RequestMapping(value="/item/delete",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult deleteItem(@RequestParam Long[] ids) {
		TaotaoResult result = itemService.deleteItem(ids);
		 return result;
		}
}