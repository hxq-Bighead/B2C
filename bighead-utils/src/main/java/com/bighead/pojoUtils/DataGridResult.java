package com.bighead.pojoUtils;

import java.util.List;

/*
 * easyUI的datagrid要求返回的json格式，通过pojo来封装
 */
public class DataGridResult {
 private long  total;
 private List<?> rows;
public long getTotal() {
	return total;
}
public void setTotal(long total) {
	this.total = total;
}
public List<?> getRows() {
	return rows;
}
public void setRows(List<?> rows) {
	this.rows = rows;
}
 
 
 
	
	
}
