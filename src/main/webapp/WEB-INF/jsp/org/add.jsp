<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 27267
  Date: 2020/2/29
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加人员</title>
</head>
<body>

<form:form method="post" modelAttribute="org" >
    <table border="1" align="center" width="700">
    <tr>
    <td> 机构名称: </td> <td><form:input path="name"/></td>
    </tr><br>
    <tr> <td> 机构排序号: </td> <td><form:input path="orderNum"/></td>
    </tr><br>
    <tr> <td> 上级组织id: </td> <td><form:input path="parentId"/></td>
    </tr><br>
    <tr> <td> 上级组织名称: </td> <td><form:input path="parentName"/></td>
    </tr><br>
    <tr> <td> 描述: </td> <td><form:input path="description"/></td>
    </tr><br>
    <tr >
        <td colspan="2"><input type="submit" value="添加"></td>
    </tr>
</table>
</form:form>

</body>
</html>
