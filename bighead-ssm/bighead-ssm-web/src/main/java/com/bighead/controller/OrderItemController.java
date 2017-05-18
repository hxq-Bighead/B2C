package com.bighead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bighead.service.OrderItemService;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.TaotaoResult;

@Controller
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;
	
	
@RequestMapping("/item/order/list")
@ResponseBody()
public DataGridResult getOrderItemList(Integer page,Integer rows){
	DataGridResult result = orderItemService.getOrderItemList(page, rows);
	return result;
}
	
@RequestMapping("/order/delete")
@ResponseBody()
public TaotaoResult deleteOrders(Integer[] ids){
	TaotaoResult result = orderItemService.deleteOrders(ids);
	return result;
}
	
}
