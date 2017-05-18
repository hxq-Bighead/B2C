<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding:10px 10px 10px 10px">
	<form id="UserAddForm"  method="post">
	    <table cellpadding="4">
	        <tr>
	            <td>用户姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="username" data-options="required:true" style="height:20px; width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>密码:</td>
	            <td><input class="easyui-textbox" type="email" name="password"  data-options="required:true" style="height:20px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>联系方式:</td>
	            <td><input class="easyui-textbox" name="phone" data-options="required:true" style="height:20px;width: 280px;"></input></td>
	        </tr>
	         <tr>
	            <td>电子邮件:</td>
	            <td><input class="easyui-textbox" type="email" name="email" data-options="required:true" style="height:20px;width: 280px;"></input></td>
	        </tr> 
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentAddPage.submitForm()">添加</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentAddPage.clearForm()">重置</a>
	</div>
</div>

<script type="text/javascript">
var contentAddPage  = {
		submitForm : function (){
			if(!$('#userAddForm').form('validate')){
				$.messager.alert('提示','表单还未填写完成!');
				return ;
			}
			
			$.post("/user/add",$("#UserAddForm").serialize(), function(data){
				if(data.status == 200){
					$.messager.alert('提示','新增内容用户成功!');
					$('form input').val('');
					
				}
			});
			
		},
		clearForm : function(){
			$('form input').val('');
			
		}
};

</script>