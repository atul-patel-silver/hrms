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
            minlength: 2
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
            minlength: "Employee code must be at least 2 characters long"
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
                    toastr.success('Successfully Save Employee');
                    form.reset();
                    window.location = "/admin/editEmployee/"+response.id;
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
