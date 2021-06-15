<%
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.addHeader("Cache-Control","no-store");
    response.setDateHeader("Expires",0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<div class="app-inner-bar">
    <div class="inner-bar-center">
        <ul class="nav">
            <li class="nav-item" >
                <a role="tab" data-toggle="tab" class="nav-link active" href="#"  onclick="location.href='/home/dashboard'">
                    <span>홈</span>
                </a>
            </li>
            <li class="nav-item">
                <a role="tab" data-toggle="tab" class="nav-link" href="#"  onclick="location.href='/default/userApp'">
                    <span>기본설정</span>
                </a>
            </li>
            <li class="nav-item">
                <a role="tab" data-toggle="tab" class="nav-link" href="#"  onclick="location.href='/box/boxList'">
                    <span>박스</span>
                </a>
            </li>
            <li class="nav-item">
                <a role="tab" data-toggle="tab" class="nav-link" href="#"  onclick="location.href='/goods/goodsList'">
                    <span>상품</span>
                </a>
            </li>
            <li class="nav-item">
                <a role="tab" data-toggle="tab" class="nav-link" href="#"  onclick="location.href='/sales/paymentList'">
                    <span>판매</span>
                </a>
            </li>
            <li class="nav-item">
                <a role="tab" data-toggle="tab" class="nav-link" href="#"  onclick="location.href='/member/userList'">
                    <span>회원</span>
                </a>
            </li>
            <li class="nav-item">
                <a role="tab" data-toggle="tab" class="nav-link" href="#"  onclick="location.href='/board/agencyQuestion'">
                    <span>게시판</span>
                </a>
            </li>
            <li class="nav-item">
                <a role="tab" data-toggle="tab" class="nav-link" href="#"  onclick="location.href='/promotion/userList'">
                    <span>프로모션</span>
                </a>
            </li>
            <li class="nav-item">
                <a role="tab" data-toggle="tab" class="nav-link" href="#"  onclick="location.href='/marketing/bannerUserApp'">
                    <span>마케팅</span>
                </a>
            </li>
            <li class="nav-item">
                <a role="tab" data-toggle="tab" class="nav-link" href="#"  onclick="location.href='/statistics/bannerUserApp'">
                    <span>통계</span>
                </a>
            </li>
            <%--<li class="nav-item dropdown">
                <a data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                   class="nav-link opacity-8">
                    <span>More</span>
                    <i class="fa fa-angle-down ml-1 opacity-6"></i>
                </a>
                <div tabindex="-1" role="menu" aria-hidden="true"
                     class="dropdown-menu-right rm-pointers dropdown-menu-shadow dropdown-menu-hover-link dropdown-menu">
                    <h6 tabindex="-1" class="dropdown-header">Header</h6>
                    <button type="button" tabindex="0" class="dropdown-item"><i
                            class="dropdown-icon lnr-inbox"> </i><span>Menus</span></button>
                    <button type="button" tabindex="0" class="dropdown-item"><i
                            class="dropdown-icon lnr-file-empty"> </i><span>Settings</span></button>
                    <button type="button" tabindex="0" class="dropdown-item"><i
                            class="dropdown-icon lnr-book"> </i><span>Actions</span></button>
                    <div tabindex="-1" class="dropdown-divider"></div>
                    <div class="p-3 text-right">
                        <button class="mr-2 btn-shadow btn-sm btn btn-link">View Details</button>
                        <button class="mr-2 btn-shadow btn-sm btn btn-primary">Action</button>
                    </div>
                </div>
            </li>--%>
        </ul>
    </div>
</div>