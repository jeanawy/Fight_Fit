<%-- 
    Document   : bookingHistory
    Created on : Aug 27, 2018, 4:38:07 PM
    Author     : Anuwat_K
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
    var table = null;

    $(document).keypress(function (e) {
        if (e.keyCode === 13) {
            $("#submitBtn").click();
            return false;
        }
    });

    $(document).ready(function () {
        $('#invis').hide();

        $('.form_datetime').datetimepicker({
            format: "dd/mm/yyyy hh:ii",
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
        });

        $('#buildingID').change(function () {
            $("#meetingRoomID").find('option').remove();
            $.ajax({
                url: "reloadRoomDropDown",
                type: "POST",
                data: {language: "th", buildingID: $('#buildingID').val()},
                success: function (response) {
                    $.each(response, function (key, value) {
                        $('<option>').val(value.dropDownKey).text(value.dropDownValue).appendTo(meetingRoomID);
                    });
                }
            });
        });
    });

    function doSearch() {

        $('#submitBtn').attr('disabled', 'disabled');

        $.fn.dataTable.ext.errMode = 'none';
        table = $('#bookingTable').DataTable({
            "processing": true,
            "serverSide": true,
            "lengthChange": false,
            "pageLength": 10,
            "searching": false,
            "ordering": false,
            "scrollY": true,
            "scrollX": true,
            ajax: {
                url: "MeetingRoomController-searchBookingHistory",
                type: "POST",
                data: function (d) {
                    d.sid = "mpy001";
                    d.language = "th";
                    d.buildingID = $('#buildingID').val();
                    d.meetingRoomID = $('#meetingRoomID').val();
                    d.searchDateTimeFrom = $('#searchDateTimeFrom').val();
                    d.searchDateTimeTo = $('#searchDateTimeTo').val();
                },
                dataSrc: function (response) {
                    $('#invis').show();
                    $('#submitBtn').removeAttr('disabled');
                    return response.booking;
                }
            },
            columns: [
                {data: 'dateBooking', title: 'Date Booking'},
                {data: 'timeBooking', title: 'Time Booking'},
                {data: 'buildingName', title: 'Building Name'},
                {data: 'roomName', title: 'Room Name'},
                {data: 'employeeName', title: 'Name'},

                {data: 'department', title: 'Department'},
                {data: 'division', title: 'Division'},
                {data: 'mobileNo', title: '<img style="width: 40px; height: 40px;" src="images/tel_image.png">'},
                {data: 'lineID', title: '<img style="width: 40px; height: 40px;" src="images/line_image.png">'}

            ],
            columnDefs: [
                {
                    targets: 0,
                    className: "dt-body-center",
                },
                {
                    targets: 1,
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
                    className: "dt-body-center"
                }
//                {
//                    targets: 9,
//                    render: function (data) {
//                        return '<img style="width: 100px; height: 75px;" src="' + data + '">'
//                    },
//                    className: "dt-body-center"
//                },
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

</script>


<div class="content">
    <form:form id="mainForm" name="mainForm" method="post" modelAttribute="bookingHistory">
        <h3><span class="heading">Booking History</span></h3>
        <hr>
        <div class="container">
            <div class="row form-inline">
                <div class="col-1">
                    <img style="width: 50px; height: 50px;" src="images/building_image.png">
                </div>
                <div class="col-2">
                    Building
                    <br>
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
                <div class="col-2">
                    Room
                    <br>
                    <div class="dropdown">
                        <form:select path="meetingRoomID" id="meetingRoomID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                            <form:option value="">
                                please select
                                <%-- <spring:message code="label.please.select" /> --%>
                            </form:option>
                            <c:forEach items="${meetingRoomDropdown}" var="meetingRoomDropdown">
                                <form:option value="${meetingRoomDropdown.dropDownKey}">${meetingRoomDropdown.dropDownValue}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="col-3">
                    From
                    <div class="form-group">
                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii">
                            <form:input path="searchDateTimeFrom" id="searchDateTimeFrom" cssClass="form-control" readonly="true"/>
                            <span class="input-group-addon">
                                <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:230%;"></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    To
                    <div class="form-group">
                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii">
                            <form:input path="searchDateTimeTo" id="searchDateTimeTo" cssClass="form-control" readonly="true"/>
                            <span class="input-group-addon">
                                <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:230%;"></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-1">
                    <br>
                    <input class="btn btn-primary" id="submitBtn" name="Search" type="button" value="Submit" onClick="doSearch()"/>
                </div>
            </div>
        </div>
        <br>
        <div class="container" id="invis">
            <div class="card">
                <div class="card-body">
                    <table id="bookingTable" class="table">
                    </table>
                </div>
            </div>
        </div>
        <br>
        <br>
    </form:form>
</div>


