<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="orderList" title="商品订单列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/item/order/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th id ="orderId" data-options="field:'id',width:60">ID</th>
        	<th data-options="field:'itemId',width:60">订单ID</th>
            <th data-options="field:'title',width:100">商品标题</th>
            <th data-options="field:'num',width:70">商品数量</th>
            <th data-options="field:'totalFee',width:70,align:'right',formatter:TAOTAO.formatPrice">总价格</th>
        	<th data-options="field:'buyerName',width:100">买家姓名</th>
        	<th data-options="field:'buyerPhone',width:200">买家联系方式</th>
        	<th data-options="field:'receiverAddress',width:200">买家地址</th>
            <th data-options="field:'created',width:100,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:100,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
             
        </tr>
    </thead>
</table>
<script>

    function getSelectionsIds(){
    	var orderList = $("#orderList");
    	var sels = orderList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [
        {
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中订单!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/order/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除订单成功!',undefined,function(){
            					$("#orderList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>