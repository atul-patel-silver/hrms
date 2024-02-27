<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Detail</title>
    <style>
        .social-icons {
            display: flex;
            justify-content: center;
            gap: 10px;
        }

        .social-icon {
            text-decoration: none;
            display: inline-flex;
            justify-content: center;
            align-items: center;
            width: 40px;
            height: 40px;
            border-radius: 50%;
            color: white;
            font-size: 20px;
        }

        .facebook {
            background-color: #1877f2;
        }

        .twitter {
            background-color: #1da1f2;
        }

        .linkedin {
            background-color: #0077b5;
        }
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
                    <h2 style="color: #42A5F5">My Profile</h2>
                </div>
                <div class="col text-end">
                    <a class="btn primary-bg" style="color: white" href="/admin/editEmployee/${employee.id}">
                        <i class="fa fa-edit"></i> Edit Employee
                    </a>
                </div>
            </div>
        </div>
        <div class="container-fluid " style="background-color: white;padding: 10px;margin-top: 5px;border-radius: 15px">
            <div class="container mt-4 ">
                <div class="row">
                    <!-- First Column: Image -->
                    <div class="col-12 col-md-3">
                        <img style="height: 150px;width: 200px;border-radius: 50%"
                             src="/image/profile/${employee.photograph.image}" class="img-fluid" alt="Employee Image">
                    </div>
                    <!-- Second Column: Info -->
                    <div class="col-12 col-md-9">
                        <div class="row">
                            <div class="col-12">
                                <h2 style="color: #42A5F5">${employee.salutation} ${employee.firstName}
                                    (${employee.login.employeeCode} )</h2>
                                <div class="row">
                                    <div class="col-3 m-2" style="font-size: 25px;font-weight: bold">
                                        JR. ${employee.designation.designationTitle}</div>
                                    |
                                    <div class="col-3 m-2">
                                        <div class="btn btn-danger">${employee.department.departmentName}</div>
                                    </div>
                                    |
                                    <div class="col-3 m-2">
                                        <div class="social-icons">
                                            <a href="#" class="social-icon facebook"><i
                                                    class="fa fa-facebook-f"></i></a>
                                            <a href="#" class="social-icon twitter"><i class="fa fa-twitter"></i></a>
                                            <a href="#" class="social-icon linkedin"><i class="fa fa-linkedin"></i></a>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <hr/>
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-3">Reporting to</div>
                                    <div class="col-3">Blood Group</div>
                                    <div class="col-2">Location</div>
                                    <div class="col-2">Appointment Date</div>
                                    <div class="col-2">Gender</div>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <div class="row" style="font-weight: bold">
                                    <div class="col-3">${employee.reportingOfficer.hod}</div>
                                    <div class="col-3">${employee.health.bloodGroup}</div>
                                    <div class="col-2">${employee.job.branchName}</div>
                                    <div class="col-2">${employee.reportingOfficer.startDate}</div>
                                    <div class="col-2">${employee.personal.gender}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>


        <div class="container-fluid mt-5 "
             style="background-color: white;padding: 10px;margin-top: 5px;border-radius: 15px">
            <h3 style="color: #42A5F5" class="m-3">Employee Information</h3>
            <div class="container mt-4 ">

                <hr/>
                <h4>Employee Detail</h4>
                <div class="row mt-2">

                    <div class="col-md-3 mb-2">
                        <div class="text-muted">PAN Number</div>
                        <div style="font-weight: bold">${employee.panNumber}</div>
                    </div>
                    <div class="col-md-3 mb-2">
                        <div class="text-muted">Salutation</div>
                        <div style="font-weight: bold">${employee.salutation}</div>
                    </div>
                    <div class="col-md-2 mb-2">
                        <div class="text-muted">First Name</div>
                        <div style="font-weight: bold">${employee.firstName}</div>
                    </div>
                    <div class="col-md-2 mb-2">
                        <div class="text-muted">Middle Name</div>
                        <div style="font-weight: bold">${employee.middleName}</div>
                    </div>
                    <div class="col-md-2 mb-2">
                        <div class="text-muted">Last Name</div>
                        <div style="font-weight: bold">${employee.lastName}</div>
                    </div>
                </div>


                <div class="row mt-2">
                    <div class="col-md-3 mb-2">
                        <div class="text-muted">Department</div>
                        <div style="font-weight: bold">${employee.department.departmentName}</div>
                    </div>
                    <div class="col-md-3 mb-2">
                        <div class="text-muted">Old Employee Code</div>
                        <div style="font-weight: bold">${employee.oldEmployeeCode}</div>
                    </div>
                    <div class="col-md-2 mb-2">
                        <div class="text-muted">Unit</div>
                        <div style="font-weight: bold">${employee.unit}</div>
                    </div>
                    <div class="col-md-2 mb-2">
                        <div class="text-muted">Designation</div>
                        <div style="font-weight: bold">${employee.designation.designationTitle}</div>
                    </div>
                    <div class="col-md-2 mb-2">
                        <div class="text-muted">BIO Metric Id</div>
                        <div style="font-weight: bold">${employee.bioMetricId}</div>
                    </div>
                </div>

                <hr/>

                <h4>Personal Details</h4>

                <div class="row mt-2">

                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Marriage Status</div>
                        <div style="font-weight: bold">${employee.personal.marriageStatus}</div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Marriage Date</div>
                        <div style="font-weight: bold">${employee.personal.dateOfMarriage}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Date Of Birth</div>
                        <div style="font-weight: bold">${employee.personal.dateOfBirth}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Birth Place</div>
                        <div style="font-weight: bold">${employee.personal.birthPlace}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Community Category</div>
                        <div style="font-weight: bold">${employee.personal.communityCategory}</div>
                    </div>


                    <div class="col-md-3 mb-3">
                        <div class="text-muted">UID No</div>
                        <div style="font-weight: bold">${employee.personal.uidNo}</div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <div class="text-muted">GPF A/C No</div>
                        <div style="font-weight: bold">${employee.personal.gpfAcNo}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Religion</div>
                        <div style="font-weight: bold">${employee.personal.religion}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Caste</div>
                        <div style="font-weight: bold">${employee.personal.caste}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">community Category Ref</div>
                        <div style="font-weight: bold">${employee.personal.communityCategoryRef}</div>
                    </div>


                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Nationality</div>
                        <div style="font-weight: bold">${employee.personal.nationality}</div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Postel Life Insurance No</div>
                        <div style="font-weight: bold">${employee.personal.postelLifeInsuranceNo}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Hobbies</div>
                        <div style="font-weight: bold">${employee.personal.hobbies}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">BankName</div>
                        <div style="font-weight: bold">${employee.personal.bankName}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Bank Branch</div>
                        <div style="font-weight: bold">${employee.personal.bankBranch}</div>
                    </div>


                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Bank A/C No</div>
                        <div style="font-weight: bold">${employee.personal.bankAcNo}</div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <div class="text-muted">IFSC Code</div>
                        <div style="font-weight: bold">${employee.personal.ifscCode}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">BSR Code</div>
                        <div style="font-weight: bold">${employee.personal.bsrCode}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Passport No</div>
                        <div style="font-weight: bold">${employee.personal.passportNo}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Date Of Expiry</div>
                        <div style="font-weight: bold">${employee.personal.dateOfExpiry}</div>
                    </div>


                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Visa Detail</div>
                        <div style="font-weight: bold">${employee.personal.visaDetail}</div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Driving Licence No</div>
                        <div style="font-weight: bold">${employee.personal.drivingLicenceNo}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Issued State</div>
                        <div style="font-weight: bold">${employee.personal.issuedState}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Licence Issue For</div>
                        <div style="font-weight: bold">${employee.personal.vehicleType}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Valid Upto</div>
                        <div style="font-weight: bold">${employee.personal.validUpto}</div>
                    </div>

                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Detail Of VehicleProvider</div>
                        <div style="font-weight: bold">${employee.personal.detailOfVehicleProvider}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Other Country</div>
                        <div style="font-weight: bold">${employee.personal.country}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Other Country Address</div>
                        <div style="font-weight: bold">${employee.personal.otherCountryAddress}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Additional Information</div>
                        <div style="font-weight: bold">${employee.personal.addtionalInfo}</div>
                    </div>

                </div>


                <hr/>

                <h4>Contact Details</h4>

                <div class="row mt-2">

                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Work Phone</div>
                        <div style="font-weight: bold">${employee.contact.workPhone}</div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Extention</div>
                        <div style="font-weight: bold">${employee.contact.extention}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Work Mobile</div>
                        <div style="font-weight: bold">${employee.contact.workMobile}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Home Phone</div>
                        <div style="font-weight: bold">${employee.contact.homePhone}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Home Mobile</div>
                        <div style="font-weight: bold">${employee.contact.homeMobile}</div>
                    </div>

                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Corporate Email</div>
                        <div style="font-weight: bold">${employee.contact.corporateEmail}</div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Personal Email</div>
                        <div style="font-weight: bold">${employee.contact.personalEmail}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Secondary Email</div>
                        <div style="font-weight: bold">${employee.contact.secondaryEmail}</div>
                    </div>
                </div>


                <hr/>

                <h4>Address Details</h4>

                <div class="row mt-2">


                    <c:forEach items="${addresses}" var="add">
                        <div class="col-md-3 mb-3">
                            <div class="center-box ">
                                <div>
                                    <h5>${add.addressType} Address</h5>
                                    <hr/>
                                    <div style="color: #FFA726;font-weight: bold">${employee.firstName}</div>
                                    <div>${add.address} ${add.city} ${add.state} ${add.country} ${add.pincode}</div>
                                    <div class="card-footer text-end" style="margin-top: 120px">
                                        <div style="color: #FFA726;font-weight: bold">${add.addressOwner}</div>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </c:forEach>

                </div>




                <hr/>

                <h4>Family</h4>

                <div class="row mt-2">


                    <c:if test="${not empty families}">
                        <div class="container">
                            <table class="table">
                                <thead id="blue-header">
                                <tr class="table-primary">
                                    <th>Sr No</th>
                                    <th>First Name</th>
                                    <th>Occupation</th>
                                    <th>BirthDate</th>
                                    <th>Relation</th>
                                    <th>Gender</th>
                                    <th>Marital Status</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="family" items="${families}" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${family.firstName}</td>
                                        <td>${family.occupation}</td>
                                        <td>${family.dateOfBirth}</td>
                                        <td>${family.relation}</td>
                                        <td>${family.gender}</td>
                                        <td>${family.maritalStatus}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>

                </div>


                <hr/>

                <h4>Emergency</h4>

                <div class="row mt-2">
                    <c:if test="${not empty emergencies}">
                        <div class="container">
                            <table  class="table">
                                <thead style="background-color: #4b4b4b; color: white;">
                                <tr class="table-primary">
                                    <th>Sr No</th>
                                    <th>Priority</th>
                                    <th>Name</th>
                                    <th>Mobile No.</th>
                                    <th>Phone No.</th>
                                    <th>Relation</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="emr" items="${emergencies}" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${emr.priority}</td>
                                        <td>${emr.firstName} ${emr.lastName}</td>
                                        <td>${emr.mobileNo}</td>
                                        <td>${emr.phoneNo}</td>
                                        <td>${emr.relation}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>

                </div>


                <hr/>

                <h4>Health</h4>

                <div class="row mt-2">

                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Height</div>
                        <div style="font-weight: bold">${employee.health.height}</div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <div class="text-muted">Weight</div>
                        <div style="font-weight: bold">${employee.health.weight}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Blood Group</div>
                        <div style="font-weight: bold">${employee.health.bloodGroup}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Identification Mark1</div>
                        <div style="font-weight: bold">${employee.health.identificationMark1}</div>
                    </div>
                    <div class="col-md-2 mb-3">
                        <div class="text-muted">Identification Mark2</div>
                        <div style="font-weight: bold">${employee.health.identificationMark2}</div>
                    </div>

                </div>


                <hr/>

                <h4>Attachment</h4>

                <div class="row mt-2">

                    <div class="col-md-3 mb-3">
                        <div style="font-weight: bold" class="text-muted">Profile Picture</div>
                        <div style="font-weight: bold"> <img style="height: 150px;width: 200px;border-radius: 50%"
                                                             src="/image/profile/${employee.photograph.image}" class="img-fluid" alt="Employee Image"></div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <div style="font-weight: bold" class="text-muted">Sign Image</div>
                        <div > <img style="height: 150px;width: 200px;border-radius: 50%"
                                                             src="/image/sign/${employee.photograph.sign}" class="img-fluid" alt="Employee Image"></div>
                    </div>


                </div>


                <hr/>

                <h4>Document</h4>

                <div class="row mt-2">
                    <c:if test="${not empty attachments}" >
                        <div class="container" style="margin-bottom: 15px">
                            <table  class="table">
                                <thead style="background-color: #4b4b4b; color: white;">
                                <tr class="table-primary">
                                    <th>Sr No</th>
                                    <th>Document Image</th>
                                    <th>Document Type</th>
                                    <th>Title Of Document</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="atta" items="${attachments}" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td><img style="height: 100px;width: 150px;border-radius: 50%"
                                                 src="/image/attachment/${atta.documentImage}" class="img-fluid" alt="Employee Image"></td>
                                        <td>${atta.documentType}</td>
                                        <td>${atta.titleOfDocument}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>




                </div>










            </div>
        </div>

    </div>


</div>

</div>

</body>
</html>
