<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<section>
    <div class="container">
        <div class="wrapper">
            <div class="title text-center">
            <span>Human Resource Management System</span>
            </div>
            <c:if test="${not empty param.error}">
            <div class="alert alert-danger">
                <div>Invalid UserName or Password</div>
            </div>
            </c:if>
            <c:if test="${not empty param.logout}">
            <div class="alert alert-success">
                <div>You have been logged out!!</div>
            </div>
            </c:if>
            <c:if test="${not empty param.change}">
            <div class="alert alert-success">

                    <p><c:out value="${param.change}" /></p>

            </div>
            </c:if>

            <form method="post" action="${pageContext.request.contextPath}/doLogin">
                <div class="row">
                    <i class="fas fa-user"></i>
                    <input type="text" placeholder="Employee Id" name="username" required>
                </div>
                <div class="row">
                    <i class="fas fa-lock"></i>
                    <input type="password" placeholder="Password" name="password" required>
                </div>
                <div class="pass"><a href="#">Forgot password?</a></div>
                <div class="row button">
                    <input type="submit" value="Login">
                </div>
            </form>
        </div>
    </div>
</section>



</body>
</html>
