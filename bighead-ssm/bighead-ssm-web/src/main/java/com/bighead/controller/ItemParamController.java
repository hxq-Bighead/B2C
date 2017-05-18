package com.bighead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bighead.pojo.TbItemParam;
import com.bighead.service.ItemParamService;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.TaotaoResult;

/**
 * 商品规格参数模板管理
 * 接收页面返回的cid，调用Service进行查询，返回json
 * 
 * 
 * @author bighead
 *
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

@Autowired
private ItemParamService itemParamService;
@RequestMapping("/query/itemcatid/{itemCatId}")
@ResponseBody
public TaotaoResult getItemParamByCid(@PathVariable long itemCatId){
	TaotaoResult result = itemParamService.getItemParamByCid(itemCatId);
	return result;
}
/**
 * 
 * 接收cid、规格参数模板，创建TbItemParam对象，调用Service返回TaoTaoResult，返回json数据
 *	
 */
@RequestMapping("save/{cid}")
@ResponseBody
public TaotaoResult insertItemParam(@PathVariable long cid,String paramData){
	TbItemParam itemParam=new TbItemParam();
	itemParam.setItemCatId(cid);
	itemParam.setParamData(paramData);
	TaotaoResult result = itemParamService.insertItemParam(itemParam);
	return result;
}

@RequestMapping("list")
@ResponseBody
public DataGridResult getItemParamList(Integer page, Integer rows){
	DataGridResult result = itemParamService.getItemParamList(page, rows);
	return result;
	
}
	
}
