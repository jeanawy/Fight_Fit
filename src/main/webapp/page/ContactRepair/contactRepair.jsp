
<%-- 
    Document   : contactRepair
    Created on : 28-Aug-2018, 16:07:51
    Author     : Jeep_
--%>
<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">




<script>

    var slideIndex = 1;
    showDivs(slideIndex);
    function plusDivs(n) {
        showDivs(slideIndex += n);
    }
    var x;



    function showDivs(n, m) {


        console.log(m);

        $.ajax({
            url: "getPictureURLContactRepair",
            type: "POST",
            data: {transactionID: m},
            success: function (response) {
                console.log(response);
                $('#searchimage').append(response.repairPictureURL1);
                return response;
            }

        });
        var i;
        var x = document.getElementsByClassName("mySlides");
        if (n > x.length) {
            slideIndex = 1;
        }
        if (n < 1) {
            slideIndex = x.length;
        }
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        x[slideIndex - 1].style.display = "block";
    }


</script>

<script type="text/javascript" >

    var table = null;
    $(document).ready(function () {
        $('#invis').hide();
        $('.form_datetime').datetimepicker({
            format: "yyyy-mm-dd",
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            minView: 'month'
        });
    });
    function contactcolorImage(x) {
        x.src = "images/contact-color.png";
    }

    function contactImage(x) {
        x.src = "images/contact.png";
    }

    function successcolorImage(x) {
        x.src = "images/success-color.png";
    }

    function successImage(x) {
        x.src = "images/success.png";
    }



    function doSearch() {

        $('#submitBtn').attr('disabled', 'disabled');
        $.fn.dataTable.ext.errMode = 'none';
        table = $('#contactRepairTable').DataTable({
            "processing": true,
            "serverSide": true,
            "lengthChange": false,
            "pageLength": 10,
            "searching": false,
            "ordering": false,
            "scrollY": true,
            "scrollX": true,
            ajax: {
                url: "ContactRepairController-searchContactRepairHistory",
                type: "POST",
                data: function (d) {
                    d.sid = "mpy001";
                    d.language = "th";
                    d.buildingID = $('#buildingID').val();
                    d.searchDateTime = $('#searchDateTime').val();
                    d.statusID = $('#statusID').val();
                    console.log(statusID);
                },
                dataSrc: function (response) {
                    $('#invis').show();
                    return response.contactRepair;
                }
            },
            columns: [
                {data: 'day', title: 'day'},
                {data: 'time', title: 'time'},
                {data: 'repairPictureURL1', title: 'pic'},
                {data: 'name', title: 'Name'},
                {data: 'departmentName', title: 'department'},
                {data: 'divisionName', title: 'division'},
                {data: 'repairRemark', title: 'Remark'},
                {data: 'buildingName', title: 'building Name'},
                {data: 'repairStatus', title: 'Status'},
                {data: 'transactionID', title: 'Edit'}


            ],
            columnDefs: [
                {
                    targets: 0,
                    className: "dt-body-center"
                },
                {
                    targets: 1,
                    className: "dt-body-center"
                },
                {
                    targets: 2,
                    render: function (data, x) {
                        return '<img data-toggle="modal" data-target="#myModal2"  src="' + data + '" alt="test" style="width: 50px; height: 50px">';
                    }
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
                    className: "dt-body-center"
                },
                {
                    targets: 7,
                    className: "dt-body-center"
                },
                {
                    targets: 8,
                    className: "dt-body-center"
                },
                {
                    targets: 9,
                    className: "dt-body-center",
                    render: function (data) {
                        return '<button type="button" id="edit" name="trac" class="btn btn-default btn-circle" style="background-color:white;" data-toggle="modal" data-target="#myModal" value="' + data + '" onclick="popUpmodal()"><img style="width: 15px; height: 15px;" src="images/edit.png"></button>';
                    }
                }
            ], language: {
                emptyTable: 'No result found.'
            }
        });

        $('#contactRepairTable tbody').on('click', 'img', function () {
            console.log("rrrr");
            var data = table.row($(this).parents('tr')).data();
            console.log(data.transactionID);
            x = data.transactionID;
            showDivs(1, x);

        });

        clearDataTable();
    }

    function clearDataTable() {
        table.clear().draw();
    }

</script>

<div class="content">
    <form:form id="mainForm" name="mainForm" method="post" modelAttribute="searchContactRepairHistory">
        <h3>
            <span class="heading">
                Job Contact Repair
            </span>
        </h3>
        <hr>
        <div class="row form-inline">
            <div class="col-1">

            </div>
            <div class="col-2"> <font size = "3"> <span class="heading"> อาคาร </span> </font> </div>
            <div class="col-3"> <font size = "3"> <span class="heading"> Request Day  </span> </font> </div>
            <div class="col-3"> <font size = "3"> <span class="heading"> Search by Status  </span> </font> </div>
        </div>
        <div class="row"> 
            <div class="col-1">
                <img style="width: 50px; height: 50px;" src="images/building_image.png">
            </div>
            <div class="col-2">
                <div class="dropdown">
                    <form:select path="buildingID" id="buildingID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                        <form:option value="">
                            please select
                            <%-- <spring:message code="label.please.select" /> --%>
                        </form:option>
                        <c:forEach items="${buildingDropdown}" var="buildingDropdown">
                            <form:option value="${buildingDropdown.dropDownKey}">${buildingDropdown.dropDownValue}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="col-3">
                <div class="form-group">
                    <div class="input-group date form_datetime" data-date-format="yyyy-mm-dd">
                        <form:input path="searchDateTime" id="searchDateTime" cssClass="form-control" readonly="true"/>
                        <span class="input-group-addon">
                            <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:230%;"></i>
                        </span>
                    </div>
                </div>
            </div>

            <div class="col-3">
                <div class="dropdown">
                    <form:select path="statusID" id="statusID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                        <form:option value="">
                            please select
                            <%-- <spring:message code="label.please.select" /> --%>
                        </form:option>
                        <c:forEach items="${contactRepairDropdown}" var="contactRepairDropdown">
                            <form:option value="${contactRepairDropdown.dropDownKey}">${contactRepairDropdown.dropDownValue}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="col-2">
                <input class="btn btn-primary" name="Search" type="button" value="Submit" onClick="doSearch()"/>
            </div>
        </div>
        <br>
        <div class="container" id="invis">
            <div class="card">
                <div class="card-body">
                    <table id="contactRepairTable" class="table table-striped table-bordered" style="font-size: 80%">
                    </table>
                </div>
            </div>
        </div>
        <br>
        <br>

        <!-- Modal -->
        <div class="modal fade bd-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content rounded border border-primary">
                    <div class="modal-header border border-primary">
                        <h5 class="modal-title heading" id="myModal"><img style="width: 25px; height: 25px;" src="images/edit.png"><b> Edit Status</b></h5>
                        <button type="button" class="close heading" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body heading">
                        Choose status
                        <div class="col-12">      
                            <form>
                                <button name="Contact" id="contact"  type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;"><img onmouseover="contactcolorImage(this)" onmouseout="contactImage(this)" style="width: 60px; height: 60px;" src="images/contact.png"/></button>
                                <button name="Success" id="success"  type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;"><img onmouseover="successcolorImage(this)" onmouseout="successImage(this)" style="width: 60px; height: 60px;" src="images/success.png"/></button>
                            </form>
                        </div>

                    </div>

                    <div class="modal-footer col-8">
                        <button type="button" class="btn btn-primary heading" style="width: 140px;">Update</button>
                    </div>

                </div>
            </div>
        </div>

        <div class="modal" id="myModal2" >

            <div class="modal-header">
                <span class="close">&times;</span>
            </div>
            <div class="modal-body" id="searchimage">
                <div class="modal-body">

                    <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
                    <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>

                </div>
                <div class="modal-footer">
                </div>


            </div>



        </form:form>
    </div>
