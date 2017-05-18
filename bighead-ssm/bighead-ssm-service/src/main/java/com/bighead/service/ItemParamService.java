package com.bighead.service;

import com.bighead.pojo.TbItemParam;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.TaotaoResult;

public interface ItemParamService {

	
	TaotaoResult getItemParamByCid(long cid);


	TaotaoResult insertItemParam(TbItemParam itemParam);

	
	//商品规格参数分页查询
   DataGridResult getItemParamList(int page,int rows);

}
