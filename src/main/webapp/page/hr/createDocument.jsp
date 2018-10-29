<%-- 
    Document   : welcome
    Created on : Aug 28, 2018, 2:08:56 PM
    Author     : Sukrit_p
--%>
<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <h3>
        <span class="heading">
            Create Document
        </span>
    </h3>
    <hr>
    <form>

        <div class="block1 border border-primary">
            <div class="row">
                <div class="col-7">

                    <span class="heading col-12">
                        Document Thai
                        <div class="form-group col-12">
                            <input type="text" class="form-control mt-2">
                        </div>
                    </span>

                    <span class="heading">
                        Document English

                        <div class="form-group col-12">
                            <input type="text" class="form-control mt-2">
                        </div>
                    </span>
                    <span class="heading col-12">
                        Process Day
                    </span>
                    <div class="input-group col-4 mt-1">
                        <input type="text" class="form-control">
                        <div class="input-group-append">
                            <span class="input-group-text btn-primary" id="basic-addon2" style="width: 50px;">
                                Day
                            </span>
                        </div>
                    </div>

                </div>

                <div class="col-5">

                    <span class="heading">
                        Document URL
                    </span>

                    <div class="block1 border border-primary col-11 text-center mt-2"  style="height: 150px;">
                        Drop File to Upload
                    </div>  
                    <div class="col-11 text-center mt-2 mb-4 ">
                        <button type="button" class="btn btn-primary btn-sm" style="width: 130px;">BROWSE</button>
                    </div>
                </div>
                <div class="col-12 text-center mt-4">
                    <button type="button" class="btn btn-primary btn-lg" style="width: 140px;">สร้าง</button>
                </div>
            </div>



        </div>
    </form>
    <br>
    <br>
</div>
