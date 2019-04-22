<%@ page import="java.util.Date" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8"  %>
<%@include file="util/util.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${app}/css/style.css" />
    <script src="${app}/js/jquery-3.3.1.min.js"></script>
    <script>

    </script>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd " />
                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome  !${login.realname}
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Bir
                    </td>
                    <td>
                        Sex
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <c:forEach items="${emps}" var="emp">
                <tr th:class="${empState.odd ? 'row2':'row1'}">
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.salary}</td>
                    <td>${emp.age}</td>
                    <td><fmt:formatDate value="${emp.bir}" pattern="yyyy-MM-dd"/> </td>
                    <td><c:if test="${emp.sex eq 'm'}">
                        男
                     </c:if>
                        <c:if test="${emp.sex eq 'f'}">
                           女
                        </c:if>
                    </td>
                    <td>
                        <a href="${app}/emp/delete?id=${emp.id}">delete emp</a>&nbsp;
                        <a href="${app}/emp/findOne?id=${emp.id}">update emp</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <a href="${app}/emp/findAll?page=1">首页</a>

            <c:forEach  begin="1" end="${totals}" varStatus="p">
                <a href="${app}/emp/findAll?page=${p.count}">${p.count}</a>
            </c:forEach>
            <a href="${app}/emp/findAll?page=${totals}">尾页</a>
            <p>
                <a href="${app}/addEmp.jsp" class="button">添加员工信息</a>
            </p>


        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
