<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui/demo/demo.css"/>
    <script type="text/javascript" src="/js/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div id="cc" class="easyui-layout" style="width:100%;height:100%;">
    <div data-options="region:'north',split:true" style="height:100px;">
        <div style="height: 100px">
            <img src="/img/logo_bg.jpg" style="height: 100px;width: 100%"/>
        </div>
    </div>
    <div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
        <ul id="tt" class="easyui-tree">
            <li>
                <span>用户管理</span>
                <ul>
                    <li>
                        <span>用户管理1</span>
                        <ul>
                            <li><span><a href="#">VIP用户</a></span></li>
                            <li><span>垃圾用户</span></li>
                            <li><span>普通用户</span></li>
                        </ul>
                    </li>
                    <li><span>资源池管理</span></li>
                </ul>
            </li>
            <li><span>随便写一点</span></li>
            <li><span>不然好尴尬</span></li>
        </ul>
    </div>
    <div data-options="region:'center',title:'主页'" style="padding:5px;background:#eee;">
        <table class="easyui-datagrid" title="" style="width:100%;height:100%"
               data-options="singleSelect:true,
                               collapsible:true,
                               url:'/member/pageList',method:'get',
                                pagination:true">
            <thead>
            <tr>
                <th data-options="field:'id',width:'25%', align:'center'">ID</th>
                <th data-options="field:'memberUuid',width:'25%', align:'center'">会员uuid</th>
                <th data-options="field:'registerPhone',width:'25%',align:'center'">手机号</th>
                <th data-options="field:'memberType',width:'25%',align:'center'">会员类型</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
</body>
</html>
