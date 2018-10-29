<%-- 
    Document   : setStarByGroup
    Created on : Aug 28, 2018, 4:13:56 PM
    Author     : ธนากร
--%>

<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    $(document).ready(function () {
        $('#hide').hide();
        $('#hide2').hide();
    });
    function doSearch() {
        console.log("sdsd");
        $.ajax({
            url: "StarController-GiveStarByGroup",
            type: "POST",
            data: {language: "th", sid: "mpy001", groupUserID: $('#groupUserID').val()},
            success: function (response) {
                $('#hide').show();
                $('#hide2').show();
                $('#title').html($('#groupUserID option:selected').text());
                console.log("response success");
                var i = 0;
                $.each(response, function (key, value) {
                    console.log(key + " : " + value[0]);
                    if (i === 0) {
                        $('#goldStar').val(value[0]);
                    } else if (i === 1) {
                        $('#silverStar').val(value[0]);
                    } else if (i === 2) {
                        $('#bronzeStar').val(value[0]);
                    }
                    i++;
                });
            }
        });
    }

    function doUpdate() {
        console.log("doUpdate");
        $.ajax({
            url: "StarController-updateGiveStarByGroup",
            type: "POST",
            data: {
                language: "th",
                sid: "mpy001",
                groupUserID: $('#groupUserID').val(),
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
                    $("#myModal").modal("toggle");
                } else {
                    console.log("failure if");
                    $("#myModal2").modal("toggle");
                }
            },
            error: function () {
                $("#myModal2").modal("toggle");
            }
        });
    }

    function search(table, resetPage) {
        table.ajax.reload(null, resetPage);
    }

    function doReload() {
        location.reload();
    }

    function doAlert() {
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
        <h3><span class="heading">Choose Group</span></h3>
        <hr>
        <div class="row">
            <div class="col-4">
                Choose Group
                <br>group<br>
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
                <br>
                <br>
                <botton type="botton" name="Search" class="btn btn-primary btn-md" onClick="doSearch()"> Search </botton>
            </div>
        </div> 
        <div class="row" id="hide">
            <div class="col-12">
                <br>    
                <div id="title" class="rounded" style="background-color: green">ssd</div>
                <br><br>
            </div>
        </div>
        <div class="row" id="hide2">
            <br>
            <div class="col-4">
                GOLD STAR
                <br>
                <div class="input-group">
                    <input type="number" class="form-control" id="goldStar" style="text-align: right;" min="0">
                    <span class="input-group-addon tail">ดวง</span>
                </div>
            </div>
            <div class="col-4">
                SILVER STAR
                <br>
                <div class="input-group">
                    <input type="number" class="form-control" id="silverStar" style="text-align: right;" min="0">
                    <span class="input-group-addon tail">ดวง</span>
                </div>
            </div>
            <div class="col-4">
                BRONZE STAR
                <br>
                <div class="input-group">
                    <input type="number" class="form-control" id="bronzeStar" style="text-align: right;" min="0">
                    <span class="input-group-addon tail">ดวง</span>
                </div>
            </div>

            <div class="col-4"></div>
            <div class="col-2">
                <br>
                <botton type="botton" id="update" name="update" class="btn btn-primary btn-sm btn-center" align="center" onClick="doUpdate()"> Submit </botton>
            </div>
        </div>
    </form:form>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
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
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
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

