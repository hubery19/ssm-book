<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hubery
  Date: 2019/9/5
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <style>
        a{
            text-decoration: none;
        }
        .c:nth-child(odd){
            background: aqua;
        }
        .c:nth-child(even){
           background: blanchedalmond;
        }
    </style>
</head>
<body>
<center>
    <div style="border: solid 2px slategray; width: 800px">
        <h2>图书借阅系统</h2>
        <form action="/book/list" method="post" id="form1">
           <input type="hidden" name="page" id="pg" value="1"/>
            <p>
                图书分类:<select name="tid">
                <option value="-1">全部</option>
                <c:forEach items="${tList}" var="t">
                    <option value="${t.id}"
                            <c:if test="${tid == t.id}">selected = selected</c:if>
                    >${t.typename}</option>
                </c:forEach>
            </select>

                图书名称:<input name="likename" value="${likename}" >
                是否借阅:<select name="isb">
                <option value="-1">请选择</option>
                <option value="0"
                        <c:if test="${0 == isb}">selected="selected"</c:if>
                >可借阅</option>
                <option value="1"
                        <c:if test="${1 == isb}">selected="selected"</c:if>
                >已借阅</option>
            </select>
                <input type="submit" value="查询">
            </p>
            <p>
                <a style="margin-left: 600px" href="/book/find?id=-1">添加</a>
            </p>
        </form>

        <table border="1" cellpadding="4" cellspacing="0">
            <tr>
                <td>图书编号</td>
                <td>图书分类</td>
                <td>图书名称</td>
                <td>作者</td>
                <td>出版社</td>
                <td>操作</td>
                <td>详细</td>
                <td>删除</td>
                <td>修改</td>
            </tr>
            <c:forEach items="${pb.list}" var="b">
                <tr class="c">
                    <td>${b.bookcode}</td>
                    <td>${b.type.typename}</td>
                    <td>${b.bookname}</td>
                    <td>${b.bookauthor}</td>
                    <td>${b.publishpress}</td>
                    <td>
                        <c:if test="${b.isborrow == 0}">
                            <a href="javascript:void(0)" class="getset" data="${b.bookid}">借阅</a>
                        </c:if>
                        <c:if test="${b.isborrow == 1}">
                            <a href="javascript:void(0)" class="getset" data="${b.bookid}">归还</a>
                        </c:if>
                    </td>
                    <td>
                        <a href="javascript:void(0)" class="show" data="${b.bookid}">详细</a>
                    </td>
                    <td>
                        <a href="javascript:void(0)" class="del" data="${b.bookid}">删除</a>
                    </td>
                    <td>
                        <a href="javascript:void(0)" class="update" data="${b.bookid}">修改</a>
                    </td>
                </tr>
            </c:forEach>
           <tr align="center">
                <td colspan="9">
                    <a href="javascript:void(0)" class="gos" data="1">首页</a>
                    <a href="javascript:void(0)" class="gos" data="${pb.pageNum-1}">上一页</a>
                    <a href="javascript:void(0)" class="gos" data="${pb.pageNum+1}">下一页</a>
                    <a href="javascript:void(0)" class="gos" data="${pb.pages}">尾页</a>
                    ${pb.pageNum}/${pb.pages}页
                    <input type="number" maxlength="5" id="pg1"> <input type="button" id="btn" value="GO">

                </td>
            </tr>
        </table>
    </div>
</center>

<script>
    $(function () {
        $("#btn").click(function () {
            var page = $("#pg1").val()
            if (page >= ${pb.pages}){
                page = ${pb.pages}
            }
            if (page <= 1){
                page = 1
            }
            $("#pg").val(page)
            $("#form1").submit()
        });
        $(".gos").click(function () {
            var page = $(this).attr("data")
            if (page >= ${pb.pages}){
                page = ${pb.pages}
            }
            if (page <= 1){
                page = 1
            }
            go(page)
        })
        function go(page) {
            $("#pg").val(page)
            $("#form1").submit()
        }

        $(".del").click(function () {
            $.ajax({
                url:"/book/del",
                type:"POST",
                data: {id:$(this).attr("data")},
                dataType:"JSON",
                success:function (data) {
                    alert(data.msg)
                    location.href=data.url
                }
            })
        })

        $(".update").click(function () {
            location.href="/book/find?id="+$(this).attr("data")
        })
        $(".show").click(function () {
            location.href="/book/show?id="+$(this).attr("data")
        })

        $(".getset").click(function () {
            $.ajax({
                url:"/book/getset",
                type:"POST",
                data: {id:$(this).attr("data")},
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
