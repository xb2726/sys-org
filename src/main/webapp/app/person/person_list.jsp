<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <title>用户</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=contextPath%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="<%=contextPath%>/vendor/jquery/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=contextPath%>/vendor/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="<%=contextPath%>/vendor/ztree/js/jquery.ztree.all.min.js"></script>
    <script src="<%=contextPath%>/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=contextPath%>/vendor/layer/layer.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <form class="form-inline">
            <div class="form-group">
                <label for="orgName">机构名称</label>
                <input type="text" class="form-control" id="orgName" placeholder="">
                <label for="name">用户姓名</label>
                <input type="text" class="form-control" id="name" placeholder="">
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-info" id="btn_query">查询</button>
                    <button type="button" class="btn btn-primary" id="btn_add">新建用户</button>
                </div>
            </div>
        </form>
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <td>序号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>所属机构</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
            <jsp:include page="/app/page.jsp"/>
        </div>
    </div>
</div>
<script src="<%=contextPath%>/app/common.js"></script>
<script src="<%=contextPath%>/app/person/person_list.js?v=1"></script>
</body>
</html>
