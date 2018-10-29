<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<nav class="navbar sticky-top navbar-color">
        <div class="navbar-header-left">
<!--            <a class="navbar-brand" href="#">
                <img src="images/Logompy.png" class="logo">
                <img src="images/MPYsmile.png" class="logo-responsive">
            </a>-->
            <i class="fas fa-bars align-middle" id="sidebarCollapse"></i>
        </div>
        <div class="navbar-header-righ">
            <a href="#" id="noti">
                <i class="fas fa-bell align-middle"></i>
            </a>
            <div class="bell-circle"></div>
            <a href="#" id="signout">
                <i class="fas fa-user align-middle"></i>
                <!--<img src="images/profile.png" class="img-fluid rounded-circle" id="img-profile" alt="Responsive image">-->
                <span class="profile-name">User name or name  ( Test ) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <i class="fas fa-caret-down align-middle"></i>
                </span>
            </a>
        </div>
    </nav>
    <div class="dropdown-signout align-middle" id="signout-box">
        <ul class="list-unstyled signout">
            <li>
                <i class="fas fa-sign-out-alt space-icon"></i>
                <span>Sign out</span>
            </li>
        </ul>
    </div>
    <div class="notification" id="noti-box">
        <h5>Notifications</h5>
        <hr>
    </div>