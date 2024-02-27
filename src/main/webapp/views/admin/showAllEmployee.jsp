<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
    <style>

    </style>
</head>
<body>

<div class="flex-container">
    <!-- Sidebar -->
    <div class="sidebar">
        <ul>
            <li><a href="/admin/dashboard">Dashboard</a></li>
            <li><a href="/admin/employeeList">Employees</a></li>
            <li><a href="#">Job Master</a></li>
            <li><a href="#">Pay Master</a></li>
            <li><a href="#">Personal Master</a></li>
        </ul>
    </div>

    <!-- Middle Section -->
    <div class="middle-section">
        <div class="">
            <div class="row">
                <div class="col">
                    <h2 style="color: #42A5F5">Employee Information</h2>
                </div>
                <div class="col text-end">
                    <a class="btn primary-bg" style="color: white" href="/admin/addEmployee">
                        <i class="fa fa-plus"></i> Add Employee
                    </a>
                </div>
            </div>
        </div>
        <div class="container-fluid">

            <div class="m-3 ">
                <div class="row">
                    <div class="card container" style="margin-right: 100px">
                        <div class="table-responsive p-5">

                            <table id="employee-table" class="table no-wrap user-table mb-0 mt-2">
                                <button class="btn btn-outline-info btn-circle btn-lg btn-circle mb-5 " id="refresh"><i
                                        class="fa fa-refresh"></i></button>
                                <thead>
                                <tr class="table-primary">
                                    <th scope="col" class="border-0 text-uppercase font-medium pl-4">Employee</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Code</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Designation</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Department</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Pan Number</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="emp" items="${employees}">
                                    <tr>
                                        <td><img style="width: 50px;height: 50px;" src="/image/user.png" class="ml-1"/>${emp.salutation} ${emp.firstName} ${emp.lastName}</td>
                                        <td>${emp.login.employeeCode}</td>
                                        <td>${emp.designation.designationTitle}</td>
                                        <td>${emp.department.departmentName}</td>
                                        <td>${emp.panNumber}</td>
                                        <td>
                                            <a type="button" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2"
                                               href="/admin/editEmployee/${emp.id}"
                                            >
                                                <i class="fa fa-edit"></i>
                                            </a>

                                            <a type="button" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2" href="/admin/viewEmployee/${emp.id}">

                                                <i class="fa fa-eye"></i>
                                            </a>

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
        </div>
    </div>

    <!-- Profile Section -->
    <div class="profile">
        <div class="profile-set text-center ">
            <img style="height: 250px;width: 250px;border: 2px blue" src="https://upload.wikimedia.org/wikipedia/commons/9/99/Sample_User_Icon.png" alt="no image">
            <h2>Atul</h2>
            <div class="m-2" style="font-weight: bold;">Super Admin</div>
            <a class="m-2" href="">MyProfile</a> | <a class="m-2" href="">MyTeam</a>
        </div>

        <div class="profile-set">
            <table class="table">
                <tbody>
                <tr >
                    <th scope="row" style="font-size:16px;font-width:30px">Employee :</th>
                    <td style="font-size:16px;font-width:30px">STTL_SU</td>
                </tr>
                <tr class="m-5">
                    <th scope="row" style="font-size:16px;font-width:30px">Department:</th>
                    <td  style="font-size:16px;font-width:30px">-</td>

                </tr>

                <tr>
                    <th scope="row" style="font-size:16px;font-width:30px">Location :</th>
                    <td style="font-size:16px;font-width:30px">Ahmedabad Head Office</td>

                </tr>
                <tr>
                    <th scope="row" style="font-size:16px;font-width:30px">Reporting :</th>
                    <td  style="font-size:16px;font-width:30px">-</td>

                </tr>
                </hr>
                <tr>
                    <th scope="row" style="font-size:16px;font-width:30px">Last Login</th>
                    <td style="font-size:16px;font-width:30px">21 Feb,2024-17:58</td>

                </tr>


                </tbody>
            </table>

            <div class="d-grid gap-2 col-6 mx-auto">
                <button class="btn btn-danger" type="button">Apply For <i class="fa fa-sort-asc"></i></button>
            </div>
        </div>
    </div>
</div>
<script>
    new DataTable('#employee-table', {
        searchable: true,
        pagination: true,
        entries: [2,5,10, 25, 50, 100],
        perPage: 10,
        layout: {
            pagination: '.pagination-container',
            entries: '.entries-container'
        }
    });
</script>
</body>
</html>
