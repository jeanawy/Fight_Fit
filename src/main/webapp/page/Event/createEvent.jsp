%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">

//    $(document).ready(function () {
//        $('.active_datetime').datetimepicker({
//            startDate: new Date(),
//            weekStart: 1,
//            autoclose: true,
//            minView: 'month'
//        }).on('changeDate', function (selected) {
//            var minDate = new Date(selected.date.valueOf());
//            $('.redeemExp_datetime').datetimepicker('setStartDate', minDate);
//            $('.exchangeExp_datetime').datetimepicker('setStartDate', minDate);
//        });
        
      
        
        $('.showStart_datetime').datetimepicker({
            startDate: new Date(),
            weekStart: 1,
            autoclose: true,
            minView: 'month'
        }).on('changeDate', function (selected) {
            var maxDate = new Date(selected.date.valueOf());
            $('.showEnd_datetime').datetimepicker('setStartDate', maxDate);
        });
        $('.showEnd_datetime').datetimepicker({
            startDate: new Date(),
            weekStart: 1,
            autoclose: true,
            minView: 'month'
        }).on('changeDate', function (selected) {
            var maxDate = new Date(selected.date.valueOf());
            $('.showStart_datetime').datetimepicker('setEndDate', maxDate);
        });
//        $('.exchangeExp_datetime').datetimepicker({
//            startDate: new Date(),
//            weekStart: 1,
//            autoclose: true,
//            minView: 'month'
//        }).on('changeDate', function (selected) {
//            var maxDate = new Date(selected.date.valueOf());
//            $('.active_datetime').datetimepicker('setEndDate', maxDate);
//            $('.redeemExp_datetime').datetimepicker('setEndDate', maxDate);
//        });
//    });


    $('#btn1').attr('disabled', 'disabled');
    $(document).keypress(function (e) {
        if (e.keyCode === 13) {
            $("#btn1").click();
            return false;
        }
    });


    function send() {

        var arrayValue = [];
        $('input[name=fo]').each(function () {

            if ($(this).prop('checked')) {
                arrayValue.push($(this).val());
            }
            console.log("input" + arrayValue);
        });

    }

    $(document).ready(function () {

        $('#departmentID').change(function () {
            $("#divisionID").find('option').remove();
            $.ajax({
                url: "reloadDivisionDropDown",
                type: "POST",
                data: {language: "th", departmentID: $('#departmentID').val()},
                success: function (response) {
                    console.log(divisionID);

                    $('#btn1').removeAttr('disabled');
                    $('<option>').val("null").text("please select").appendTo(divisionID);
                    $.each(response, function (key, value) {
                        $('<option>').val(value.dropDownKey).text(value.dropDownValue).appendTo(divisionID);

                    });
                }
            });
        });

    });

    function doSearch() {
        $('#Search').attr('disabled', 'disabled');
        $('#userAuthorizeTable tbody').off('click', 'tr');


        console.log($('#groupID').val());


        $.fn.dataTable.ext.errMode = 'none';
        table = $('#UserAuthorizeTable').DataTable({
            "processing": true,
            "serverSide": true,
            "lengthChange": false,
            "pageLength": 5,
            "searching": false,
            "ordering": false,
            "scrollY": true,
            "scrollX": true,
            "order": true,

            ajax: {
                url: "UserAuthorizeController-searchUserAuthorize",
                type: "POST",
                data: function (d) {
                    d.sid = "mpy001";
                    d.language = "th";
                    
                    d.eventID = $('#eventID').val();
                    d.eventLocationID = $('#eventLocationID').val();
                    d. = $('#divisionID').val();
                    d.searchName = $('#searchName').val();
                    d.flageoption = false;
                },
                dataSrc: function (response) {

                    $('#UserAuthorizeTable tbody').on('click', 'tr', function () {
                        var arrayValue = [];
                        var data = table.row($(this).parents('tr')).data();
                        
                        $('input[name=fo]').each(function () {
                            if ($(this).prop('checked')) {
                                arrayValue.push($(this).val());
                                console.log($(this).val());
                            }
                        });
                        console.log("input" + arrayValue.length);
                        if (arrayValue.length > 0) {
                            $('#ko').show('speed');
                            $('#ko2').show('speed');
                            console.log(">0");
                        } else {
                            $('#selectall').prop('checked', false);
                            console.log("0");
                        }
                    });

                    console.log(response.userAuthorize);
                    $('#selectall').prop('checked', false);
                    $('#Search').removeAttr('disabled');
                    return response.userAuthorize;
                }

            },
            columns: [
                {data: 'uid', title: 'No.'},
                {data: 'image', title: 'Image'},
                {data: 'name', title: 'Name'},
                {data: 'department', title: 'Department'},
                {data: 'division', title: 'Division'},
                {data: 'group', title: 'Group'},
                {data: 'uid', title: '<input type="checkbox" id="selectall"/>'}
            ],
            columnDefs: [
                {
                    targets: 0,
                    className: "dt-body-center"
                },
                {
                    targets: 1,
                    render: function (data) {
                        return '<img class="rounded-circle  border border-dark" style="width: 50px; height: 50px;" src="' + data + '">';
                    },
                    className: "dt-body-center"
                },
                {
                    targets: 2,
                    className: "dt-body-center"
                },
                {
                    targets: 3,
                    className: "dt-body-center"
                },
                {
                    targets: 4,
                    className: "dt-body-center"
                },
                {
                    targets: 5,
                    className: "dt-body-center"
                },
                {
                    targets: 6,
                    searchable: false,
                    orderable: false,
                    className: "dt-body-center",
                    render: function (data) {
                        return '<input type="checkbox" class="checkbox  checkbox-primary" name="fo"  value="' + data + '"/>';
                    }
                }
            ],
            language: {
                emptyTable: 'No result found.'
            }

        });


        $('#selectall').on('click', function () {
            var rows = table.rows({'search': 'applied'}).nodes();
            $('input[type="checkbox"]', rows).prop('checked', this.checked);

            var arrayValue = [];
            $('input[name=fo]').each(function () {
                if ($(this).prop('checked')) {
                    arrayValue.push($(this).val());
                    console.log($(this).val());
                }
            });
            console.log("input" + arrayValue.length);
            if (arrayValue.length > 0) {
                $('#ko').show('speed');
                $('#ko2').show('speed');
                console.log(">0");
            } else {
                $('#selectall').prop('checked', false);
                console.log("0");
            }
        });



        search(table, true);
        clearDataTable();




    }
    function reset() {
        $('input[type="checkbox"]', rows).prop('check', this.checked);
    }

    function clearDataTable() {
        table.clear().draw();
    }
    function search(table, resetPage) {
        table.ajax.reload(null, resetPage);
    }

    function query() {

        $.ajax({
            url: "GroupController-createGroup",
            type: "POST",
            data: {language: "th",
                sid: "mpy001",
                groupNameTh: $('input[name="groupNameTh"]').val(),
                groupNameEn: $('input[name="groupNameEn"]').val()

            }, success: function (response) {


                return response;
            }

        });

        location.reload();
    }

    function addUser() {
        console.log("addUser");

        var arrayValue = [];
        $('input[name=fo]').each(function () {
            if ($(this).prop('checked')) {
                var data = table.row($(this).parents('tr')).data();
                console.log(data.image);
                x(data.image);
                arrayValue.push($(this).val());
            }
            console.log("input" + arrayValue);

        });

        function x(n) {
            $('#wait').append('<img class="rounded-circle  border border - dark mx-1"  style="width: 50px; height: 50px; " src="' + n + '">');
        }
    }

</script>
<style>
    .input-group-addon.tail {
        color: rgb(255, 255, 255);
        background-color: rgb(50, 118, 177);
        border-color: rgb(40, 94, 142);
    }
    .btn-circle {
        width: 50px;
        height: 50px;
        padding: 10px 16px;
        font-size: 18px;
        line-height: 1.33;
        border-radius: 25px;
    }
</style>


<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create Page</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/admin.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
  </head>

  <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="index.html">Fightfit</a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

      <!-- Navbar Search -->
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div>
      </form>

      <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-bell fa-fw"></i>
            <span class="badge badge-danger">9+</span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-envelope fa-fw"></i>
            <span class="badge badge-danger">7</span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="#">Settings</a>
            <a class="dropdown-item" href="#">Activity Log</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
          </div>
        </li>
      </ul>

    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="index.html">
            <i class="fas fa-home"></i>
            <span>Home</span>
          </a>
        </li>
                <li class="nav-item">
          <a class="nav-link" href="event.html">
            <i class="fas fa-fw fa-table"></i>
            <span>Events</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="create.html">
            <i class="fas fa-fw fa-folder"></i>
            <span>Creates</span></a>
        </li>
        <!--<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Pages</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="event.html">Event</a>
            <a class="dropdown-item" href="create.html">Create</a>
          </div>
        </li>-->
        <li class="nav-item">
          <a class="nav-link" href="fitbitlogin.html">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Profile</span></a>
        </li>

      </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs -->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.html">Home</a>
            </li>
            <li class="breadcrumb-item active">Creates</li>
          </ol>

          <!-- Page Content 
          <h1>Create</h1>
          <hr>
          <p></p>-->
              <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">Create</div>
        <div class="card-body">
          <form>
            <div class="form-group">
              <div class="form-row">

                <div><font face="Tahoma">Event name</font></div>
                <input type="text" id="eventname" class="form-control" placeholder="Event name" required="required" autofocus="autofocus">
                
              </div>
            </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <font face="Tahoma">Date</font>
                    <input type="date" id="date" class="form-control" placeholder="Date" required="required">                   
                  </div>
                  <div class="form-label-group">
                    <div><font face="Tahoma">Time to start</font></div>
                    <input type="time" id="time" class="form-control" placeholder="Time" required="required">
                    

                  </div>
                  <div class="form-label-group">
                    <div><font face="Tahoma">Time to end</font></div>
                    <input type="time" id="time" class="form-control" placeholder="Time" required="required">
                  </div>
                </div>
              
            <div class="col-md-6">
            <div class="form-group">
              <div class="form-label-group">
                
                <div><font face="Tahoma">Sport Type</font></div>
                <div class="form-control">
                <select>
                <option value="football">Football</option>
                <option value="basketball">Basketball</option>
                <option value="badminton">Badminton</option>
                </select>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                
                <div><font face="Tahoma">Tactic</font></div>
                <div class="form-control">
                <select>
                <option value="volvo">1vs1</option>
                <option value="saab">2vs2</option>
                <option value="opel">5vs5</option>
                <option value="audi">7vs7</option>
                <option value="audi">11vs11</option>
                </select>
                </div>
              </div>
            </div>
            </div>

            <a class="btn btn-primary btn-block" href="map.html">Submit</a>
          </form>
        </div>
      </div>
    </div>
</div>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright © Fightfit 2018</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>

  </body>

</html>





<!--
<div class="content">
    <form:form method="POST" id="mainForm" name="mainForm" modelAttribute="createReward">
        <div class="container">
            <h3><span class="heading">Create Reward</span></h3>
            <hr>
            <div class="row">
                <div class="col-6 mt-2">
                    <label for="eventName" class="text-primary">Event Name</label>
                    <form:input class="form-control" id="rewardTh" maxlength="100" path="rewardTh" required="required"/>
                </div>

            </div>
            <div class="row">

                <div class="col-6 mt-2">
                    <label for="descEn" class="text-primary">Describe Thai</label>
                    <form:input class="form-control" id="descEn" maxlength="200" path="descEn"/>
                </div>
            </div>
            <div class="row">
                <div class="col-6 mt-2">
                    <label for="conditionTh" class="text-primary">Condition Thai</label>
                    <textarea id="conditionTh" style="width:100%;height:80px;overflow:auto;" maxlength="300" path="conditionTh"></textarea>
                </div>

                <div class="col-6 mt-2">
                    <label for="conditionEn" class="text-primary">Condition English</label>
                    <textarea id="conditionEn" style="width:100%;height:80px;overflow:auto;" maxlength="300" path="conditionEn"></textarea>
                </div>
            </div>

            <div class="row">
                <div class="col-8 mt-2">
                    <div class="row">
                        <div class="col-4">
                            <div class="form-group">
                                <label for="activeDate" class="text-primary">Active Date</label>
                                <div class="input-group date active_datetime" data-date-format="dd/mm/yyyy">
                                    <form:input class="form-control" id="activeDate" path="activeDate"/>
                                    <span class="input-group-addon">
                                        <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-group">
                                <label for="showStartDate" class="text-primary">Show Start Date</label>
                                <div class="input-group date showStart_datetime" data-date-format="dd/mm/yyyy">
                                    <form:input class="form-control" id="showStartDate" path="showStartDate"/>
                                    <span class="input-group-addon">
                                        <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-group">
                                <label for="showEndDate" class="text-primary">Show End Date</label>
                                <div class="input-group date showEnd_datetime" data-date-format="dd/mm/yyyy">
                                    <form:input class="form-control" id="showEndDate" path="showEndDate"/>
                                    <span class="input-group-addon">
                                        <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-4">
                            <div class="form-group">
                                <label for="redeemExpDate" class="text-primary">Redeem EXP Date</label>
                                <div class="input-group date redeemExp_datetime" data-date-format="dd/mm/yyyy">
                                    <form:input class="form-control" id="redeemExpDate" path="redeemExpDate"/>
                                    <span class="input-group-addon">
                                        <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-group">
                                <label for="exchangeExpDate" class="text-primary">Exchange EXP Date</label>
                                <div class="input-group date exchangeExp_datetime" data-date-format="dd/mm/yyyy">
                                    <form:input class="form-control" id="exchangeExpDate" path="exchangeExpDate"/>
                                    <span class="input-group-addon">
                                        <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4">
                            <label for="quantity" class="text-primary">จำนวนรางวัล</label>
                            <div class="input-group">
                                <form:input class="form-control" type="number" id="quantity" min="1" path="quantity"/>
                                <div class="input-group-append">
                                    <span class="input-group-text">รางวัล</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6 mt-2">
                            <label for="starAmount" class="text-primary">ดาวที่ใช้</label>
                            <div class="input-group">
                                <font color="#cd7f32" class="mr-2">&#9733; Bronze Star</font>
                                <form:input class="form-control" type="number" id="starAmount" min="1" path="starAmount"/>
                                <div class="input-group-append">
                                    <span class="input-group-text">ดวง</span>
                                </div>
                            </div>
                        </div>
                    </div>          
                </div>
                <div class="col mt-2 ml-4">
                    <div class="container">
                        <div class="row">
                            <div class="offset"
                                 <form action="fileUploadController-singleFileUpload" method="post" enctype="multipart/form-data">
                                    <div class="form-group inputDnD">
                                        <label class="sr-only" for="inputFile">File Upload</label>
                                        <input type="file" class="form-control-file text-primary font-weight-bold" id="inputFile" name="file" accept="image/*" onchange="readUrl(this)" data-title="Drop file to Upload">
                                    </div>
                                    <button type="button" class="btn btn-primary" onclick="document.getElementById('inputFile').click()">BROWSE</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12 mt-2">
                    <label class="text-primary">ผู้สร้าง Event ได้ </label><br>
                </div>
                <div id="wait">

                </div> 
                <div class="col-2">
                    <button type="button" class="btn btn-default btn-circle" data-toggle="modal" onclick="doSearch()" data-target="#myModal">+</button>  
                </div>
            </div>

            <div class="col align-self-center mb-4">
                <center><button type="submit" class="btn btn-primary" style="width: 100px">สร้าง</button></center>
            </div>

             Modal 
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            Choose User
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="content ">
                                <div class="row">
                                    <div class="col-5">
                                        <label for="eventID" class="text-primary px-2"> Group</label>
                                        <div class="dropdown">
                                            <form:select path="eventID" id="eventID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                                                <form:option value="null">Search by Group Name</form:option> 
                                                <c:forEach items="${eventDropdown}" var="groupDropdown">
                                                    <form:option value="${eventDropdown.dropDownKey}" name="${eventDropdown.dropDownValue}"> ${eventDropdown.dropDownValue} </form:option>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <label for="btn1"> &nbsp;</label>
                                        <button class="btn btn-primary" id="btn1" name="Search" type="button" value="Submit" onClick="doSearch()" >Search</button>
                                    </div>
                                </div>

                                <div class="row mt-2">
                                    <div class="col-3">
                                        <label for="eventLocationId" class="text-primary px-2"> Location </label>
                                        <form:select path="eventLocationId" id="eventLocationId" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                                            <form:option value="">
                                                please select
                                            </form:option>
                                            <c:forEach items="${eventLocationDropDownList}" var="departmentsDropDownList">
                                                <form:option value="${eventLocationDropDownList.dropDownKey}">${eventLocationDropDownList.dropDownValue}</form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <div class="col-3">
                                        <label for="SportId" class="text-primary px-2"> Division</label>
                                        <form:select path="SportId" id="SportId" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                                            <form:option value="">
                                                please select
                                            </form:option>
                                            <c:forEach items="${sportDropDownList}" var="divisionDropDownList">
                                                <form:option value="${sportDropDownList.dropDownKey}">${sportDropDownList.dropDownValue}</form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <div class="col-3" >
                                        <label for="searchName" class="text-primary px-2"> Search</label>
                                        <form:input class="form-control" id="eventName" path="eventName" placeholder="eventName"/>
                                    </div>

                                    <div class="col-12 mt-4 ">
                                        <table id="UserAuthorizeTable" class="table table-striped table-bordered" width="100%">
                                        </table>
                                    </div>

                                    <div class="col-3 mt-3">

                                    </div>
                                    <div  id="ko" class="col-3 mt-3">
                                        <button type="button" class="btn btn-large btn-block btn-warning text-white" onClick="reset()" >Cancel</button>
                                    </div>
                                    <div  id="ko2" class="col-3 mt-3">
                                        <button type="button" class="btn btn-primary" onClick="addUser()" data-dismiss="modal">Add</button>
                                    </div>
                                    <div class="col-3 mt-3">
                                    </div>
                                </div> 
                                <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header bg-primary">
                                                <div class="mx-auto">
                                                    <h4 class="modal-title text-white" id="exampleModalLabel">Create Reward</h4>
                                                </div>
                                            </div>
                                            <div class="modal-body mt-2 mb-2">
                                                <center><h5>Confirm to Select User</h5></center>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-large btn-block btn-warning text-white" data-dismiss="modal">Cancel</button>
                                                <button class="btn btn-primary" id="Search2" name="Search2" type="button" value="Submit2" onClick="send()" data-dismiss="modal">Confirm</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                     END OF MODAL BODY 
                </div>
            </div>
        </div>
    </div>


</div>
</form:form>
</div>-->