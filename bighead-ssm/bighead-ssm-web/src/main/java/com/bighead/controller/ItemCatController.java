package com.bighead.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bighead.pojo.TbItemCat;
import com.bighead.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	/**
	 * 
	 * 前台点击返回parentId的值，通过parentId查询所有可能的结果，并判断其是否为叶子节点或者父节点
	 * @param parentId
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@RequestMapping("/list")
	@ResponseBody
	public List categoryList(@RequestParam(value="id", defaultValue="0") Long parentId) throws Exception{
		
		List catList=new ArrayList();
		//查询
		List<TbItemCat> list = itemCatService.getItemCatList(parentId);
		//遍历
		for (TbItemCat tbItemCat : list) {
			Map node=new HashMap<>();
			node.put("id", tbItemCat.getId());
			node.put("text", tbItemCat.getName());
			//如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
			node.put("state", tbItemCat.getIsParent()?"closed":"open");
			catList.add(node);
			
		}
		return catList;
		
	}
}
