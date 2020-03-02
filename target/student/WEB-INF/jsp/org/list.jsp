<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 27267
  Date: 2020/2/19
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>组织机构列表</title>
</head>
<body>
<table width="700" align="center" border="1px">
    <h2><a href="/org/add">添加</a></h2>
    <tr>
        <td>组织</td><td>组织名</td><td>排序号</td><td>上级id</td><td>上级名称</td><td>描述</td><td>操作</td>
    </tr>
    <c:if test="${pagers.size() eq 0}">
        <tr>
        <td colspan="6">目前还没有数据</td>
        </tr>
    </c:if>
    <c:if test="${pagers.size() gt 0}">
        <c:forEach items="${pagers}" var="o">
            <tr>
                <td>${o.id}</td>
                <td>${o.name}</td>
                <td>${o.orderNum}</td>
                <td>${o.parentId}</td>
                <td>${o.parentName}</td>
                <td>${o.description}</td>
                <td><a href="${o.id}/update">更新</a >&nbsp;<a href="${o.id}/delete">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <%--<td colspan="6">
                <jsp:include page="/WEB-INF/inc/pager.jsp">
                    <jsp:param value="pagers" name="url"/>
                    <jsp:param value="${pagers.size()}" name="items"/>
                </jsp:include>
            </td>--%>
        </tr>
    </c:if>

</table>
</body>
</html>
