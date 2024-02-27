<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage | Designation</title>
</head>
<body>
<div class="flex-container-add">

    <div class="sidebar">
        <ul>
            <li><a href="/admin/dashboard">Dashboard</a></li>
            <li><a href="/admin/employeeList">Employees</a></li>
            <li><a href="#">Job Master</a></li>
            <li><a href="#">Pay Master</a></li>
            <li><a href="#">Personal Master</a></li>
        </ul>
    </div>

    <div class="middle-section-add">
        <div class="container-fluid">
            <div class="m-5">
                <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " id="add-designation"><i
                        class="fa fa-plus"></i></button>
                <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " id="show-designation-button"><i
                        class="fa fa-eye"></i></button>

                <button class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 " id="refresh"><i
                        class="fa fa-refresh"></i></button>
            </div>

            <div class="m-3 " id="show-designation" >
                <div class="row">
                    <div class="card container" style="margin-right: 100px">
                        <div class="card-body">
                            <h5 class="card-title text-uppercase mb-0">Manage Designation</h5>
                        </div>
                        <div class="table-responsive p-5">
                            <table id="designation-table" class="table no-wrap user-table mb-0">
                                <thead>
                                <tr class="table-primary">
                                    <th scope="col" class="border-0 text-uppercase font-medium pl-4">No</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Designation Title</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Description</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="designation" items="${designations}">
                                    <tr>
                                        <td>${designation.id}</td>
                                        <td>${designation.designationTitle}</td>
                                        <td>${designation.description}</td>
                                        <td>
                                            <button type="button" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 delete-designation"
                                                    data-designation_id="${designation.id}">
                                                <i class="fa fa-trash"></i>
                                            </button>
                                            <button type="button" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2 update-designation-button"
                                                    data-designation_id="${designation.id}">
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
                <div id="show-designation-form" style="display: none">
                    <h1>Add Designation</h1>
                    <form id="designation-reg-form">
                        <div class="form-group">
                            <label for="designationTitle">Designation Title</label>
                            <input name="designationTitle" type="text" class="form-control" id="designationTitle"
                                   placeholder="Enter Designation Title" required />
                        </div>
                        <div class="form-group">
                            <label for="description">Description</label>
                            <textarea name="description" class="form-control" id="description"
                                      rows="10" placeholder="Enter Description"></textarea>
                        </div>
                        <div class="container text-center mt-3">
                            <button type="submit" class="btn btn-primary" id="submit-btn">Submit</button>
                            <button type="reset" class="btn btn-warning" id="reset-btn">Reset</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    new DataTable('#designation-table', {
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
