<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage | Department</title>
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
               <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " id="add-department"><i
                       class="fa fa-plus"></i></button>
               <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " id="show-department-button"><i
                       class="fa fa-eye"></i></button>
               <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " id="refresh"><i
                       class="fa fa-refresh"></i></button>
           </div>




            <div class="m-3 " id="show-department" >
                <div class="row">

                        <div class="card container" style="margin-right: 100px">
                            <div class="card-body">
                                <h5 class="card-title text-uppercase mb-0">
                                    Manage Department
                                </h5>
                            </div>
                            <div class="table-responsive p-5">

                                <table id="department-table" class="table no-wrap user-table mb-0">
                                    <thead>
                                    <tr class="table-primary">
                                        <th scope="col" class="border-0 text-uppercase font-medium pl-4">
                                            No
                                        </th>
                                        <th scope="col" class="border-0 text-uppercase font-medium">
                                            Department Name
                                        </th>
                                        <th scope="col" class="border-0 text-uppercase font-medium">
                                            Department Description
                                        </th>
                                        <th scope="col" class="border-0 text-uppercase font-medium">
                                            Action
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="department" items="${departments}">
                                        <tr>
                                            <td>${department.id}</td>
                                            <td>${department.departmentName}</td>
                                            <td>${department.description}</td>
                                            <td>
                                                <button type="button" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 delete-department"
                                                        data-department_id="${department.id}">
                                                    <i class="fa fa-trash"></i>
                                                </button>
                                                <button type="button" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 update-department-button"
                                                        data-department_id="${department.id}">
                                                    <i class="fa fa-edit"></i>
                                                </button>
                                            </td>
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



            <div class="container">


                <div id="show-department-form" style="display: none">
                <h1>Add Department</h1>
                <form id="department-reg-form">
                    <div class="form-group">
                        <label for="departmentName">Department Name</label>
                        <input name="departmentName" type="text" class="form-control" id="departmentName"
                               aria-describedby="emailHelp" placeholder="Enter DepartmentName" required />
                    </div>

                    <div class="form-group">
                        <label for="description">Department Description</label>
                        <textarea name="description" class="form-control" id="description"
                                  rows="10" placeholder="Enter Something About Department"></textarea>
                    </div>

                    <div class="container text-center mt-3">
                        <button type="submit" class="btn btn-primary" id="submit-btn">
                            Submit
                        </button>
                        <button type="reset" class="btn btn-warning" id="reset-btn">
                            Reset
                        </button>
                    </div>
                </form>

                </div>
            </div>


        </div>
    </div>


    </div>
</div>


<script>
    new DataTable('#department-table', {
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
