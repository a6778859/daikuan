<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
  <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ include file="../common/head.jsp" %>
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- -----------------------------------model -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
        aria-hidden="true">
          <div class="modal-content" style="width: 900px; margin: 34.5px auto;margin-top:10%">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                <li class="fa fa-remove">
                </li>
              </button>
              <h5 class="modal-title">
                编辑操作
              </h5>
            </div>
            <div class="modal-body">
              <form id="user-form" name="user-form" class="form-horizontal bv-form"
              novalidate="novalidate">
                <input type="hidden" name="id" id="id" value="">
                <div class="box-body">
                  <div class="col-md-6">
                    <div class="form-group has-feedback">
                      <label for="name" class="col-sm-3 control-label">
                        标题
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="title" name="title" placeholder="标题"
                        data-bv-field="name">
                        <i class="form-control-feedback" data-bv-icon-for="name" style="display: none;">
                        </i>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="telphone" class="col-sm-3 control-label">
                        还款方式
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="payreturn" name="payreturn"
                        placeholder="座机">
                      </div>
                    </div>
                    <div class="form-group has-feedback">
                      <label for="email" class="col-sm-3 control-label">
                        日利率
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="interestrate" name="interestrate"
                        placeholder="请输入如0.05" data-bv-field="email">
                        <i class="form-control-feedback" data-bv-icon-for="email" style="display: none;">
                        </i>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="telphone" class="col-sm-3 control-label">
                        期限范围
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="timerange" name="timerange"
                        placeholder="期限范围">
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="form-group has-feedback">
                      <label for="loginName" class="col-sm-3 control-label">
                        额度范围
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="moenyrange" name="moenyrange"
                        placeholder="额度范围" data-bv-field="loginName">
                        <i class="form-control-feedback" data-bv-icon-for="loginName" style="display: none;">
                        </i>
                        <small data-bv-validator="notEmpty" data-bv-validator-for="loginName"
                        class="help-block" style="display: none;">
                          请输入登录名
                        </small>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="mobile" class="col-sm-3 control-label">
                        放款方式
                      </label>
                      <div class="col-sm-8">
                        <!--<input type="text" class="form-control" id="lendingmethods" name="lendingmethods"
                        placeholder="放款方式" data-inputmask='"mask": "9999999999999"' data-mask>-->
                        <input type="text" class="form-control" id="lendingmethods" name="lendingmethods"
                        placeholder="放款方式">
                      </div>
                    </div>
                    <div>
                      <div class="form-group">
                        <label for="mobile" class="col-sm-3 control-label">
                          状态
                        </label>
                        <div class="col-sm-8">
                          <div class="col-sm-8">
                            <select class="form-control" id='status' name="status">
                              <option value="1">
                                显示
                              </option>
                              <option value="0">
                                隐藏
                              </option>
                            </select>
                            </i>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div>
                      <label for="qq" class="col-sm-3 control-label">
                        申请条件
                      </label>
                      <div class="col-sm-8">
                        <textarea name="remark" id="remark" placeholder="" class="form-control"
                        data-bv-field="remark">
                        </textarea>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- /.box-body -->

                  <div class="box-footer " >
                          <div class="form-group" style="width:100%">




                                     <c:forEach var="list" items="${labelList}">
                                        <div class="checkbox" style='width:25%;float:left;' >
                                                     <label>
                                                        <input type="checkbox" value="${list.id}" name="label">
                                                    ${list.value}
                                                </label>
                                          </div>

                                     </c:forEach>







                             </div>

                  </div>



                <div class="box-footer text-right">
                  <!--以下两种方式提交验证,根据所需选择-->
                  <button type="button" class="btn btn-default" data-btn-type="cancel" data-dismiss="modal">
                    取消
                  </button>
                  <button type="button" class="btn btn-primary" data-btn-type="save" onclick='save()'>
                    提交
                  </button>
                </div>
                <!-- /.box-footer -->
                <input type="hidden" value="">
              </form>
            </div>
            <script>
            </script>
          </div>
        </div>
        <!-- -----------------------------------model -->
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
                    <h3 class="box-title">
                      Table
                    </h3>
                  </div>
                  <div class="col-sm-9">
                    <div class="dataTables_filter" id="searchDiv" style="float:right">
                      <div class="btn-group" style="display:none">
                        <button type="button" class="btn btn-primary" data-btn-type="search">
                          查询
                        </button>
                        <button type="button" class="btn btn-default" data-btn-type="reset">
                          重置
                        </button>
                      </div>
                      <div class="btn-group">
                        <button type="button" class="btn btn-default" data-btn-type="add" onclick="click2()">
                          新增
                        </button>
                        <button style="display:none" type="button" class="btn btn-default" data-btn-type="edit">
                          编辑
                        </button>
                        <button style="display:none" type="button" class="btn btn-default" data-btn-type="delete">
                          删除
                        </button>
                      </div>
                    </div>
                  </div>
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
                        <table id="example2" class="table table-bordered table-hover dataTable"
                        role="grid" aria-describedby="example2_info">
                          <thead>
                            <tr role="row">
                              <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1"
                              colspan="1" aria-label="Rendering engine: activate to sort column descending"
                              aria-sort="ascending">
                                标题
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              colspan="1" aria-label="Browser: activate to sort column ascending">
                                还款方式
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                额度范围
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              colspan="1" aria-label="Engine version: activate to sort column ascending">
                                期限范围
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                放款方式
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              colspan="1" aria-label="Engine version: activate to sort column ascending">
                                状态
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                操作
                              </th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="list" items="${list}">
                              <tr role="row" class="odd">
                                <td class="sorting_1">
                                  ${list.title}
                                </td>
                                <td>
                                  ${list.payreturn}
                                </td>
                                <td>
                                  ${list.moenyrange}
                                </td>
                                <td>
                                  ${list.timerange}
                                </td>
                                <td>
                                  ${list.lendingmethods}
                                </td>
                                <td>
                                  ${list.status==1? "显示" : "隐藏"}
                                </td>
                                <td>
                                  <a>
                                    <div onclick="update(${list.id})">
                                      修改
                                    </div>
                                  </a>
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
                            <li class="paginate_button previous disabled" id="example2_previous">
                              <a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0">
                                Previous
                              </a>
                            </li>
                            <li class="paginate_button active">
                              <a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0">
                                1
                              </a>
                            </li>
                            <li class="paginate_button ">
                              <a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0">
                                2
                              </a>
                            </li>
                            <li class="paginate_button ">
                              <a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0">
                                3
                              </a>
                            </li>
                            <li class="paginate_button ">
                              <a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0">
                                4
                              </a>
                            </li>
                            <li class="paginate_button ">
                              <a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0">
                                5
                              </a>
                            </li>
                            <li class="paginate_button ">
                              <a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0">
                                6
                              </a>
                            </li>
                            <li class="paginate_button next" id="example2_next">
                              <a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0">
                                Next
                              </a>
                            </li>
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




        function update(id) {
          $.ajax({
            type: 'get',
            url: "/home/loan_id?id=" + id,
            data: "",
            dataType: 'json',
            beforeSend: function() {},
            success: function(json) {
              if (json.state == 1) {
                var msg = json.msg;
                $("#user-form :input").each(function() {
                  var this_id = $(this).attr("id");
                  var msg_ = msg[this_id];
                  $("#" + this_id).val(msg_);
                });
                $("#remark").val(json.msg.remark);
                $('#myModal').modal();



                  $("input[name='label']").each(function () {
                          $(this).prop('checked', false);//

                      });


               var checkbox= json.checkbox;
               for(var i=0;i<checkbox.length;i++){
                   $("input:checkbox[value='"+checkbox[i].labelid+"']").attr('checked','true');
               }





              } else {
                alert(json.msg);
              }
            },
            error: function(XmlHttpRequest) {
              alert('发送信息错误！！请稍后再试...');
            }

          })
        }

        function click2() {
          $("#user-form :input").each(function() {
            var this_id = $(this).attr("id");
            $("#" + this_id).val("");
          });
          $("#remark").val("");
          $("#status").val("1");
       $("input[name='label']").each(function () {
                          $(this).prop('checked', false);//

                      });
          $('#myModal').modal();
        }

        function save() {
          $.ajax({
            type: 'post',
            url: "/home/loansave",
            data: $('#user-form').serialize(),
            dataType: 'json',
            beforeSend: function() {},
            success: function(json) {
              if (json.state == 1) {
                $('#myModal').modal('hide');
                alert("成功");
                location.reload()
              } else {
                alert(json.msg);
              }
            },
            error: function(XmlHttpRequest) {
              alert('发送信息错误！！请稍后再试...');
            }

          })
        }
      </script>
      <%@ include file="../common/foot.jsp" %>