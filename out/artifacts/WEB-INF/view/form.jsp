<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<%@include file="/WEB-INF/view/includes/header.jsp"%>
<%--<nav class="navigation">--%>
<%--    <p class="menu-item selected"><a href="home.html">Home</a></p>--%>
<%--    <p class="menu-item"><a href="about.html">About</a></p>--%>
<%--    <p class="menu-item"><a href="shop.html">Shop</a></p>--%>
<%--</nav>--%>
<div id="wrapper">
    <div id="header">
        <h2>Shop</h2>
    </div>
</div>

<form:form action="save" modelAttribute="aCustomer" enctype="multipart/form-data">
    <form:hidden path="id" value="${aCustomer.id}"/>

    <table>
        <tr>
            <td><label>Name</label></td>
            <td><form:input path="name"/>
                <form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Age</label></td>
            <td><form:input path="age"/>
                <form:errors path="age" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Email</label></td>
            <td><form:input path="email"/>
                <form:errors path="email" cssClass="error"/></td>
        </tr>
<%--        <tr>--%>
<%--            <td><label>Product</label></td>--%>
<%--            <td><form:select items="${product}" path="product"--%>
<%--                             itemLabel="name" itemValue="Product_Id">--%>
<%--            </form:select></td>--%>
<%--        </tr>--%>
        <tr>
            <td></td>
            <td><input type="submit" value="Save" class="save"></td>
        </tr>
    </table>
</form:form>
<%@ include file="/WEB-INF/view/includes/footer.jsp" %>
</body>
</html>
