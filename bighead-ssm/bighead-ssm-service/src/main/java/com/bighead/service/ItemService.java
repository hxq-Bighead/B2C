package com.bighead.service;

import com.bighead.pojo.TbItem;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.TaotaoResult;

public interface ItemService {
 
	//根据商品id查找商品
	TbItem getItemById(long itemId);
	
	
	//商品列表分页查询
	DataGridResult getItemList(int page,int rows);
	
	
	//商品添加
	TaotaoResult createItem(TbItem item,String desc,String itemParam)throws Exception;

 
	//商品删除
	TaotaoResult deleteItem(Long[] ids);
	
	
}
