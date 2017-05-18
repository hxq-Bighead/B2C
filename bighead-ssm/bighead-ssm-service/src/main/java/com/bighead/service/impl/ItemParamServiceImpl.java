package com.bighead.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bighead.mapper.TbItemParamMapper;
import com.bighead.pojo.TbItemParam;
import com.bighead.pojo.TbItemParamExample;

import com.bighead.pojo.TbItemParamExample.Criteria;
import com.bighead.service.ItemParamService;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.TaotaoResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
 * 商品规格参数模板
 * @author bighead
 *
 */

@Service
public class ItemParamServiceImpl implements ItemParamService {

   @Autowired
    private	TbItemParamMapper itemParamMapper;
  

	
	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		//设置查询条件
		TbItemParamExample example=new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		//返回查询结果,处理大文本列用selectByExampleWithBLOBs(paramData)
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//判断是否查询到结果
		if(list!=null&&list.size()>0){
			return TaotaoResult.ok(list.get(0));
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult insertItemParam(TbItemParam itemParam) {
		//补全
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入到规格参数模板表
		itemParamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}

	@Override
	public DataGridResult getItemParamList(int page, int rows) {
		//设置查询条件
		TbItemParamExample example=new TbItemParamExample();
		//设置分页查询
		PageHelper.startPage(page, rows);
		//查询
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//DataGridResult对象
		DataGridResult result=new DataGridResult();
		result.setRows(list);
		//取记录总数
		PageInfo<TbItemParam> pageInfo=new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;

	
	}
	
}
