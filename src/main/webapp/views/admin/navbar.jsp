<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        .error {
            color: red;
        }
    </style>
    <link rel="icon" type="image/x-icon" href="data:image/png;base64,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">
    <!-- fa fa font -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <!-- for uli icon -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css" />

    <!-- Include DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">

</head>

<body>


<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img class="mt-2" style="height: 42px;width: 50px;" src="data:image/png;base64,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"/></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#/admin/dashboard">HRMS</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Master
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/admin/manage-designation">Designation</a></li>
                        <li><a class="dropdown-item" href="/admin/manage-department">Department</a></li>

                    </ul>
                </li>
            </ul>
            <div class="d-flex">
                <a class="nav-link" href="#" style="margin:10px">
                    <span class="fa fa-user fa-2x" >Account</span>
                </a>
                <a class="nav-link ml-3" href="/logout">
                    <i style="margin:10px" class="fa fa-sign-out fa-2x"></i>
                </a>


            </div>

        </div>
    </div>
</nav>




<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"
        integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<script src="/js/admin/rolemaster.js"></script>
<script src="/js/admin/script.js"></script>
</body>

</html>