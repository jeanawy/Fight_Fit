<%-- 
    Document   : RequestDocHistory
    Created on : Sep 3, 2018, 12:56:11 PM
    Author     : Sukrit_p
--%>
<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min_1.css" media="screen">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>-->

<script type="text/javascript">

    var firsFlag = true;
    var dataJson = null;
    var table = null;
    var Colors = '#00FF00';

    $(document).keypress(function (e) {
        if (e.keyCode === 13) {
            $("#submitBtn").click();
            return false;
        }
    });
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

    function doUpdate() {
        console.log(this);
        $.ajax({
            url: "hrController-editStatucDoc",
            type: "POST",
            data: {
                language: "th",
                sid: "mpy001",
                transactionID: "201809111700016660",
                transactionCode: "PROCESS",
                documentID: "2"
//                transactionID: $('#tranId').val(),
//                transactionCode: $('#buttonStatusDoc').val(),
//                documentID: $('#documentID').val()       
            }
        });
    }
    function statusColor() {
        console.log($('#request').val());
        var colorCode = document.getElementById('requestImg');
        var statusDocument = document.getElementById('StatusDoc');


        if (imageRequest.src.match("Request")) {
            imageRequest.src = "images/Request-color.png";
            imageProcess.src = "images/Process.png";
            imageDelivery.src = "images/Delivery.png";
            imageSuccess.src = "images/success.png";
            imageReject.src = "images/Reject.png";
        }
    }
    
    function changeImageRequest() {
        console.log($('#request').val());
        var imageRequest = document.getElementById('requestImg');
        var imageProcess = document.getElementById('processImg');
        var imageDelivery = document.getElementById('deliveryImg');
        var imageSuccess = document.getElementById('successImg');
        var imageReject = document.getElementById('rejectImg');


        if (imageRequest.src.match("Request")) {
            imageRequest.src = "images/Request-color.png";
            imageProcess.src = "images/Process.png";
            imageDelivery.src = "images/Delivery.png";
            imageSuccess.src = "images/success.png";
            imageReject.src = "images/Reject.png";
        }
    }
    function changeImageProcess() {
        console.log($('#process').val());
        var imageRequest = document.getElementById('requestImg');
        var imageProcess = document.getElementById('processImg');
        var imageDelivery = document.getElementById('deliveryImg');
        var imageSuccess = document.getElementById('successImg');
        var imageReject = document.getElementById('rejectImg');

        if (imageProcess.src.match("Process")) {
            imageRequest.src = "images/Request.png";
            imageProcess.src = "images/Process-color.png";
            imageDelivery.src = "images/Delivery.png";
            imageSuccess.src = "images/success.png";
            imageReject.src = "images/Reject.png";
        }
    }
    function changeImageDelivery() {
        console.log($('#delivery').val());
        var imageRequest = document.getElementById('requestImg');
        var imageProcess = document.getElementById('processImg');
        var imageDelivery = document.getElementById('deliveryImg');
        var imageSuccess = document.getElementById('successImg');
        var imageReject = document.getElementById('rejectImg');

        if (imageDelivery.src.match("Delivery")) {
            imageRequest.src = "images/Request.png";
            imageProcess.src = "images/Process.png";
            imageDelivery.src = "images/Delivery-color.png";
            imageSuccess.src = "images/success.png";
            imageReject.src = "images/Reject.png";
        }
    }
    function changeImageSuccess() {
        console.log($('#success').val());
        var imageRequest = document.getElementById('requestImg');
        var imageProcess = document.getElementById('processImg');
        var imageDelivery = document.getElementById('deliveryImg');
        var imageSuccess = document.getElementById('successImg');
        var imageReject = document.getElementById('rejectImg');

        if (imageSuccess.src.match("success")) {
            imageRequest.src = "images/Request.png";
            imageProcess.src = "images/Process.png";
            imageDelivery.src = "images/Delivery.png";
            imageSuccess.src = "images/success-color.png";
            imageReject.src = "images/Reject.png";
        }
    }

    function changeImageReject() {
        console.log($('#reject').val());
        var imageRequest = document.getElementById('requestImg');
        var imageProcess = document.getElementById('processImg');
        var imageDelivery = document.getElementById('deliveryImg');
        var imageSuccess = document.getElementById('successImg');
        var imageReject = document.getElementById('rejectImg');

        if (imageReject.src.match("Reject")) {
            imageRequest.src = "images/Request.png";
            imageProcess.src = "images/Process.png";
            imageDelivery.src = "images/Delivery.png";
            imageSuccess.src = "images/success.png";
            imageReject.src = "images/Reject-color.png";
        }
    }

    function popUpmodal() {
        var status1 = "REQUEST";

        var imageRequest = document.getElementById('requestImg');
        var imageProcess = document.getElementById('processImg');
        var imageDelivery = document.getElementById('deliveryImg');
        var imageSuccess = document.getElementById('successImg');
        var imageReject = document.getElementById('rejectImg');

        if (status1.match("REQUEST")) {
            imageRequest.src = "images/Request-color.png";
            imageProcess.src = "images/Process.png";
            imageDelivery.src = "images/Delivery.png";
            imageSuccess.src = "images/success.png";
            imageReject.src = "images/Reject.png";
        }
    }

    function reqeustcolorImage(x) {
        x.src = "images/Request-color.png";
    }

    function reqeustImage(x) {
        x.src = "images/Request.png";
    }

    function processcolorImage(x) {
        x.src = "images/Process-color.png";
    }

    function processImage(x) {
        x.src = "images/Process.png";
    }

    function deliverycolorImage(x) {
        x.src = "images/Delivery-color.png";
    }

    function deliveryImage(x) {
        x.src = "images/Delivery.png";
    }

    function successcolorImage(x) {
        x.src = "images/success-color.png";
    }

    function successImage(x) {
        x.src = "images/success.png";
    }

    function rejectcSolorImage(x) {
        x.src = "images/Reject-color.png";
    }

    function rejectImage(x) {
        x.src = "images/Reject.png";
    }

    function myFunction() {
        var x = document.getElementsByName("Proccess");

        if (x.name === "Proccess") {
            x.style.width = "80px";
            x.style.height = "80px";
        }
    }
    function doSearch() {

        $('#submitBtn').attr('disabled', 'disabled');
        $.fn.dataTable.ext.errMode = 'none';
        table = $('#histRequestDocTable').DataTable({
            "processing": true,
            "serverSide": true,
            "lengthChange": false,
            "pageLength": 10,
            "searching": false,
            "ordering": false,
            "scrollY": false,
            "scrollX": false,
            "order": true,
            ajax: {
                url: "hrController-searchRequestDocHistory",
                type: "POST",
                data: function (d) {
                    d.sid = "mpy001";
                    d.language = "en";
                    d.documentID = $('#documentID').val();
                    d.requestDay = $('#requestDay').val();
                    d.searchByStatus = $('#searchByStatus').val();
                },
                dataSrc: function (response) {
                    $('#invis').show();
                    $('#submitBtn').removeAttr('disabled');
                    $('#histRequestDocTable tbody').on('click', 'tr', function () {
                        jobRequestData = table.row(this).data();

//                        if (jobRequestData.statusDoc === new String("REQUEST")) {
                        $("#statusColor").val(jobRequestData.statusColor);
                        $("#statusDocModal").val(jobRequestData.statusDoc);
//                        }
                    });

                    return response.histRequestDoc;
                }

            },
            columns: [

                {data: 'requestDay', title: 'ว/ด/ป', width: '9%'},
                {data: 'image', title: 'รูป'},
                {data: 'nameEN', title: 'ชื่อ-นามสกุล', width: '17%'},
                {data: 'divisionName', title: 'ฝ่าย', width: '10%'},
                {data: 'departmentName', title: 'แผนก', width: '16%'},
                {data: 'position', title: 'ตำแหน่ง', width: '14%'},
                {data: 'documentName', title: 'Document', width: '12%'},
                {data: 'buildingName', title: 'สถานที่รับ', width: '9%'},
                {data: 'statusDoc', title: 'Status', width: '8%'},
                {data: 'tranID', id: 'tranId', title: 'Edit', 'width': '5%'}
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
                        console.log(data);
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
                    className: "dt-body-center"
                },
                {
                    targets: 7,
                    className: "dt-body-center"
                },
                {
                    targets: 8,
                    render: function (data) {
                        var data1 = '<button disabled style="background-color:#00FF00; border: 2px; padding: 3px; border-radius: 4px;"><font color="white">#00FF00</font></button>';
////                        return '<div style="background-color:' + data1 + '" id="Status" name="Status">' + data + '</div>';
//                        return '<div id="StatusDoc" name="Status">' + data + '</div>';
//                        return '<button '+data+'>'+data+'</button>';
//                        return '<button style="background-color:#00FF00">'+data+'</button>';
                          return data;
                        console.log(data);
                    },
                    className: "dt-body-center"
                },
                {
                    targets: 9,
                    className: "dt-body-center",
                    render: function () {
                        return '<img style="width: 15px; height: 15px;" src="images/edit.png" data-toggle="modal" data-target="#myModal">';
                    }
                }
            ],
            language: {
                emptyTable: 'No result found.'
            }
        });
        search(table, true);
        clearDataTable();
    }

    function clearDataTable() {
        table.clear().draw();
    }

    function search(table, resetPage) {
        table.ajax.reload(null, resetPage);
    }


</script>


<div class="content">
    <form:form id="mainForm" name="mainForm" method="POST" modelAttribute="requestDocHistory">
        <div class="container">
            <h3><span class="heading">Job Request Document form</span></h3>
            <hr>
            <div class="row">
                <div class="col-3 heading">
                    Document
                    <div class="dropdown mt-2">
                        <form:select path="documentID" id="documentID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                            <form:option value="">
                                เลือกแบบฟอร์ม
                                <%-- <spring:message code="label.please.select" /> --%>
                            </form:option>
                            <c:forEach items="${documentDropdown}" var="documentDropdown">
                                <form:option value="${documentDropdown.dropDownKey}">${documentDropdown.dropDownValue}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="col-3 heading">
                    Request Date               
                    <div class="form-group">                    
                        <div class="input-group date form_datetime mt-2" data-date-format="yyyy-mm-dd">                       
                            <form:input path="requestDay" id="requestDay" cssClass="form-control" readonly="true"/>
                            <span class="input-group-addon">                            
                                <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:230%;"></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-3 heading">
                    Search By Status
                    <div class="dropdown mt-2">
                        <form:select path="searchByStatus" id="searchByStatus" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                            <form:option value="">
                                Choose status
                                <%-- <spring:message code="label.please.select" /> --%>
                            </form:option>
                            <c:forEach items="${searchByStatusDropdown}" var="searchByStatusDropdown">
                                <form:option value="${searchByStatusDropdown.dropDownKey}">${searchByStatusDropdown.dropDownValue}</form:option>
                            </c:forEach>              
                        </form:select>
                    </div>
                </div>
                <div class="col-2 mt-2">
                    <br>
                    <input class="btn btn-primary" id="submitBtn" name="Search" type="button" value="Search" onClick="doSearch()"/>
                </div>
                <div class="col-2">
                </div>
                <div class="container col-12 " id="invis">
                    <table id="histRequestDocTable" class="table table-striped table-bordered" style="font-size: 80%">
                    </table>
                </div>

            </div>

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
                        <div class="modal-body heading ml-5" id="statusDocModal2">
                            Choose status
                            <!--                        <div><input path="statusDocModal" id="statusDocModal" class="col-2"></div>                 
                                                    <div path="buttonStatusDoc" id="buttonStatusDoc" class="col-12">-->
                            <div>
                                <!--                            <button name="Request" id="request" value="REQUEST" type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;" onclick="changeImageRequest()">
                                                                <img id="requestImg" style="width: 60px; height: 60px;" src="images/Request.png"/>
                                                            </button>
                                                            <button name="Proccess" id="process" value="PROCESS" type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;" onclick="changeImageProcess()">
                                                                <img id="processImg" style="width: 60px; height: 60px ;" src="images/Process.png"/>
                                                            </button>
                                                            <button name="Delivery" id="delivery" value="DELIVERY" type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;" onclick="changeImageDelivery()">
                                                                <img id="deliveryImg" style="width: 60px; height: 60px;" src="images/Delivery.png"/>
                                                            </button>
                                                            <button name="Success" id="success" value="SUCCESS" type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;" onclick="changeImageSuccess()">
                                                                <img id="successImg" style="width: 60px; height: 60px;" src="images/success.png"/>
                                                            </button>
                                                            <button name="Reject" id="reject" value="REJECT" type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;" onclick="changeImageReject()">
                                                                <img id="rejectImg" style="width: 60px; height: 60px;" src="images/Reject.png"/>
                                                            </button>-->
                                <button name="Request" id="request" value="REQUEST" type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;" onclick="changeImageRequest()"><img id="requestImg" onmouseover="reqeustcolorImage(this)" onmouseout="reqeustImage(this)"  style="width: 60px; height: 60px;" src="images/Request.png"/></button>
                                <button name="Proccess" id="process" value="PROCESS" type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;" onclick="changeImageProcess()"><img id="processImg" onmouseover="processcolorImage(this)" onmouseout="processImage(this)" style="width: 60px; height: 60px ;" src="images/Process.png"/></button>
                                <button name="Delivery" id="delivery" value="DELIVERY" type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;" onclick="changeImageDelivery()"><img id="deliveryImg" onmouseover="deliverycolorImage(this)" onmouseout="deliveryImage(this)" style="width: 60px; height: 60px;" src="images/Delivery.png"/></button>
                                <button name="Success" id="success" value="SUCCESS" type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;" onclick="changeImageSuccess()"><img id="successImg" onmouseover="successcolorImage(this)" onmouseout="successImage(this)" style="width: 60px; height: 60px;" src="images/success.png"/></button>
                                <button name="Reject" id="reject" value="REJECT" type="button" class="heading mt-4 ml-4" style="width: 100px; height: 120px;" onclick="changeImageReject()"><img id="rejectImg" onmouseover="rejectcolorImage(this)" onmouseout="rejectImage(this)" style="width: 60px; height: 60px;" src="images/Reject.png"/></button>

                            </div>
                        </div>
                        <center> 
                            <div class="modal-footer col-2">
                                <button type="button" class="btn btn-primary heading" style="width: 140px;" onclick="doUpdate()">Update</button>
                            </div>
                        </center>
                    </div>
                </div>
            </div>

        </div>
    </form:form>
</div>


