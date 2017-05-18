package com.bighead.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bighead.service.PictureService;
import com.bighead.pojoUtils.JsonUtils;

@Controller
public class PictureController {
	
	@Autowired
	private PictureService pictureService;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureload(MultipartFile uploadFile){
		Map result=pictureService.uploadPicture(uploadFile);
		//返回前台一个json格式的信息
		String json=JsonUtils.objectToJson(result);
		return json;
		
	}

	}



