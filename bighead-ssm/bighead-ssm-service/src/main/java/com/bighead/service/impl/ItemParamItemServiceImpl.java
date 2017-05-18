package com.bighead.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.bighead.mapper.TbItemParamItemMapper;
import com.bighead.pojo.TbItem;
import com.bighead.pojo.TbItemParamItem;
import com.bighead.pojo.TbItemParamItemExample;
import com.bighead.pojo.TbItemParamItemExample.Criteria;
import com.bighead.service.ItemParamItemService;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {


	    @Autowired
		private TbItemParamItemMapper itemParamItemMapper;
		@Override
		public String getItemParamByItemId(Long itemId) {
			//根据商品id查询商品规格参数
			TbItemParamItemExample example=new TbItemParamItemExample();
			Criteria criteria=example.createCriteria();
			criteria.andItemIdEqualTo(itemId);
			//执行查询
			List<TbItemParamItem> list=itemParamItemMapper.selectByExampleWithBLOBs(example);
			if(list==null||list.size()==0){
				return "";
			}
			//取规格参数信息
			TbItemParamItem itemParamItem=list.get(0);
			String paramData=itemParamItem.getParamData();
			//System.out.println(paramData);
			//把规格参数装换为Java对象
			List<Map> jsonList=JsonUtils.jsonToList(paramData, Map.class);
			
			//生成html
			StringBuffer sb=new StringBuffer();
			sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
			sb.append("    <tbody>\n");
		    for(Map m1:jsonList){
		    	sb.append("        <tr>\n");
				sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
				sb.append("        </tr>\n");
			   List<Map> list2=(List<Map>) m1.get("params");
			 for(Map m2:list2){
				   sb.append("        <tr>\n");
				   sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
				   sb.append("            <td>"+m2.get("v")+"</td>\n");
				   sb.append("        </tr>\n");
			   }
		   }
			
		    sb.append("    </tbody>\n");
			sb.append("</table>");
			return sb.toString();
		}
}

