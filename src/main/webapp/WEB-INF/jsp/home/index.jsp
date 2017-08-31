<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Bootstrap 实例 - 模态框（Modal）插件</title>
    <style>
    .modal-content {
      position: fixed;
      margin-top:40%

    }
    </style>


</head>
<body>

<h2>创建模态框（Modal）</h2>
<!-- 按钮触发模态框 -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	开始演示模态框
</button>
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
				在这里添加一些文本
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>

			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>

<link rel="stylesheet" href="${TMP}bootstrap/css/bootstrap.min.css">
  <script src="${TMP}/plugins/jQuery/jquery-2.2.3.min.js"></script>
  <!-- Bootstrap 3.3.6 -->
    <script src="${TMP}/bootstrap/js/bootstrap.min.js"></script>
</html>

