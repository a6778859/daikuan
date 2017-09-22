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
                <input type="hidden" name="companyid" id="companyid" value="">
                <input type="hidden" name="pic" id="pic">
                <div class="box-body">
                  <div class="col-md-6">
                    <div class="form-group has-feedback">
                      <label for="name" class="col-sm-3 control-label">
                        公司名称
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="companyname" name="companyname" placeholder="公司名称"
                        data-bv-field="name">
                        <i class="form-control-feedback" data-bv-icon-for="name" style="display: none;">
                        </i>
                      </div>
                    </div>



                      <div class="form-group">
                          <label for="name" class="col-sm-3 control-label">
                                             描述
                                           </label>
                                           <div class="col-sm-8">
                                             <input type="text" class="form-control" id="remark" name="remark" placeholder="描述"
                                             data-bv-field="name">
                                             <i class="form-control-feedback" data-bv-icon-for="name" style="display: none;">
                                             </i>
                                           </div>
                       </div>


                  </div>
                  <div class="col-md-6">




                         <div class="form-group">
                                          <label for="mobile" class="col-sm-3 control-label">
                                            上传图片
                                          </label>
                                          <div class="col-sm-8">
 <p><input type="file" id="myfiles" name="myfiles"  /></p>
    <input type="button" value="上传" onclick="upload()"  />

                                          </div>
                                        </div>







                  </div>




                </div>
                <!-- /.box-body -->
                <div class="box-footer ">
                  <div class="form-group" style="width:100%">
                    <c:forEach var="list" items="${labelList}">
                      <div class="checkbox" style='width:25%;float:left;'>
                        <label>
                          <input type="checkbox" value="${list.id}" name="label2">
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
                                  图片
                               </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              colspan="1" aria-label="Browser: activate to sort column ascending">
                                描述
                              </th>



                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" style="display:none"
                              colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                额度范围
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" style="display:none"
                              colspan="1" aria-label="Engine version: activate to sort column ascending">
                                期限范围
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" style="display:none"
                              colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                放款方式
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" style="display:none"
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
                                  ${list.companyname}
                                </td>
                                <td class="sorting_1">
                                  <img src="${list.pic}" style="width:50px;height:50px">
                                  </td>
                                <td>
                                  ${list.remark}
                                </td>

                                <td>

                                    <div onclick="update(${list.companyid})" style="float:left">
                                          <a>修改</a>
                                    </div>
                               <div style="float:left">
                                               &nbsp;&nbsp;&nbsp;&nbsp;
                                                              </div>

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
                        <div class="dataTables_info" id="example2_info" role="status" aria-live="polite" style="display:none">
                          Showing 1 to 10 of 57 entries
                        </div>
                      </div>
                      <div class="col-sm-7">
                        <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                          <ul class="pagination">
                             <div id="page_div">
                                                  <%@ include file="../common/pagehelper.jsp"%>
                                              </div>
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
            url: "/home/company_id?companyid=" + id,
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


                $('#myModal').modal();
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
          $('#myModal').modal();
        }





        function save() {
          $.ajax({
            type: 'post',
            url: "/home/companysave",
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

        function upload(){
            $.ajaxFileUpload
            (
                {
                    url: '/home/uploadPic', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: 'myfiles', //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
                    success: function (data, status)  //服务器成功响应处理函数
                                    {
                    if (data.state == 1) {
                                    $("#pic").val(data.msg);
                                      alert("上传成功");
                                      }else{
                        alert(data.msg);
                   }
                     },
                    error: function (data, status, e)//服务器响应失败处理函数
                    {
                        alert(e);
                    }
                }
            )
            return false;
        }

      </script>
      <%@ include file="../common/foot.jsp" %>