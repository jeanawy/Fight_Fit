<%-- 
Document   : group
Created on : Aug 28, 2018, 2:18:41 PM
Author     : Worakan
--%>

<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<script type="text/javascript">

    $(document).ready(function () {


// check all block top
        var checkAllBlockTop = [];
        $('input[name=selectallgroup]').on('click', function () {
            checkAllBlockTop = ($(this).val());
           $('input[type="checkbox" ][var="' + checkAllBlockTop + '"]').prop('checked', this.checked);

        });



//check all block bottom
        $('input[name=checkallMobilee]').click(function () {
            $('input[name=masMobileCheckBox').prop('checked', $(this).prop('checked'));
        });


//check TextBox is null
        document.getElementById('Submit').style.backgroundColor = '#008CBA';
        $('input[type=text]').keyup(function () {
            var empty = false;

            $('input[type=text]').each(function () {
                if (($(this).val().length == 0)) {
                    empty = true;
                }
                if (empty) {

                    $('#actions input').attr('disabled', 'disabled');

                    document.getElementById('Submit').style.backgroundColor = '#555555';

                } else {
                    $('#actions input').removeAttr('disabled');

                    document.getElementById('Submit').style.backgroundColor = '#008CBA';
                }
            });
        });

    });




    function query() {

        //BosMenuCheckBox
        var BosMenuCheckBox = [];
        $('input[name=BosMenuCheckBox]').each(function () {
            if ($(this).prop('checked')) {
                BosMenuCheckBox.push($(this).val());
            }
        });

        var BosMenuCheckBoxString = BosMenuCheckBox.toString();
        var BosMenu = [];
        BosMenu = BosMenuCheckBoxString.split(",");

        var bosGroupId = [];
        var bosMenuId = [];
        BosMenu.forEach(function (element) {
            let BosMenuSplit = [];
            BosMenuSplit = element.split("|");

            bosGroupId.push(BosMenuSplit[0]);
            bosMenuId.push(BosMenuSplit[1]);
        });
//        console.log("bosGroupId: " + bosGroupId.toString());
//        console.log("bosMenuId: " + bosMenuId.toString());

        //masMobileCheckBox
        var masMobileCheckBox = [];
        $('input[name=masMobileCheckBox]').each(function () {
            if ($(this).prop('checked')) {
                masMobileCheckBox.push($(this).val());
            }
        });


//        console.log(" masMobileCheckBox  = " + masMobileCheckBox);
        $.ajax({
            url: "GroupController-createGroup",
            type: "POST",
            data: {language: "th",
                sid: "mpy001",
                bosGroupId: bosGroupId.toString(),
                bosMenuId: bosMenuId.toString(),
                mobileMenuId: masMobileCheckBox.toString(),
                groupNameTh: $('input[name="groupNameTh"]').val(),
                groupNameEn: $('input[name="groupNameEn"]').val()


            }, success: function (response) {
             
                editUpdateGroup();


                return response;
            }

        });
        $('intput[name=Search2]').on('click', 'button', function () {
      
            editUpdateGroup();
            location.reload();
        });

    }

    function backtoUpdateGroup() {
        $("#mainForm").attr("action", "GroupController-initEditUpdateGroup");
//        $("#mainForm").submit();
        location.reload();

    }

</script>



<div class="container">
    <form:form method="post" id="mainForm" name="mainForm" >

        <h2><span class="heading">Update Group</span></h2>
        <hr />


        <div class="block1">
            <div class="row" id="createname">

                <div class="col-6 ">
                    <h4><span class="heading"> Group Name (TH)</span></h4>
                    <input class="form-control col-8 border-secondary"  id="groupNameThId" type="text" name="groupNameTh" placeholder="กรุณากรอกข้อมูล" value="${GroupNameTh}">


                </div>
                <div class="col-6">
                    <h4><span class="heading"> Group Name (EN)</span></h4>
                    <input class="form-control col-8 border-secondary" id="groupNameEnId" type="text" name="groupNameEn" placeholder="Please fill in Group Name" value="${GroupNameTh}">

                </div>

            </div>               
            <hr />
            <h4><span class="heading">Authority</span></h4>
            <div class="container">
                <h4><span class="heading text-secondary">MPY (BACK OFFICE)</span></h4>
                <div class="block1 border border-secondary" id="borderStyle">  
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
                                                                <input type="checkbox" class="custom-control-input bos-checkBox" var="${authorityBOS.checkBoxKey}" id="${authorityBOS.checkBoxValue2}" name="BosMenuCheckBox" value="${authorityBOS.checkBoxKey}|${authorityBOS.checkBoxKey2}" checked="true">
                                                                <label class="custom-control-label" for="${authorityBOS.checkBoxValue2}"> ${authorityBOS.checkBoxValue2}</label>
                                                            </h5>
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="custom-control custom-checkbox col-4">
                                                            <h5>
                                                                <input type="checkbox" class="custom-control-input bos-checkBox" var="${authorityBOS.checkBoxValue2}" id="cb${authorityBOS.checkBoxValue2}" name="BosMenuCheckBox" value="${authorityBOS.checkBoxKey}|${authorityBOS.checkBoxKey2}">
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

                <!--SUMMIT AND CANCEL-->
                <div class="row mt-3 ">
                    <div class="mx-auto" id="actions">
                        <button type="reset" class="text-light btn btn-warning btn-lg mr-2">Cancel</button>                        
                        <input  type = "button" id="Submit" name="Alert" class="btn btn-lg  confirm ml-2" data-toggle="modal" data-target="#modal" value = "Submit" />
                    </div>
                </div>
            </div>

            <!--MODAL-->
            <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header bg-primary">
                            <div class="mx-auto">
                                <h4 class="modal-title text-white" id="exampleModalLabel">Edit Group ?</h4>
                            </div>
                        </div>
                        <br>
                        <span class="text-secondary ml-4 mt-2"><h5 class="mb-4">Confirm to edit Group</h5></span>
                        <br>
      <!--<a href="${pageContext.request.contextPath}/GroupController-initUpdateGroup" class="btn btn-success"> Back</a>-->

                        <div class="row">

                            <div class="modal-footer border-0 mx-auto">
                                <button type="button" class="btn btn-large btn-block btn-warning text-white col-6 " data-dismiss="modal">Cancel</button>
                                <a href="${pageContext.request.contextPath}/GroupController-initUpdateGroup" class="btn btn-primary col-6" id="alertSummit" name="Search2"  onClick="query()">Summit</a>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
            <!--END MODAL-->

        </div>
    </form:form>
</div>
