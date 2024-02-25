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


//add employee
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
    submitHandler: function(form) {
        $.ajax({
            type: "POST",
            url: "/admin/saveEmployee",
            data: $(form).serialize(),
            success: function(response) {
                if (response.isSuccess.trim() === 'success') {
                    form.reset();
                    window.location = "/admin/editEmployee/"+response.id;
                    toastr.success('Successfully Save Employee');
                } else {
                    toastr.error('Something Went Wrong !!');
                }

            },
            error: function(xhr, status, error) {
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
        $("#employee-emergancy-form").hide();
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
        $("#employee-emergancy-form").hide();
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
        $("#employee-emergancy-form").show();

    });
});

$(document).ready(function() {
    $('#isGovernmentVehicleProvider').change(function() {
        if ($(this).is(":checked")) {
            $('#UsedForOnDuty').show();
            $('#detailOfVehicle').show();
        } else {
            $('#UsedForOnDuty').hide();
            $('#detailOfVehicle').hide();
        }
    });
});


$(document).ready(function() {
    $('#isResidentOfOtherCountry').change(function() {
        if($(this).is(":checked")) {
            $('#othercountry').show();
        } else {
            $('#othercountry').hide();
        }
    });
});




$(document).ready(function() {
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

            detailOfVehicleProvider:{
                required: function(element) {
                    return $('#isGovernmentVehicleProvider').is(':checked');
                }
            },
            migrationDateOfIndia: {
                required: function(element) {
                    return $('#isResidentOfOtherCountry').is(':checked');
                }
            },
            country: {
                required: function(element) {
                    return $('#isResidentOfOtherCountry').is(':checked');
                }
            },
            otherCountryAddress: {
                required: function(element) {
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
        submitHandler: function(form) {
            $.ajax({
                enctype: 'multipart/form-data',
                type: 'POST',
                url: '/admin/employee-personalData',
                data: new FormData(form),
                processData: false,
                contentType: false,
                cache: false,

                success: function(response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Personal Data');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function(xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});



    $(document).ready(function() {

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
        submitHandler: function(form) {
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
                url: "/admin/employeeContactFromData/"+employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function(response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Contact Data');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function(xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});



$(document).ready(function() {
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
        messages: {

        },
        submitHandler: function(form) {
            var formData = {
                 addressType : $('#addressType').val(),
                 address : $('#address').val(),
                 country : $('#country2').val(),
                 state : $('#state').val(),
                 district : $('#district').val(),
                 city : $('#city').val(),
                 pincode : $('#pincode').val(),
                 allAddressAreSame : $('#allAddressAreSame').is(':checked'),
                 addressOwner : $('input[name="addressOwner"]:checked').val(),

            };
            var employeeId = $('#employeeId3').val();
            $.ajax({
                type: "POST",
                url: "/admin/employeeAddressFromData/"+employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function(response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Address Data');
                        $("#exampleModal").modal("hide");
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function(xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });

        }
    });
});



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



//family form

$(document).ready(function() {
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
        submitHandler: function(form) {
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
                url: "/admin/employeeFamilyFromData/"+employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function(response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Family Data');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function(xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});



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


$(document).ready(function() {
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
        submitHandler: function(form) {
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
                url: "/admin/employeeFromEmergancyData/"+employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function(response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Emergency Data');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function(xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});


$(document).ready(function() {
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
        submitHandler: function(form) {
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
                url: "/admin/employeeFromHealthData/"+employeeId,
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function(response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Health Data');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }
                },
                error: function(xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});


$(document).ready(function() {
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
        submitHandler: function(form) {
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

$(document).ready(function() {
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
        submitHandler: function(form) {
            var formData = new FormData(form);
            $.ajax({
                url: "/admin/saveEmployeeDocument",
                type: "POST",
                data: formData,
                processData: false,
                contentType: false,
                success: function(response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Document Data');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }

                },
                error: function(xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});



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
                url: "/admin/saveEmployeeNominee/"+employeeId,
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function(response) {
                    if (response.trim() === 'success') {
                        form.reset();
                        toastr.success('Successfully Save Nominee Data');
                    } else {
                        toastr.error('Something Went Wrong !!');
                    }

                },
                error: function(xhr, status, error) {
                    toastr.error('Something Went Wrong !!');
                }
            });
        }
    });
});



$(document).ready(function() {
    $('.checkbox-data').click(function() {
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
            // Clear the form fields if the checkbox is unchecked
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
