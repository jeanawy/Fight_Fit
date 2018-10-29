<%@page import="th.mfec.mpybackoffice.constant.ProjectConstant"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
        <meta http-equiv="pragma" content="no-cache" />
        <title>FightFit</title>

        <style>
            .inputDnD .form-control-file {
                position: relative;
                width: 100%;
                height: 100%;
                min-height: 6em;
                outline: none;
                visibility: hidden;
                cursor: pointer;
                background-color: #c61c23;
                box-shadow: 0 0 5px solid currentColor;
            }
            .inputDnD .form-control-file:before {
                content: attr(data-title);
                position: absolute;
                top: 0.5em;
                left: 0;
                width: 100%;
                min-height: 6em;
                line-height: 2em;
                padding-top: 1.5em;
                opacity: 1;
                visibility: visible;
                text-align: center;
                border: 0.25em dashed currentColor;
                transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
                overflow: hidden;
            }
            .inputDnD .form-control-file:hover:before {
                border-style: solid;
                box-shadow: inset 0px 0px 0px 0.25em currentColor;
            }

            body {
                background-color: #f7f7f9;
            }

        </style>

        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.18/r-2.2.2/sc-1.5.0/sl-1.2.6/datatables.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min_1.css" media="screen">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/4.4.7/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>

        <!-- BootStrap -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.18/r-2.2.2/sc-1.5.0/sl-1.2.6/datatables.min.js"></script>
        <%-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script> --%>

        <script type="text/javascript"  src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>


        <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/dropzone.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/4.4.7/js/fileinput.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/4.4.7/themes/fa/theme.js" type="text/javascript"></script>

        <!-- css -->
        <link rel="stylesheet" href="css/MPY_Create_Group_Style.css">
        <link rel="stylesheet" href="css/animate.css">


        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/all.css">
        <link href="css/Poiret+One.css" rel="stylesheet">
        <script src="js/mpy.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dropzone.css">
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

        <!-- Collapse CheckBox -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/CreateGroupCollapse.css">

        <!--datatable-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/MPY_DataTableGroup.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Table_Style.css">

        <script type="text/javascript">
            $("#file-1").fileinput({
                theme: 'fa',
                uploadUrl: '#',
                allowedFileExtensions: ['jpg', 'png', 'gif'],
                overwriteInitial: false,
                maxFileSize: 2000,
                maxFilesNum: 10,
                slugCallback: function (filename) {
                    return filename.replace('(', '_').replace(']', '_');
                }
            });
        </script>

        <script>
            window.console = window.console || function (t) {};
        </script>



        <script>
            if (document.location.search.match(/type=embed/gi)) {
                window.parent.postMessage("resize", "*");
            }
        </script>

        <script>
            function readUrl(input) {

                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        var imgData = e.target.result;
                        var imgName = input.files[0].name;
                        input.setAttribute("data-title", imgName);
                        console.log(e.target.result);
                    };
                    reader.readAsDataURL(input.files[0]);
                }

            }
        </script>

    </head>

    <body>

        <tiles:insertAttribute name="header" ignore="true" />
        <div class="wrapper">
            <tiles:insertAttribute name="menu" ignore="true" />
            <tiles:insertAttribute name="body" ignore="true" />
        </div>

    </body>
</html>


