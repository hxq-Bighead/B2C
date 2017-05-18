package com.bighead.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bighead.mapper.TbOrderMapper;
import com.bighead.pojo.TbOrder;
import com.bighead.pojo.TbOrderExample;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.TaotaoResult;
import com.bighead.service.OrderItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private TbOrderMapper orderMapper;
	
	@Override
	public DataGridResult getOrderItemList(int page, int rows) {
		//设置查询条件
		TbOrderExample example=new TbOrderExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//进行查询，返回结果
		List<TbOrder> list = orderMapper.selectByExample(example);
		//新建DataGridResult对象
		DataGridResult result=new DataGridResult();
		result.setRows(list);
		PageInfo<TbOrder> pageInfo=new PageInfo<>(list);
		
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public TaotaoResult deleteOrders(Integer[] ids) {
		orderMapper.deleteOrders(ids);
		return TaotaoResult.ok();
	}

}
