$(document).ready(function () {
    $('#add-role-form').validate({
        rules: {
            name: 'required'
        },
        messages: {
            name: 'Please enter a role name'
        },
        submitHandler: function (form) {

            $.ajax({
                url: '/admin/add-role',
                method: 'POST',
                data: $(form).serialize() ,
                success: function (response) {
                    if(response.trim() === 'success'){


                        toastr.success("Successfully added role!");
                        setTimeout(function() {
                            window.location.reload(true);
                        }, 2000);

                    }
                    else {
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










$(document).ready(function () {
    $('#add-module-form').validate({
        rules: {
            name: 'required',
            prefix: 'required',
            plugin: {
                required: true,
            },
            controller: 'required',
            action: 'required',
            menuIconCss: 'required'
        },
        messages: {
            name: 'Please enter a module name',
            prefix: 'Please enter a prefix',
            plugin: {
                required: 'Please enter a plugin',
            },
            controller: 'Please enter a controller',
            action: 'Please enter an action',
            menuIconCss: 'Please enter a menu icon CSS'
        },
        submitHandler: function (form) {
            var formData = $(form).serializeArray();
            var parentId =$('#parentId').val();
            var subParentId = $('#subParentId').val();
            // console.log(parentId)
            // console.log(subParentId)

            // formData.push({ name: 'parentId', value: parentId });
            // formData.push({ name: 'subParentId', value: subParentId });
            console.log(formData)
            $.ajax({
                url: '/admin/add-module-data',
                method: 'POST',
                data: formData ,
                success: function (response) {
                    if(response.trim() === 'success'){


                        toastr.success("Successfully added Module!");
                        setTimeout(function() {
                            window.location.reload(true);
                        }, 2000);

                    }
                    else {
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
    function generateTable(data,roleId) {
        var tableHtml = '<div class="row">' +
            '<div class="card container" style="margin-right: 100px">' +
            '<div class="card-body">' +
            '<h5 class="card-title text-uppercase mb-0">Mapping </h5>' +
            '</div>' +
            '<div class="table-responsive p-5">' +
            '<table id="role-module-table" class="table no-wrap user-table mb-0">' +
            '<thead>' +
            '<tr class="table-primary">' +
            '<th scope="col" class="border-0 text-uppercase font-medium pl-4">Sr No</th>' +
            '<th scope="col" class="border-0 text-uppercase font-medium pl-4">Module Name</th>' +
            '<th scope="col" class="border-0 text-uppercase font-medium pl-4">Controller</th>' +
            '<th scope="col" class="border-0 text-uppercase font-medium pl-4">Action</th>' +
            '<th scope="col" class="border-0 text-uppercase font-medium pl-4"><input type="checkbox">Add</th>' +
            '<th scope="col" class="border-0 text-uppercase font-medium pl-4"><input type="checkbox">View</th>' +
            '<th scope="col" class="border-0 text-uppercase font-medium pl-4"><input type="checkbox">Edit</th>' +
            '<th scope="col" class="border-0 text-uppercase font-medium pl-4"><input type="checkbox">Delete</th>' +


            '</tr>' +
            '</thead>' +
            '<tbody>';


        data.forEach(function(item, index) {
            tableHtml += '<tr>' +
                '<td>' + (index + 1) + '</td>' +
                '<td>' + item.name + '</td>' +
                '<td>' + item.controller + '</td>' +
                '<td>' + item.action + '</td>' +
                '<td><input type="checkbox" onclick="add(' + item.id + ',' + roleId + ')"></td>'+
                '<td><input type="checkbox" onclick="view(' + item.id + ',' + roleId + ')"></td>' +
                '<td><input type="checkbox" onclick="edit(' + item.id + ',' + roleId + ')"></td>' +
                '<td><input type="checkbox" onclick="deletea(' + item.id + ',' + roleId + ')"></td>' +

                '</tr>';
        });
        tableHtml += '</tbody></table></div></div></div>';

        return tableHtml;
    }
    $('#role-select').change(function() {

        var roleId = $('#role-select').val();
        console.log(roleId+"fjfnkjdnfd")
        $.ajax({
            url: '/admin/getModulesForRole',
            method: 'GET',
            success: function(response) {
                var tableHtml = generateTable(response,roleId);
                $('#mapping-table').html(tableHtml);
            },
            error: function(xhr, status, error) {
                console.error('Error fetching modules:', error);
            }
        });
    });
});

function add(moduleId,roleId){
    $.ajax({
        url: '/admin/addPermission',
        method: 'POST',
        data:{moduleId:moduleId,roleId:roleId},
        success: function(response) {

        },
        error: function(xhr, status, error) {

        }
    });
}

function view(moduleId,roleId){
    $.ajax({
        url: '/admin/viewPermission',
        method: 'POST',
        data:{moduleId:moduleId,roleId:roleId},
        success: function(response) {

        },
        error: function(xhr, status, error) {

        }
    });
}

function view(moduleId,roleId){
    $.ajax({
        url: '/admin/editPermission',
        method: 'POST',
        data:{moduleId:moduleId,roleId:roleId},
        success: function(response) {

        },
        error: function(xhr, status, error) {

        }
    });
};

function deletea(moduleId,roleId){
    $.ajax({
        url: '/admin/deletePermission',
        method: 'POST',
        data:{moduleId:moduleId,roleId:roleId},
        success: function(response) {

        },
        error: function(xhr, status, error) {

        }
    });
}

