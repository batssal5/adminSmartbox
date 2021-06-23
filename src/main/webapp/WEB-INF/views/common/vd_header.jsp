<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Management - This is an example dashboard created using build-in elements and components.</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no"
    />
    <meta name="description" content="This is an example dashboard created using build-in elements and components.">
    <link rel="icon" href="favicon.ico">

    <!-- Disable tap highlight on IE -->
    <meta name="msapplication-tap-highlight" content="no">

    <link rel="stylesheet" href=/bootstrab/css/vd-style.css>


    <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
    <script type="text/javascript" src="/bootstrab/js/util.js"></script>
    <script language="javascript">
        $(function () {
            // Handler for .ready() called.
            console.log("sssssssssssss");

        });


    </script>
</head>
<body>
<div class="app-container app-theme-gray">
    <div class="app-main">
        <div class="app-sidebar-wrapper">
            <div class="app-sidebar sidebar-shadow">
                <div class="app-header__logo">
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="SmartBox Admin">
                        <img src="/bootstrab/assets/images/logo.png"></a>
                    <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                                <span class="hamburger-box">
                                    <span class="hamburger-inner"></span>
                                </span>
                    </button>
                </div>
                <div class="scrollbar-sidebar scrollbar-container">
                    <div class="app-sidebar__inner">
                        <ul class="vertical-nav-menu">
                            <li class="app-sidebar__heading">${pageInfo.pageTitle}</li>
                            <c:forEach items="${leftMenuInfo.leftMenuList}" var="row" varStatus="leftMenuInfos">
                                <li class="mm-active">
                                    <a href="#" aria-expanded="true">
                                        <i class="metismenu-icon ${row.menu_icon}"></i>
                                            ${row.menu_name}
                                        <i class="metismenu-state-icon pe-7s-angle-down caret-left"></i>
                                    </a>
                                    <c:forEach items="${row.leftMenuSub}" var="subrow" varStatus="leftMenuSub">
                                        <ul class="mm-show">
                                            <li><a href="${subrow.link_url}">${subrow.menu_name}</a></li>
                                        </ul>
                                    </c:forEach>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="app-sidebar-overlay d-none animated fadeIn"></div>
        <div class="app-main__outer">
            <div class="app-main__inner">