<%-- 
    Document   : createReward
    Created on : Aug 28, 2018, 2:23:04 PM
    Author     : 58050232
--%>
<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">

    $(document).ready(function () {
        $('.active_datetime').datetimepicker({
            startDate: new Date(),
            weekStart: 1,
            autoclose: true,
            minView: 'month'
        }).on('changeDate', function (selected) {
            var minDate = new Date(selected.date.valueOf());
            $('.redeemExp_datetime').datetimepicker('setStartDate', minDate);
            $('.exchangeExp_datetime').datetimepicker('setStartDate', minDate);
        });
        $('.redeemExp_datetime').datetimepicker({
            startDate: new Date(),
            weekStart: 1,
            autoclose: true,
            minView: 'month'
        }).on('changeDate', function (selected) {
            var maxDate = new Date(selected.date.valueOf());
            $('.active_datetime').datetimepicker('setEndDate', maxDate);
            $('.exchangeExp_datetime').datetimepicker('setStartDate', maxDate);
        });
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
        $('.exchangeExp_datetime').datetimepicker({
            startDate: new Date(),
            weekStart: 1,
            autoclose: true,
            minView: 'month'
        }).on('changeDate', function (selected) {
            var maxDate = new Date(selected.date.valueOf());
            $('.active_datetime').datetimepicker('setEndDate', maxDate);
            $('.redeemExp_datetime').datetimepicker('setEndDate', maxDate);
        });
    });


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
                    d.groupID = $('#groupID').val();
                    d.departmentID = $('#departmentID').val();
                    d.divisionID = $('#divisionID').val();
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
<div class="content">
    <form:form method="POST" id="mainForm" name="mainForm" modelAttribute="createReward">
        <div class="container">
            <h3><span class="heading">Create Reward</span></h3>
            <hr>
            <div class="row">
                <div class="col-6 mt-2">
                    <label for="rewardTh" class="text-primary">Reward Thai</label>
                    <form:input class="form-control" id="rewardTh" maxlength="100" path="rewardTh" required="required"/>
                </div>

                <div class="col-6 mt-2">
                    <label for="rewardEn" class="text-primary">Reward English</label>
                    <form:input class="form-control" id="rewardEn" maxlength="100" path="rewardEn" required="required"/>
                </div>
            </div>
            <div class="row">
                <div class="col-6 mt-2">
                    <label for="descTh" class="text-primary">Describe Thai</label>
                    <form:input class="form-control" id="descTh" maxlength="200" path="descTh"/>
                </div>

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
                    <label class="text-primary">ผู้ใช้ที่สามารถแจกของรางวัลได้</label><br>
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

            <!-- Modal -->
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
                                        <label for="groupID" class="text-primary px-2"> Group</label>
                                        <div class="dropdown">
                                            <form:select path="groupID" id="groupID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                                                <form:option value="null">Search by Group Name</form:option> 
                                                <c:forEach items="${groupDropdown}" var="groupDropdown">
                                                    <form:option value="${groupDropdown.dropDownKey}" name="${groupDropdown.dropDownValue}"> ${groupDropdown.dropDownValue} </form:option>
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
                                        <label for="departmentID" class="text-primary px-2"> Department</label>
                                        <form:select path="departmentID" id="departmentID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                                            <form:option value="">
                                                please select
                                            </form:option>
                                            <c:forEach items="${departmentsDropDownList}" var="departmentsDropDownList">
                                                <form:option value="${departmentsDropDownList.dropDownKey}">${departmentsDropDownList.dropDownValue}</form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <div class="col-3">
                                        <label for="divisionID" class="text-primary px-2"> Division</label>
                                        <form:select path="divisionID" id="divisionID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                                            <form:option value="">
                                                please select
                                            </form:option>
                                            <c:forEach items="${divisionDropDownList}" var="divisionDropDownList">
                                                <form:option value="${divisionDropDownList.dropDownKey}">${divisionDropDownList.dropDownValue}</form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <div class="col-3" >
                                        <label for="searchName" class="text-primary px-2"> Search</label>
                                        <form:input class="form-control" id="searchName" path="searchName" placeholder="SearchName"/>
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
                    <!-- END OF MODAL BODY -->
                </div>
            </div>
        </div>
    </div>


</div>
</form:form>
</div>