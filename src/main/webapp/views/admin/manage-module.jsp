<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage | Module</title>
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
        <li><a href="#">Personal Master</a></li>

    </ul>
</div>


<div class="middle-section-add">

<div class="container-fluid">

<div class="m-5">
    <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " data-bs-toggle="modal"
            data-bs-target="#staticBackdrop" data-bs-whatever="@mdo" id="add-module"><i
            class="fa fa-plus"></i></button>
    <%--                <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " id="show-department-button"><i--%>
    <%--                        class="fa fa-eye"></i></button>--%>
    <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " id="refresh"><i
            class="fa fa-refresh"></i></button>
</div>


<div class="m-3 " id="show-role">
    <div class="row">

        <div class="card container" style="margin-right: 100px">
            <div class="card-body">
                <h5 class="card-title text-uppercase mb-0">
                    Manage Module
                </h5>
            </div>
            <div class="table-responsive p-5">

                <table id="module-table" class="table no-wrap user-table mb-0">
                    <thead>
                    <tr class="table-primary">
                        <th scope="col" class="border-0 text-uppercase font-medium pl-4">
                            Sr No
                        </th>
                        <th scope="col" class="border-0 text-uppercase font-medium">
                            Module Name
                        </th>
                        <th scope="col" class="border-0 text-uppercase font-medium">
                            Parent Module
                        </th>
                        <th scope="col" class="border-0 text-uppercase font-medium">
                            Sub ParentModule
                        </th>

                        <th scope="col" class="border-0 text-uppercase font-medium">
                            Prefix
                        </th>
                        <th scope="col" class="border-0 text-uppercase font-medium">
                            Module Action
                        </th>
                        <%--                                    <th scope="col" class="border-0 text-uppercase font-medium">--%>
                        <%--                                        Action--%>
                        <%--                                    </th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="m" items="${modules}" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${m.name}</td>
                            <td>${m.parentModule.name}</td>
                            <td>${m.subParentModule.name}</td>
                            <td>${m.prefix}</td>
                            <td>${m.controller}</td>
                            <td>
                                    <%--                                            <c:if test="${role.isActive == 'on'}">--%>
                                    <%--                                                <div style="color: greenyellow">Active</div>--%>
                                    <%--                                            </c:if>--%>

                                    <%--                                            <c:if test="${role.isActive == ''}">--%>
                                    <%--                                                <div style="color: red">DeActive</div>--%>
                                    <%--                                            </c:if>--%>

                            </td>
                                <%--                                        <td>--%>
                                <%--                                            <button type="button" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 delete-department"--%>
                                <%--                                                    data-role="${role.id}">--%>
                                <%--                                                <i class="fa fa-trash"></i>--%>
                                <%--                                            </button>--%>
                                <%--                                        </td>--%>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>


            </div>


        </div>

    </div>


    <div class="entries-container"></div>

    <div class="pagination-container"></div>
</div>


<%--            model start--%>


<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
<div class="modal-dialog modal-dialog-centered">
<div class="modal-content">
<div class="modal-header">
    <h1 class="modal-title fs-5" id="staticBackdropLabel">Add New Module</h1>
    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
</div>
<div class="modal-body">
<form id="add-module-form">
<div class="row g-3 mb-4">
    <div class="col">
        <label for="name" class="form-label">Module Name</label>
        <input id="name" type="text" name="name" class="form-control"
               aria-label="Mobile Number">
    </div>
    <div class="col">
        <label for="prefix" class="form-label">Prefix</label>
        <input id="prefix" type="text" name="prefix" class="form-control"
               aria-label="Email">
    </div>
</div>

<div class="row g-3 mb-4">
    <div class="col">
        <label for="plugin" class="form-label">Plugin</label>
        <input id="plugin" type="text" name="plugin" class="form-control"
               aria-label="Mobile Number">
    </div>
    <div class="col">
        <label for="controller" class="form-label">Controller</label>
        <input id="controller" type="text" name="controller" class="form-control"
               aria-label="Email">
    </div>
</div>

<div class="row g-3 mb-4">
    <div class="col">
        <label for="action" class="form-label">Action</label>
        <input id="action" type="text" name="action" class="form-control"
               aria-label="Mobile Number">
    </div>
</div>

<div class="row g-3 mb-4">
<div class="col">
<label for="menuIconCss" class="form-label">Parent Module</label>
<select class="form-select" aria-label="Default select example" id="parentId" name="parentId">

<c:forEach var="m" items="${modules}" varStatus="loop">
    <option value="${m.id}"> ${m.name}</option>
</c:forEach>
    </select>
    </div>
    <div class="col">
    <label for="menuIconCss" class="form-label">SubParent Module</label>
    <select class="form-select" aria-label="Default select example" id="subParentId" name="subParentId">
        <c:forEach var="m" items="${modules}" varStatus="loop">
            <option value="${m.id}"> ${m.name}</option>
        </c:forEach>
    </select>
    </div>
    </div>

    <div class="row g-3 mb-4">
    <div class="col-md-3">
    <label for="menuIconCss" class="form-label">Menu IconCss</label>
    <input id="menuIconCss" type="text" name="menuIconCss" class="form-control"
    aria-label="Mobile Number">
    </div>
    </div>

    <div class="form-check form-switch">
    <input class="form-check-input" type="checkbox" role="switch" id="isActive" name="isActive">
    <label class="form-check-label" for="isActive" >Active</label>
    </div>


    <div class="row">
    <div class="col text-end">
    <div class="form-submit-button">
    <button class="btn btn-secondary" type="reset">Reset</button>

    <button id="submitButton5" class="btn primary-bg"
    type="submit">Add
    </button>


    </div>
    </div>
    </div>
    </form>
    </div>
    <div class="modal-footer">
    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
    </div>
    </div>
    </div>
    </div>
    <%--model end--%>

    </div>
    </div>


    </div>
    </div>


    <script>
    new DataTable('#module-table', {
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
