<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>${title}</title>
<meta name="description" content="${des}">
<meta name="viewport"
	content="width=device-width, initial-scale=1,user-scalable=no">
<link href="/css/styles/global.css?version=2" rel="stylesheet">

<body style="background:#FCCD01 ">
	<!--head
<div class="m-hd">
  <div class="l-ct">用户注册</div>
</div>
head-->
	<style type="text/css">
.explain {
	color: #865000;
	margin-top: .666667rem;
	padding-bottom: 1.333333rem;
	line-height: 1.2;
}

.explain h3 {
	font-size: 26px;
	line-height: 1.3;
	text-align: center;
	margin-bottom: .266667rem;
	font-weight: 700
}

.explain h3:after,.explain h3:before {
	content: "";
	width: .266667rem;
	height: .026667rem;
	background: hsla(0, 0%, 100%, .6);
	display: inline-block;
	vertical-align: super;
	margin: 0 .213333rem
}

.explain ol {
	list-style: decimal;
	padding-left: 2em
}

.explain li {
	font-size: .32rem;
	line-height: .20rem;
	margin-bottom: .186667rem;
	font-size: 18px;
	line-height: 1.2;
}

.hongbao-box {
	text-align: center;
	padding-top: .533333rem
}

.hongbao-box .hongbao-content-amount {
	font-size: .4rem;
	margin-bottom: .266667rem
}

.hongbao-box .hongbao-content-amount span:first-of-type {
	color: #f85f42
}

.hongbao-box .hongbao-content-amount span:nth-of-type(2) {
	color: #f85f42;
	font-size: .96rem;
	line-height: .96rem;
	margin-right: .053333rem
}

.hongbao-box .hongbao-content-info {
	font-size: .346667rem;
	line-height: .346667rem;
	margin-bottom: .4rem
}

.hongbao-box .phonenumber {
	padding: .386667rem 0;
	font-size: .4rem;
	color: #999;
	background: hsla(0, 0%, 100%, .75);
	margin-bottom: .266667rem
}

.hongbao-box .btn,.hongbao-box .phonenumber {
	width: 8.266667rem;
	height: 1.173333rem;
	text-align: center;
	outline: none;
	border: none;
	border-radius: .053333rem
}

.hongbao-box .btn {
	line-height: 1.173333rem;
	font-size: .453333rem;
	color: #fff;
	margin-bottom: .4rem;
	cursor: pointer
}

.hongbao-box a {
	display: inline-block
}

.hongbao-invite {
	background: url(/images/wechat/error.png) no-repeat;
	background-size: 100% 100%;
	width: 100%;
	height: 27.65em;
}

.hongbao-invite .hongbao-content-amount {
	color: #4f80bc
}

.hongbao-invite .hongbao-content-info {
	color: #7b9ec8
}

.hongbao-invite .btn {
	background: #3190e8
}

.btn {
	display: block;
	width: 14.85em;
	height: 6.65em;
	line-height: 2.65em;
	background: url(/images/wechat/linqu.jpg) no-repeat;
	background-size: 100% 100%;
	margin: 0 auto;
}

.btn2 {
	display: block;
	width: 14.85em;
	height: 6.65em;
	line-height: 2.65em;
	background: url(/images/html5/zhuche.jpg) no-repeat;
	background-size: 100% 100%;
	margin: 0 auto;
}
</style>


	<div class="regist-top"><img src="/images/html5/1.png" style="width:100%"></div>

	<!--body-->
	<div class="l-ct f-mt20">
		<div class="m-form m-form2">
			<c:choose>
				<c:when test="${!empty error}">
					<div class="hongbao-body">
						<div class="hongbao-box hongbao-invite">
							<div style="padding-top:20.133333rem;font-size:36px">${error}
							</div>
						</div>
					</div>

				</c:when>
				<c:otherwise>

					<!--control-->
					<div id="red" style="display:none">
						<div class="control">
							<input class="pubInput" type="text" maxlength="11"
								placeholder="请输入手机号" id="phonenumber" name="mobile">
						</div>
						<div style="padding-bottom:3rem">
							<a href="javascript:;" id="submit" class='btn'></a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>


			<div class="hongbao-body" id="chenggong" style="display:none">
						<div class="hongbao-box hongbao-invite" style="background: url(/images/wechat/chengong.png) no-repeat;    background-size: 100% 100%;">
							<div style="padding-top:20.133333rem;font-size:36px">
							</div>
						</div>
			</div>


			<div id="login" ">
				<form method="post" novalidate="novalidate" id="login_post">

					<!--control-->
					<div class="control">
						<input class="pubInput" type="text" maxlength="11"
							placeholder="请输入手机号" name="MobilePhone" id="MobilePhone">
					</div>
					<!--control End-->

					<!--control-->
					<div class="control">
						<input class="pubInput" type="text" name="Code_" id="imgCode"
							maxlength="6" placeholder="请输入图片验证码"> <a
							href="javascript:;" class="newImgCod"
							style="position:absolute;right:8px; top:8px; cursor: pointer; display: inline-block;height: 31px;padding: 0 0 0 15px;">
							<img src="/AuthImageServlet" id="vimg"  onclick="changeCode();"
							style="width:80px;height:30px;">
						</a>
					</div>
					<!--control End-->

					<!--control-->
					<div class="control">
						<input class="pubInput" type="text" name="CodePhone" id="code"
							maxlength="6" placeholder="请输入验证码">
						<div id="getCode"
							style="display: inline-block;position:absolute;top:8px;right:8px;padding:0px;border:0px">
							<a class="fn-h-btn Y-countdown" href="javascript:void(0);"> <span
								class="timedown">获取验证码</span>
							</a>
						</div>
					</div>
					<!--control End-->

					<!--control-->
					<div class="control">
						<input class="pubInput" type="password" name="Password"
							maxlength="20" id="Password" placeholder="请输入密码">
					</div>
					<!--control End-->

					<!--control-->

					<!--control End-->

		                <div style="padding-bottom:3rem">
						<a href="javascript:;" class='btn2'></a>
					</div>
					<input type="hidden" name="Name" id="Name" />
				</form>
			</div>
		</div>
	</div>





	<!--body End-->
	<script src="/adminlte/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script>
		$(".btn").click(function() {
			var phone = $("#phonenumber").val();
			if (phone && phone.length == 11) {
			} else {
				alert("请输入正确手机号码")
				return false;
			}

			$.ajax({
				type : 'get',
				url : '/api/getWeiRed.html?out_trade_no=${orderid}&phone=' + phone,
				data : "",
				dataType : 'json',
				beforeSend : function() {
				},
				success : function(json) {
					if (json.state == 1) {
						//alert(json.msg);
						//领取成功返回
						$("#red").hide();
						$("#chenggong").show();
					} else {
						if (json.state == 2) {
							$("#red").hide();
							$("#login").show();
						} else {
							alert(json.msg);
						}
					}
				},
				error : function(XmlHttpRequest) {
					alert('发送信息错误！！请稍后再试...');
				}
			})

		});

		//手机验证码
		document.getElementById("getCode").onclick = function() {
			if($('.timedown').html()!="获取验证码"){
				return false;
			}
			//获取手机验证码
			var PhoneStr = $("*[name='MobilePhone']").val();
			var Code_ = $("*[name='Code_']").val();
			var url = "/Phone/Vcode?PhoneStr=" + PhoneStr + "&Code_=" + Code_;
			$.ajax({
				type : 'get',
				url : url,
				//data : '',
				dataType : 'json',
				cache : false,
				beforeSend : function() {
				},
				success : function(json) {
					if (json.state == 1) {
						time(document.getElementById("getCode"));
						alert("发送成功");
					} else {
						if (json.msg != "验证码错误") {
							changeCode();
						}
						alert(json.msg);
					}
				},
				error : function(XmlHttpRequest) {
					alert('发送信息错误！！请稍后再试...');
				}
			})
		}

		var wait = 60;
		function time(o) {
			if (wait == 0) {
				o.removeAttribute("disabled");
				$('.timedown').html('获取验证码');
				wait = 60;

			} else {
				o.setAttribute("disabled", true);
				$('.timedown').html("重新发送(" + wait + ")");
				wait--;
				setTimeout(function() {
					time(o)
				}, 1000)
			}
		}

		$(".btn2").click(function() {
			var phone = $("#MobilePhone").val();
			if (phone && phone.length == 11) {
			} else {
				alert("请输入正确手机号码")
				return false;
			}
			if($("#Password")&&$("#Password").val().length>=6){
			}else{
				alert("密码长度不能小于6位")
				return false;
			}

			$("#Name").val(phone);
			var f = $('#login_post');
			$.ajax({
				type : 'post',
				url : '/Phone/Register',
				data : f.serialize(),
				dataType : 'json',
				cache : false,
				beforeSend : function() {
				},
				success : function(json) {
					if (json.state == 1) {
						alert("注册成功");
						location.reload();
					} else {
						alert(json.msg);
					}
				},
				error : function(XmlHttpRequest) {
					alert('发送信息错误！！请稍后再试...');
				}
			})

		});

		function changeCode() {
			var imgNode = document.getElementById("vimg");
			imgNode.src = "/AuthImageServlet?t=" + Math.random();
		}

	</script>

</body>
</html>