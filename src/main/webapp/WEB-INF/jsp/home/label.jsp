<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ include file="../common/head.jsp"%>
<!-- Content Wrapper. Contains page content -->


<div class="content-wrapper">


<!--  -----------------------------------model  -->




<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >

<div class="modal-content" style="width: 900px; margin: 34.5px auto;margin-top:10%"><div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><li class="fa fa-remove"></li></button>
	<h5 class="modal-title">编辑操作</h5>
</div>

<div class="modal-body">
	<form id="user-form" name="user-form" class="form-horizontal bv-form" novalidate="novalidate">
		<input type="hidden" name="id" value="402880e456223e8f015625231d8e0003">

		<div class="box-body">
			<div class="col-md-6">
				<div class="form-group has-feedback">
					<label for="name" class="col-sm-3 control-label">标题</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="value" name="value" placeholder="标题" data-bv-field="name"><i class="form-control-feedback" data-bv-icon-for="name" style="display: none;"></i>
					<small data-bv-validator="notEmpty" data-bv-validator-for="name" class="help-block" style="display: none;">请输入姓名</small></div>
				</div>



			</div>
			<div class="col-md-6">

				<div class="form-group has-feedback">
					<label for="loginName" class="col-sm-3 control-label">状态</label>

					<div class="col-sm-8">
						<input type="text" class="form-control" id="status" name="status" placeholder="状态" data-bv-field="loginName"><i class="form-control-feedback" data-bv-icon-for="loginName" style="display: none;"></i>
					<small data-bv-validator="notEmpty" data-bv-validator-for="loginName" class="help-block" style="display: none;">请输入登录名</small></div>
				</div>

			</div>
		</div>
		<!-- /.box-body -->
		<div class="box-footer text-right">
			<!--以下两种方式提交验证,根据所需选择-->
			<button type="button" class="btn btn-default" data-btn-type="cancel" data-dismiss="modal">取消</button>
			<button type="submit" class="btn btn-primary" data-btn-type="save">提交</button>
		</div>
		<!-- /.box-footer -->
	<input type="hidden" value=""></form>

</div>
<script>

</script>
</div>
</div>


<!--  -----------------------------------model  -->




	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
        类目列表
	</h1>
	</section>
	<!-- Main content -->
	<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
				<div class="col-sm-3">
					<h3 class="box-title">Table</h3>
					</div>
					<div class="col-sm-9"><div class="dataTables_filter" id="searchDiv" style="float:right">

                    						<div class="btn-group" style="display:none">
                    							<button type="button" class="btn btn-primary" data-btn-type="search">查询</button>
                    							<button type="button" class="btn btn-default" data-btn-type="reset">重置</button>
                    						</div>
                    						<div class="btn-group">
                    							<button type="button" class="btn btn-default" data-btn-type="add" id="add">新增</button>
                    							<button  style="display:none" type="button" class="btn btn-default" data-btn-type="edit">编辑</button>
                    							<button  style="display:none" type="button" class="btn btn-default" data-btn-type="delete">删除</button>
                    						</div>
                    					</div></div>
				</div>


				<!-- /.box-header -->
				<div class="box-body">
					<div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-6">
							</div>
							<div class="col-sm-6">
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
								<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Rendering engine: activate to sort column descending" aria-sort="ascending">
										标题
									</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending">
										状态
									</th>

									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending">
										操作
									</th>
								</tr>
								</thead>
								<tbody>

<c:forEach var="list" items="${list}">
<tr role="row" class="odd">
									<td class="sorting_1">
										${list.value}
									</td>
									<td>
									${list.status==1? "显示" : "隐藏"}
									</td>

									<td>
										<div onclick="update(${list.id})">修改 </div>
									</td>
								</tr>
</c:forEach>








								</tbody>
								<tfoot>
								</tfoot>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-5">
								<div class="dataTables_info" id="example2_info" role="status" aria-live="polite">
									Showing 1 to 10 of 57 entries
								</div>
							</div>
							<div class="col-sm-7">
								<div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
									<ul class="pagination">
										<li class="paginate_button previous disabled" id="example2_previous"><a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li>
										<li class="paginate_button active"><a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0">1</a></li>
										<li class="paginate_button "><a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0">2</a></li>
										<li class="paginate_button "><a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0">3</a></li>
										<li class="paginate_button "><a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0">4</a></li>
										<li class="paginate_button "><a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0">5</a></li>
										<li class="paginate_button "><a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0">6</a></li>
										<li class="paginate_button next" id="example2_next"><a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
	</section>
	<!-- /.content -->
</div>



<script>
    function update(id){
            $.ajax({
				type : 'get',
				url : "/home/label_id?id="+id,
			    data:"",
				dataType : 'json',
				beforeSend : function() {
				},
				success : function(json) {
					if (json.state == 1) {
                        $("#value").val(json.msg.value);
                        $("#status").val(json.msg.status);

					   	$('#myModal').modal();

					} else {
						$("#myModal2 .modal-body").html(json.msg);
						 $('#myModal2').modal();
					}
				},
				error : function(XmlHttpRequest) {
				     $("#myModal2 .modal-body").html('发送信息错误！！请稍后再试...');
					 $('#myModal2').modal();

				}

			})
  }




</script>




<%@ include file="../common/foot.jsp"%>




