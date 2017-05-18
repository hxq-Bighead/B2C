package com.bighead.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bighead.mapper.TbItemDescMapper;
import com.bighead.mapper.TbItemMapper;
import com.bighead.mapper.TbItemParamItemMapper;
import com.bighead.pojo.TbItem;
import com.bighead.pojo.TbItemDesc;
import com.bighead.pojo.TbItemExample;
import com.bighead.pojo.TbItemExample.Criteria;
import com.bighead.pojo.TbItemParamItem;
import com.bighead.service.ItemService;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.IDUtils;
import com.bighead.pojoUtils.TaotaoResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemServiceImpl implements ItemService {

	//注入itemMapper;
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	@Override
	public TbItem getItemById(long itemId) {
		//无条件主键查询
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//条件查询
		//创建查询条件
		TbItemExample example=new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		//调用查询方法
		List<TbItem> list = itemMapper.selectByExample(example);
		//返回查询结果list
		if(list!=null&list.size()>0){
			TbItem item=list.get(0);
			return item;
		}
		return null;
		
	}

	@Override
	public DataGridResult getItemList(int page, int rows) {
		//创建查询条件
		TbItemExample example=new TbItemExample();
		//sql语句之前分页处理
		PageHelper.startPage(page, rows);
		//查询，返回list
		List<TbItem> list = itemMapper.selectByExample(example);
		//返回DataGridResult对象
		DataGridResult result=new DataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageInfo=new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public TaotaoResult createItem(TbItem item,String desc,String itemParam) throws Exception {
		//item补全
		/**
		 * 1.生成商品id
		 * 2.商品其他信息生成
		 * 3.插入数据库
		 */
		Long itemId=IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.insert(item);
		//添加商品描述
		TaotaoResult result = insertItemDesc(itemId,desc);
		
		if(result.getStatus()!=200){
			throw new Exception();
		}
		//添加规格参数
		 result = InsertItemParamItem(itemId,itemParam);
		 if(result.getStatus()!=200){
				throw new Exception();
			}
		 return TaotaoResult.ok();
	}
	/**
	 * 添加商品描叙
	 * @param desc
	 * @return
	 */
 private TaotaoResult insertItemDesc(Long itemId,String desc){
	 //创建desc对象
	 TbItemDesc itemDesc=new TbItemDesc();
	 //补全itemDesc
	 itemDesc.setItemId(itemId);
	 itemDesc.setItemDesc(desc);
	 itemDesc.setCreated(new Date());
	 itemDesc.setUpdated(new Date());
	 //插入数据库
	 itemDescMapper.insert(itemDesc);
	 return TaotaoResult.ok();
 }
 
 /**添加商品规格参数
  * 提交表单之前，先把规格参数表单中的内容转换成json数据
  * 然后跟商品基本信息，商品描叙同时提交给后台，保存到数据库
  * 
  */
 private TaotaoResult InsertItemParamItem(Long itemId,String itemParam){
	//创建POJO
	 TbItemParamItem itemParamItem=new TbItemParamItem();
	//补全
	 itemParamItem.setItemId(itemId);
	 itemParamItem.setParamData(itemParam);
	 itemParamItem.setCreated(new Date());
	 itemParamItem.setUpdated(new Date());
    //插入数据库；
	 itemParamItemMapper.insert(itemParamItem);
	 
	 return TaotaoResult.ok();
	 
 }

@Override
public TaotaoResult deleteItem(Long[] ids) {
	//删除
	itemMapper.deleteItems(ids);		
			
	return TaotaoResult.ok();
}
}
