<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div style="display: none">
            <input type="hidden" id="s" value="${person.sex}">
            <input type="hidden" id="id" value="${param.id}">
        </div>
        <div class="panel panel-primary" id="panel-edit">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" id="beans">
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">用户姓名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder=""
                                   value="${person.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="orgId" class="col-sm-3 control-label">所属机构ID</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="orgId" name="orgId" placeholder=""
                                   value="${person.orgId}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="orgName" class="col-sm-3 control-label">所属机构名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="orgName" name="orgName"
                                   value="${person.orgName}"
                                   placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sex" class="col-sm-3 control-label">性别</label>
                        <div class="col-sm-9">
                            <select id="sex">
                                <option selected>男</option>
                                <option>女</option>
                            </select>
                        </div>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-info" id="btn_cancel">取消</button>
                        <c:if test="${param.id eq null}">
                            <button type="button" class="btn btn-danger" id="btn_save">保存</button>
                        </c:if>
                        <c:if test="${param.id ne null}">
                            <button type="button" class="btn btn-danger" id="btn_update">保存</button>
                        </c:if>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="<%=contextPath%>/app/common.js"></script>
<script src="<%=contextPath%>/app/person/person_edit.js"></script>
</body>
</html>
