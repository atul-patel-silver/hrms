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
        $("#employee-personal-form").show();
    });
});


$(document).ready(function () {
    $("#contact-Info-Button").click(function () {
        $("#employee-form").hide();
        $("#employee-personal-form").hide();
        $("#employee-contact-form").show();
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