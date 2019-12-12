<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: otter
  Date: 12/9/2019
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Website - Shopping</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src ="resources/js/DJ_Duehr.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/additional-methods.min.js"></script>
    <link rel="stylesheet" href="resources/css/DJ_Duehr.css">
</head>
<body>
<%--<nav class="navigation">--%>
<%--    <p class="menu-item selected"><a href="home.html">Home</a></p>--%>
<%--    <p class="menu-item"><a href="about.html">About</a></p>--%>
<%--    <p class="menu-item"><a href="shop.html">Shop</a></p>--%>
<%--</nav>--%>
<%@include file="/WEB-INF/view/includes/header.jsp"%>
<div id="wrapper">
    <div id="header">
        <h2>Shop</h2>
    </div>
</div>


<div id="container">

    <div id="content">

        <button class="add-button"
                onclick="window.location.href='showAddCustomerForm'; return false;">Customer</button>

        <form:form action="search" method="GET">
        <input type="search" name="searchTerm">
        <input type="submit" value="Search" class="add-button">
        </form:form>

        <table>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Age</th>
                <th>Email</th>
            </tr>
            <c:forEach var="tempCustomer" items="${customer}">
                <c:url var="updateLink" value="/customer/showUpdateCustomerForm">
                    <c:param name="Customer_ID" value="${tempCustomer.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="Customer_ID" value="${tempCustomer.id}"/>
                </c:url>
                <tr>
                    <td>${tempCustomer.name}</td>
                    <td>${tempCustomer.age}</td>
                    <td>${tempCustomer.email}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        &nbsp;|&nbsp;
                        <a href="${deleteLink}"
                           onclick="if (!confirm('Are you sure?')) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <%@ include file="/WEB-INF/view/includes/footer.jsp" %>
</body>
</html>
