<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee | Add Information</title>
    <style>

    </style>
</head>
<body>
<div class="flex-container-add">
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


    <div class="middle-section-add">

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3 sidebar-employee">

                    <ul class="nav flex-column">
                        <li>
                            <a class="nav-link" style="font-size: 20px" data-bs-toggle="collapse" href="#employee-info"
                               aria-expanded="false" aria-controls="employee-info">

                                Employee Information
                                <i style="margin-left: 1px" class=" fa fa-plus"></i>
                            </a>
                            <div class="collapse" id="employee-info">
                                <ul class="nav flex-column ml-3">
                                    <li><a  class="nav-link" style="cursor: pointer" href="/admin/addEmployee">Employee</a></li>
                                    <li><a  class="nav-link disabled" style="cursor: pointer" href="#personal">Personal</a></li>
                                    <li><a  class="nav-link disabled" style="cursor: pointer" href="#contact">Contact</a></li>
                                    <li><a  class="nav-link disabled" style="cursor: pointer" href="#family">Family</a></li>
                                    <li><a  class="nav-link disabled" style="cursor: pointer" href="#nominee">Nominee</a></li>
                                    <li><a  class="nav-link disabled" style="cursor: pointer" href="#health">Health</a></li>
                                    <li><a  class="nav-link disabled" style="cursor: pointer" href="#photograph">Photograph</a></li>
                                    <li><a  class="nav-link disabled" style="cursor: pointer" href="#attachment">Attachment</a></li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <a class="nav-link" style="font-size: 20px" data-bs-toggle="collapse"
                               href="#employment-info" aria-expanded="false" aria-controls="employment-info">Employment
                                <i style="margin-left: 1px" class=" fa fa-plus"></i></a>
                            <div class="collapse" id="employment-info">
                                <ul class="nav flex-column ml-3">
                                    <li><a class="nav-link disabled"  style="cursor: pointer"
                                          >Allowance Declaration</a></li>
                                    <li><a class="nav-link disabled" style="cursor: pointer">Job</a>
                                    </li>
                                    <li><a class="nav-link disabled" style="cursor: pointer">Reporting
                                        Officer</a></li>
                                    <li><a class="nav-link disabled" style="cursor: pointer">Salary</a>
                                    </li>
                                    <li><a class="nav-link disabled" style="cursor: pointer">Previous
                                        Employment</a></li>

                                </ul>
                            </div>
                        </li>
                        <li>
                            <a class="nav-link" style="font-size: 20px" data-bs-toggle="collapse"
                               href="#qualification-info" aria-expanded="false" aria-controls="qualification-info">Qualification
                                <i style="margin-left: 1px" class=" fa fa-plus"></i></a>
                            <div class="collapse" id="qualification-info">
                                <ul class="nav flex-column ml-3">
                                    <li><a class="nav-link disabled" style="cursor: pointer" id="education-Info-Button">Education
                                        Qualification</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>

                </div>

                <div class="col-md-9">
                    <div class="container">


                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h2>Employee</h2>
                            <a  href="/admin/get-excel-file" class="btn primary-bg">Download Excel Template</a>
                        </div>

                        <div class="excel-file">
                            <form id="excel-file">
                                <label for="file-upload" class="custom-file-upload">
                                    <i class="fa fa-cloud-upload"></i> Upload File
                                </label>
                                <input id="file-upload" type="file" id="excel-file-data" name="excel-file-data"/>
                                <input style="margin-left: 15px" type="submit" class="btn primary-bg" value="Process">
                            </form>

                        </div>

                        <div class="employee-form" style="margin-top: 20px">


                            <form id="employee-first-page">
                                <div class="row g-3 mb-4">
                                    <div class="col-sm">
                                        <label for="code" class="form-label">Employee Code</label>
                                        <input disabled id="code" type="text" name="code" class="form-control" style="background-color: white" value="STTP" placeholder="STTP" aria-label="Employee Code">
                                    </div>
                                    <div class="col">
                                        <label  for="code2" class="form-label">Employee code</label>
                                        <input id="code2" type="text" class="form-control" name="code2" aria-label="Employee Code 2">
                                    </div>
                                    <div class="col">
                                        <label for="panNumber" class="form-label">Pan Number</label>
                                        <input type="text" id="panNumber" name="panNumber" class="form-control" aria-label="Pan Number">
                                    </div>
                                    <div class="col">
                                        <label for="oldEmployeeCode" class="form-label">Old Employee Code</label>
                                        <input type="text" class="form-control" id="oldEmployeeCode" name="oldEmployeeCode" aria-label="Old Employee Code">
                                    </div>
                                </div>


                                <div class="row g-3 mb-4">

                                    <div class="col-sm">
                                        <label for="dateOfAppoinment" class="form-label">Date of Appointment</label>
                                        <input  id="dateOfAppoinment" type="date" name="dateOfAppoinment" class="form-control"   aria-label="Employee Code">
                                    </div>
                                    <div class="col">
                                        <label  for="bioMetricId" class="form-label">Bio Metric Id</label>
                                        <input id="bioMetricId" type="text" class="form-control" name="bioMetricId" aria-label="Employee Code 2">
                                    </div>
                                    <div class="col">
                                        <label for="panNumber" class="form-label">Salutation</label>
                                            <select id="inputState" class="form-select" name="salutation">
                                                <option selected>Select Salutation</option>
                                                <option value="Dr.">Dr.</option>
                                                <option value="Kum.">Kum.</option>
                                                <option value="Shri.">Shri.</option>
                                                <option value="Smt.">Smt.</option>
                                            </select>

                                    </div>
                                </div>

                                <div class="row g-3 mb-4">

                                    <div class="col">
                                        <label for="department" class="form-label">Department</label>
                                        <select id="department" class="form-select" name="departmentId">
                                            <option selected>Select Department</option>
                                            <c:forEach items="${departments}" var="depart">
                                            <option value="${depart.id}" >${depart.departmentName}</option>
                                            </c:forEach>

                                        </select>

                                    </div>
                                    <div class="col">
                                        <label  for="firstName" class="form-label">First Name</label>
                                        <input id="firstName" type="text" class="form-control" name="firstName" aria-label="Employee Code 2">
                                    </div>
                                    <div class="col">
                                        <label  for="middleName" class="form-label">Middle Name</label>
                                        <input id="middleName" type="text" class="form-control" name="middleName" aria-label="Employee Code 2">
                                    </div>



                                </div>


                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label  for="lastName" class="form-label">Last Name</label>
                                        <input id="lastName" type="text" class="form-control" name="lastName" aria-label="Employee Code 2">
                                    </div>
                                    <div class="col">
                                        <label for="unit" class="form-label">Unit</label>
                                        <select id="unit" class="form-select" name="unit">
                                            <option selected>Select unit</option>
                                            <option value="AhmedabadUnit"> Ahmedabad Unit</option>
                                            <option value="BarodaUnit"> Baroda Unit</option>

                                        </select>

                                    </div>
                                    <div class="col">
                                        <label for="designation" class="form-label">Designation</label>
                                        <select id="designation" class="form-select" name="designationId">
                                            <option selected>Select Designation</option>
                                            <c:forEach items="${designations}" var="desig">
                                                <option value="${desig.id}" >${desig.designationTitle}</option>
                                            </c:forEach>

                                        </select>

                                    </div>
                                </div>


                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <input name="isGazetted" class="form-check-input" type="checkbox" value="true" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            is Gazetted
                                        </label>
                                    </div>
                                    <div class="col">
                                        <label for="employeeEligibleFor" class="form-label">Employee Eligible For</label>
                                        <select id="employeeEligibleFor" class="form-select" name="employeeEligibleFor">
                                            <option selected>Select</option>
                                            <option value="NPF"> NPF</option>
                                            <option value="GPF"> GPF</option>
                                            <option value="Other"> Other..</option>
                                        </select>

                                    </div>
                                    <div class="col">
                                        <input name="isUnderGratuityAct" class="form-check-input" type="checkbox" value="true" id="isUnderGratuityAct">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Is Employee Cover Under Gratuity Act
                                        </label>

                                    </div>
                                </div>



                                <div class="row">
                                    <div class="col text-end">
                                        <div class="form-submit-button">
                                            <button class="btn btn-secondary" type="reset">Reset</button>
                                            <button class="btn primary-bg" type="submit">Submit</button>
                                        </div>
                                    </div>
                                </div>


                            </form>

                        </div>


                    </div>
                </div>

            </div>
        </div>


    </div>
</div>

</body>
</html>
