//for depart ment

$(document).ready(function () {
    $("#refresh").click(function () {
        window.location.reload(true);
    });
});

$(document).ready(function () {
    $("#add-department").click(function () {
        $("#show-department").hide();
        $("#update-department-form").hide();
        $("#show-department-form").show();
    });
});


$(document).ready(function () {
    $("#show-department-button").click(function () {

        $("#show-department-form").hide();
        $("#update-department-form").hide();
        $("#show-department").show();
    });
});


//depart ment form
$(document).ready(function () {
    $("#department-reg-form").validate({
        rules: {
            departmentName: {
                required: true
            },
            description: {
                required: true
            }
        },
        messages: {
            departmentName: {
                required: "Please enter the department name"
            },
            description: {
                required: "Please enter the department description"
            }
        },
        submitHandler: function (form) {
            var formData = $(form).serialize();

            $.ajax({
                type: "POST",
                url: "/admin/handleDepartMentData",
                data: formData,
                success: function (data) {
                    if (data.trim() === 'success') {
                        Swal.fire("Good job!", "Successfully Add Department", "success")
                            .then((value) => {
                                form.reset();
                            });
                    } else {
                        Swal.fire("Please Try Again ", data);
                    }

                },
                error: function (xhr, status, error) {
                    console.error(xhr.responseText);
                }
            });
        }
    });
});


$(document).ready(function () {
    $('.delete-department').click(function () {

        var department_id = $(this).data('department_id');
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success ml-2',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: 'You are about to delete this Department.',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true,
        }).then((result) => {
            if (result.isConfirmed) {

                $.ajax({
                    type: 'POST',
                    url: '/admin/delete-department',
                    data: {
                        department_id: department_id
                    },
                    success: function (response) {

                        swalWithBootstrapButtons.fire(
                            'Deleted!',
                            'The Department has been deleted.',
                            'success'
                        );

                        $(this).closest('tr').remove();
                    },
                    error: function (xhr, status, error) {

                        swalWithBootstrapButtons.fire(
                            'Error!',
                            'An error occurred while deleting the Department.',
                            'error'
                        );
                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'The Depart has not been deleted.',
                    'error'
                );
            }
        });
    });
});


// for designation

$(document).ready(function () {
    $("#add-designation").click(function () {
        $("#show-designation").hide();
        $("#update-designation-form").hide();
        $("#show-designation-form").show();
    });
});

// Show designation table
$(document).ready(function () {
    $("#show-designation-button").click(function () {
        $("#show-designation-form").hide();
        $("#update-designation-form").hide();
        $("#show-designation").show();
    });
});

// Form validation and AJAX submission for adding a designation
$(document).ready(function () {
    $("#designation-reg-form").validate({
        rules: {
            designationTitle: {
                required: true
            },
            description: {
                required: true
            }
        },
        messages: {
            designationTitle: {
                required: "Please enter the designation title"
            },
            description: {
                required: "Please enter the designation description"
            }
        },
        submitHandler: function (form) {
            var formData = $(form).serialize();
            $.ajax({
                type: "POST",
                url: "/admin/handleDesignationData",
                data: formData,
                success: function (data) {
                    if (data.trim() === 'success') {
                        Swal.fire("Good job!", "Successfully Add Designation", "success")
                            .then((value) => {
                                form.reset();
                            });
                    } else {
                        Swal.fire("Please Try Again ", data);
                    }
                },
                error: function (xhr, status, error) {
                    console.error(xhr.responseText);
                }
            });
        }
    });
});

// AJAX request for deleting a designation
$(document).ready(function () {
    $('.delete-designation').click(function () {
        var designation_id = $(this).data('designation_id');
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success ml-2',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false,
        });
        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: 'You are about to delete this Designation.',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true,
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '/admin/delete-designation',
                    data: {
                        designation_id: designation_id
                    },
                    success: function (response) {
                        swalWithBootstrapButtons.fire(
                            'Deleted!',
                            'The Designation has been deleted.',
                            'success'
                        );
                        $(this).closest('tr').remove();
                    },
                    error: function (xhr, status, error) {
                        swalWithBootstrapButtons.fire(
                            'Error!',
                            'An error occurred while deleting the Designation.',
                            'error'
                        );
                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'The Designation has not been deleted.',
                    'error'
                );
            }
        });
    });
});


$(document).ready(function () {
    $('.collapse').on('show.bs.collapse', function () {
        $(this).prev().find('.fa').removeClass('fa-plus').addClass('fa-minus');
    });
    $('.collapse').on('hide.bs.collapse', function () {
        $(this).prev().find('.fa').removeClass('fa-minus').addClass('fa-plus');
    });
});


//add employee in database
$(document).ready(function () {
    $("#employee-first-page").validate({
        rules: {

            code2: {
                required: true,
                minlength: 4
            },
            panNumber: {
                required: true,
                minlength: 10
            },
            oldEmployeeCode: {
                required: true
            },
            dateOfAppoinment: {
                required: true
            },
            bioMetricId: {
                required: true
            },
            salutation: {
                required: true
            },
            departmentId: {
                required: true
            },
            firstName: {
                required: true
            },
            middleName: {
                required: true
            },
            lastName: {
                required: true
            },
            unit: {
                required: true
            },
            designationId: {
                required: true
            },
        },
        messages: {
            code2: {
                required: "Please enter employee code",
                minlength: "Employee code must be at least 4 characters long"
            },
            panNumber: {
                required: "Please enter PAN number",
                minlength: "PAN number must be at least 10 characters long"
            },
            oldEmployeeCode: {
                required: "Please enter old employee code"
            },
        },
        submitHandler: function (form) {
            $.ajax({
                type: "POST",
                url: "/admin/saveEmployee",
                data: $(form).serialize(),
                success: function (response) {
                    if (response.isSuccess.trim() === 'success') {
                        form.reset();
                        window.location = "/admin/editEmployee/" + response.id;
                        toastr.success('Successfully Save Employee');
                    } else {
                        toastr.error(response.msg);
                    }

                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});


//edite page

$(document).ready(function () {
    $("#personal-Info-button").click(function () {
        $("#employee-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-education-form").hide();
        $("#employee-job-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-personal-form").show();
    });
});


$(document).ready(function () {
    $("#contact-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-attachment-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-education-form").hide();
        $("#employee-job-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-contact-form").show();
    });
});

$(document).ready(function () {
    $("#family-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-attachment-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-job-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-education-form").hide();
        $("#employee-family-form").show();
    });
});

$(document).ready(function () {
    $("#nominee-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-health-form").hide();
        $("#employee-attachment-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-job-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-education-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-nominee-form").show();

    });
});

$(document).ready(function () {
    $("#health-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-attachment-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-job-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-education-form").hide();
        $("#employee-health-form").show();

    });
});


$(document).ready(function () {
    $("#photograph-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-attachment-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-job-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-education-form").hide();
        $("#employee-photograph-form").show();

    });
});

$(document).ready(function () {
    $("#attachment-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-job-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-education-form").hide();
        $("#employee-attachment-form").show();

    });
});

$(document).ready(function () {
    $("#emergency-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-attachment-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-job-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-education-form").hide();
        $("#employee-emergancy-form").show();

    });
});


$(document).ready(function () {
    $("#job-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-attachment-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-education-form").hide();
        $("#employee-job-form").show();

    });
});


$(document).ready(function () {
    $("#reporting-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-attachment-form").hide();
        $("#employee-job-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-education-form").hide();
        $("#employee-reporting-form").show();

    });
});

$(document).ready(function () {
    $("#salary-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-attachment-form").hide()
        $("#employee-job-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-education-form").hide();
        $("#employee-salary-form").show();


    });
});
$(document).ready(function () {
    $("#previous-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-job-form").hide();
        $("#employee-attachment-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-education-form").hide();
        $("#employee-previous-employment-form").show();

    });
});

$(document).ready(function () {
    $("#education-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").hide();
        $("#employee-family-form").hide();
        $("#employee-nominee-form").hide();
        $("#employee-health-form").hide();
        $("#employee-photograph-form").hide();
        $("#employee-reporting-form").hide();
        $("#employee-job-form").hide();
        $("#employee-attachment-form").hide();
        $("#employee-salary-form").hide();
        $("#employee-emergancy-form").hide();
        $("#employee-previous-employment-form").hide();
        $("#employee-education-form").show();


    });
});

$(document).ready(function () {
    $('#isGovernmentVehicleProvider').change(function () {
        if ($(this).is(":checked")) {
            $('#UsedForOnDuty').show();
            $('#detailOfVehicle').show();
        } else {
            $('#UsedForOnDuty').hide();
            $('#detailOfVehicle').hide();
        }
    });
});


$(document).ready(function () {
    $('#isResidentOfOtherCountry').change(function () {
        if ($(this).is(":checked")) {
            $('#othercountry').show();
        } else {
            $('#othercountry').hide();
        }
    });
});


//add employee personal detail in database
$(document).ready(function () {
    $('#employee-personal-page').validate({
        rules: {
            gender: {
                required: true
            },
            marriageStatus: {
                required: true
            },
            dateOfBirth: {
                required: true
            },

            uidNo: {
                required: true,
                digits: true
            },
            gpfAcNo: {
                required: true,
                digits: true
            },
            religion: {
                required: true
            },
            caste: {
                required: true
            },
            communityCategoryRef: {
                required: true
            },
            nationality: {
                required: true
            },

            bankName: {
                required: true
            },
            bankBranch: {
                required: true
            },
            bankAcNo: {
                required: true,
                digits: true
            },
            ifscCode: {
                required: true
            },
            bsrCode: {
                required: true
            },

            passportNo: {
                required: true
            },
            dateOfExpiry: {
                required: true
            },
            visaDetail: {
                required: true
            },

            drivingLicenceNo: {
                required: true
            },
            vehicleType: {
                required: true
            },
            validUpto: {
                required: true
            },

            issuedState: {
                required: true
            },

            detailOfVehicleProvider: {
                required: function (element) {
                    return $('#isGovernmentVehicleProvider').is(':checked');
                }
            },
            migrationDateOfIndia: {
                required: function (element) {
                    return $('#isResidentOfOtherCountry').is(':checked');
                }
            },
            country: {
                required: function (element) {
                    return $('#isResidentOfOtherCountry').is(':checked');
                }
            },
            otherCountryAddress: {
                required: function (element) {
                    return $('#isResidentOfOtherCountry').is(':checked');
                }
            }

        },
        messages: {
            gender: {
                required: "Please select gender"
            },
            marriageStatus: {
                required: "Please select marital status"
            },
            dateOfBirth: {
                required: "Please select date of birth"
            },

            uidNo: {
                required: "Please enter UID number",
                digits: "Please enter valid UID number"
            },
            gpfAcNo: {
                required: "Please enter GPF account number",
                digits: "Please enter valid GPF account number"
            },
            religion: {
                required: "Please select religion"
            },
            caste: {
                required: "Please select caste"
            },
            communityCategoryRef: {
                required: "Please enter community category reference"
            },
            nationality: {
                required: "Please select nationality"
            },

            bankName: {
                required: "Please enter bank name"
            },
            bankBranch: {
                required: "Please select bank branch"
            },
            bankAcNo: {
                required: "Please enter bank account number",
                digits: "Please enter valid bank account number"
            },

            ifscCode: {
                required: "Please enter IFSC code"
            },
            bsrCode: {
                required: "Please enter BSR code"
            },

            passportNo: {
                required: "Please enter passport number"
            },
            dateOfExpiry: {
                required: "Please select date of expiry"
            },
            visaDetail: {
                required: "Please enter visa detail"
            },

            drivingLicenceNo: {
                required: "Please enter driving licence number"
            },
            vehicleType: {
                required: "Please enter vehicle type"
            },
            validUpto: {
                required: "Please select valid upto date"
            },

            issuedState: {
                required: "Please select issued state"
            },


        },
        submitHandler: function (form) {
            $.ajax({
                enctype: 'multipart/form-data',
                type: 'POST',
                url: '/admin/employee-personalData',
                data: new FormData(form),
                processData: false,
                contentType: false,
                cache: false,

                success: function (response) {
                    if (response.trim() === 'success') {
                        toastr.success('Successfully Save Personal Data');
                        $("#employee-personal-form").hide();
                        $("#employee-contact-form").show();
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});

//add contact detail of employee

$(document).ready(function () {

    $("#employee-contact-page").validate({

        rules: {
            workPhone: {
                required: true,
                digits: true
            },
            extention: {
                required: true
            },
            workMobile: {
                required: true,
                digits: true
            },
            corporateEmail: {
                required: true,
                email: true
            },
            personalEmail: {
                required: true,
                email: true
            },

        },
        messages: {
            workPhone: {
                required: "Please enter your work phone number",
                digits: "Please enter only digits"
            },
            extention: {
                required: "Please enter your extension"
            },
            workMobile: {
                required: "Please enter your work mobile number",
                digits: "Please enter only digits"
            },
            corporateEmail: {
                required: "Please enter your corporate email",
                email: "Please enter a valid email address"
            },
            personalEmail: {
                required: "Please enter your personal email",
                email: "Please enter a valid email address"
            },
        },
        submitHandler: function (form) {
            var formData = {
                workPhone: $('#workPhone').val(),
                extention: $('#extention').val(),
                workMobile: $('#workMobile').val(),
                homePhone: $('#homePhone').val(),
                homeMobile: $('#homeMobile').val(),
                corporateEmail: $('#corporateEmail').val(),
                personalEmail: $('#personalEmail').val(),
                secondaryEmail: $('#secondaryEmail').val(),

            };
            var employeeId = $('#employeeId2').val();
            $.ajax({
                type: "POST",
                url: "/admin/employeeContactFromData/" + employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Contact Data');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});


//add employee address
$(document).ready(function () {
    // Add validation rules and messages
    $("#address-form").validate({
        rules: {
            addressType: "required",
            address: "required",
            country: "required",
            state: "required",
            district: "required",
            city: "required",
            pincode: "required",
            addressOwner: "required"
        },
        messages: {},
        submitHandler: function (form) {
            var formData = {
                addressType: $('#addressType').val(),
                address: $('#address').val(),
                country: $('#country2').val(),
                state: $('#state').val(),
                district: $('#district').val(),
                city: $('#city').val(),
                pincode: $('#pincode').val(),
                allAddressAreSame: $('#allAddressAreSame').is(':checked'),
                addressOwner: $('input[name="addressOwner"]:checked').val(),

            };
            var employeeId = $('#employeeId3').val();
            $.ajax({
                type: "POST",
                url: "/admin/employeeAddressFromData/" + employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Address Data');
                        $("#exampleModal").modal("hide");
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });

        }
    });
});


//delete employee address
$(document).ready(function () {
    $('.delete-address').click(function () {

        var address_id = $(this).data('address_id');
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success ml-2',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: 'You are about to delete this Address.',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true,
        }).then((result) => {
            if (result.isConfirmed) {

                $.ajax({
                    type: 'POST',
                    url: '/admin/delete-address',
                    data: {
                        address_id: address_id
                    },
                    success: function (response) {

                        swalWithBootstrapButtons.fire(
                            'Deleted!',
                            'The Address has been deleted.',
                            'success'
                        );

                        $(this).closest('tr').remove();
                    },
                    error: function (xhr, status, error) {

                        swalWithBootstrapButtons.fire(
                            'Error!',
                            'An error occurred while deleting the Address.',
                            'error'
                        );
                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'The Address has not been deleted.',
                    'error'
                );
            }
        });
    });
});


//add family member in database

$(document).ready(function () {
    $('#employee-family-page').validate({
        rules: {
            firstName: {
                required: true,
                minlength: 2
            },
            middleName: {
                required: true,
                minlength: 2
            },
            lastName: {
                required: true,
                minlength: 2
            },
            relation: {
                required: true
            },
            dateOfBirth: {
                required: true
            },
            gender: {
                required: true
            },
            maritalStatus: {
                required: true
            },
            occupation: {
                required: true
            },
            contactDetails: {
                required: true
            },
            nationality: {
                required: true
            },
            address: {
                required: true
            }
        },
        messages: {
            firstName: {
                required: "Please enter your first name",
                minlength: "Your first name must be at least 2 characters long"
            },
            middleName: {
                required: "Please enter your middle name",
                minlength: "Your middle name must be at least 2 characters long"
            },
            lastName: {
                required: "Please enter your last name",
                minlength: "Your last name must be at least 2 characters long"
            },
            relation: {
                required: "Please select a relation"
            },
            dateOfBirth: {
                required: "Please enter your date of birth"
            },
            gender: {
                required: "Please select your gender"
            },
            maritalStatus: {
                required: "Please select your marital status"
            },
            occupation: {
                required: "Please enter your occupation"
            },
            contactDetails: {
                required: "Please enter your contact details"
            },
            nationality: {
                required: "Please select your nationality"
            },
            address: {
                required: "Please enter your address"
            }
        },
        submitHandler: function (form) {
            var formData = {

                firstName: $('#firstNameF').val(),
                middleName: $('#middleNameF').val(),
                lastName: $('#lastNameF').val(),
                relation: $('#relation').val(),
                dateOfBirth: $('#dateOfBirthF').val(),
                gender: $('#genderF').val(),
                isNominee: $('#isNominee').is(':checked'),
                maritalStatus: $('#maritalStatus').val(),
                occupation: $('#occupation').val(),
                isDependent: $('#isDependent').is(':checked'),
                contactDetails: $('#contactDetails').val(),
                nationality: $('#nationalityF').val(),
                isResidingWith: $('#isResidingWith').is(':checked'),
                contactInEmergency: $('#contactInEmergency').is(':checked'),
                isPhysicallyDisabled: $('#isPhysicallyDisabled').is(':checked'),
                address: $('#addressF').val()

            };
            var employeeId = $('#employeeId4').val();
            $.ajax({
                type: "POST",
                url: "/admin/employeeFamilyFromData/" + employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Family Data');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});


//delete employee family member in dataBase

$(document).ready(function () {
    $('.delete-family').click(function () {

        var family_id = $(this).data('family_id');
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success ml-2',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: 'You are about to delete this Family Member.',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true,
        }).then((result) => {
            if (result.isConfirmed) {

                $.ajax({
                    type: 'POST',
                    url: '/admin/delete-family',
                    data: {
                        family_id: family_id
                    },
                    success: function (response) {

                        swalWithBootstrapButtons.fire(
                            'Deleted!',
                            'The family member has been deleted.',
                            'success'
                        );

                        $(this).closest('tr').remove();
                    },
                    error: function (xhr, status, error) {

                        swalWithBootstrapButtons.fire(
                            'Error!',
                            'An error occurred while deleting the Family member.',
                            'error'
                        );
                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'The Family Member has not been deleted.',
                    'error'
                );
            }
        });
    });
});

//Employee Emergancy data add in database
$(document).ready(function () {
    $('#employee-emergancy-page').validate({
        rules: {
            priority: {
                required: true
            },
            firstName: {
                required: true
            },
            middleName: {
                required: true
            },
            lastName: {
                required: true
            },
            relation: {
                required: true
            },
            phoneNo: {
                required: true,
                digits: true
            },
            mobileNo: {
                required: true,
                digits: true
            },
            email: {
                required: true,
                email: true
            },
            address: {
                required: true
            }
        },
        messages: {
            priority: {
                required: "Please enter priority."
            },
            firstName: {
                required: "Please enter first name."
            },
            middleName: {
                required: "Please enter middle name."
            },
            lastName: {
                required: "Please enter last name."
            },
            relation: {
                required: "Please select relation."
            },
            phoneNo: {
                required: "Please enter phone number.",
                digits: "Please enter only digits."
            },
            mobileNo: {
                required: "Please enter mobile number.",
                digits: "Please enter only digits."
            },
            email: {
                required: "Please enter email.",
                email: "Please enter a valid email address."
            },
            address: {
                required: "Please enter address."
            }
        },
        submitHandler: function (form) {
            var formData = {
                priority: $('#priority').val(),
                firstName: $('#firstNameE').val(),
                middleName: $('#middleNameE').val(),
                lastName: $('#lastNameE').val(),
                relation: $('#relationE').val(),
                phoneNo: $('#phoneNo').val(),
                mobileNo: $('#mobileNo').val(),
                email: $('#email').val(),
                address: $('#addressE').val()

            };


            var employeeId = $('#employeeId9').val();
            $.ajax({
                type: "POST",
                url: "/admin/employeeFromEmergancyData/" + employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Emergency Data');
                        $("#employee-emergancy-form").hide();
                        $("#employee-nominee-form").show();
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});


//add Employee health data in database
$(document).ready(function () {
    $("#employee-health-page").validate({
        rules: {
            height: {
                required: true,
                number: true
            },
            weight: {
                required: true,
                number: true
            },
            bloodGroup: {
                required: true
            },
            identificationMark1: {
                required: true
            },
            identificationMark2: {
                required: true
            }
        },
        messages: {
            height: {
                required: "Please enter height",
                number: "Please enter a valid number"
            },
            weight: {
                required: "Please enter weight",
                number: "Please enter a valid number"
            },
            bloodGroup: {
                required: "Please select blood group"
            },
            identificationMark1: {
                required: "Please enter identification mark 1"
            },
            identificationMark2: {
                required: "Please enter identification mark 2"
            }
        },
        submitHandler: function (form) {
            var formData = {
                height: $('#height').val(),
                weight: $('#weight').val(),
                bloodGroup: $('#bloodGroup').val(),
                identificationMark1: $('#identificationMark1').val(),
                identificationMark2: $('#identificationMark2').val(),
                isHandicapped: $('#isHandicapped').is(':checked')
            };
            var employeeId = $('#employeeId6').val();
            $.ajax({
                type: "POST",
                url: "/admin/employeeFromHealthData/" + employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Health Data');
                        $("#employee-health-form").hide();
                        $("#employee-photograph-form").show();
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});


//employee photo and sign upload in database
$(document).ready(function () {
    $('#employee-photograph-page').validate({
        rules: {
            image: {
                required: true
            },
            sign: {
                required: true
            }
        },
        messages: {
            image: {
                required: "Please select an image."
            },
            sign: {
                required: "Please select a signature."
            }
        },
        submitHandler: function (form) {
            var formData = new FormData($('#employee-photograph-page')[0]);
            $.ajax({
                url: '/admin/handleEmployeePhotograph',
                type: 'POST',
                data: formData,
                contentType: false,
                processData: false,
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Photograph Data');
                        $("#employee-photograph-form").hide();
                        $("#employee-attachment-form").show();
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }

            });
        }
    });
});


//employee document upload in database
$(document).ready(function () {
    $("#employee-attachment-page").validate({
        rules: {
            documentType: "required",
            titleOfDocument: "required",
            description: "required",
            documentImage: "required"
        },
        messages: {
            documentType: "Please select a document type",
            titleOfDocument: "Please enter the title of the document",
            description: "Please enter a description",
            documentImage: "Please select a document image"
        },
        submitHandler: function (form) {
            var formData = new FormData(form);
            $.ajax({
                url: "/admin/saveEmployeeDocument",
                type: "POST",
                data: formData,
                processData: false,
                contentType: false,
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Document Data');
                        $("#employee-attachment-form").hide();
                        $("#employee-job-form").show();
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }

                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});


//nominee data add in database
$(document).ready(function () {

    $("#employee-nominee-page").validate({
        rules: {
            priority: "required",
            firstName: "required",
            lastName: "required",
            relation: "required",
            gender: "required",
            dateOfBirth: "required",
            uidNo: "required",
            panNo: "required",
            contactNo: "required",
            nomineeInvalidCondition: "required"
        },
        messages: {
            priority: "Please enter priority",
            firstName: "Please enter first name",
            lastName: "Please enter last name",
            relation: "Please select relation",
            gender: "Please select gender",
            dateOfBirth: "Please enter date of birth",
            uidNo: "Please enter UID number",
            panNo: "Please enter PAN number",
            contactNo: "Please enter contact number",
            nomineeInvalidCondition: "Please enter nominee invalid condition"
        },
        submitHandler: function (form) {
            var formData = {
                priority: $('#priorityN').val(),
                firstName: $('#firstNameN').val(),
                middleName: $('#middleNameN').val(),
                lastName: $('#lastNameN').val(),
                relation: $('#relationN').val(),
                gender: $('#genderN').val(),
                dateOfBirth: $('#dateOfBirthN').val(),
                uidNo: $('#uidNoN').val(),
                panNo: $('#panNo').val(),
                contactNo: $('#contactNo').val(),
                nomineeInvalidCondition: $('#nomineeInavalidCondition').val()
            };
            var employeeId = $('#employeeId5').val();
            $.ajax({
                url: "/admin/saveEmployeeNominee/" + employeeId,
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Nominee Data');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }

                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});

//delete nominee data in daa base
$(document).ready(function () {
    $('.delete-nominee').click(function () {

        var nominee_id = $(this).data('nominee_id');
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success ml-2',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: 'You are about to delete this Nominee.',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true,
        }).then((result) => {
            if (result.isConfirmed) {

                $.ajax({
                    type: 'POST',
                    url: '/admin/delete-nominee',
                    data: {
                        nominee_id: nominee_id
                    },
                    success: function (response) {

                        swalWithBootstrapButtons.fire(
                            'Deleted!',
                            'The Nominee has been deleted.',
                            'success'
                        );

                        $(this).closest('tr').remove();
                    },
                    error: function (xhr, status, error) {

                        swalWithBootstrapButtons.fire(
                            'Error!',
                            'An error occurred while deleting the Nominee.',
                            'error'
                        );
                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'The Nominee has not been deleted.',
                    'error'
                );
            }
        });
    });
});


//add some data in nominee from family member
$(document).ready(function () {
    $('.checkbox-data').click(function () {
        if ($(this).is(':checked')) {
            var $row = $(this).closest('tr');
            var firstName = $row.find('td:eq(1)').text();
            var occupation = $row.find('td:eq(2)').text();
            var dateOfBirth = $row.find('td:eq(3)').text();
            var relation = $row.find('td:eq(4)').text();
            var gender = $row.find('td:eq(5)').text();
            var maritalStatus = $row.find('td:eq(6)').text();


            $('#firstNameN').val(firstName);
            $('#occupationN').val(occupation);
            $('#dateOfBirthN').val(dateOfBirth);
            $('#relationN').val(relation);
            $('#genderN').val(gender);
            $('#maritalStatusN').val(maritalStatus);
            $('#exampleModal2').modal('hide');
        } else {
            $('#firstNameN').val('');
            $('#occupationN').val('');
            $('#dateOfBirthN').val('');
            $('#relationN').val('');
            $('#genderN').val('');
            $('#maritalStatusN').val('');
            $('#exampleModal2').modal('hide');
        }
    });
});


//add job detail

$(document).ready(function () {
    $("#employee-job-page").validate({
        rules: {
            designationId: {
                required: true
            },
            employmentType: {
                required: true
            },
            employmentCategory: {
                required: true
            },
            employmentSubType: {
                required: true
            },
            status: {
                required: true
            },
            noticePeriod: {
                required: true,
                digits: true
            },
            employeeGrade: {
                required: true
            },
            probationDuration: {
                required: true
            },
            probationStartDate: {
                required: true
            },
            dutiesAndResponsibilities: {
                required: true
            },
            insuranceStartGroup: {
                required: true
            },
            insuranceWithEffectiveFrom: {
                required: true
            },
            placeOfPosition: {
                required: true
            },
            branchName: {
                required: true
            },
            workLocation: {
                required: true
            },
            dateOfPosting: {
                required: true
            },
            groupWhenPosting: {
                required: true
            },
            postOrderNumber: {
                required: true,
                digits: true
            },
            dateOfPostingOrder: {
                required: true
            },
            payConfiguration: {
                required: true
            },

            scaleValue: {
                required: true,
                digits: true
            },
            recruitmentCategory: {
                required: true
            },
            weeklyOffWithEffectiveFrom: {
                required: true
            },
            weeklyOff: {
                required: true
            }
        },
        messages: {},
        submitHandler: function (form) {
            var formData = $(form).serializeArray();
            var jsonData = {};
            $(formData).each(function (index, obj) {
                jsonData[obj.name] = obj.value;
            });

            $.ajax({
                url: "/admin/employeeJobData",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(jsonData),
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Job Data');
                        $("#employee-job-form").hide();
                        $("#employee-reporting-form").show();
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }

                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});


//add report officer in database
$(document).ready(function () {
    $("#employee-reporting-page").validate({
        rules: {
            startDate: {
                required: true
            },

            DDO: {
                required: true
            },
            DH: {
                required: true
            },
            HO: {
                required: true
            },
            HOD: {
                required: true
            },
            AuthDate: {
                required: true
            },
            note: {
                required: true
            }
        },
        messages: {},
        submitHandler: function (form) {

            var formData = {
                startDate: $('#startDate').val(),
                endDate: $('#endDate').val(),
                ddo: $('#DDO').val(),
                dh: $('#DH').val(),
                ho: $('#HO').val(),
                hod: $('#HOD').val(),
                authDate: $('#AuthDate').val(),
                note: $('#note').val()
            };

            console.log(formData)
            var employeeId = $('#employeeId11').val();
            $.ajax({
                type: "POST",
                url: "/admin/saveReportOfficerForEmployee/" + employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save reporting Person Data');
                        $("#employee-reporting-form").hide();
                        $("#employee-previous-employment-form").show();
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }

                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});


//delete report officer data in daa base
$(document).ready(function () {
    $('.delete-report-person').click(function () {

        var repo_id = $(this).data('repo_id');
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success ml-2',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: 'You are about to delete this Reporting Officer.',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true,
        }).then((result) => {
            if (result.isConfirmed) {

                $.ajax({
                    type: 'POST',
                    url: '/admin/delete-reporting-officer',
                    data: {
                        repo_id: repo_id
                    },
                    success: function (response) {

                        swalWithBootstrapButtons.fire(
                            'Deleted!',
                            'The Reporting Officer has been deleted.',
                            'success'
                        );

                        $(this).closest('tr').remove();
                    },
                    error: function (xhr, status, error) {

                        swalWithBootstrapButtons.fire(
                            'Error!',
                            'An error occurred while deleting the Reporting Officer.',
                            'error'
                        );
                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'The Reporting Officer has not been deleted.',
                    'error'
                );
            }
        });
    });
});

//add previous employment data add in database
$(document).ready(function () {

    $("#employee-previous-employment-page").validate({
        rules: {
            fromDate: {
                required: true
            },
            toDate: {
                required: true
            },
            companyName: {
                required: true
            },
            serviceType: {
                required: true
            },
            position: {
                required: true
            },
            ctc: {
                required: true,
                number: true
            },
            responsibilities: {
                required: true
            },
            reasonOfSeperation: {
                required: true
            },
            hrContactPerson: {
                required: true
            },
            phoneNo: {
                required: true,
                number: true
            },
            mobileNo: {
                required: true,
                number: true
            },
            email: {
                required: true,
                email: true
            },
            website: {
                url: true
            },
            address: {
                required: true
            },
            remark: {
                required: true
            }
        },
        messages: {},

        submitHandler: function (form) {

            var formData = {
                fromDate: $('#fromDate').val(),
                toDate: $('#toDate').val(),
                companyName: $('#companyName').val(),
                serviceType: $('#serviceType').val(),
                position: $('#position').val(),
                ctc: $('#ctc').val(),
                responsibilities: $('#responsibilities').val(),
                reasonOfSeperation: $('#reasonOfSeperation').val(),
                hrContactPerson: $('#hrContactPerson').val(),
                phoneNo: $('#phoneNoP').val(),
                mobileNo: $('#mobileNoP').val(),
                email: $('#emailP').val(),
                website: $('#website').val(),
                address: $('#addressP').val(),
                remark: $('#remark').val()
            };

            console.log(formData)
            var employeeId = $('#employeeId13').val();
            $.ajax({
                type: "POST",
                url: "/admin/saveOldCompanyDetail/" + employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Previous Employment Detail');
                        $("#employee-previous-employment-form").hide();
                        $("#employee-education-form").show();
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }

                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });

});



//add Qualification Data in database

$(document).ready(function () {
    $("#employee-education-page").validate({
        rules: {
            qualification: {
                required: true
            },
            modeOfStudy: {
                required: true
            },
            university: {
                required: true
            },
            passingMonth: {
                required: true
            },
            board: {
                required: true
            },
            passingYear: {
                required: true,
                digits: true
            },
            duration: {
                required: true,
                digits: true
            },
            major: {
                required: true
            },
            percentage: {
                required: true,
                number: true
            },
            grade: {
                required: true
            },
            percentile: {
                required: true,
                number: true
            },
            gpaScore: {
                required: true,
                number: true
            },
            remark: {
                required: true
            },
            instituteAddress: {
                required: true
            }
        },
        messages: {
            qualification: "Please select qualification",
            modeOfStudy: "Please select mode of study",
            university: "Please enter university",
            passingMonth: "Please select passing month",
            board: "Please enter board",
            passingYear: {
                required: "Please enter passing year",
                digits: "Please enter a valid year"
            },
            duration: {
                required: "Please enter duration",
                digits: "Please enter a valid duration"
            },
            major: "Please enter major",
            percentage: {
                required: "Please enter percentage",
                number: "Please enter a valid percentage"
            },
            grade: "Please select grade",
            percentile: {
                required: "Please enter percentile",
                number: "Please enter a valid percentile"
            },
            gpaScore: {
                required: "Please enter GPA score",
                number: "Please enter a valid GPA score"
            },
            remark: "Please enter remark",
            instituteAddress: "Please enter institute address"
        },
        submitHandler: function (form) {
            var formData = {
                qualification: $('#qualification').val(),
                modeOfStudy: $('#modeOfStudy').val(),
                university: $('#university').val(),
                passingMonth: $('#passingMonth').val(),
                board: $('#board').val(),
                passingYear: $('#passingYear').val(),
                duration: $('#duration').val(),
                major: $('#major').val(),
                percentage: $('#percentage').val(),
                grade: $('#grade').val(),
                percentile: $('#percentile').val(),
                gpaScore: $('#gpaScore').val(),
                remark: $('#remarkE').val(),
                instituteAddress: $('#instituteAddress').val()
            };

            var employeeId= $('#employeeId14').val();
            $.ajax({
                type: "POST",
                url: "/admin/saveEmployeeQulification/"+employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Qulification Detail');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }

                },
                error: function (xhr, status, error) {
                    toastr.error('Something Went Wrong !!');

                }
            });
        }
    });
});


//excel file data
$(document).ready(function(){
    $('#excel-file').validate({
        rules: {
            'excel-file-data': {
                required: true,
            }
        },
        messages: {
            'excel-file-data': {
                required: "Please select a file."
            }
        },
        submitHandler: function(form) {
            $.ajax({
                url: '/admin/upload-excel',
                type: 'POST',
                data: new FormData(form),
                processData: false,
                contentType: false,
                success: function(response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Upload Excel File');
                    } else {
                        toastr.error(response);
                    }
                },
                error: function(xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});