<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HRMS System</title>
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
            <li><a href="/admin/manage-role">Role Master</a>

            </li>
            <li><a href="/admin/manage-module">Menu Master</a></li>
            <li><a href="/admin/manage-mapping">Role Mapping</a></li>

        </ul>
    </div>

    <!-- Middle Section -->
    <div class="middle-section">
        <h2>Dashboard</h2>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Department</th>
                <!-- Add more table headers as needed -->
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>John Doe</td>
                <td>john@example.com</td>
                <td>Engineering</td>
                <!-- Add more table data rows as needed -->
            </tr>
            <tr>
                <td>2</td>
                <td>Jane Smith</td>
                <td>jane@example.com</td>
                <td>Marketing</td>
                <!-- Add more table data rows as needed -->
            </tr>
            <!-- Add more table data rows as needed -->
            </tbody>
        </table>
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

</body>
</html>
