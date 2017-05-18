package com.bighead.service;

import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.TaotaoResult;


public interface OrderItemService {

	
	DataGridResult getOrderItemList(int page,int rows);
	
	TaotaoResult deleteOrders(Integer[] ids);
}
