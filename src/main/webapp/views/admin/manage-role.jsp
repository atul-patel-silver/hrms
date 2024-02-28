<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage | Role</title>
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

            <div class="m-5">
                <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " data-bs-toggle="modal" data-bs-target="#staticBackdrop" data-bs-whatever="@mdo" id="add-role"><i
                        class="fa fa-plus"></i></button>
<%--                <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " id="show-department-button"><i--%>
<%--                        class="fa fa-eye"></i></button>--%>
                <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " id="refresh"><i
                        class="fa fa-refresh"></i></button>
            </div>




            <div class="m-3 " id="show-role" >
                <div class="row">

                    <div class="card container" style="margin-right: 100px">
                        <div class="card-body">
                            <h5 class="card-title text-uppercase mb-0">
                                Manage Role
                            </h5>
                        </div>
                        <div class="table-responsive p-5">

                            <table id="role-table" class="table no-wrap user-table mb-0">
                                <thead>
                                <tr class="table-primary">
                                    <th scope="col" class="border-0 text-uppercase font-medium pl-4">
                                       Sr No
                                    </th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">
                                        Role Name
                                    </th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">
                                        Role Description
                                    </th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">
                                       Status
                                    </th>

<%--                                    <th scope="col" class="border-0 text-uppercase font-medium">--%>
<%--                                        Action--%>
<%--                                    </th>--%>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="role" items="${roles}" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${role.name}</td>
                                        <td>${role.roleDescription}</td>
                                        <td>
                                            <c:if test="${role.isActive == 'on'}">
                                                <div style="color: greenyellow">Active</div>
                                            </c:if>

                                            <c:if test="${role.isActive == ''}">
                                                <div style="color: red">DeActive</div>
                                            </c:if>
                                            
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
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Add Role</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                       <form id="add-role-form">
                           <div class="mb-3">
                               <label for="name" class="form-label">Role Name</label>
                               <input name="name" id="name" type="text" class="form-control">
                           </div>
                           <div class="mb-3">
                               <label for="roleDescription" class="form-label">Role Description</label>
                               <textarea name="roleDescription" class="form-control" id="roleDescription" rows="3"></textarea>
                           </div>
                           <div class="form-check form-switch">
                               <input class="form-check-input" type="checkbox" role="switch" id="isActive" name="isActive">
                               <label class="form-check-label" for="isActive" >Active</label>
                           </div>

                           <div class="form-check">
                               <input class="form-check-input" type="checkbox" name="isAdmin" id="isAdmin">
                               <label class="form-check-label" for="isAdmin">
                                   Is Admin
                               </label>
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
    new DataTable('#role-table', {
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
