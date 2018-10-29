<%-- 
    Document   : editUserAuthorize
    Created on : Sep 6, 2018, 11:06:17 AM
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

    $(document).keypress(function (e) {
        if (e.keyCode === 13) {
            $("#updateBtn").click();
            return false;
        }
    });

    $(document).ready(function () {
        $('#invis').hide();
        $('.alert').hide();

        $('.form_datetime').datetimepicker({
            format: "yyyy-mm-dd",
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            minView: 'month'
        });

        //select all
        var ss = [];
        $('input[name=selectallgroup]').on('click', function () {
            ss = ($(this).val());
            $('input[type="checkbox" ][var="' + ss + '"]').prop('checked', this.checked);
        });

        $('input[name=checkallMobilee]').click(function () {
            $('.mobile-checkBox').prop('checked', this.checked);
        });
    });

    function updateUserAuthorize() {

        $('#submitBtn').attr('disabled', 'disabled');

        //Get value from checkbox
        var bosCheckedValue = [];
        $('.bos-checkBox:checked').each(function () {
            bosCheckedValue.push($(this).val());
        });
//        alert("BOS : " + bosCheckedValue);

        var mobileCheckedValue = [];
        $('.mobile-checkBox:checked').each(function () {
            mobileCheckedValue.push($(this).val());
        });
//        alert("Mobile : " + mobileCheckedValue);

        $.ajax({
            url: "UserAuthorizeController-editCustomerUserAuthorize",
            type: "POST",
            data: {sid: "mpy001", language: "th", uid: '${employeeDetails.uid}', bosMenuArray: JSON.stringify(bosCheckedValue), mobileMenuArray: JSON.stringify(mobileCheckedValue)},
            success: function (response) {
                alert(" Update user authorize complete.");
                window.location.href = '${pageContext.request.contextPath}/UserAuthorizeController-initCustomerUserAuthorize';
            }
        });
    }

</script>

<div class="content">
    <form:form id="mainForm" name="mainForm" method="post" modelAttribute="searchUserAuthorize">
        <h3><span class="heading">Manage Group & User Authorize</span></h3>
        <hr>
        <div class="card mx-auto" style="background-image: url('images/navbg.png'); background-repeat: no-repeat; background-size: cover;">
            <div class="card-body">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-3 form-inline">
                        <img class="rounded-circle" style="width: 200px; height: 200px;" src="${employeeDetails.image}">
                    </div>
                    <div class="col-8 form-inline">
                        <h1 class="card-title" style="font-size: 300%; color: #ffffff">${employeeDetails.name}</h1>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <h3>Employee Details</h3>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body form-inline">
                        <div class="col-3">
                            <h5>รหัสพนักงาน :</h5>
                            <h5>ผ่าย :</h5>
                            <h5>แผนก :</h5>
                            <h5>ตำแหน่ง :</h5>
                            <h5>ระดับพนักงาน :</h5>
                        </div>
                        <div class="col-6">
                            <h5 style="color: #007bff">${employeeDetails.employeeID}</h5>
                            <h5 style="color: #007bff">${employeeDetails.department}</h5>
                            <h5 style="color: #007bff">${employeeDetails.division}</h5>
                            <h5 style="color: #007bff">${employeeDetails.position}</h5>
                            <h5 style="color: #007bff">${employeeDetails.level}</h5>
                        </div>
                        <div class="col-3"></div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <h3>Employee Group</h3>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body form-inline">
                        <div class="col-3">
                            <h5>กลุ่ม :</h5>
                        </div>
                        <div class="col-6">
                            <h5 style="color: #007bff">${employeeDetails.group}</h5>
                        </div>
                        <div class="col-3"></div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <h3>Authority</h3>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <h4>
                            <span class="heading text-secondary ">  MPY (Back Office)</span>
                        </h4>
                        <div class="block1 border border-secondary">
                            <c:forEach items="${masBosGroupMenuList}" var="masBosGroupMenuList">
                                <div class="form-check" >
                                    <h4>
                                        <input name="grouphead" type="checkbox" data-toggle="collapse" data-target="#collapse${masBosGroupMenuList.checkBoxKey}" aria-expanded="true" aria-controls="collapseOne" id="collapseJSP${masBosGroupMenuList.checkBoxKey}" class="grouphead"  value="${masBosGroupMenuList.checkBoxKey}" aria-hidden="true" >
                                        <label class="custom-control-label" name="grouplists" for="collapseJSP${masBosGroupMenuList.checkBoxKey}">${masBosGroupMenuList.checkBoxValue} </label>
                                    </h4>
                                    <div id="collapse${masBosGroupMenuList.checkBoxKey}" class="panel-collapse collapse" role="tabpanel"  aria-labelledby="headingOne">
                                        <div class="custom-control custom-checkbox">
                                            <h5>
                                                <input type="checkbox" class="custom-control-input" id="groupidgropmenu${masBosGroupMenuList.checkBoxValue}" name="selectallgroup" value="${masBosGroupMenuList.checkBoxKey}" />
                                                <label class="custom-control-label ml-4" for="groupidgropmenu${masBosGroupMenuList.checkBoxValue}">Select All</label>
                                            </h5>
                                        </div>
                                        <div class="block1 ml-2 border border-primary bg-primary text-light">
                                            <div class="row ml-2">
                                                <c:forEach items="${authorityBOS}" var="authorityBOS">
                                                    <c:if test="${masBosGroupMenuList.checkBoxKey.equals(authorityBOS.checkBoxKey)}">
                                                        <c:choose>
                                                            <c:when test="${authorityBOS.checkBoxKey3.equals('Y')}">
                                                                <div class="custom-control custom-checkbox col-4">
                                                                    <h5>
                                                                        <input type="checkbox" class="custom-control-input bos-checkBox" var="${authorityBOS.checkBoxKey}" id="${authorityBOS.checkBoxValue2}" name="BosMenuCheckBox" value="${authorityBOS.checkBoxKey2}" checked="true">
                                                                        <label class="custom-control-label" for="${authorityBOS.checkBoxValue2}"> ${authorityBOS.checkBoxValue2}</label>
                                                                    </h5>
                                                                </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <div class="custom-control custom-checkbox col-4">
                                                                    <h5>
                                                                        <input type="checkbox" class="custom-control-input bos-checkBox" var="${authorityBOS.checkBoxValue2}" id="cb${authorityBOS.checkBoxValue2}" name="BosMenuCheckBox" value="${authorityBOS.checkBoxKey2}">
                                                                        <label class="custom-control-label "for="cb${authorityBOS.checkBoxValue2}"> ${authorityBOS.checkBoxValue2}</label>
                                                                    </h5>
                                                                </div>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br>
                            </c:forEach> 
                        </div>
                        <br>
                        <h4>
                            <span class="heading text-secondary ">  MPY (Mobile App)</span>
                        </h4>
                        <!--SELECT ALL MOBILE APP-->
                        <div class="custom-control custom-checkbox  ml-3 mb-2">
                            <div class="form-check allmobilekub">
                                <h5>
                                    <input type="checkbox" class="custom-control-input " id="selectAllMobile" name="checkallMobilee">
                                    <label class="custom-control-label " for="selectAllMobile">Select All</label>
                                </h5>
                            </div>
                        </div>
                        <!--BLOCK MOBILE APP-->
                        <div class="block1 border border-secondary">   
                            <div class="form-check ">
                                <div class="row ">
                                    <c:forEach items="${authorityMobile}" var="authorityMobile"  varStatus="status">
                                        <c:choose>
                                            <c:when test="${authorityMobile.checkBoxKey2.equals('Y')}">
                                                <div class="custom-control custom-checkbox col-3 ">
                                                    <div class="ml-4 mb-4 form-check" >
                                                        <h5>
                                                            <input type="checkbox" class="custom-control-input mr-10 mobile-checkBox" id="mobileApp${authorityMobile.checkBoxKey}" name="masMobileCheckBox" value="${authorityMobile.checkBoxKey}" checked="true">
                                                            <label class="custom-control-label " name="checkallMobilees" for="mobileApp${authorityMobile.checkBoxKey}">  ${authorityMobile.checkBoxValue}</label>
                                                        </h5>
                                                    </div>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="custom-control custom-checkbox col-3 ">
                                                    <div class="ml-4 mb-4 form-check" >
                                                        <h5>
                                                            <input type="checkbox" class="custom-control-input mr-10 mobile-checkBox" id="mobileApp${authorityMobile.checkBoxKey}" name="masMobileCheckBox" value="${authorityMobile.checkBoxKey}">
                                                            <label class="custom-control-label" name="checkallMobilees" for="mobileApp${authorityMobile.checkBoxKey}">  ${authorityMobile.checkBoxValue}</label>
                                                        </h5>
                                                    </div>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach> 
                                </div>
                            </div>   
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4"></div>
                        <div class="col-2">
                            <button type="reset" class="btn btn-primary" data-dismiss="modal" style="size: 100%;border-color: #E6A900; background-color: #E6A900;border-radius: 10px">Cancel</button>
                        </div>
                        <div class="col-2">
                            <button class="btn btn-primary" id="update" type="button" data-toggle="modal" data-target="#modal" style="size: 100%; border-radius: 10px">Update</button>
                        </div>
                        <div class="col-4"></div>
                        <br>
                    </div>
                    <br>
                </div>
            </div>
        </div>

        <!--MODAL-->
        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header bg-primary">
                        <div class="mx-auto">
                            <h5 class="modal-title text-white" id="exampleModalLabel">Update user authorize ?</h5>
                        </div>
                    </div>
                    <br>
                    <span class="text-secondary ml-4 mt-2"><h4>Confirm to Update user authorize</h4></span>
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-1"></div>
                        <div class="col-5">
                            <button type="button" id="comfirmCancel" class="btn btn-primary" data-dismiss="modal" style="size: 100%;border-color: #E6A900; background-color: #E6A900;border-radius: 10px">Cancel</button>
                        </div>
                        <div class="col-5">
                            <button class="btn btn-primary" id="comfirmUpdate" type="button" data-dismiss="modal" style="size: 100%; border-radius: 10px" onclick="updateUserAuthorize()">Update</button>
                        </div>
                        <div class="col-1"></div>
                        <br>
                    </div>
                    <br>
                </div>
            </div> 
        </div>
        <!--END MODAL-->

        <br>
    </form:form>
</div>