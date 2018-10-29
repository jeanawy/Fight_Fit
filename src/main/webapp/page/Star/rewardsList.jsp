<%-- 
    Document   : rewardsList
    Created on : Sep 5, 2018, 11:55:55 AM
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
                url: "rewardController-searchRewardsList",
                type: "POST",
                data: function (d) {
                    d.sid = "mpy001";
                    d.language = "th";
                    d.reward = $('#reward').val();
                    d.searchByStatus = $('#searchByStatus').val();
                },
                dataSrc: function (response) {
                    $('#invis').show();
                    $('#submitBtn').removeAttr('disabled');

                    $('#rewardsListDocTable tbody').on('click', 'tr', function () {
                        rewardsListData = table.row(this).data();

                        $("#rewardId").val(rewardsListData.rewardId);
                        $("#rewardTh").val(rewardsListData.rewardTh);
                        $("#rewardEn").val(rewardsListData.rewardEn);
                        $("#describeTh").val(rewardsListData.descTh);
                        $("#describeEn").val(rewardsListData.descEn);
                        $("#conditionTh").val(rewardsListData.conditonTh);
                        $("#conditionEn").val(rewardsListData.conditonEn);
                        $("#activeDate").val(rewardsListData.activeDate);
                        $("#showStartDate").val(rewardsListData.startDate);
                        $("#showEndDate").val(rewardsListData.endDate);
                        $("#redeemExpDate").val(rewardsListData.redeemExpDate);
                        $("#exchangeExpDate").val(rewardsListData.exchangeExpDate);
                        $("#quantity").val(rewardsListData.quantity);
                        $("#quantityExchange").val(rewardsListData.quantityExchange);
                        $("#goldStarUse").val(rewardsListData.goldStarUse);
                        $("#silverStarUse").val(rewardsListData.sivlerStarUse);
                        $("#bronzeStarUse").val(rewardsListData.bronzeStarUse);

                    });

                    return response.rewardLists;
                }
            },
            columns: [
                {data: 'urlImage', title: 'รูป', width: '5%'},
                {data: 'name', title: 'ชื่อ', width: '9%'},

                {data: 'detail', title: 'รายละเอียด', width: '13%'},
                {data: 'starTypeUsed', title: 'ดาวที่ใช้', width: '5%'},
                {data: 'starAmount', title: 'จำนวนดาว', width: '5%'},
                {data: 'startDate', title: 'Start Date', width: '9%'},
                {data: 'endDate', title: 'End Date', width: '9%'},

                {data: 'quantity', title: 'ทั้งหมด', width: '1%'},
                {data: 'quantityExchange', title: 'จำนวนที่ใช้ไป', width: '7%'},
                {data: 'quantityPhysical', title: 'จำนวนที่เหลือ', width: '7%'},
                {data: 'condition', title: 'เงื่อนไข', width: '11%'},
                {data: 'status', title: 'Status', width: '8%'},

                {data: 'rewardId', title: 'Edit', width: '5%'},
                {data: 'rewardId', title: 'Delete', width: '5%'}
            ],
            columnDefs: [
                {
                    targets: 0,
                    render: function (data) {
                        return '<img class="rounded-circle  border border-dark" style="width: 50px; height: 50px;" src="' + data + '">';
                        console.log(data);
                    },
                    className: "dt-body-center"
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
                    render: function (data) {
                        var data1 = '<button disabled style="background-color:#00FF00; border: 2px; padding: 3px; border-radius: 4px;"><font color="white">#00FF00</font></button>';
                        return data;
                        console.log(data);
                    },
                    className: "dt-body-center"
                },
                {
                    targets: 12,
                    render: function () {
                        return '<img style="width: 20px; height: 20px;" src="images/edit.png" data-toggle="modal" data-target="#editModal">';
                    },
                    className: "dt-body-center"
                },
                {
                    targets: 13,
                    render: function (data) {
//                        return'<button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalDelete" id="btnselect" value="' + data + '"><i class="fa fa-trash-o fa-lg"  aria-hidden="true"></i></button>';
                        return '<img style="width: 20px; height: 20px;" src="images/garbage.png" data-toggle="modal" data-target="#modalDelete" id="btnselect" value="' + data + '">';
                    },
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

    function doDelete() {
        console.log(this);
        $.ajax({
            url: "deleteReward",
            type: "POST",
            data: {
                language: "th",
                sid: "mpy001",
                rewardId: $("#rewardId").val(),
                quantityExchange: $("#quantityExchange").val()
            },
            success: function (response) {
                doSearch();
            }
        });
    }
</script>


<div class="content">
    <form:form id="mainForm" name="mainForm" method="POST" modelAttribute="RewardsList">
        <div class="container">
            <h3><span class="heading">Reward lists</span></h3>
            <hr>
            <div class="row">
                <div class="col-3 heading">
                    <label for="reward" class="text-primary px-2">Reward Name</label>
                    <form:input class="form-control" id="reward" path="reward" placeholder="By Name..."/>
                </div>
                <div class="col-3 heading">
                    Search By Status
                    <div class="dropdown mt-2">
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
                <div class="col-2 mt-2">
                    <br>
                    <input class="btn btn-primary" id="submitBtn" name="Search" type="button" value="Search" onClick="doSearch()"/>
                </div>
                <div class="col-2">
                </div>
                <div class="container col-12 mt-3" id="invis">
                    <table id="rewardsListDocTable" class="table table-striped table-bordered" style="font-size: 70%">
                    </table>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade bd-example-modal-lg" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content rounded border border-primary">
                        <div class="modal-header border border-primary">
                            <h5 class="modal-title heading" id="myModal"><img style="width: 25px; height: 25px;" src="images/edit.png"><b> Reward lists Edit</b></h5>
                            <button type="button" class="close heading" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body heading ml-5" id="rewardModal">
                            <div style="font-size: 90%">
                                <div class="row">
                                    <div class="col-6">
                                        <spanreward>Reward Thai</spanreward>
                                        <input  type="text" class="form-control" id="rewardTh" name="rewardTh" maxlength="100" required style="height: 35px; font-size: 85%;">
                                    </div>

                                    <div class="col-6">
                                        <spanreward>Reward English</spanreward>
                                        <input type="text" class="form-control" id="rewardEn" name="rewardEn" maxlength="100" required style="height: 35px; font-size: 85%;">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <spanreward>Describe Thai</spanreward>
                                        <input type="text" class="form-control" id="describeTh" name="descTh" maxlength="200" style="font-size: 80%;">
                                    </div>

                                    <div class="col-6">
                                        <spanreward>Describe English</spanreward>
                                        <input type="text" class="form-control" id="describeEn" name="descEn" maxlength="200" style="font-size: 80%;">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <spanreward>Condition Thai</spanreward>
                                        <input type="text" class="form-control" id="conditionTh" name="conditionTh" maxlength="300" style="height: 80px; font-size: 70%;">
                                    </div>

                                    <div class="col-6">
                                        <spanreward>Condition English</spanreward>
                                        <input type="text" class="form-control" id="conditionEn" name="conditionEn" maxlength="300" style="height: 80px; font-size: 70%;">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-8">
                                    <div class="row">
                                        <div class="col-4">
                                            <spanreward style="font-size: 90%">Active Date</spanreward>
                                            <div class="form-group">
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy">
                                                    <input type="text" class="form-control" id="activeDate" name="activeDate" style="font-size: 90%;height:33px;"/>
                                                    <%-- <form:input path="searchDateTime" id="searchDateTime" cssClass="form-control" readonly="true"/> --%>
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <spanreward style="font-size: 90%">Show Start Date</spanreward>
                                            <div class="form-group">
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy">
                                                    <input type="text" class="form-control" id="showStartDate" name="showStartDate" style="font-size: 90%;height:33px;"/>
                                                    <%-- <form:input path="searchDateTime" id="searchDateTime" cssClass="form-control" readonly="true"/> --%>
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <spanreward style="font-size: 90%">Show End Date</spanreward>
                                            <div class="form-group">
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy">
                                                    <input type="text" class="form-control" id="showEndDate" name="showEndDate" style="font-size: 90%;height:33px;"/>
                                                    <%-- <form:input path="searchDateTime" id="searchDateTime" cssClass="form-control" readonly="true"/> --%>
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-4">
                                            <spanreward style="font-size: 90%">Redeem EXP Date</spanreward>
                                            <div class="form-group">
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy">
                                                    <input type="text" class="form-control" id="redeemExpDate" name="redeemExpDate" style="font-size: 90%;height:33px;"/>
                                                    <%-- <form:input path="searchDateTime" id="searchDateTime" cssClass="form-control" readonly="true"/> --%>
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <spanreward style="font-size: 90%">Exchange EXP Date</spanreward>
                                            <div class="form-group">
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy">
                                                    <input type="text" class="form-control" id="exchangeExpDate" name="exchangeExpDate"  style="font-size: 90%;height:33px;"/>
                                                    <%-- <form:input path="searchDateTime" id="searchDateTime" cssClass="form-control" readonly="true"/> --%>
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:200%;"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-4">
                                            <div style="font-size: 90%;">
                                                <spanreward >จำนวนรางวัล</spanreward>
                                            </div>
                                            <div class="input-group">
                                                <input type="number" class="form-control" id="quantity" name="quantity" min="1" style="font-size: 90%;height:35px;">
                                                <div class="input-group-append">
                                                    <span class="input-group-text bg-primary" id="group-txet-quantity" style="width: 55px; font-size: 85%;">
                                                        <font color="white">รางวัล</font>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div style="font-size: 90%;">
                                                <spanreward >ใช้ไปแล้ว</spanreward>
                                            </div>
                                            <div class="input-group">
                                                <input type="number" class="form-control" id="quantityExchange" name="quantityExchange" min="0" style="font-size: 90%;height:35px;">
                                                <div class="input-group-append">
                                                    <span class="input-group-text bg-primary" id="group-txet-quantityExchange" style="width: 55px; font-size: 85%;">
                                                        <font color="white">รางวัล</font>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-6">
                                            <div style="font-size: 90%;"><spanreward>ดาวที่ใช้</spanreward></div>
                                            <div class="input-group mt-2" id="inputGoldstarAmount">    
                                                <div class="mr-4" style="color:#FFD700">&#9733 Gold</div>
                                                <input type="number" class="form-control" id="goldStarUse" name="GoldStarUse" min="1" style="height: 35px; font-size: 85%;">
                                                <div class="input-group-append"><span class="input-group-text bg-primary"><font style="height: 20px; font-size: 90%;" color="white">ดวง</font></span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-6">
                                            <div class="input-group" id="inputSiverstarAmount">
                                                <div class="mr-3" style="color:#C0C0C0">&#9733 Silver</div>
                                                <input type="number" class="form-control" id="silverStarUse" name="SilverStarUse" min="1" style="height: 35px; font-size: 85%;">
                                                <div class="input-group-append"><span class="input-group-text bg-primary"><font style="height: 20px; font-size: 90%;" color="white">ดวง</font></span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-6">
                                            <div class="input-group" id="inputBronzestarAmount">    
                                                <div class="mr-2" style="color:#CD7F32">&#9733 Bronze</div>
                                                <input type="number" class="form-control" id="bronzeStarUse" name="BronzeStarUse" min="1" style="height: 35px; font-size: 85%;">
                                                <div class="input-group-append"><span class="input-group-text bg-primary"><font style="height: 20px; font-size: 90%;" color="white">ดวง</font></span></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer col-12">
                            <button type="button" class="btn btn-primary heading" style="width: 140px; font-size: 85%;" onclick="doUpdate()">Update</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Delete Reward</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Confirm To Delete
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-large btn-block btn-warning text-white" data-dismiss="modal">Cancel</button>
                            <button class="btn btn-primary" id="rewardId" name="rewardId" type="button"  onClick="doDelete()" data-dismiss="modal">Confirm</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div> 



