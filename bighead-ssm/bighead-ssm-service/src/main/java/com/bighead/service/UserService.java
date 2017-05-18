

package com.bighead.service;

import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.TaotaoResult;

public interface UserService {
	
	//用户登录验证
	TaotaoResult userLogin(String username,String password);
	
	//用户添加验证
	TaotaoResult userAdd(String username,String password,String phone,String email);

    //查询用户
	DataGridResult userList(int page,int rows);


}
