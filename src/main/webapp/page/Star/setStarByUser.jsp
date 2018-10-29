<%-- 
    Document   : setStarByUser
    Created on : Aug 29, 2018, 4:01:11 PM
    Author     : ธนากร
--%>
<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    var table = null;

    $(document).keypress(function (e) {
        if (e.keyCode === 13) {
            $("#submitBtn").click();
            return false;
        }
    });

    $(document).ready(function () {
        $('#hide').hide();

        $('#department').change(function () {
            $('#division').find('option').remove();

            console.log($('#department').val());

            $.ajax({
                url: "reloadDivisionDropDown",
                type: "POST",
                data: {language: "th", departmentID: $('#department').val()},
                success: function (response) {
                    $('<option>').val("null").text("please select").appendTo(divisionID);
                    $.each(response, function (key, value) {
                        $('<option>').val(value.dropDownKey).text(value.dropDownValue).appendTo(division);
                    });
                }
            });
        });
    });

    function doSearch() {
        console.log($('#groupUserID').val());
        console.log($('#department').val());
        console.log($('#division').val());

        $('#submitBtn').attr('disabled', 'disabled');
        $('#employeeTable tbody').off('click', 'tr');

        $.fn.dataTable.ext.errMode = 'none';
        table = $('#employeeTable').DataTable({
            "processing": true,
            "serverSide": true,
            "lengthChange": false,
            "pageLength": 10,
            "searching": false,
            "ordering": false,
            "scrollY": true,
            "scrollX": true,
            ajax: {
                url: "StarController-searchGiveStarByUser",
                type: "POST",
                data: function (d) {
                    d.sid = "mpy001";
                    d.language = "th";
                    d.groupUserID = $('#groupUserID').val();
                    d.department = $('#department').val();
                    d.division = $('#division').val();
                    d.searchName = $('#searchName').val();
                },
                dataSrc: function (response) {
                    $('#hide').show();
                    $('#submitBtn').removeAttr('disabled');

                    console.log($('#goldStar').val());

                    $('#employeeTable tbody').on('click', 'tr', function () {
                        employeeData = table.row(this).data();

                        console.log("test");

                        $("#goldStar").val(employeeData.goldStarGenGiveAmount);
                        $("#silverStar").val(employeeData.silverStarGenGiveAmount);
                        $("#bronzeStar").val(employeeData.bronzeStarGenGiveAmount);
                        $("#employeeID").val(employeeData.no);
                    });


                    return response.employee;
                }
            },
            columns: [
                {data: 'no', title: 'No'},
                {data: 'pictureURL', title: 'Picture'},
                {data: 'name', title: 'Name', width: '22%'},
                {data: 'departmentName', title: 'Department Name'},
                {data: 'divisionName', title: 'Division Name'},
                {data: 'positionName', title: 'Position Name'},
                {data: 'no', title: 'Edit Star'}

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
                    render: function (data) {
                        return '<button type="button" class="btn btn-link btn-circle" id="employeeID" data-toggle="modal" data-target="#myModal"><img style="width: 18px; height: 18px;" src="images/edit.png"></button>';
                    },
                    className: "dt-body-center"

                }
//                {
//                    targets: 7,
//                    className: "dt-body-center"
//                },
//                {
//                    targets: 8,
//                    className: "dt-body-center"
//                },
//                {
//                    targets: 9,
//                    className: "dt-body-center"
//                }
//                {
//                    targets: 10,
//                    className: "dt-body-center"
//                },
//                {
//                    targets: 11,
//                    className: "dt-body-center"
//                }
            ],
            language: {
                emptyTable: 'No result found.'
            }
        });




        clearDataTable();
    }

    function clearDataTable() {
        table.clear().draw();
    }

    function doUpdate() {
        console.log("doUpdate");
        $.ajax({
            url: "StarController-updateGiveStarByUser",
            type: "POST",
            data: {
                language: "th",
                sid: "mpy001",
                uid: $('#employeeID').val(),
                giveGoldStar: $('#goldStar').val(),
                giveSilverStar: $('#silverStar').val(),
                giveBronzeStar: $('#bronzeStar').val()
            },
            success: function (response) {
                
                console.log("success function");
                console.log(response);
                response.toString();
                
                var data = response.giveGoldStar;
                
                console.log("data : " + data);
                
                if (data) {
                    console.log("success if");
                    $("#ModalSuccess").modal("toggle");
                } else {
                    console.log("failure if");
                    $("#ModalFailure").modal("toggle");
                }
            },
            error: function () {
                $("#ModalFailure").modal("toggle");
            }
        });

    }
    function doReload() {
        location.reload();

    }

</script>

<style>
    .input-group-addon.tail {
        color: rgb(255, 255, 255);
        background-color: rgb(50, 118, 177);
        border-color: rgb(40, 94, 142);
    }
    spanreward {
        color: #003eff;
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
    <form:form id="mainForm" name="mainForm" method="post" modelAttribute="setGiveStar">
        <h3><span class="heading">Set give star by user</span></h3>
        <hr>
        <div class="row">      
            <div class="col-3">
                Choose Group
                <br>
                <div class="dropdown">
                    <form:select path="groupUserID" id="groupUserID" cssClass="form-control select2" data-style="select-sm">
                        <form:option value="">
                            Name Group...
                            <%-- <spring:message code="label.please.select" /> --%>
                        </form:option>
                        <c:forEach items="${groupDropdown}" var="groupDropdown">
                            <form:option value="${groupDropdown.dropDownKey}">${groupDropdown.dropDownValue}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="col-2">                       
                Department
                <br>
                <div class="dropdown">
                    <form:select path="department" id="department" cssClass="form-control select2" data-style="select-sm">
                        <form:option value="">
                            department
                            <%-- <spring:message code="label.please.select" /> --%>
                        </form:option>
                        <c:forEach items="${departmentDropdown}" var="departmentDropdown">
                            <form:option value="${departmentDropdown.dropDownKey}">${departmentDropdown.dropDownValue}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="col-2">
                Division
                <br>
                <div class="dropdown">
                    <form:select path="division" id="division" cssClass="form-control select2" data-style="select-sm">
                        <form:option value="">
                            division
                            <%-- <spring:message code="label.please.select" /> --%>
                        </form:option>
                        <c:forEach items="${divisionDropdown}" var="divisionDropdown">
                            <form:option value="${divisionDropdown.dropDownKey}">${divisionDropdown.dropDownValue}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="col-2">
                Search
                <br>
                <input type="text" class="form-control ml-2" id="searchName" path="searchName" placeholder="Byname">
            </div>
            <div class="col-2">
                <br>
                <input class="btn btn-primary" id="submitBtn" name="Search" type="button" value="Search" onClick="doSearch()"/>
            </div>
        </div>
        <br>
        <div class="container" id="hide">
            <div class="card">
                <div class="card-body">
                    <table id="employeeTable" class="table table-striped table-bordered" width="100%">
                    </table>
                </div>
            </div>
        </div>
        <br>
        <br>
    </form:form>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content rounded border border-primary">
            <div class="modal-header border border-primary">
                <h5 class="modal-title heading" id="myModal"><img style="width: 25px; height: 25px;" src="images/edit.png"><b> ดาวที่ให้ได้/วัน</b></h5>
                <button type="button" class="close heading" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body heading">
                <div class="row">
                    <br>
                    <div class="col-3"></div>
                    <div class="col-6">
                        <div class="text-center">
                            GOLD STAR
                            <br>
                            <div class="input-group">
                                <input type="text" class="form-control" id="goldStar" value="gold star" style="text-align: right" min="0" style="width: 140px;">
                                <span class="input-group-addon tail">ดวง</span>
                            </div>
                            SILVER STAR
                            <br>
                            <div class="input-group">
                                <input type="number" class="form-control" id="silverStar" value="silver star" style="text-align: right" min="0" style="width: 140px;">
                                <span class="input-group-addon tail">ดวง</span>
                            </div>
                            BRONZE STAR
                            <br>
                            <div class="input-group">
                                <input type="number" class="form-control" id="bronzeStar" value="bronze star" style="text-align: right" min="0" style="width: 140px;">
                                <span class="input-group-addon tail">ดวง</span>
                            </div>
                            <br>
                        </div> 
                    </div>
                </div>
                <div class="modal-footer col-12">
                </div>
                <div class="row">
                    <div class="col-3">
                    </div>
                    <div class="col-6">
                        <button type="button" class="btn btn-primary heading" onClick="doUpdate()">Update</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="ModalSuccess" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content rounded border border-primary">
            <div class="modal-body heading" style="text-align: center">
                <div class="row" id="hide2">
                    <br>
                    <div class="col-12" style="text-align: center">
                        <div class="text-center">
                            Update Success!!!!
                        </div>  
                        <br>
                        <br>
                        <button type="button" class="btn btn-primary btn-sm btn-center" value="Submit" onclick="doReload()">Submit</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="ModalFailure" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content rounded border border-primary">
            <div class="modal-body heading" style="text-align: center">
                <div class="row" id="hide2">
                    <br>
                    <div class="col-12" style="text-align: center">
                        <div class="text-center">
                            Update Failure!!!!
                        </div>  
                        <br>
                        <br>
                        <button type="button" class="btn btn-primary btn-sm btn-center" value="Submit" data-dismiss="modal">Submit</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
