<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
  <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ include file="../common/head.jsp" %>
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- -----------------------------------model -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
        aria-hidden="true">
          <div class="modal-content" style="width: 900px; margin: 34.5px auto;margin-top:5%">
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
                        姓名
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="realname" name="realname"
                        placeholder="姓名" data-bv-field="name">
                        <i class="form-control-feedback" data-bv-icon-for="name" style="display: none;">
                        </i>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="telphone" class="col-sm-3 control-label">
                        手机号
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="name" name="name" placeholder="手机号">
                      </div>
                    </div>
                    <div class="form-group has-feedback">
                      <label for="email" class="col-sm-3 control-label">
                        城市
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="city" name="city" placeholder="城市"
                        data-bv-field="email">
                        <i class="form-control-feedback" data-bv-icon-for="email" style="display: none;">
                        </i>
                      </div>
                    </div>
                    <div class="form-group has-feedback">
                      <label for="email" class="col-sm-3 control-label">
                        身份证
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="idcard" name="idcard" placeholder="身份证"
                        data-bv-field="email">
                        <i class="form-control-feedback" data-bv-icon-for="email" style="display: none;">
                        </i>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="telphone" class="col-sm-3 control-label">
                        婚姻状况
                      </label>
                      <div class="col-sm-8">
                        <select class="form-control" id='marriage' name="marriage">
                          <option value="未婚">
                            未婚
                          </option>
                          <option value="已婚">
                            已婚
                          </option>
                        </select>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="telphone" class="col-sm-3 control-label">
                        文化程度
                      </label>
                      <div class="col-sm-8">
                        <select class="form-control" id='culture' name="culture">
                          <option value="高中">
                            高中
                          </option>
                          <option value="大专">
                            大专
                          </option>
                          <option value="本科">
                            本科
                          </option>
                          <option value="硕士">
                            硕士
                          </option>
                          <option value="博士">
                            博士
                          </option>
                        </select>
                      </div>
                    </div>
                    <div>
                      <div class="form-group has-feedback">
                        <label for="name" class="col-sm-3 control-label">
                          是否成功贷款记录
                        </label>
                        <div class="col-sm-8">
                          <select class="form-control" id="loan" name="loan">
                            <option value="是">
                              是
                            </option>
                            <option value="否">
                              否
                            </option>
                          </select>
                        </div>
                      </div>
                    </div>
                    <div class="form-group has-feedback">
                      <label for="name" class="col-sm-3 control-label">
                        状态
                      </label>
                      <div class="col-sm-8">
                        <select class="form-control" id='status' name="status">
                          <option value="1">
                            显示
                          </option>
                          <option value="0">
                            隐藏
                          </option>
                        </select>
                      </div>
                    </div>

  <div class="form-group has-feedback">
                      <label for="name" class="col-sm-3 control-label">
                    收入形势
                      </label>
                      <div class="col-sm-8">
                        <select class="form-control" id='income' name="income">
                          <option value="良好">
                            良好
                          </option>
                          <option value="优秀">
                            优秀
                          </option>
                        </select>
                      </div>
                    </div>


                  </div>
                  <div class="col-md-6">
                    <div>
                      <div class="form-group has-feedback">
                        <label for="name" class="col-sm-3 control-label">
                          职业身份
                        </label>
                        <div class="col-sm-8">
                          <select class="form-control" id='job' name="job">
                            <option value="上班族">
                              上班族
                            </option>
                            <option value="个体户">
                              个体户
                            </option>
                            <option value="企业主">
                              企业主
                            </option>
                            <option value="自由职业">
                              自由职业
                            </option>
                            <option value="学生">
                              学生
                            </option>
                          </select>
                        </div>
                      </div>
                    </div>
                    <div>
                      <div class="form-group has-feedback">
                        <label for="name" class="col-sm-3 control-label">
                          工作时间
                        </label>
                        <div class="col-sm-8">
                          <select class="form-control" id='jobtime' name="jobtime">
                            <option value="不足3个月">
                              不足3个月
                            </option>
                            <option value="3-5个月">
                              3-5个月
                            </option>
                            <option value="6-12个月">
                              6-12个月
                            </option>
                            <option value="1-3年">
                              1-3年
                            </option>
                            <option value="4-7年">
                              4-7年
                            </option>
                            <option value="7年以上">
                              7年以上
                            </option>
                          </select>
                        </div>
                      </div>
                    </div>
                    <div>
                      <div class="form-group has-feedback">
                        <label for="name" class="col-sm-3 control-label">
                          6个月以上缴纳社保
                        </label>
                        <div class="col-sm-8">
                          <select class="form-control" id='insurance' name="insurance">
                            <option value="是">
                              是
                            </option>
                            <option value="否">
                              否
                            </option>
                          </select>
                        </div>
                      </div>
                    </div>
                    <div>
                      <div class="form-group has-feedback">
                        <label for="name" class="col-sm-3 control-label">
                          是否有信用卡
                        </label>
                        <div class="col-sm-8">
                          <select class="form-control" id='creditcard' name="creditcard">
                            <option value="是">
                              是
                            </option>
                            <option value="否">
                              否
                            </option>
                          </select>
                        </div>
                      </div>
                    </div>
                    <div>
                      <div class="form-group has-feedback">
                        <label for="name" class="col-sm-3 control-label">
                          名下房产
                        </label>
                        <div class="col-sm-8">
                          <select class="form-control" id='house' name="house">
                            <option value="无房产">
                              无房产
                            </option>
                            <option value="商品住宅">
                              商品住宅
                            </option>
                            <option value="商铺">
                              商铺
                            </option>
                            <option value="办公楼">
                              办公楼
                            </option>
                            <option value="厂房">
                              厂房
                            </option>
                            <option value="宅基地/自建房">
                              宅基地/自建房
                            </option>
                          </select>
                        </div>
                      </div>
                    </div>
                    <div>
                      <div class="form-group has-feedback">
                        <label for="name" class="col-sm-3 control-label">
                          名下车产
                        </label>
                        <div class="col-sm-8">
                          <select class="form-control" id='car' name="car">
                            <option value="无车产">
                              无车产
                            </option>
                            <option value="名下有车">
                              名下有车
                            </option>
                            <option value="有车但车已被抵押">
                              有车但车已被抵押
                            </option>
                          </select>
                        </div>
                      </div>
                    </div>
                    <div>
                      <div class="form-group has-feedback">
                        <label for="name" class="col-sm-3 control-label">
                          信用情况
                        </label>
                        <div class="col-sm-8">
                          <select class="form-control" id='credit' name="credit">
                            <option value="无信用记录">
                              无信用记录
                            </option>
                            <option value="信用记录良好">
                              信用记录良好
                            </option>
                            <option value="少量逾期">
                              少量逾期
                            </option>
                            <option value="征信较差">
                              征信较差
                            </option>
                          </select>
                        </div>
                      </div>
                    </div>

                    <div class="form-group has-feedback">
                      <label for="name" class="col-sm-3 control-label">
                        月收入
                      </label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="monthincome" name="monthincome"
                        placeholder="月收入">
                      </div>
                    </div>



		      <div>
                                          <div class="form-group has-feedback">
                                            <label for="name" class="col-sm-3 control-label">
                                              公司类型
                                            </label>
                                            <div class="col-sm-8">
                                              <select class="form-control" id='company' name="company">
                                                <option value="无">
                                                 无
                                                </option>
                                                <option value="私企">
                                                  私企
                                                </option>
                                                <option value="国企">
                                                  国企
                                                </option>
                                              </select>
         </div>
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
                <div class="box-header" >
                  <div  style="float:right">
                    <div >
             						<div style="float:left">
             						<div style="float:left"><input  placeholder="请输入手机号码" name="phone" class="form-control" type="search" likeoption="true" id="phone"></div>
             						<button type="button" class="btn btn-primary" data-btn-type="search" onclick="find()">查询</button>
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
                                用户名
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              colspan="1" aria-label="Browser: activate to sort column ascending">
                                手机号
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              style="display:none" colspan="1" aria-label="Browser: activate to sort column ascending">
                                还款方式
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              style="display:none" colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                额度范围
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              style="display:none" colspan="1" aria-label="Engine version: activate to sort column ascending">
                                期限范围
                              </th>
                              <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                              style="display:none" colspan="1" aria-label="Platform(s): activate to sort column ascending">
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
                                  ${list.realname}
                                </td>
                                <td>
                                  ${list.name}
                                </td>
                                <td>
                                  ${list.status==1? "正常" : "被封"}
                                </td>
                                <td>
                                  <div onclick="update(${list.id})" style="float:left;cursor:pointer">
                                    <a>
                                      修改
                                    </a>
                                  </div>
                                  <div style="float:left">
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                  </div>
                                  <div onclick="update_time(${list.id})" style="float:left">
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
                        <div class="dataTables_info" id="example2_info" role="status" aria-live="polite"
                        style="display:none">
                          Showing 1 to 10 of 57 entries
                        </div>
                      </div>
                      <div class="col-sm-7">
                        <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                          <ul class="pagination">
                            <div id="page_div">
                              <%@ include file="../common/pagehelper.jsp" %>
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
            url: "/home/user_id?id=" + id,
            data: "",
            dataType: 'json',
            beforeSend: function() {},
            success: function(json) {

              if (json.state == 1) {
                var msg = json.msg;
                $("#user-form :input").each(function() {
                  var this_id = $(this).attr("id");
                  var msg_ = msg[this_id];
                  var jQueryObject = $("#" + this_id); //取jQuery对象，实际上它是一个数组，只不过里面只有一个元素，因为这里选择器是id
                  var domObject = jQueryObject[0]; //从jQuery对象中得到原生的DOM对象
                  if (domObject == "SELECT") {
                    $("#" + this_id + " option[value='" + msg_ + "']").attr("selected", true);
                  } else {
                    $("#" + this_id).val(msg_);
                  }
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

        function save() {
          $.ajax({
            type: 'post',
            url: "/home/usesave",
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

        function find(){
            var phone=$("#phone").val();
            window.location.href="/home/user?phone="+phone;
        }
      </script>
      <%@ include file="../common/foot.jsp" %>