package com.bighead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bighead.service.UserService;
import com.bighead.pojoUtils.DataGridResult;
import com.bighead.pojoUtils.TaotaoResult;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/login")
	@ResponseBody()
	public TaotaoResult userLogin(String username,String password){
		TaotaoResult result = userService.userLogin(username, password);
		return result;
	}
 
	@RequestMapping(value="/user/add",method=RequestMethod.POST)
	@ResponseBody()
	public TaotaoResult userAdd(String username, String password, String phone, String email){
		TaotaoResult result = userService.userAdd(username, password, phone, email);
		return result;
	}
	@RequestMapping("/user/list")
	@ResponseBody()
	public DataGridResult userList(Integer page,Integer rows){
		DataGridResult result = userService.userList(page, rows);
		return result;
	}
	
}
