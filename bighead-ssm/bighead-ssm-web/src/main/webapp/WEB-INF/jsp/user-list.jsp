<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="userList" title="用户列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/user/list',method:'get',pageSize:30">
    <thead>
        <tr>
            <th data-options="field:'id',width:70">编号</th>
            <th data-options="field:'username',width:70">用户名</th>
            <th data-options="field:'password',width:100,type:'password'">密码</th>
        	<th data-options="field:'phone',width:100">手机号码</th>
        	<th data-options="field:'email',width:100">邮件</th>
            <th data-options="field:'created',width:100,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:100,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table>
