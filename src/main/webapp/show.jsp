<%--
  Created by IntelliJ IDEA.
  User: Hubery
  Date: 2019/9/5
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<center>
    <div style="width: 800px;border: solid 2px slategray">
        <h2>图书借阅系统</h2>
            <table border="1" width="550px" cellpadding="4" cellspacing="0">
                <tr>
                    <td>图书编号</td>
                    <td>
                        ${b.bookcode}
                    </td>
                </tr>
                <tr>
                    <td>图书名称</td>
                    <td>
                        ${b.bookname}
                    </td>
                </tr>
                <tr>
                    <td>图书分类</td>
                    <td>
                        ${b.type.typename}
                    </td>
                </tr>
                <tr>
                    <td>作者</td>
                    <td>
                        ${b.bookauthor}
                    </td>
                </tr>
                <tr>
                    <td>出版社</td>
                    <td>
                        ${b.publishpress}
                    </td>
                </tr>
                <tr>
                    <td>出版时间</td>
                    <td>
                        <fmt:formatDate value='${b.publishdate}' type='time' pattern='yyyy-MM-dd'/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <center>
                            <a href="/book/list">返回首页</a>
                        </center>
                    </td>
                </tr>
            </table>
    </div>
</center>
</body>
</html>
