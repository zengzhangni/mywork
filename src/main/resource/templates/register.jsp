<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui/demo/demo.css"/>
    <script type="text/javascript" src="/js/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css"/>
    <script>
        $(function () {
            /**
             * 获取验证码
             * */
            $("#sendButton").click(function () {
                var name = $("#nameInput").val();
                $.ajax({
                    type: "post",
                    url: "/member/yzm",
                    data: {"phone": name},
                    success: function (result) {
                        if (result.data != null) {
                            alert(result.data);
                        }
                    }
                });
            })
            /**
             * 注册
             * */
            $("#registerButton").click(function () {
                var name = $("#nameInput").val();
                var pwd = $("#pwdInput").val();
                var isPwd = $("#isPwdInput").val();
                var yzm = $("#yzm").val();
                var str = {"name": name, "pwd": pwd, "isPwd": isPwd, "yzm": yzm}
                $.ajax({
                    type: "post",
                    url: "/member/register",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify(str),
                    success: function (result) {
                        if (result.data === "验证码正确") {
                            location.href = "cs";
                        } else {
                            $("#pwdInput").val(pwd);
                            $("#isPwdInput").val(isPwd);
                            $("#yzm").val(null);
                        }
                    }
                });
            })
        });
    </script>
</head>
<body>
<div class="wrap login_wrap">
    <div class="content">
        <div class="logo"></div>
        <div class="register_box">
            <div class="login_form">
                <div class="login_title">
                    注册
                </div>
                <form id="registerForm" method="post">
                    <div class="form_text_ipt">
                        <input id="nameInput" name="username" type="text" placeholder="手机号">
                    </div>
                    <div class="form_text_ipt">
                        <input id="pwdInput" name="password" type="password" placeholder="密码">
                    </div>
                    <div class="form_text_ipt">
                        <input id="isPwdInput" name="password" type="password" placeholder="确认密码">
                    </div>
                    <div class="send_ipt">
                        <input id="yzm" name="yzm" type="text" placeholder="输入验证码">
                        <button style="width: 94px;height: 35px;padding-top: 5px" type="button" id="sendButton">获取验证码
                        </button>
                    </div>
                    <div class="form_btn">
                        <button type="button" id="registerButton">注册</button>
                    </div>
                    <div style="height: 20px"></div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
