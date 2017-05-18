package com.bighead.service;

import java.util.List;

import com.bighead.pojo.TbItemCat;

public interface ItemCatService {
	//可以根据parentid查询分类列表
 List<TbItemCat> getItemCatList(long parentId) throws Exception;
}
