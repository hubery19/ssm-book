<%--
  Created by IntelliJ IDEA.
  User: Hubery
  Date: 2019/9/5
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.2.1.min.js" type="text/javascript"></script>
</head>
<body>
<center>
    <div style="width: 800px;border: solid 2px slategray">
        <h2>图书借阅系统</h2>
        <form id="form1" method="post">
            <input hidden name="id" value="${b.bookid}">
            <input hidden name="isb" value="${b.isborrow}">
            <table border="1" cellpadding="4" cellspacing="0">
                <tr>
                    <td>图书编号</td>
                    <td>
                        <input name="bookcode" value="${b.bookcode}" >
                    </td>
                </tr>
                <tr>
                    <td>图书名称</td>
                    <td>
                        <input name="bookname" value="${b.bookname}">
                    </td>
                </tr>
                <tr>
                    <td>图书分类</td>
                    <td>
                        <select name="booktype">
                            <option value="-1">全部</option>
                            <c:forEach items="${tList}" var="t">
                                <option value="${t.id}"
                                        <c:if test="${b.booktype == t.id}">selected = selected</c:if>
                                >${t.typename}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>作者</td>
                    <td>
                        <input name="bookauthor" value="${b.bookauthor}">
                    </td>
                </tr>
                <tr>
                    <td>出版社</td>
                    <td>
                        <input name="publishpress" value="${b.publishpress}">
                    </td>
                </tr>
                <tr>
                    <td>出版时间</td>
                    <td>


                        <input name="publishdate" value="<fmt:formatDate value='${b.publishdate}' type='time' pattern='yyyy-MM-dd'/>">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <center>
                            <input type="button" id="btn_form" value="提交">
                            <input type="reset" value="取消">
                        </center>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</center>
<script>
    $(function () {
        $('#btn_form').click(function () {
            $.ajax({
                url:"/book/save",
                type:"POST",
                data:$("#form1").serialize(),
                dataType:"JSON",
                success:function (data) {
                    alert(data.msg)
                    location.href=data.url
                }
            })
        })
    })
</script>
</body>
</html>
