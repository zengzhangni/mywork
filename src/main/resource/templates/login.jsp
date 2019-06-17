<html>
<head>
    <title>用户登录</title>
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
            $("#loginButton").click(function () {
                var name = $("#nameInput").val();
                var pwd = $("#pwdInput").val();
                var str = {"name": name, "pwd": pwd}
                $.ajax({
                    type: "post",
                    url: "/member/login",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify(str),
                    success: function (result) {
                        if (result.code === 200) {
                            location.href = "cs";
                        }
                        console.debug(result);
                    }
                });
            })
        })
    </script>
</head>
<body>
<div class="wrap login_wrap">
    <div class="content">
        <div class="logo"></div>
        <div class="login_box">
            <div class="login_form">
                <div class="login_title">
                    登录
                </div>
                <form id="loginForm" method="post">
                    <div class="form_text_ipt">
                        <input id="nameInput" name="username" type="text" placeholder="手机号">
                    </div>
                    <div class="ececk_warning"><span>手机号/邮箱不能为空</span></div>
                    <div class="form_text_ipt">
                        <input id="pwdInput" name="password" type="password" placeholder="密码">
                    </div>
                    <div class="ececk_warning"><span>密码不能为空</span></div>
                    <div class="form_check_ipt">
                        <div class="left check_left">
                            <label><input name="" type="checkbox"> 下次自动登录</label>
                        </div>
                        <div class="right check_right">
                            <a href="#">忘记密码？</a>
                        </div>
                    </div>
                    <div class="form_btn">
                        <button type="button" id="loginButton">登录</button>
                    </div>
                    <div class="form_reg_btn">
                        <span>还没有帐号？</span><a href="register">马上注册</a>
                    </div>
                </form>
                <div class="other_login">
                    <div class="left other_left">
                        <span>其它登录方式</span>
                    </div>
                    <div class="right other_right">
                        <a href="javascript;">
                            <img src="/img/wx.png" style="height: 40px;width: 40px;margin-top: 15px"/>
                        </a>
                        <a href="javascript;">
                            <img src="/img/qq.png" style="height: 40px;width: 40px;margin-top: 15px"/>
                        </a>
                        <a href="javascript;">
                            <img src="/img/wb.png" style="height: 40px;width: 40px;margin-top: 15px"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div/>
</body>
</html>
