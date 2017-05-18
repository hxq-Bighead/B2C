package com.bighead.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bighead.mapper.TbUserMapper;
import com.bighead.pojo.TbUser;
import com.bighead.pojo.TbUserExample;
import com.bighead.pojo.TbUserExample.Criteria;
import com.bighead.service.UserService;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.Encrypt;
import com.bighead.pojoUtils.TaotaoResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;
	@Override
	public TaotaoResult userLogin(String username, String password) {
		//创建查询条件
		TbUserExample example=new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		//进行查询，返回结果
		List<TbUser> result = userMapper.selectByExample(example);
		System.out.println();
		if(result!=null&&result.size()>0){
			return TaotaoResult.ok();
		}
		return null;
		
	}
	@Override
	public TaotaoResult userAdd(String username, String password, String phone, String email) {
		//新建pojo，补全pojo
		TbUser user=new TbUser();
		user.setUsername(username);
		user.setPassword(Encrypt.e(password));
		user.setEmail(email);
		user.setPhone(phone);
		user.setCreated(new Date());
		user.setUpdated(new Date());
		
		//插入数据库
		userMapper.insert(user);
		return TaotaoResult.ok();
	}
	public DataGridResult userList(int page,int rows){
		//设置查询条件
		TbUserExample example=new TbUserExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//查询，返回结果
		List<TbUser> list = userMapper.selectByExample(example);
		//返回DataGridResult对象
		DataGridResult result=new DataGridResult();
		result.setRows(list);
		PageInfo<TbUser> pageInfo=new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

}
