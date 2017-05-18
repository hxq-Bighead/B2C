package com.bighead.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bighead.mapper.TbItemCatMapper;
import com.bighead.pojo.TbItemCat;
import com.bighead.pojo.TbItemCatExample;
import com.bighead.pojo.TbItemCatExample.Criteria;
import com.bighead.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Override
	public List<TbItemCat> getItemCatList(long parentId)throws Exception {
	//设置查询条件
	TbItemCatExample example=new TbItemCatExample();	
	Criteria criteria = example.createCriteria();	
	//根据父节点查询子节点
	criteria.andParentIdEqualTo(parentId);		
    //返回子节点列表
	List<TbItemCat> list = itemCatMapper.selectByExample(example);
	
	return list;
	}

}
