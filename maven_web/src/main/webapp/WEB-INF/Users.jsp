<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" />
<script type="text/javascript" src="layui/layui.js"></script>
<script>
	var table, form, layer, $, laydate, util;
	layui.use([ 'table', 'util', 'form', 'layer', 'jquery', 'laydate' ],
			function() {
				table = layui.table;
				form = layui.form;
				layer = layui.layer;
				$ = layui.jquery;
				laydate = layui.laydate;
				util = layui.util;
				laydate.render({
					elem : "#beginDate"
				});

				laydate.render({
					elem : "#endDate"
				});

				table.render({
					elem : '#tab',
					"method" : "post",
					url : 'getAll',
					id:'idTest',
					page : true, //是否开启分页
					cols : [ [ {
						type : 'checkbox',
						fixed : 'left'
							
					}, {
						field : 'Id',
						title : '编号',
						align : 'center'
					}, {
						field : 'LoginName',
						title : '用户名',
						align : 'center'

					}, {
						field : 'IsLockout',
						title : '是否锁定',
						align : 'center'

					}, {
						field : 'LastLoginTime',
						title : '上次登录',
						align : 'center',templet : function(r) {
							return util.toDateString(r.LastLoginTime, "yyyy-MM-dd")
						}

					}, {
						field : 'CreateTime',
						title : '创建时间',
						align : 'center',templet : function(r) {
							return util.toDateString(r.CreateTime, "yyyy-MM-dd")
						}

					},/*  {
						field : 'PsdWrongTime',
						title : '秘密错误次数',
						align : 'center'

					}, {
						field : 'LockTime ',
						title : '用户锁定时间 ',
						align : 'center'

					}, {
						field : 'ProtectEMail',
						title : '邮箱',
						align : 'center'

					}, {
						field : 'protectMTel',
						title : '手机',
						align : 'center'
						

					}, */ {
						title : '操作',

						align : 'center',
						toolbar : "#barDemo"
					,width:450
							
					} ] ],
					"toolbar" : "#toolbarDemo"
				});
/* 查询*/
				 form.on('submit(search)', function(data){
					  table.reload('idTest',{
						  where:data.field //设定异步数据接口的额外参数
						});
					  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
					});
			 table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
					  var data = obj.data; //获得当前行数据
					  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					  var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
					 if(layEvent === 'del'){ //删除
					    layer.confirm('真的删除行么', function(index){
					      $.post("deleteUser",{"uid":data.Id},function(r){   
					    		  table.reload('idTest');
					    		  layer.closeAll(); //疯狂模式，关闭所有层
					      },"json");
					    });
					  } 
					});
				
});
</script>
<script type="text/html" id="toolbarDemo">
			<div class="layui-btn-container">
				<button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
				<button class="layui-btn layui-btn-sm" lay-event="deletes">批量删除</button>
			</div>
		</script>
<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="block">锁定</a>
			<a class="layui-btn layui-btn-xs" lay-event="unblock">解锁</a>
			<a class="layui-btn layui-btn-xs" lay-event="reset">密码重置</a>
			<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
</head>

<body>
<!-- 查询 -->
	<form method="post" class="layui-form"  >
		<div class="layui-inline">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-inline" style="width: 100px;">
				<input type="text" name="userName" placeholder="用户名"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">起止时间</label>
			<div class="layui-input-inline" style="width: 100px;">
				<input type="text" name="beginDate" id="beginDate"
					placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid">-</div>
			<div class="layui-input-inline" style="width: 100px;">
				<input type="text" name="endDate" id="endDate"
					placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">是否锁定</label>
			<div class="layui-input-inline" style="width: 100px;">
				<select name="isLock" lay-verify="">
					<option value="">--请选择--</option>
					<option value="是">是</option>
					<option value="否">否</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<button class="layui-btn layui-btn-radius layui-btn-normal"
				lay-submit lay-filter="search">搜索</button>
		</div>
	</form>
	
	<table class="layui-table" id="tab"  lay-filter="test"></table>

</body>


</html>