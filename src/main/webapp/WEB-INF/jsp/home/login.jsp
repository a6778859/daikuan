<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>后台 | Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${TMP}bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${TMP}dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${TMP}plugins/iCheck/square/blue.css">

  <style>

      .modal-content {
        margin-top:40%
  }
  </style>


  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>

			</div>
			<div class="modal-body">

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>

			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<div class="login-box">
  <div class="login-logo">
   <b>Admin</b>LTE
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session</p>

    <form  method="post" id="post_login">
      <div class="form-group has-feedback">
        <input type="input" class="form-control" name="name" value="admin">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Password" name="password" value="123456">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label style="display:none">
              <input type="checkbox" > Remember Me
            </label>
          </div>
        </div>
            </div>
        <!-- /.col -->

        <!-- /.col -->
    </form>


  <div  style="margin-left:80%">
         <button id="submit"  >Sign In</button>
       </div>


    <div class="social-auth-links text-center" style="display:none">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using
        Facebook</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using
        Google+</a>
    </div>
    <!-- /.social-auth-links -->

    <a href="#" style="display:none">I forgot my password</a><br>
    <a href="register.html" class="text-center" style="display:none">Register a new membership</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="${TMP}plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${TMP}bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${TMP}plugins/iCheck/icheck.min.js"></script>
<script>


$("#submit").click(function(e){
$.ajax({
				type : 'post',
				url : "/home/login",
			    data:$('#post_login').serialize(),
				dataType : 'json',
				beforeSend : function() {
				},
				success : function(json) {
					if (json.state == 1) {
					   window.location.href="/home/index";
					} else {
						$(".modal-body").html(json.msg);
						 $('#myModal').modal();

					}
				},
				error : function(XmlHttpRequest) {
				     $(".modal-body").html('发送信息错误！！请稍后再试...');
					 $('#myModal').modal();

				}

			})
   });



</script>
</body>
</html>
