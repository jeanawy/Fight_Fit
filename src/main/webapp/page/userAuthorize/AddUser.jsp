<%-- 
    Document   : AddUser
    Created on : Aug 29, 2018, 4:28:32 PM
    Author     : Panaporn
--%>

<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<script type="text/javascript">


    $('#btn1').attr('disabled', 'disabled');
    $(document).keypress(function (e) {
        if (e.keyCode === 13) {
            $("#btn1").click();
            return false;
        }
    });

    function resetcheck() {
        $('#selectall').prop('checked', false);
        $('input[name=fo]').each(function () {
            if ($(this).prop('checked')) {
                $(this).prop('checked', false);
            }
        });
    }

    function send() {


        if ($('#groupID').val() !== "null") {

            var arrayValue = [];
            $('input[name=fo]').each(function () {

                if ($(this).prop('checked')) {
                    arrayValue.push($(this).val());
                }
                console.log("input" + arrayValue);
            });
            $.ajax({
                url: "addUserAuthorize",
                type: "POST",
                data: {uid: arrayValue.toString(), groupID: $('#groupID').val()},
                success: function (response) {
                    doSearch();
                }
            });
        }
    }

    $(document).ready(function () {
        $('#hide').hide();
        $('#re').hide();
        $('#suc').hide();


        $('#departmentID').change(function () {
            $("#divisionID").find('option').remove();
            $.ajax({
                url: "reloadDivisionDropDown",
                type: "POST",
                data: {language: "th", departmentID: $('#departmentID').val()},
                success: function (response) {
                    console.log(divisionID);

                    $('#btn1').removeAttr('disabled');
                    $('<option>').val("null").text("please select").appendTo(divisionID);
                    $.each(response, function (key, value) {
                        $('<option>').val(value.dropDownKey).text(value.dropDownValue).appendTo(divisionID);

                    });
                }
            });
        });

    });

    function doSearch() {
        $('#Search').attr('disabled', 'disabled');
        $('#userAuthorizeTable tbody').off('click', 'tr');
        if ($('#groupID').val() !== "null") {
            console.log($('#groupID').val());
            $.fn.dataTable.ext.errMode = 'none';
            table = $('#UserAuthorizeTable').DataTable({
                "processing": true,
                "serverSide": true,
                "lengthChange": false,
                "pageLength": 10,
                "searching": false,
                "ordering": false,
                "scrollY": true,
                "scrollX": true,
                "order": true,
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
                        d.flageoption = true;
                    },
                    dataSrc: function (response) {
                        $('#UserAuthorizeTable tbody').on('click', 'tr', function () {
                            console.log($(this).val());
                            var arrayValue = [];
                            $('input[name=fo]').each(function () {
                                if ($(this).prop('checked')) {
                                    arrayValue.push($(this).val());
                                    console.log("sss" + $(this).val());
                                }
                            });
                            console.log("input" + arrayValue.length);
                            if (arrayValue.length > 0) {
                            } else {
                                $('#selectall').prop('checked', false);
                            }
                        });
                        $('#hide').show();
                        $('#suc').show().html($('#groupID option:selected').text());
                        $("#suc").removeClass('alert alert-danger').addClass("alert alert-success");
                        console.log(response.userAuthorize);
                        $('#selectall').prop('checked', false);
                        $('#Search').removeAttr('disabled');
                        return response.userAuthorize;
                    }
                },
                columns: [
                    {data: 'uid', title: 'No.'},
                    {data: 'image', title: 'Image'},
                    {data: 'name', title: 'Name'},
                    {data: 'department', title: 'Department'},
                    {data: 'division', title: 'Division'},
                    {data: 'group', title: 'Group'},
                    {data: 'uid', title: '<input type="checkbox" class="checkbox checkbox-success" id="selectall"/>'}
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
                        searchable: false,
                        orderable: false,
                        className: "dt-body-center",
                        render: function (data) {
                            return '<input type="checkbox" class="checkbox checkbox-success"  id="foot" name="fo"  value="' + data + '"/>';
                        }
                    }
                ],
                language: {
                    emptyTable: 'No result found.'
                }
            });


            $('#selectall').on('click', function () {
                var rows = table.rows({'search': 'applied'}).nodes();
                $('input[type="checkbox"]', rows).prop('checked', this.checked);

                var arrayValue = [];
                $('input[name=fo]').each(function () {
                    if ($(this).prop('checked')) {
                        arrayValue.push($(this).val());
                    }
                });
                console.log("input" + arrayValue.length);
                if (arrayValue.length > 0) {
                    console.log(">0");
                } else {
                    $('#selectall').prop('checked', false);
                    console.log("0");
                }
            });



            search(table, true);
            clearDataTable();
        } else {
            $('#suc').show().html("เลือกดิ เลือกเลย!!!");
            $("#suc").removeClass('alert alert-success').addClass("alert alert-danger");
        }
    }


    function clearDataTable() {
        table.clear().draw();
    }

    function search(table, resetPage) {
        table.ajax.reload(null, resetPage);
    }

    function checkdata() {
        var arrayValue = [];
        $('input[name=fo]').each(function () {
            if ($(this).prop('checked')) {
                arrayValue.push($(this).val());
            }
        });
        console.log("input" + arrayValue.length);
        if (arrayValue.length > 0) {
            console.log(">0");
            $('#modalcontro').attr('data-target', '#modal');
        } else {
            console.log("0");
            $('#selectall').prop('checked', false);
            $('#modalcontro').attr('data-target', '#modal2');
        }
    }
</script>

<div class="content ">
    <form:form method="POST" id="mainForm" name="mainForm" modelAttribute="searchUserAuthorize">
        <h3>
            <span class="heading">
                Add User to Group
            </span>
        </h3>
        <hr>
        <div class="row mt-2">
            <div class="col-12">
                <div>
                    Choose Group
                    <div class="row">
                        <div class="col-5">
                            <label for="groupID" class="text-primary px-2"> Group</label>
                            <div class="dropdown">
                                <form:select path="groupID" id="groupID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                                    <form:option value="null" style="display: none;">Search by Group Name</form:option> 
                                    <c:forEach items="${groupDropdown}" var="groupDropdown">
                                        <form:option value="${groupDropdown.dropDownKey}" name="${groupDropdown.dropDownValue}"> ${groupDropdown.dropDownValue} </form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="col-3">
                            <label for="btn1"> &nbsp;</label>
                            <button class="btn btn-primary" id="btn1" name="Search" type="button" value="Submit" onClick="doSearch()" >Search</button>
                        </div>
                        <div class="col-12 mt-2 text-muted ">
                            <div id="suc" class="alert alert-success" role="alert">test</div>
                        </div>
                    </div> 
                </div>
                <div id="hide">
                    Add User to Group:BIG MFEC
                    <div class="row mt-2">
                        <div class="col-3">
                            <label for="departmentID" class="text-primary px-2"> Department</label>
                            <form:select path="departmentID" id="departmentID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                                <form:option value="">
                                    please select
                                </form:option>
                                <c:forEach items="${departmentsDropDownList}" var="departmentsDropDownList">
                                    <form:option value="${departmentsDropDownList.dropDownKey}">${departmentsDropDownList.dropDownValue}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-3">
                            <label for="divisionID" class="text-primary px-2"> Division</label>
                            <form:select path="divisionID" id="divisionID" cssClass="form-control select2" data-style="select-sm" cssStyle="width: 100%">
                                <form:option value="">
                                    please select
                                </form:option>
                                <c:forEach items="${divisionDropDownList}" var="divisionDropDownList">
                                    <form:option value="${divisionDropDownList.dropDownKey}">${divisionDropDownList.dropDownValue}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-3" >
                            <label for="searchName" class="text-primary px-2"> Search</label>
                            <form:input class="form-control" id="searchName" path="searchName" placeholder="SearchName"/>
                        </div>
                        <div class="col-3">
                            <label for="Search"> &nbsp;</label>
                            <button class="btn btn-primary" id="Search" name="Search" type="button" value="Submit" onClick="doSearch()" >Search</button>
                        </div>
                        <div class="col-12 mt-4 ">
                            <table id="UserAuthorizeTable" class="table table-striped table-bordered" width="100%">
                            </table>
                        </div>
                        <div class="col-3 mt-3">
                        </div>
                        <div  id="ko" class="col-3 mt-3">
                            <button type="button" class="btn btn-large btn-block btn-warning text-white"  onClick="resetcheck()" >Cancel</button>
                        </div>
                        <div  id="ko2" class="col-3 mt-3">
                            <button type="button" class="btn btn-primary" data-toggle="modal" id="modalcontro" onClick="checkdata()" >Add</button>
                        </div>
                        <div class="col-3 mt-3">
                        </div>
                    </div> 
                    <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header bg-primary">
                                    <div class="mx-auto">
                                        <h4 class="modal-title text-white" id="exampleModalLabel">Add User To Group</h4>
                                    </div>
                                </div>
                                <div class="modal-body mt-2 mb-2">
                                    <h5> Confirm To Add User</h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-large btn-block btn-warning text-white" data-dismiss="modal">Cancel</button>
                                    <button class="btn btn-primary" id="Search2" name="Search2" type="button" value="Submit2" onClick="send()" data-dismiss="modal">Confirm</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="modal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header bg-primary">
                                    <div class="mx-auto">
                                        <h4 class="modal-title text-white" id="exampleModalLabel">Add User To Group</h4>
                                    </div>
                                </div>
                                <div class="modal-body mt-2 mb-2">
                                    <h5>เลือกดิ</h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-large btn-block btn-warning text-white" data-dismiss="modal">Exit</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
    </form:form>
</div>
