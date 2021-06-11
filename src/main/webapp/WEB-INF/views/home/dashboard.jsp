<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.addHeader("Cache-Control","no-store");
    response.setDateHeader("Expires",0);
%>
<jsp:include page = '<%="../common/vd_header.jsp" %>'/>
<div class="header-mobile-wrapper">
    <div class="app-header__logo">
        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Smart Box Admin" class="logo-src"></a>
        <button type="button" class="hamburger hamburger--elastic mobile-toggle-sidebar-nav">
                <span class="hamburger-box">
                    <span class="hamburger-inner"></span>
                </span>
        </button>
        <div class="app-header__menu">
            <span>
                <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                    <span class="btn-icon-wrapper">
                        <i class="fa fa-ellipsis-v fa-w-6"></i>
                    </span>
                </button>
            </span>
        </div>
    </div>
</div>
<div class="app-inner-layout app-inner-layout-page" style>
    <jsp:include page = '<%="../common/vd_top_tabmenu.jsp" %>'/>
    <div class="app-inner-layout__wrapper">
        <div class="app-inner-layout__content">
            <div class="container-fluid">
                <div class="mb-3 card">
                    <div class="card-header-tab card-header">
                        <div class="card-header-title font-size-lg text-capitalize font-weight-normal">
                            <i class="header-icon lnr-charts icon-gradient bg-happy-green"> </i>
                            주요현황
                        </div>
                        <div class="btn-actions-pane-right text-capitalize">
                            <button class="btn-wide btn-outline-2x mr-md-2 btn btn-outline-focus btn-sm">
                                View All
                            </button>
                        </div>
                    </div>
                    <div class="no-gutters row">
                        <div class="col-sm-20p col-md-2 col-xl-20p">
                            <div class="row">
                                <div class="col-sm-12 col-lg-12 text-center">
                                    일일거래량
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 col-lg-12">
                                    <div class="card no-shadow rm-border bg-transparent widget-chart text-left">
                                        <div class="icon-wrapper rounded-circle">
                                            <div class="icon-wrapper-bg opacity-10 bg-warning"></div>
                                            <i class="lnr-laptop-phone text-dark opacity-8"></i></div>
                                        <div class="widget-chart-content">
                                            <div class="widget-numbers">${todayPayCount}건</div>
                                            <div class="widget-description opacity-8 text-focus">
                                                <div class="d-inline text-danger pr-1">
                                                    <i class="fa fa-angle-up"></i>
                                                    <span class="pl-1">
                                                        <a href="#" data-toggle="tooltip" data-placement="bottom"
                                                           title="&nbsp;&nbsp;&nbsp;&nbsp;전일대비증감 : ${rateChangeCount}건&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                           신규결재 : ${rateChangeCount}건(추가개발필요)" >${rateChangeCount}건</a>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="divider m-0 d-md-none d-sm-block"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-20p col-md-2 col-xl-20p">
                            <div class="row">
                                <div class="col-sm-12 col-lg-12 text-center">
                                    환불접수
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 col-lg-12">
                                    <div class="card no-shadow rm-border bg-transparent widget-chart text-left">
                                        <div class="icon-wrapper rounded-circle">
                                            <div class="icon-wrapper-bg opacity-9 bg-danger"></div>
                                            <i class="lnr-graduation-hat text-white"></i></div>
                                        <div class="widget-chart-content">
                                            <div class="widget-numbers">10건</div>
                                            <div class="widget-description opacity-8 text-focus">
                                                <div class="d-inline text-info pr-1">
                                                    <i class="fa fa-angle-down"></i>
                                                    <span class="pl-1">
                                                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="전일대비 : 1건" >1건</a>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="divider m-0 d-md-none d-sm-block"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-20p col-md-2 col-xl-20p">
                            <div class="row">
                                <div class="col-sm-12 col-lg-12 text-center">
                                    유저문의
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 col-lg-12">
                                    <div class="card no-shadow rm-border bg-transparent widget-chart text-left">
                                        <div class="icon-wrapper rounded-circle">
                                            <div class="icon-wrapper-bg opacity-9 bg-info"></div>
                                            <i class="lnr-question-circle text-white"></i></div>
                                        <div class="widget-chart-content">
                                            <div class="widget-numbers">10건</div>
                                        </div>
                                    </div>
                                    <div class="divider m-0 d-md-none d-sm-block"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-20p col-md-2 col-xl-20p">
                            <div class="row">
                                <div class="col-sm-12 col-lg-12 text-center">
                                    관리자문의
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 col-lg-12">
                                    <div class="card no-shadow rm-border bg-transparent widget-chart text-left">
                                        <div class="icon-wrapper rounded-circle">
                                            <div class="icon-wrapper-bg opacity-9 bg-success"></div>
                                            <i class="lnr-user text-white"></i></div>
                                        <div class="widget-chart-content">
                                            <div class="widget-numbers">10건</div>
                                        </div>
                                    </div>
                                    <div class="divider m-0 d-md-none d-sm-block"></div>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-20p col-md-2 col-xl-20p">
                            <div class="row">
                                <div class="col-sm-12 col-lg-12 text-center">
                                    박스상태
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 col-lg-12">
                                    <div class="card no-shadow rm-border bg-transparent widget-chart text-left">
                                        <div class="icon-wrapper rounded-circle">
                                            <div class="icon-wrapper-bg opacity-9 bg-primary"></div>
                                            <i class="pe-7s-box2 text-white"></i></div>
                                        <div class="widget-chart-content">
                                            <div class="widget-numbers">10건</div>
                                        </div>
                                    </div>
                                    <div class="divider m-0 d-md-none d-sm-block"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="text-center d-block p-3 card-footer">
                        <button class="btn-pill btn-wide fsize-1 btn btn-primary">
                                <span class="mr-2 opacity-7">
                                    <i class="icon icon-anim-pulse ion-ios-analytics-outline"></i>
                                </span>
                            <span class="mr-1">View Complete Report</span>
                        </button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 col-lg-6">
                        <div class="mb-3 card">
                            <div class="card-header-tab card-header">
                                <div class="card-header-title font-size-lg text-capitalize font-weight-normal">
                                    <i class="header-icon lnr-cloud-download icon-gradient bg-happy-itmeo"> </i>
                                    일별결제금액 (최근 7일)
                                </div>
                                <div class="btn-actions-pane-right text-capitalize actions-icon-btn">
                                    <div class="btn-group dropdown">
                                        <button type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn-icon btn-icon-only btn btn-link">
                                            <i class="pe-7s-menu btn-icon-wrapper"></i>
                                        </button>
                                        <div tabindex="-1" role="menu" aria-hidden="true" class="dropdown-menu-right rm-pointers dropdown-menu-shadow dropdown-menu-hover-link dropdown-menu">
                                            <h6 tabindex="-1" class="dropdown-header">Header</h6>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-inbox"> </i><span>Menus</span>
                                            </button>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-file-empty"> </i><span>Settings</span>
                                            </button>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-book"> </i><span>Actions</span>
                                            </button>
                                            <div tabindex="-1" class="dropdown-divider"></div>
                                            <div class="p-3 text-right">
                                                <button class="mr-2 btn-shadow btn-sm btn btn-link">
                                                    View Details
                                                </button>
                                                <button class="mr-2 btn-shadow btn-sm btn btn-primary">
                                                    Action
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="p-0 card-body">
                                <table class="mb-0 table">
                                    <thead>
                                    <tr>
                                        <th class="text-center">날짜</th>
                                        <th class="text-right pr-lg-4">결제금액</th>
                                        <th class="text-center">객수</th>
                                        <th class="text-right pr-lg-4">객단가</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${paymentPerDayListInfo}" var="rows" varStatus="paymentPerDayList">
                                    <tr>
                                        <td scope="row" class="text-center">${rows.daytime}</td>
                                        <td class="text-right pr-lg-4">${rows.amount_per_day_form}</td>
                                        <td class="text-center">${rows.customer_cnt}</td>
                                        <td class="text-right pr-lg-4">${rows.amount_per_customer_form}</td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-lg-6">
                        <div class="mb-3 card">
                            <div class="card-header-tab card-header">
                                <div class="card-header-title font-size-lg text-capitalize font-weight-normal">
                                    <i class="header-icon lnr-cloud-download icon-gradient bg-happy-itmeo"> </i>
                                    월별결제금액 (최근 6개월)
                                </div>
                                <div class="btn-actions-pane-right text-capitalize actions-icon-btn">
                                    <div class="btn-group dropdown">
                                        <button type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn-icon btn-icon-only btn btn-link">
                                            <i class="pe-7s-menu btn-icon-wrapper"></i>
                                        </button>
                                        <div tabindex="-1" role="menu" aria-hidden="true" class="dropdown-menu-right rm-pointers dropdown-menu-shadow dropdown-menu-hover-link dropdown-menu">
                                            <h6 tabindex="-1" class="dropdown-header">Header</h6>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-inbox"> </i><span>Menus</span>
                                            </button>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-file-empty"> </i><span>Settings</span>
                                            </button>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-book"> </i><span>Actions</span>
                                            </button>
                                            <div tabindex="-1" class="dropdown-divider"></div>
                                            <div class="p-3 text-right">
                                                <button class="mr-2 btn-shadow btn-sm btn btn-link">
                                                    View Details
                                                </button>
                                                <button class="mr-2 btn-shadow btn-sm btn btn-primary">
                                                    Action
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="p-0 card-body">
                                <table class="mb-0 table">
                                    <thead>
                                    <tr>
                                        <th class="text-center">월</th>
                                        <th class="text-right pr-lg-4">결제금액</th>
                                        <th class="text-center">객수</th>
                                        <th class="text-right pr-lg-4">객단가</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${paymentPerMonthListInfo}" var="rows" varStatus="paymentPerMonthList">
                                        <tr>
                                            <td scope="row" class="text-center">${rows.daytime}</td>
                                            <td class="text-right pr-lg-4">${rows.amount_per_month_form}</td>
                                            <td class="text-center">${rows.customer_cnt}</td>
                                            <td class="text-right pr-lg-4">${rows.amount_per_customer_form}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 col-lg-6">
                        <div class="mb-3 card">
                            <div class="card-header-tab card-header">
                                <div class="card-header-title font-size-lg text-capitalize font-weight-normal">
                                    <i class="header-icon lnr-cloud-download icon-gradient bg-happy-itmeo"> </i>
                                    5월 상품 판매량 TOP 10
                                </div>
                                <div class="btn-actions-pane-right text-capitalize actions-icon-btn">
                                    <div class="btn-group dropdown">
                                        <button type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn-icon btn-icon-only btn btn-link">
                                            <i class="pe-7s-menu btn-icon-wrapper"></i>
                                        </button>
                                        <div tabindex="-1" role="menu" aria-hidden="true" class="dropdown-menu-right rm-pointers dropdown-menu-shadow dropdown-menu-hover-link dropdown-menu">
                                            <h6 tabindex="-1" class="dropdown-header">Header</h6>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-inbox"> </i><span>Menus</span>
                                            </button>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-file-empty"> </i><span>Settings</span>
                                            </button>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-book"> </i><span>Actions</span>
                                            </button>
                                            <div tabindex="-1" class="dropdown-divider"></div>
                                            <div class="p-3 text-right">
                                                <button class="mr-2 btn-shadow btn-sm btn btn-link">
                                                    View Details
                                                </button>
                                                <button class="mr-2 btn-shadow btn-sm btn btn-primary">
                                                    Action
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="p-0 card-body">
                                <table class="mb-0 table">
                                    <thead>
                                    <tr>
                                        <th>순위</th>
                                        <th class="text-center">상품명</th>
                                        <th>판매량</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${lastMonthSalesTopListInfo}" var="rows" varStatus="lastMonthSalesTopList">
                                        <tr>
                                            <td scope="row" class="text-center">${lastMonthSalesTopList.count}</td>
                                            <td class="pl-lg-5">${rows.goods_name}</td>
                                            <td class="text-right pr-lg-4">${rows.sales_cnt}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-lg-6">
                        <div class="mb-3 card">
                            <div class="card-header-tab card-header">
                                <div class="card-header-title font-size-lg text-capitalize font-weight-normal">
                                    <i class="header-icon lnr-cloud-download icon-gradient bg-happy-itmeo"> </i>
                                    5월 박스 매출 TOP 10
                                </div>
                                <div class="btn-actions-pane-right text-capitalize actions-icon-btn">
                                    <div class="btn-group dropdown">
                                        <button type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn-icon btn-icon-only btn btn-link">
                                            <i class="pe-7s-menu btn-icon-wrapper"></i>
                                        </button>
                                        <div tabindex="-1" role="menu" aria-hidden="true" class="dropdown-menu-right rm-pointers dropdown-menu-shadow dropdown-menu-hover-link dropdown-menu">
                                            <h6 tabindex="-1" class="dropdown-header">Header</h6>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-inbox"> </i><span>Menus</span>
                                            </button>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-file-empty"> </i><span>Settings</span>
                                            </button>
                                            <button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-book"> </i><span>Actions</span>
                                            </button>
                                            <div tabindex="-1" class="dropdown-divider"></div>
                                            <div class="p-3 text-right">
                                                <button class="mr-2 btn-shadow btn-sm btn btn-link">
                                                    View Details
                                                </button>
                                                <button class="mr-2 btn-shadow btn-sm btn btn-primary">
                                                    Action
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="p-0 card-body">
                                <table class="mb-0 table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Username</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Mark</td>
                                        <td>Otto</td>
                                        <td>@mdo</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Jacob</td>
                                        <td>Thornton</td>
                                        <td>@fat</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>Larry</td>
                                        <td>the Bird</td>
                                        <td>@twitter</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="card no-shadow bg-transparent no-border rm-borders mb-3">
                    <div class="card">
                        <div class="no-gutters row">
                            <div class="col-md-12 col-lg-4">
                                <ul class="list-group list-group-flush">
                                    <li class="bg-transparent list-group-item">
                                        <div class="widget-content p-0">
                                            <div class="widget-content-outer">
                                                <div class="widget-content-wrapper">
                                                    <div class="widget-content-left">
                                                        <div class="widget-heading">Total Orders
                                                        </div>
                                                        <div class="widget-subheading">Last year
                                                            expenses
                                                        </div>
                                                    </div>
                                                    <div class="widget-content-right">
                                                        <div class="widget-numbers text-success">
                                                            1896
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="bg-transparent list-group-item">
                                        <div class="widget-content p-0">
                                            <div class="widget-content-outer">
                                                <div class="widget-content-wrapper">
                                                    <div class="widget-content-left">
                                                        <div class="widget-heading">Clients</div>
                                                        <div class="widget-subheading">Total Clients
                                                            Profit
                                                        </div>
                                                    </div>
                                                    <div class="widget-content-right">
                                                        <div class="widget-numbers text-primary">
                                                            $12.6k
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-md-12 col-lg-4">
                                <ul class="list-group list-group-flush">
                                    <li class="bg-transparent list-group-item">
                                        <div class="widget-content p-0">
                                            <div class="widget-content-outer">
                                                <div class="widget-content-wrapper">
                                                    <div class="widget-content-left">
                                                        <div class="widget-heading">Followers</div>
                                                        <div class="widget-subheading">People
                                                            Interested
                                                        </div>
                                                    </div>
                                                    <div class="widget-content-right">
                                                        <div class="widget-numbers text-danger">
                                                            45,9%
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="bg-transparent list-group-item">
                                        <div class="widget-content p-0">
                                            <div class="widget-content-outer">
                                                <div class="widget-content-wrapper">
                                                    <div class="widget-content-left">
                                                        <div class="widget-heading">Products Sold
                                                        </div>
                                                        <div class="widget-subheading">Total revenue
                                                            streams
                                                        </div>
                                                    </div>
                                                    <div class="widget-content-right">
                                                        <div class="widget-numbers text-warning">
                                                            $3M
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-md-12 col-lg-4">
                                <ul class="list-group list-group-flush">
                                    <li class="bg-transparent list-group-item">
                                        <div class="widget-content p-0">
                                            <div class="widget-content-outer">
                                                <div class="widget-content-wrapper">
                                                    <div class="widget-content-left">
                                                        <div class="widget-heading">Total Orders
                                                        </div>
                                                        <div class="widget-subheading">Last year
                                                            expenses
                                                        </div>
                                                    </div>
                                                    <div class="widget-content-right">
                                                        <div class="widget-numbers text-success">
                                                            1896
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="bg-transparent list-group-item">
                                        <div class="widget-content p-0">
                                            <div class="widget-content-outer">
                                                <div class="widget-content-wrapper">
                                                    <div class="widget-content-left">
                                                        <div class="widget-heading">Clients</div>
                                                        <div class="widget-subheading">Total Clients
                                                            Profit
                                                        </div>
                                                    </div>
                                                    <div class="widget-content-right">
                                                        <div class="widget-numbers text-primary">
                                                            $12.6k
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page = '<%="../common/vd_footer.jsp" %>'/>
