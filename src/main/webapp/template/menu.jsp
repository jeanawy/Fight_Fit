<%@page import="java.util.Map"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="sidebar-menu-responsive">
        <nav id="sidebar-responsive">
            <ul class="list-unstyled">
                <li>
                    <a href="#groupSubMenu-responsive" data-toggle="collapse" aria-expanded="false">
                        <img src="images/group.png" class="icon-menu space-icon">
                        <span>Event</span>
                        <i class="fas fa-caret-down float-right"></i>
                    </a>
                    <ul class="collapse list-unstyled" id="groupSubMenu-responsive">
                        <li>
                            <a href="">Create Event</a>
                        </li>
                        <li>
                            <a href="">Update Event</a>
                        </li>
                        <li>
                            <a href="">Delete Event</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#userAuthorizeSubMenu-responsive" data-toggle="collapse" aria-expanded="false">
                        <img src="images/user.png" class="icon-menu space-icon">
                        <span>User Profile</span>
                        <i class="fas fa-caret-down float-right"></i>
                    </a>
                    <ul class="collapse list-unstyled" id="userAuthorizeSubMenu-responsive">
                        <li>
                            <a href="">My Profile </a>
                        </li>
                        <li>
                            <a href="">Profile HeartRate</a>
                        </li>
                        <li>
                            <a href="">Activity Profile</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#meetingRoomSubMenu-responsive" data-toggle="collapse" aria-expanded="false">
                        <img src="images/meeting.png" class="icon-menu space-icon">
                        <span>Meeting Event </span>
                        <i class="fas fa-caret-down float-right"></i>
                    </a>
                    <ul class="collapse list-unstyled" id="meetingRoomSubMenu-responsive">
                        <li>
                            <a href="">My Event </a>
                        </li>
                        <li>
                            <a href="">Find Event</a>
                        </li>
                        <li>
                            <a href="">Find team Event</a>
                        </li>
                        <li>
                            <a href=""></a>
                        </li>
                        <li>
                            <a href=""></a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#hrSubMenu-responsive" data-toggle="collapse" aria-expanded="false">
                        <img src="images/HR.png" class="icon-menu space-icon">
                        <span>Friend</span>
                        <i class="fas fa-caret-down float-right"></i>
                    </a>
                    <ul class="collapse list-unstyled" id="hrSubMenu-responsive">
                        <li>
                            <a href="">Add Friend</a>
                        </li>
                        <li>
                            <a href=""></a>
                        </li>
                        <li>
                            <a href=""></a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#contactToRepairSubMenu-responsive" data-toggle="collapse" aria-expanded="false">
                        <img src="images/repair.png" class="icon-menu space-icon">
                        <span>Report</span>
                        <i class="fas fa-caret-down float-right"></i>
                    </a>
                    <ul class="collapse list-unstyled" id="contactToRepairSubMenu-responsive">
                        <li>
                            <a href="">Report User and Block</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#starSubMenu-responsive" data-toggle="collapse" aria-expanded="false">
                        <img src="images/star.png" class="icon-menu space-icon">
                        <span>Ranking</span>
                        <i class="fas fa-caret-down float-right"></i>
                    </a>
                    <ul class="collapse list-unstyled" id="starSubMenu-responsive">
                        <li>
                            <a href="">Ranking World</a>
                        </li>
                        <li>
                            <a href="">Ranking friend</a>
                        </li>
                        <li>
                            <a href=""></a>
                        </li>
                        <li>
                            <a href="">Reward List</a>
                        </li>
                        <li>
                            <a href="">Searc Redeem Rewards</a>
                        </li>
                    </ul>
                </li>
            </ul>

        </nav>
    </div>

    <!-- Sidebar Menu Destop -->
        <div class="sidebar-menu">
            <nav id="sidebar">
                <ul class="list-unstyled">
                    <li>
                        <a href="#groupSubMenu" data-toggle="collapse" aria-expanded="false">
                            <img src="images/group.png" class="icon-menu space-icon">
                            <span> Event</span>
                            <i class="fas fa-caret-down float-right"></i>
                        </a>
                <ul class="collapse list-unstyled" id="groupSubMenu">
                            <li>
                            <a href="">Create Event</a>
                        </li>
                            <li>
                                <a href="">Update Event</a>
                            </li>
                            <li>
                                <a href="">Delete Event</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#userAuthorizeSubMenu" data-toggle="collapse" aria-expanded="false">
                            <img src="images/user.png" class="icon-menu space-icon">
                                <span>User Profile</span>
                            <i class="fas fa-caret-down float-right"></i>
                        </a>
                        <ul class="collapse list-unstyled" id="userAuthorizeSubMenu">
                            <li>
                                <a href="">My Profile</a>
                            </li>
                            <li>
                                <a href="">Profile HeartRate</a>
                            </li>
                            <li>
                                <a href="">Activity Profile</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#meetingRoomSubMenu" data-toggle="collapse" aria-expanded="false">
                            <img src="images/meeting.png" class="icon-menu space-icon">
                            <span>Meeting Event</span>
                            <i class="fas fa-caret-down float-right"></i>
                        </a>
                        <ul class="collapse list-unstyled" id="meetingRoomSubMenu">
                            <li>
                                <a href="">My Event</a>
                            </li>
                            <li>
                                <a href="">Find Event</a>
                            </li>
                            <li>
                                <a href="">Find team</a>
                            </li>
                           
                        </ul>
                    </li>
                    <li>
                        <a href="#hrSubMenu" data-toggle="collapse" aria-expanded="false">
                            <img src="images/HR.png" class="icon-menu space-icon">
                            <span>Friend</span>
                            <i class="fas fa-caret-down float-right"></i>
                        </a>
                        <ul class="collapse list-unstyled" id="hrSubMenu">
                            <li>
                                <a href="">Add Friend</a>
                            </li>
                            <li>
                                <a href="">Team Recent</a>
                            </li>
                            <li>
                                <a href=""></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#contactToRepairSubMenu" data-toggle="collapse" aria-expanded="false">
                            <img src="images/repair.png" class="icon-menu space-icon">
                            <span>Report</span>
                            <i class="fas fa-caret-down float-right"></i>
                        </a>
                        <ul class="collapse list-unstyled" id="contactToRepairSubMenu">
                            <li>
                                <a href="">Report user</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#starSubMenu" data-toggle="collapse" aria-expanded="false">
                            <img src="images/star.png" class="icon-menu space-icon">
                            <span>Ranking</span>
                            <i class="fas fa-caret-down float-right"></i>
                        </a>
                        <ul class="collapse list-unstyled" id="starSubMenu">
                            <li>
                                <a href="">My Ranking</a>
                            </li>
                            <li>
                                <a href="">Ranking Friend</a>
                            </li>
                            <li>
                                <a href="">Ranking World</a>
                            </li>
                            
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>