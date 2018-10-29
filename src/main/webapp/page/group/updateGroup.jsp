<%-- 
    Document   : updateGroup
    Created on : Sep 10, 2018, 5:33:41 PM
    Author     : Worakan
--%>



<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    var groupData = null;

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


        console.log($('#btnselect').val());
        $.ajax({
            url: "GroupController-initEditUpdateGroup",
            type: "POST",
            data: {groupID: $('#btnselect').val()},
            success: function (response) {
                doSearch();
            }
        });

    }



    function doSearch() {
        $('#DeleteGroup tbody').off('click', 'a');

        $.fn.dataTable.ext.errMode = 'none';
        table = $('#DeleteGroup').DataTable({
            "processing": true,
            "serverSide": true,
            "lengthChange": false,
            "pageLength": 5,
            "searching": false,
            "ordering": false,
            "scrollY": false,
            "scrollX": false,
            "order": true,
//            source: dataAdapter,
            ajax: {
                url: "GroupController-searchDeleteGroup",
                type: "POST",
                data: function (d) {
                    d.sid = "mpy001";
                    d.language = "th";
                    d.SearchName = $('#SearchName').val();
                  
                },
                dataSrc: function (response) {

                    console.log(response);



                        $('#DeleteGroup tbody').on('click', 'a', function () {
                            groupData = table.row($(this).parents('tr')).data();
                          
                            $("#groupIDs").val(groupData.groupid);                            
                            $("#sid").val("mpy001");
                            $("#language").val("th");
                            editUpdateGroup();
                        });

                    return response.group;
                }

            },
            columns: [
                {
                    data: 'count',
                    title: 'No.'
                },
                {
                    data: 'nameGroup',
                    title: 'Name'},
                {
                    data: 'groupid',
                    title: 'Update Group'
                }
            ],
            columnDefs: [
                {
                    targets: 0,
                    className: "dt-body-center1"
                },
                {
                    targets: 1,
                    className: "dt-body-center2"
                },
                {
                    targets: 2,
                    render: function () {
                        return '<a class="btn btn-default fa fa-pencil-square-o fa-2x "  id="editicon" value="' + $(this) + '"></a>';
                    },
                    className: "dt-body-center3"
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

    function editUpdateGroup() {
        $("#mainForm").attr("action", "GroupController-initEditUpdateGroup");
        $("#mainForm").submit();
    }

</script>


<div class="content ">
    <form:form method="POST" id="mainForm" name="mainForm" modelAttribute="searchUpdateGroup">
        <form:hidden path="groupIDs" id="groupIDs"/>
        <form:hidden path="sid" id="sid"/>
        <form:hidden path="language" id="language"/>

        <h3>
            <span class="heading">
                Update Group
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



            </div>
        </div>
        <br>
        <br>
    </form:form>
</div>


