<%-- 
    Document   : deleteGroup
    Created on : Sep 6, 2018, 2:36:13 PM
    Author     : Panaporn
--%>

<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    $(document).keypress(function (e) {
        if (e.keyCode === 13) {
            $("#Search").click();
            return false;
        }
    });
    $(document).ready(function () {
        doSearch();
    });

    function send() {


        console.log($('#Search2').val());
        $.ajax({
            url: "deletegroup",
            type: "POST",
            data: {groupID: $('#Search2').val()},
            success: function (response) {
                doSearch();
            }
        });

    }



    function doSearch() {
        $.fn.dataTable.ext.errMode = 'none';
        table = $('#DeleteGroup').DataTable({
            "processing": true,
            "serverSide": true,
            "lengthChange": false,
            "pageLength": 5,
            "searching": false,
            "ordering": false,
            "scrollY": true,
            "scrollX": true,
            "order": true,
            ajax: {
                url: "GroupController-searchDeleteGroup",
                type: "POST",
                data: function (d) {
                    d.sid = "mpy001";
                    d.language = "th";
                    d.SearchName = $('#SearchName').val();
                    console.log($('#SearchName').val());
                },
                dataSrc: function (response) {
                    console.log(response);
                    return response.group;
                }

            },
            columns: [
                {data: 'count', title: 'No.'},
                {data: 'nameGroup', title: 'NameGroup'},
                {data: 'groupid', title: 'Delete Group'}
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
                    render: function (data) {
                        return '<button type="button" class="btn btn-link" data-toggle="modal" data-target="#modal" id="btnselect" value="' + data + '"><i class="fa fa-trash-o fa-lg"  aria-hidden="true"></i></button>';
                    },
                    className: "dt-body-center"
                }
            ],
            language: {
                emptyTable: 'No result found.'
            }

        });

        $('#DeleteGroup tbody').on('click', 'button', function () {
//            var data = table.row($(this).parents('tr')).data();
            console.log($(this).val());
            var x = $(this).val();
            $("#Search2").attr('value', x);
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


<div class="content ">
    <form:form method="POST" id="mainForm" name="mainForm" modelAttribute="searchNameModel">
        <h3>
            <span class="heading">
                Delete Group
            </span>
        </h3>
        <hr>
        <div class="row mt-2">
            <div class="col-12">
                <div>

                    <div class="row">
                        <div class="col-4" >
                            <label for="SearchName" class="text-primary px-2"> Search</label>
                            <form:input class="form-control" id="SearchName" path="SearchName" placeholder="Search By Group Name"/>
                        </div>
                        <div class="col-2">
                            <label for="Search" class="text-primary px-2"> &nbsp;</label>
                            <button class="btn btn-primary" id="Search" name="Search" type="button" value="Submit" onClick="doSearch()" >Search</button>
                        </div>
                        <div class="col-6">

                        </div>
                        <div class="col-12 mt-4">
                            <table id="DeleteGroup" class="table table-striped table-bordered" width="100%">
                            </table>
                        </div>

                    </div> 
                </div>


                <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Delete Group</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Confirm To Delete
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-large btn-block btn-warning text-white" data-dismiss="modal">Cancel</button>
                                <button class="btn btn-primary" id="Search2" name="Search2" type="button"  onClick="send()" data-dismiss="modal">Confirm</button>
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

