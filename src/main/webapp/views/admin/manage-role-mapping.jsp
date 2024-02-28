<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage | Role Mapping</title>
</head>
<body>
<div class="flex-container-add">

    <div class="sidebar">
        <ul>
            <li><a href="/admin/dashboard">Dashboard</a></li>
            <li><a href="/admin/employeeList">Employees</a></li>
            <li><a href="/admin/manage-role">Role Master</a>

            </li>
            <li><a href="/admin/manage-module">Menu Master</a></li>
            <li><a href="/admin/manage-mapping">Role Mapping</a></li>

        </ul>
    </div>


    <div class="middle-section-add">

        <div class="container-fluid">
            <select id="role-select" class="form-select" aria-label="Default select example">
                <option selected>Open this select menu</option>
                <c:forEach items="${roles}" var="r">
                <option value="${r.id}">${r.name}</option>
                </c:forEach>
            </select>

            <div class="m-3" id="mapping-table">

            </div>


        </div>
    </div>


</div>
</div>


<script>
    new DataTable('#role-module-table', {
        searchable: true,
        pagination: true,
        entries: [5,10, 25, 50, 100],
        perPage: 10,
        layout: {
            pagination: '.pagination-container',
            entries: '.entries-container'
        }
    });
</script>
</body>
</html>
