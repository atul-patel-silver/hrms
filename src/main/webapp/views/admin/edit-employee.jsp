<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee| Edit Information</title>
</head>
<body>
<div class="flex-container-add">
    <!-- Sidebar -->
    <div class="sidebar">
        <ul>
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Employees</a></li>
            <li><a href="#">Leave Requests</a></li>
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
                                    <li><a class="nav-link" href="#">Employee</a></li>
                                    <li><a class="nav-link" style="cursor: pointer"
                                           id="personal-Info-button">Personal</a></li>
                                    <li><a class="nav-link" style="cursor: pointer" id="contact-Info-Button">Contact</a>
                                    </li>
                                    <li><a class="nav-link" href="#family">Family</a></li>
                                    <li><a class="nav-link" href="#nominee">Nominee</a></li>
                                    <li><a class="nav-link" href="#health">Health</a></li>
                                    <li><a class="nav-link" href="#photograph">Photograph</a></li>
                                    <li><a class="nav-link" href="#attachment">Attachment</a></li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <a class="nav-link" style="font-size: 20px" data-bs-toggle="collapse"
                               href="#employment-info" aria-expanded="false" aria-controls="employment-info">Employment
                                <i style="margin-left: 1px" class=" fa fa-plus"></i></a>
                            <div class="collapse" id="employment-info">
                                <ul class="nav flex-column ml-3">
                                    <li><a class="nav-link" href="#personal">Personal</a></li>
                                    <li><a class="nav-link" href="#contact">Contact</a></li>

                                </ul>
                            </div>
                        </li>
                        <li>
                            <a class="nav-link" style="font-size: 20px" data-bs-toggle="collapse"
                               href="#qualification-info" aria-expanded="false" aria-controls="qualification-info">Qualification
                                <i style="margin-left: 1px" class=" fa fa-plus"></i></a>
                            <div class="collapse" id="qualification-info">
                                <ul class="nav flex-column ml-3">
                                    <li><a class="nav-link" href="#personal">Personal</a></li>
                                    <li><a class="nav-link" href="#contact">Contact</a></li>
                                    <li><a class="nav-link" href="#family">Family</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>

                </div>

                <div class="col-md-9">
                    <div class="container">


                        <%--                       start employee first page--%>

                        <div class="employee-form" style="margin-top: 20px;display: none">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h2>Employee</h2>

                            </div>
                            <form id="employee-first-page">
                                <input type="hidden" name="employeeId" value="${employee.id}">
                                <div class="row g-3 mb-4">
                                    <div class="col-sm">
                                        <label for="code" class="form-label">Employee Code</label>
                                        <input disabled id="code" type="text" name="code" class="form-control"
                                               value="STTP" placeholder="STTP" aria-label="Employee Code">
                                    </div>
                                    <div class="col">
                                        <label for="code2" class="form-label">Employee code</label>
                                        <input value="${employee.id}" id="code2" type="text" class="form-control"
                                               name="code2" aria-label="Employee Code 2">
                                    </div>
                                    <div class="col">
                                        <label for="panNumber" class="form-label">Pan Number</label>
                                        <input value="${employee.panNumber}" type="text" id="panNumber" name="panNumber"
                                               class="form-control" aria-label="Pan Number">
                                    </div>
                                    <div class="col">
                                        <label for="oldEmployeeCode" class="form-label">Old Employee Code</label>
                                        <input value="${employee.oldEmployeeCode}" type="text" class="form-control"
                                               id="oldEmployeeCode" name="oldEmployeeCode"
                                               aria-label="Old Employee Code">
                                    </div>
                                </div>


                                <div class="row g-3 mb-4">

                                    <div class="col-sm">
                                        <label for="dateOfAppoinment" class="form-label">Date of Appointment</label>
                                        <input value="${employee.dateOfAppoinment}" id="dateOfAppoinment" type="date"
                                               name="dateOfAppoinment" class="form-control" aria-label="Employee Code">
                                    </div>
                                    <div class="col">
                                        <label for="bioMetricId" class="form-label">Bio Metric Id</label>
                                        <input value="${employee.bioMetricId}" id="bioMetricId" type="text"
                                               class="form-control" name="bioMetricId" aria-label="Employee Code 2">
                                    </div>
                                    <div class="col">
                                        <label for="panNumber" class="form-label">Salutation</label>
                                        <select id="inputState" class="form-select" name="salutation">
                                            <option selected
                                                    value="${employee.salutation}">${employee.salutation}</option>
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
                                            <option selected
                                                    value="${employee.department.departmentName}">${employee.department.departmentName}</option>
                                            <c:forEach items="${departments}" var="depart">
                                                <option value="${depart.id}">${depart.departmentName}</option>
                                            </c:forEach>

                                        </select>

                                    </div>
                                    <div class="col">
                                        <label for="firstName" class="form-label">First Name</label>
                                        <input value="${employee.firstName}" id="firstName" type="text"
                                               class="form-control" name="firstName" aria-label="Employee Code 2">
                                    </div>
                                    <div class="col">
                                        <label for="middleName" class="form-label">Middle Name</label>
                                        <input value="${employee.middleName}" id="middleName" type="text"
                                               class="form-control" name="middleName" aria-label="Employee Code 2">
                                    </div>


                                </div>


                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="lastName" class="form-label">Last Name</label>
                                        <input value="${employee.lastName}" id="lastName" type="text"
                                               class="form-control" name="lastName" aria-label="Employee Code 2">
                                    </div>
                                    <div class="col">
                                        <label for="unit" class="form-label">Unit</label>
                                        <select id="unit" class="form-select" name="unit">
                                            <option selected value="${employee.unit}">${employee.unit}</option>
                                            <option value="AhmedabadUnit"> Ahmedabad Unit</option>
                                            <option value="BarodaUnit"> Baroda Unit</option>

                                        </select>

                                    </div>
                                    <div class="col">
                                        <label for="designation" class="form-label">Designation</label>
                                        <select id="designation" class="form-select" name="designationId">
                                            <option selected
                                                    value="${employee.designation.designationTitle}">${employee.designation.designationTitle}</option>
                                            <c:forEach items="${designations}" var="desig">
                                                <option value="${desig.id}">${desig.designationTitle}</option>
                                            </c:forEach>

                                        </select>

                                    </div>
                                </div>


                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <input name="isGazetted" class="form-check-input" type="checkbox" value="true"
                                               id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            is Gazetted
                                        </label>
                                    </div>
                                    <div class="col">
                                        <label for="employeeEligibleFor" class="form-label">Employee Eligible
                                            For</label>
                                        <select id="employeeEligibleFor" class="form-select" name="employeeEligibleFor">
                                            <option value="${employee.employeeEligibleFor}"
                                                    selected>${employee.employeeEligibleFor}</option>
                                            <option value="NPF"> NPF</option>
                                            <option value="GPF"> GPF</option>
                                            <option value="Other"> Other..</option>
                                        </select>

                                    </div>
                                    <div class="col">
                                        <input name="isUnderGratuityAct" class="form-check-input" type="checkbox"
                                               value="true" id="isUnderGratuityAct">
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


                        <%--end employee first page--%>


                        <%--                        start personal information--%>
                        <div id="employee-personal-form" style="margin-top: 20px">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h2>Personal</h2>

                            </div>
                            <form id="employee-personal-page">
                                <input type="hidden" id="employeeId" name="employeeId" value="${employee.id}"/>
                                <div class="row g-3 mb-4">
                                    <div class="col-sm">
                                        <label for="gender" class="form-label">Gender</label>
                                        <select id="gender" class="form-select" name="gender">
                                            <option selected disabled>Select Gender</option>
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                            <option value="Other">Other</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <label for="marriageStatus" class="form-label">Marital Status</label>
                                        <select id="marriageStatus" class="form-select" name="marriageStatus">
                                            <option selected disabled>Select Marital Status</option>
                                            <option value="Single">Single</option>
                                            <option value="Married">Married</option>
                                            <option value="Divorced">Divorced</option>
                                            <option value="Widowed">Widowed</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <label for="dateOfBirth" class="form-label">Date of Birth</label>
                                        <input id="dateOfBirth" type="date" name="dateOfBirth" class="form-control"
                                               aria-label="Date of Birth">
                                    </div>
                                </div>


                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="dateOfMarriage" class="form-label">Date of Birth</label>
                                        <input id="dateOfMarriage" type="date" name="dateOfMarriage"
                                               class="form-control" aria-label="Date of Marriage">
                                    </div>

                                    <div class="col">
                                        <label for="birthPlace" class="form-label">Birth Place</label>
                                        <input id="birthPlace" type="text" name="birthPlace" class="form-control"
                                               aria-label="Date of Birth">
                                    </div>
                                    <div class="col">
                                        <label for="communityCategory" class="form-label">Marital Status</label>
                                        <select id="communityCategory" class="form-select" name="communityCategory">
                                            <option selected disabled>Select Marital Status</option>
                                            <option value="General">General</option>
                                            <option value="SEBC">SEBC</option>
                                            <option value="SC">SC</option>
                                            <option value="ST">ST</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="uidNo" class="form-label">UID Number</label>
                                        <input id="uidNo" type="number" name="uidNo" class="form-control"
                                               placeholder="Enter UID Number" aria-label="UID Number">
                                    </div>
                                    <div class="col">
                                        <label for="gpfAcNo" class="form-label">GPF Account Number</label>
                                        <input id="gpfAcNo" type="number" name="gpfAcNo" class="form-control"
                                               placeholder="Enter GPF Account Number" aria-label="GPF Account Number">
                                    </div>
                                    <div class="col">
                                        <label for="religion" class="form-label">Religion</label>
                                        <select id="religion" class="form-select" name="religion"
                                                onchange="populateCaste()">
                                            <option selected disabled>Select Religion</option>
                                            <option value="hindu">Hindu</option>
                                            <option value="muslim">Muslim</option>

                                        </select>
                                    </div>
                                </div>


                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="caste" class="form-label">Caste</label>
                                        <select id="caste" class="form-select" name="caste">
                                            <option selected disabled>Select Caste</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <label for="communityCategoryRef" class="form-label">Community Category
                                            Reference</label>
                                        <input id="communityCategoryRef" type="text" name="communityCategoryRef"
                                               class="form-control" placeholder="Enter Community Category Reference"
                                               aria-label="Community Category Reference">
                                    </div>
                                </div>


                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="nationality" class="form-label">Nationality</label>
                                        <select id="nationality" class="form-select" name="nationality">
                                            <option selected disabled>Select Nationality</option>
                                            <option value="INDIAN">INDIAN</option>
                                            <option value="afghan">Afghan</option>
                                            <option value="albanian">Albanian</option>
                                            <option value="algerian">Algerian</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <label for="postelLifeInsuranceNo" class="form-label">Postel Life Insurance
                                            Number</label>
                                        <input id="postelLifeInsuranceNo" type="number" name="postelLifeInsuranceNo"
                                               class="form-control" placeholder="Enter Postel Life Insurance Number"
                                               aria-label="Postel Life Insurance Number">
                                    </div>
                                    <div class="col">
                                        <label for="hobbies" class="form-label">Hobbies</label>
                                        <input id="hobbies" type="text" name="hobbies" class="form-control"
                                               placeholder="Enter Hobbies" aria-label="Hobbies">
                                    </div>
                                </div>


                                <hr/>


                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="bankName" class="form-label">Bank Name</label>
                                        <input id="bankName" type="text" name="bankName" class="form-control"
                                               placeholder="Enter Bank Name" aria-label="Bank Name">
                                    </div>
                                    <div class="col">
                                        <label for="bankBranch" class="form-label">Bank Branch</label>
                                        <select id="bankBranch" class="form-select" name="bankBranch">
                                            <option selected disabled>Select Bank Branch</option>
                                            <option value="Ahmedabad">Ahmedabad</option>
                                            <option value="Vadali">Vadali</option>
                                            <option value="Ghandhinagar">Ghandhinagar</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <label for="bankAcNo" class="form-label">Bank Account Number</label>
                                        <input id="bankAcNo" type="number" name="bankAcNo" class="form-control"
                                               placeholder="Enter Bank Account Number" aria-label="Bank Account Number">
                                    </div>
                                </div>


                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="ifscCode" class="form-label">IFSC Code</label>
                                        <input id="ifscCode" type="text" name="ifscCode" class="form-control"
                                               placeholder="Enter IFSC Code" aria-label="IFSC Code">
                                    </div>
                                    <div class="col">
                                        <label for="bsrCode" class="form-label">BSR Code</label>
                                        <input id="bsrCode" type="text" name="bsrCode" class="form-control"
                                               placeholder="Enter BSR Code" aria-label="BSR Code">
                                    </div>
                                </div>

                                <hr/>
                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="passportNo" class="form-label">Passport Number</label>
                                        <input id="passportNo" type="text" name="passportNo" class="form-control"
                                               placeholder="Enter Passport Number" aria-label="Passport Number">
                                    </div>
                                    <div class="col">
                                        <label for="dateOfExpiry" class="form-label">Date of Expiry</label>
                                        <input id="dateOfExpiry" type="date" name="dateOfExpiry" class="form-control"
                                               aria-label="Date of Expiry">
                                    </div>
                                    <div class="col">
                                        <label for="visaDetail" class="form-label">Visa Detail</label>
                                        <input id="visaDetail" type="text" name="visaDetail" class="form-control"
                                               placeholder="Enter Visa Detail" aria-label="Visa Detail">
                                    </div>
                                </div>

                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="drivingLicenceNo" class="form-label">Driving Licence Number</label>
                                        <input id="drivingLicenceNo" type="text" name="drivingLicenceNo"
                                               class="form-control" placeholder="Enter Driving Licence Number"
                                               aria-label="Driving Licence Number">
                                    </div>
                                    <div class="col">
                                        <label for="vehicleType" class="form-label">Vehicle Type</label>
                                        <input id="vehicleType" type="text" name="vehicleType" class="form-control"
                                               placeholder="Enter Vehicle Type" aria-label="Vehicle Type">
                                    </div>
                                    <div class="col">
                                        <label for="validUpto" class="form-label">Valid Upto</label>
                                        <input id="validUpto" type="date" name="validUpto" class="form-control"
                                               aria-label="Valid Upto">
                                    </div>
                                </div>


                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="issuedState" class="form-label">Issued State</label>
                                        <select id="issuedState" class="form-select" name="issuedState">
                                            <option selected disabled>Select Issued State</option>
                                            <option value="Gujarat">Gujarat</option>
                                            <option value="Rajasthan">Rajasthan</option>
                                            <option value="M.P">M.P</option>
                                            <option value="U.P">U.P</option>

                                        </select>
                                    </div>

                                    <div class="col">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox"
                                                   id="isGovernmentVehicleProvider" name="isGovernmentVehicleProvider"/>
                                            <label class="form-check-label" for="isGovernmentVehicleProvider">
                                                Is Government Vehicle Provider ?
                                            </label>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox"
                                                   id="isResidentOfOtherCountry" name="isResidentOfOtherCountry">
                                            <label class="form-check-label" for="isResidentOfOtherCountry">
                                                Is Resident of Other Country ?
                                            </label>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox"
                                                   id="isDisciplinaryProceeding" name="isDisciplinaryProceeding">
                                            <label class="form-check-label" for="isDisciplinaryProceeding">
                                                Is Disciplinary Proceeding ?
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div class="row g-3 mb-4" id="othercountry" style="display: none">
                                    <div class="col">
                                        <label for="migrationDateOfIndia" class="form-label">Migration Date of
                                            India</label>
                                        <input id="migrationDateOfIndia" type="date" name="migrationDateOfIndia"
                                               class="form-control" aria-label="Migration Date of India">
                                    </div>
                                    <div class="col">
                                        <label for="country" class="form-label">Country</label>
                                        <select id="country" class="form-select" name="country2">
                                            <option selected disabled>Select Country</option>
                                            <option value="India">India</option>
                                            <option value="USA">USA</option>
                                            <option value="UK">UK</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <label for="otherCountryAddress" class="form-label">Other Country
                                            Address</label>
                                        <textarea id="otherCountryAddress" name="otherCountryAddress"
                                                  class="form-control" rows="3"
                                                  placeholder="Enter Other Country Address"
                                                  aria-label="Other Country Address"></textarea>
                                    </div>
                                </div>


                                <div class="row g-3 mb-4">
                                    <div class="col" id="UsedForOnDuty" style="display: none">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="isUsedForOnDuty"
                                                   name="isUsedForOnDuty">
                                            <label class="form-check-label" for="isUsedForOnDuty">
                                                Government Vehicle Used for On Duty ?
                                            </label>
                                        </div>
                                    </div>


                                    <div class="col" id="detailOfVehicle" style="display: none">
                                        <label for="detailOfVehicleProvider" class="form-label">Detail of Vehicle
                                            Provider</label>
                                        <input id="detailOfVehicleProvider" type="text" name="detailOfVehicleProvider"
                                               class="form-control" placeholder="Enter Detail of Vehicle Provider"
                                               aria-label="Detail of Vehicle Provider">
                                    </div>


                                    <div class="col">
                                        <label for="additionalInfo" class="form-label">Additional Information</label>
                                        <textarea id="additionalInfo" name="additionalInfo" class="form-control"
                                                  rows="3" placeholder="Enter Additional Information"
                                                  aria-label="Additional Information"></textarea>
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

                        <%--                        end personal information--%>


                        <%--                        start contact page--%>

                        <div id="employee-contact-form" style="margin-top: 20px;display: none">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h2>Contact</h2>

                            </div>
                            <form id="employee-contact-page">
                                <input type="hidden" name="employeeId" id="employeeId2" value="${employee.id}"/>
                                <div class="row  mb-4">
                                    <div class="col">
                                        <label for="workPhone" class="form-label">Work Phone</label>
                                        <input id="workPhone" type="number" name="workPhone" class="form-control"
                                               aria-label="Work Phone">
                                    </div>
                                    <div class="col">
                                        <label for="extention" class="form-label">Extention</label>
                                        <input style="width: 70px" id="extention" type="text" name="extention"
                                               class="form-control" aria-label="Extention">
                                    </div>
                                    <div class="col">
                                        <label for="workMobile" class="form-label">Work Mobile</label>
                                        <input id="workMobile" type="number" name="workMobile" class="form-control"
                                               aria-label="Work Mobile">
                                    </div>
                                    <div class="col">
                                        <label for="homePhone" class="form-label">Home Phone</label>
                                        <input id="homePhone" type="number" name="homePhone" class="form-control"
                                               aria-label="Home Phone">
                                    </div>
                                </div>

                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="homeMobile" class="form-label">Home Mobile</label>
                                        <input id="homeMobile" type="number" name="homeMobile" class="form-control"
                                               aria-label="Home Mobile">
                                    </div>
                                    <div class="col">
                                        <label for="corporateEmail" class="form-label">Corporate Email</label>
                                        <input id="corporateEmail" type="email" name="corporateEmail"
                                               class="form-control" aria-label="Corporate Email">
                                    </div>
                                    <div class="col">
                                        <label for="personalEmail" class="form-label">Personal Email</label>
                                        <input id="personalEmail" type="email" name="personalEmail" class="form-control"
                                               aria-label="Personal Email">
                                    </div>
                                </div>

                                <div class="row g-3 mb-4">
                                    <div class="col">
                                        <label for="secondaryEmail" class="form-label">Secondary Email</label>
                                        <input style="width: 300px" id="secondaryEmail" type="email"
                                               name="secondaryEmail" class="form-control" aria-label="Secondary Email">
                                    </div>
                                </div>


                                <%--            address box start--%>

                                <div class="row">
                                    <c:forEach items="${addresses}" var="add">
                                        <div class="col-md-3 text-center">

                                            <div class="center-box ">
                                                <div>
                                                    <h5>${add.addressType} Address</h5>
                                                    <hr/>

                                                    <div>${add.address} ${add.city} ${add.state} ${add.country} ${add.pincode}</div>
                                                    <div class="card-footer text-end" style="margin-top: 120px">
                                                        <div class="form-submit-button">
                                                            <i data-address_id="${add.id}"  class="fa fa-close delete-address" style="font-size:24px;border: 2px solid orange;border-radius: 50%;cursor: pointer"></i>
                                                            <i class="fa fa-pencil" style="font-size:24px;border: 2px solid orange;border-radius: 50% ;cursor: pointer"></i>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </c:forEach>

                                    <div class="col text-center">

                                        <div class="center-box text-center">
                                            <div style="margin-top: 50px" class="container text-center">
                                                <h3>Add New Record As Address</h3>
                                                <div data-bs-toggle="modal" data-bs-target="#exampleModal"
                                                     data-bs-whatever="@fat"
                                                     style="background-color:white;border: 2px black;padding: 10px;cursor:  pointer;width: 25px;height: 25px;border-radius: 50%"
                                                     class="fa fa-plus">


                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <%--            address box end--%>


                                <div class="row">
                                    <div class="col text-end">
                                        <div class="form-submit-button">
                                            <button class="btn btn-secondary" type="reset">Reset</button>
                                            <button class="btn primary-bg" type="submit">Submit</button>
                                        </div>
                                    </div>
                                </div>


                            </form>


                            <%--            model start--%>
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Add New Address</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <form id="address-form">

                                                <input type="hidden" name="employeeId" id="employeeId3"
                                                       value="${employee.id}"/>

                                                <div class="row g-3 mb-4">
                                                    <div class="col">
                                                        <label for="addressType" class="form-label">Address Type</label>
                                                        <select id="addressType" name="addressType" class="form-select"
                                                                aria-label="Address Type">
                                                            <option value="Permanent">Permanent</option>
                                                            <option value="Correspondence">Correspondence</option>
                                                            <option value="Resident">Resident</option>
                                                        </select>
                                                    </div>
                                                    <div class="col">
                                                        <label for="address" class="form-label">Address</label>
                                                        <input id="address" type="text" name="address"
                                                               class="form-control" aria-label="Address">
                                                    </div>
                                                </div>

                                                <div class="row g-3 mb-4">
                                                    <div class="col">
                                                        <label for="country2" class="form-label">Country</label>
                                                        <select id="country2" name="country" class="form-select"
                                                                aria-label="Country"></select>
                                                    </div>
                                                    <div class="col">
                                                        <label for="state" class="form-label">State</label>
                                                        <select id="state" name="state" class="form-select"
                                                                aria-label="State"></select>
                                                    </div>
                                                </div>

                                                <div class="row g-3 mb-4">
                                                    <div class="col">
                                                        <label for="district" class="form-label">District</label>
                                                        <select id="district" name="district" class="form-select"
                                                                aria-label="District"></select>
                                                    </div>
                                                    <div class="col">
                                                        <label for="city" class="form-label">City</label>
                                                        <select id="city" name="city" class="form-select"
                                                                aria-label="City"></select>
                                                    </div>
                                                </div>


                                                <div class="row g-3 mb-4">
                                                    <div class="col">
                                                        <label for="pincode" class="form-label">Pincode</label>
                                                        <input type="text" id="pincode" name="pincode"
                                                               class="form-control"/>
                                                    </div>
                                                    <div class="col">
                                                        <label for="allAddressAreSame" class="form-check-label">All
                                                            Addresses Are Same</label>
                                                        <input type="checkbox" id="allAddressAreSame"
                                                               name="allAddressAreSame" class="form-check-input"/>
                                                    </div>
                                                </div>


                                                <div>
                                                    <label>
                                                        <input type="radio" name="addressOwner" value="Owner"> Owner
                                                    </label>
                                                    <label>
                                                        <input type="radio" name="addressOwner" value="Tenant"> Tenant
                                                    </label>
                                                </div>
                                                <button type="submit" class="btn primary-bg">Submit</button>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                Close
                                            </button>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--            model end--%>


                        </div>
                        <%--                        end contact page--%>
                    </div>
                </div>

            </div>
        </div>


    </div>
</div>


<script>
    function populateCaste() {
        var religionSelect = document.getElementById("religion");
        var casteSelect = document.getElementById("caste");
        casteSelect.innerHTML = '<option selected disabled>Select Caste</option>';
        var selectedReligion = religionSelect.value;
        var casteOptions = [];

        if (selectedReligion === "hindu") {
            casteOptions = ["Brahmin", "Kshatriya", "Vaishya", "Shudra", "Other"];
        } else if (selectedReligion === "muslim") {
            casteOptions = ["Sunni", "Shia", "Other"];
        }
        casteOptions.forEach(function (caste) {
            var option = document.createElement("option");
            option.text = caste;
            option.value = caste.toLowerCase(); // Optional: you can set the value to lowercase
            casteSelect.add(option);
        });
    }
</script>
<script>
    // Sample data for demonstration
    const stateData = {
        "USA": ["New York", "California", "Texas"],
        "Canada": ["Ontario", "Quebec", "British Columbia"]
    };

    const districtData = {
        "New York": ["Manhattan", "Brooklyn", "Queens"],
        "California": ["Los Angeles", "San Francisco", "San Diego"],
        "Texas": ["Houston", "Dallas", "Austin"],
        "Ontario": ["Toronto", "Ottawa", "Mississauga"],
        "Quebec": ["Montreal", "Quebec City", "Gatineau"],
        "British Columbia": ["Vancouver", "Victoria", "Kelowna"]
    };

    const cityData = {
        "Los Angeles": ["New York City", "Harlem", "Upper East Side"],
        "Brooklyn": ["Downtown Brooklyn", "Williamsburg", "Park Slope"],
        "Queens": ["Long Island City", "Astoria", "Flushing"]
        // Add more data as needed
    };

    const countrySelect = document.getElementById('country2');
    const stateSelect = document.getElementById('state');
    const districtSelect = document.getElementById('district');
    const citySelect = document.getElementById('city');

    // Populate country dropdown
    for (const country in stateData) {
        const option = document.createElement('option');
        option.value = country;
        option.textContent = country;
        countrySelect.appendChild(option);
    }

    // Event listener for country dropdown change
    countrySelect.addEventListener('change', () => {
        const selectedCountry = countrySelect.value;
        stateSelect.innerHTML = ''; // Clear previous options
        districtSelect.innerHTML = '<option selected disabled>Select District</option>'; // Clear previous options and add default option
        citySelect.innerHTML = '<option selected disabled>Select City</option>'; // Clear previous options and add default option

        // Populate state dropdown based on selected country
        stateData[selectedCountry].forEach(state => {
            const option = document.createElement('option');
            option.value = state;
            option.textContent = state;
            stateSelect.appendChild(option);
        });
    });

    // Event listener for state dropdown change
    stateSelect.addEventListener('change', () => {
        const selectedState = stateSelect.value;
        districtSelect.innerHTML = '<option selected disabled>Select District</option>'; // Clear previous options and add default option
        citySelect.innerHTML = '<option selected disabled>Select City</option>'; // Clear previous options and add default option

        // Populate district dropdown based on selected state
        districtData[selectedState].forEach(district => {
            const option = document.createElement('option');
            option.value = district;
            option.textContent = district;
            districtSelect.appendChild(option);
        });
    });

    // Event listener for district dropdown change
    districtSelect.addEventListener('change', () => {
        const selectedDistrict = districtSelect.value;
        citySelect.innerHTML = '<option selected disabled>Select City</option>'; // Clear previous options and add default option

        // Populate city dropdown based on selected district
        cityData[selectedDistrict].forEach(city => {
            const option = document.createElement('option');
            option.value = city;
            option.textContent = city;
            citySelect.appendChild(option);
        });
    });
</script>

</body>
</html>
