<%-- 
    Document   : searchRedeemReward
    Created on : Sep 6, 2018, 3:47:16 PM
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
        $('.form_datetime').datetimepicker({
            weekStart: 1,
            autoclose: true,
            todayHighlight: true,
            minView: 'month'
        });
        $('.form_datetime').datetimepicker();
    });

    var firsFlag = true;
    var dataJson = null;
    var table = null;

    $(document).keypress(function (e) {
        if (e.keyCode === 13) {
            $("#submitBtn").click();
            return false;
        }
    });

    $(document).ready(function () {
        $('#invis').hide();
//        $('.form_datetime').datetimepicker({
//            format: "yyyy-mm-dd",
//            todayBtn: 1,
//            autoclose: 1,
//            todayHighlight: 1,
//            minView: 'month'
//        });
    });
    function doSearch() {

        $('#submitBtn').attr('disabled', 'disabled');

        $.fn.dataTable.ext.errMode = 'none';
        table = $('#rewardsListDocTable').DataTable({
            "processing": true,
            "serverSide": true,
            "lengthChange": false,
            "pageLength": 10,
            "searching": false,
            "ordering": false,
            "scrollY": true,
            "scrollX": true,
            ajax: {
                url: "rewardController-searchRedeemReward",
                type: "POST",
                data: function (d) {
                    d.sid = "mpy001";
                    d.language = "th";
                    d.searchUser = $('#searchUser').val();
                    d.searchRewardName = $('#searchRewardName').val();
                    d.requestDay = $('#requestDay').val();
                    d.searchByStatus = $('#searchByStatus').val();
                },
                dataSrc: function (response) {
                    $('#invis').show();
                    $('#submitBtn').removeAttr('disabled');
                    return response.redeemReward;
                }
            },
            columns: [
                {data: 'createDate', title: 'ว/ด/ป', width: '5%'},
                {data: 'empPic', title: 'รูป', width: '9%'},
                {data: 'empName', title: 'ชื่อ-นามสกุล', width: '13%'},
                {data: 'division', title: 'ฝ่าย', width: '5%'},
                {data: 'department', title: 'แผนก', width: '5%'},

                {data: 'position', title: 'ตำแหน่ง', width: '9%'},
                {data: 'rewardPic', title: 'รูปรางวัล', width: '9%'},
                {data: 'rewardName', title: 'ชื่อรางวัล', width: '1%'},
                {data: 'desc', title: 'รายละเอียด', width: '7%'},
                {data: 'starType', title: 'ดาวที่ใช้', width: '7%'},

                {data: 'quantity', title: 'จำนวนรางวัล', width: '11%'},
                {data: 'rewardStatus', title: 'Status', width: '8%'}
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
                    render: function (data) {
                        return '<img class="rounded-circle  border border-dark" style="width: 50px; height: 50px;" src="' + data + '">';
                        console.log(data);
                    },
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
                    className: "dt-body-center"
                },
                {
                    targets: 10,
                    className: "dt-body-center"
                },
                {
                    targets: 11,
                    className: "dt-body-center"
                }
            ],
            language: {
                emptyTable: 'No result found.'
            }
        });
        search(table, true);
        clearDataTable();
    }

    function search(table, resetPage) {
        table.ajax.reload(null, resetPage);
    }

    function clearDataTable() {
        table.clear().draw();
    }

</script>
<style>
    .row.no-pad {
        margin-right:0;
        margin-left:0;
    }
    .row.no-pad > [class*='col-'] {
        padding-right:0;
        padding-left:0;
    }
</style>

<div class="content">
    <form:form id="mainForm" name="mainForm" method="POST" modelAttribute="searchRedeemReward">
        <div class="container">
            <h3><span class="heading">Search Redeem Reward</span></h3>
            <hr>
            <div class="row no-pad">
                <div class="col">
                    <label for="searchUser" class="text-primary">Search Name</label>
                    <form:input class="form-control" id="searchUser" path="searchUser"/>
                </div>
                <div class="col">
                    <label for="searchRewardName" class="text-primary">Reward Name</label>
                    <form:input class="form-control" id="searchRewardName" path="searchRewardName"/>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="requestDay" class="text-primary">Request Day</label>
                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy">
                            <form:input class="form-control" id="requestDay" path="requestDay"/>
                            <span class="input-group-addon">
                                <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <label for="searchByStatus" class="text-primary ">Search By Status</label>
                    <div class="dropdown">
                        <form:select path="searchByStatus" id="searchByStatus" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                            <form:option value="">
                                please select
                                <%-- <spring:message code="label.please.select" /> --%>
                            </form:option>
                            <c:forEach items="${searchByStatusDropdown}" var="searchByStatusDropdown">
                                <form:option value="${searchByStatusDropdown.dropDownKey}">${searchByStatusDropdown.dropDownValue}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="col">
                    <label for="btn1"> &nbsp;</label>
                    <button class="btn btn-primary" id="btn1" name="Search" type="button" value="Submit" onClick="doSearch()" >Search</button>
                </div>
            </div>
            <div class="container col-12 mt-3" id="invis">
                <table id="rewardsListDocTable" class="table table-striped table-bordered" style="font-size: 70%">
                </table>
            </div>
        </div>
    </form:form>
</div>