<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <title>组织机构</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=contextPath%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="<%=contextPath%>/vendor/jquery/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=contextPath%>/vendor/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="<%=contextPath%>/vendor/ztree/js/jquery.ztree.all.min.js"></script>
    <script src="<%=contextPath%>/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=contextPath%>/vendor/layer/layer.js"></script>

    <style>
        #left {
            width: 400px;
            border: 1px solid #dcdcdc;
            overflow: auto;
            float: left;
        }

        #right {
            width: calc(100% - 410px);
            float: left;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3 ztree">
            <div id="orgTree"> </div>
        </div>
        <div class="col-md-9">
            <form class="form-inline">
                <div class="form-group">
                    <label for="orgName">机构名称</label>
                    <input type="text" class="form-control" placeholder="">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-info" id="btn_query">查询</button>
                        <button type="button" class="btn btn-primary" id="btn_edit">编辑</button>
                        <button type="button" class="btn btn-danger" id="btn_delete">删除</button>
                    </div>
                </div>
            </form>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <td>序号</td>
                        <td>机构名称</td>
                        <td>上级机构</td>
                        <td>备注</td>
                        <td>操作</td>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <div class="panel panel-primary" style="display: none" id="panel-edit">
                <div class="panel-heading">编辑</div>
                <div class="panel-body">
                    <form class="form-horizontal" id="beans">
                        <div class="form-group">
                            <label for="orgName" class="col-sm-3 control-label">机构名称</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="orgName" name="orgName" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="parentId" class="col-sm-3 control-label">上级机构ID</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="parentId" name="parentId" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="parentName" class="col-sm-3 control-label">上级机构名称</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="parentName" name="parentName"
                                       placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-3 control-label">备注</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="description" name="description"
                                       placeholder="">
                            </div>
                        </div>
                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-info" id="btn_cancel">取消</button>
                            <button type="button" class="btn btn-danger" id="btn_save">保存</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=contextPath%>/app/org/org.js"></script>
</body>
</html>
