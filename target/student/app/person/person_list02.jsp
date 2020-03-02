<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <meta charset="utf-8">
    <title>用户</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=contextPath%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="<%=contextPath%>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=contextPath%>/vendor/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=contextPath%>/vendor/layer/theme/default/layer.css" media="all">
</head>
<body>
<table id="demo" lay-filter="test"></table>

<script src="<%=contextPath%>/vendor/layer/layer.js"></script>
<script>
    layer.use('table', function(){
        var table = layer.table;
        //第一个实例

        table.render({
            elem: '#demo'
            ,height: 312
            ,url: '/person/query' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'name', title: '用户名', width:80}
                ,{field: 'orgId', title: '组织id', width:80, sort: true}
                ,{field: 'orgName', title: '组织名称', width:80}
                ,{field: 'sex', title: '性别', width: 80, sort: true}
            ]]
        });
    });
</script>
<script src="<%=contextPath%>/app/common.js"></script>
</body>
</html>
