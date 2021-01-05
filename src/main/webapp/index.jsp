<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<c:if test="${empty requestScope.pageUtil}">
    <jsp:forward page="StuInfoServlet?type=StuInfoPage"/>
</c:if>
<table align="center" border="1" cellspacing="0" cellpadding="0" width="550px">
    <tr><th colspan="8"><a href="add.jsp">添加</a></th></tr>
    <tr>
        <th>学生编号</th>
        <th>学生姓名</th>
        <th>学生密码</th>
        <th>学生性别</th>
        <th>学生年龄</th>
        <th>家庭住址</th>
        <th>所学课程</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.pageUtil.lists}" var="stu" >
        <tr align="center">
            <td>${stu.stu_id}</td>
            <td>${stu.stu_name}</td>
            <td>${stu.stu_pwd}</td>
            <td>${stu.sex.s_sex}</td>
            <td>${stu.stu_age}</td>
            <td>${stu.stu_address}</td>
            <td>${stu.stu_major}</td>
            <td>
                <a href="StuInfoServlet?type=del&stu_id=${stu.stu_id}">删除</a>
                <a href="StuInfoServlet?type=get&stu_id=${stu.stu_id}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="8" align="center">
            <c:if test="${requestScope.pageUtil.pageindex>1}">
                <a href="StuInfoServlet?type=StuInfoPage">首页</a>
                <a href="StuInfoServlet?type=StuInfoPage&pageIndexStr=${requestScope.pageUtil.pageindex-1}">上一页</a>
            </c:if>
            <c:if test="${requestScope.pageUtil.pageindex<requestScope.pageUtil.pagecount}">
                <a href="StuInfoServlet?type=StuInfoPage&pageIndexStr=${requestScope.pageUtil.pageindex+1}">下一页</a>
                <a href="StuInfoServlet?type=StuInfoPage&pageIndexStr=${requestScope.pageUtil.pagecount}">尾页</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
