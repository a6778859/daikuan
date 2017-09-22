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
                <input type="hidden" name="pic" id="pic">
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
                        placeholder="还款方式">
                      </div>
                    </div>
                    <div class="form-group has-feedback">
                      <label for="email" class="col-sm-3 control-label">
                        日利率
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="interestrate" name="interestrate"
                        placeholder="请输入如0.05%" data-bv-field="email">
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

                      <div class="form-group">
                                          <label for="telphone" class="col-sm-3 control-label">
                                            标签
                                          </label>
                                          <div class="col-sm-8">
                                                         <select class="form-control" id='label' name="label">
                                                           <option value="热门">
                                                             热门
                                                           </option>
                                                           <option value="最新">
                                                             最新
                                                           </option>

                                                                           </select>
                                          </div>
                       </div>

                       <div class="form-group">
                                          <label for="telphone" class="col-sm-3 control-label">
                                            标签2
                                          </label>
                                          <div class="col-sm-8">
                                                         <select class="form-control" id='label3' name="label3">
                                                           <option value="小额贷款">
                                                             小额贷款
                                                           </option>
                                                           <option value="大额贷款">
                                                             大额贷款
                                                           </option>

                                                                                                                           </select>
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

                         <div class="form-group">
                                          <label for="mobile" class="col-sm-3 control-label">
                                            上传图片
                                          </label>
                                          <div class="col-sm-8">
 <p><input type="file" id="myfiles" name="myfiles"  /></p>
    <input type="button" value="上传" onclick="upload()"  />


                                          </div>
                                        </div>



                   <div class="form-group">
                      <label for="qq" class="col-sm-3 control-label">
                      所需材料
                      </label>
                      <div class="col-sm-8">
                        <textarea name="material" id="material" placeholder="" class="form-control"
                        data-bv-field="remark">
                        </textarea>
                      </div>
                    </div>

                    <div class="form-group">
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
                                <td class="sorting_1">
                                  <img src="${list.pic}" style="width:50px;height:50px">
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

                                    <div onclick="update(${list.id})" style="float:left">
                                          <a>修改</a>
                                    </div>
                               <div style="float:left">
                                               &nbsp;&nbsp;&nbsp;&nbsp;
                                                              </div>
                                    <div onclick="update_time(${list.id})" style="float:left"><a>置顶</a></div>
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

                  if(this_id=="label"){
                   $("#label option[value='"+msg_+"']").attr("selected",true);
                   }else if(this_id=="label3"){
                     $("#label3 option[value='"+msg_+"']").attr("selected",true);
                   }

                   else{
                   $("#" + this_id).val(msg_);
                   }



                });

                      $("#material").val(json.msg.material);
                $("#remark").val(json.msg.remark);
                $('#myModal').modal();

                $("input[name='label2']").each(function() {
                  $(this).prop('checked', false); //
                });

                var checkbox = json.checkbox;
                for (var i = 0; i < checkbox.length; i++) {
                  $("input:checkbox[value='" + checkbox[i].labelid + "']").prop('checked', 'checked');
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

          $("#material").val("");
          $("input[name='label2']").each(function() {
            $(this).prop('checked', false); //
          });

          $('#label').prop('selectedIndex', 0);
          $('#label3').prop('selectedIndex', 0);
          $('#status').prop('selectedIndex', 0);
          $('#myModal').modal();
        }


        function update_time(id){
               $.ajax({
                        type: 'get',
                        url: "/home/loan_time?id="+id,
                        data: "",
                        dataType: 'json',
                        beforeSend: function() {},
                        success: function(json) {
                          if (json.state == 1) {
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