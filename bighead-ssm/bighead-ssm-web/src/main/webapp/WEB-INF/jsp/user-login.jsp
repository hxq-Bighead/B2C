<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="userloginDialog" class="easyui-dialog" data-options="title:'登录',modal:true,closable:false">
	<form id="userloginForm" method="post">
		<table>
			<tr>
				<th>登录名</th>
				<td><input name="username" class="easyui-validatebox" data-options="required:true,missingMessage:'登陆名称必填'" />
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" name="password" class="easyui-validatebox" data-options="required:true,missingMessage:'密码必填'" />
				</td>
			</tr>
		</table>
	</form>
	<div style="padding:5px">
	  <a href="javascript:void(0)" class="easyui-linkbutton" onclick="UserLoginPage.submitForm()">登录</a>
	  <a href="javascript:void(0)" class="easyui-linkbutton" onclick="UserLoginPage.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">

var UserLoginPage = {
		submitForm : function(){
			$.post("/user/login",$("#userloginForm").serialize(), function(data){
				if(data.status == 200){
					$.messager.alert('提示','登录成功!');
					$('#userloginDialog').dialog('close')
				}else{
					$.messager.alert('提示','密码或用户名错误!');
					$('form input').val('');
				}
			});
		},
		clearForm : function(){
			$('form input').val('');
		}
};
</script>