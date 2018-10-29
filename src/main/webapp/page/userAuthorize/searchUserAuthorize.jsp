<%-- 
    Document   : searchUserAuthorize
    Created on : Sep 4, 2018, 11:42:36 AM
    Author     : Anuwat_K
--%>
<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    var table = null;
    var employeeData = null;

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

        $('#departmentID').change(function () {
            $("#divisionID").find('option').remove();
            $.ajax({
                url: "reloadDivisionDropDown",
                type: "POST",
                data: {language: "th", departmentID: $('#departmentID').val()},
                success: function (response) {
                    $('<option>').val("").text("please select").appendTo(divisionID);
                    $.each(response, function (key, value) {
                        $('<option>').val(value.dropDownKey).text(value.dropDownValue).appendTo(divisionID);
                    });
                }
            });
        });

    });

    function doSearch() {

        $('#submitBtn').attr('disabled', 'disabled');
        $('#userAuthorizeTable tbody').off('click', 'tr');

        $.fn.dataTable.ext.errMode = 'none';
        table = $('#userAuthorizeTable').DataTable({
            "processing": true,
            "serverSide": true,
            "lengthChange": false,
            "pageLength": 10,
            "searching": false,
            "ordering": false,
            "scrollY": true,
            "scrollX": true,
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
                    $('#invis').show();
                    $('#submitBtn').removeAttr('disabled');

                    $('#userAuthorizeTable tbody').on('click', 'tr', function () {
                        employeeData = table.row(this).data();
                        $("#uid").val(employeeData.uid);
                        editUserAuthorize();
                    });

                    return response.userAuthorize;
                }
            },
            columns: [
                {data: 'employeeID', title: 'EmployeeID'},
                {data: 'image', title: 'Image'},
                {data: 'name', title: 'Name'},
                {data: 'department', title: 'Department'},
                {data: 'division', title: 'Division'},

                {data: 'group', title: 'Group'},
                {title: 'Custom'}
            ],
            columnDefs: [
                {
                    targets: 0,
                    className: "dt-body-center"
                },
                {
                    targets: 1,
                    render: function (data) {
                        return '<img class="rounded-circle  border" style="width: 80px; height: 80px;" src="' + data + '">';
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
                    render: function () {
                        return '<img style="width: 50px; height: 50px;" src="images/edit_icon_image.png">';
                    },
                    className: "dt-body-center"

                }
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

    function editUserAuthorize() {
        $("#mainForm").attr("action", "UserAuthorizeController-initEditCustomerUserAuthorize");
        $("#mainForm").submit();
    }

</script>

<div class="content">
    <form:form id="mainForm" name="mainForm" method="post" modelAttribute="searchUserAuthorize">
        <form:hidden path="uid" id="uid"/>
        <h3><span class="heading">Custom User Authorize</span></h3>
        <hr>
        <div class="row">
            <div class="col-12">
                Choose User
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-4">
                    Department
                    <br>
                    <div class="dropdown">
                        <form:select path="departmentID" id="departmentID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                            <form:option value="">
                                please select
                                <%-- <spring:message code="label.please.select" /> --%>
                            </form:option>
                            <c:forEach items="${departmentsDropDownList}" var="departmentsDropDownList">
                                <form:option value="${departmentsDropDownList.dropDownKey}">${departmentsDropDownList.dropDownValue}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="col-4">
                    Division
                    <br>
                    <div class="dropdown">
                        <form:select path="divisionID" id="divisionID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                            <form:option value="">
                                please select
                                <%-- <spring:message code="label.please.select" /> --%>
                            </form:option>
                            <c:forEach items="${divisionDropDownList}" var="divisionDropDownList">
                                <form:option value="${divisionDropDownList.dropDownKey}">${divisionDropDownList.dropDownValue}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="col-4">
                    Name
                    <form:input path="searchName" id="searchName" cssClass="form-control select2" cssStyle="width: 100%" />
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    Group
                    <br>
                    <div class="dropdown">
                        <form:select path="groupID" id="groupID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                            <form:option value="">
                                please select
                                <%-- <spring:message code="label.please.select" /> --%>
                            </form:option>
                            <c:forEach items="${groupDropdown}" var="groupDropdown">
                                <form:option value="${groupDropdown.dropDownKey}">${groupDropdown.dropDownValue}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="col-2">
                    <br>
                    <input class="btn btn-primary" id="submitBtn" name="Search" type="button" value="Submit" onClick="doSearch()"/>
                </div>
                <div class="col-6">
                </div>
            </div>
        </div>
        <br>
        <div class="container" id="invis">
            <div class="card">
                <div class="card-body">
                    <table id="userAuthorizeTable" class="table" style="width:100%">
                    </table>
                </div>
            </div>
        </div>
        <br>
        <br>
    </form:form>
</div>