<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page='<%="../common/vd_header.jsp" %>'/>
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
    <jsp:include page='<%="../common/vd_top_tabmenu.jsp" %>'/>
    <div class="app-inner-layout__wrapper">
        <div class="app-inner-layout__content">
            <div class="container-fluid">
                <form id="que_form" name="que_form" method="post">
                    <div class="row">
                        <div class="col-sm-12 col-lg-12">
                            <h5>관리자 > 관리자1:1문의</h5>
                        </div>
                        <div class="col-sm-12 col-lg-6 card">
                            <div class="card-body">
                                <table class="mb-0 table">
                                    <tbody>
                                    <tr>
                                        <th>본사명</th>
                                        <td>
                                            <select id="agency_select" class="form-control" style="width: 100%"
                                                    onchange="agencySelect()">
                                                <option value="0">전체</option>
                                                <c:forEach var="agc" items="${agcList}">
                                                    <option value="${agc.agc_idx}">${agc.company_name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>본사사업자번호</th>
                                        <td><input id="company_num" name="company_num" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>아이디</th>
                                        <td><input id="id" name="id" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>이름</th>
                                        <td><input id="name" name="name" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>관리자등급</th>
                                        <td>
                                            <select id="rate_select" name="rate" class="form-control" style="width: 100%">
                                                <option value="0">전체</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>휴대전화</th>
                                        <td><input id="mobile" name="mobile" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>이메일</th>
                                        <td><input id="email" name="email" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>메모</th>
                                        <td><input id="memo" name="memo" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-6 card">
                            <div class="card-body">
                                <table class="mb-0 table">
                                    <tbody>
                                    <tr>
                                        <th>근무지점</th>
                                        <td>
                                            <select id="store_select" class="form-control" style="width: 100%">
                                                <option value="0">전체</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>지점사업자번호</th>
                                        <td><input id="store_num" name="store_num" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>일반전화</th>
                                        <td><input id="tel" name="tel" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>카테고리</th>
                                        <td>
                                            <select id="cate_select" name="cate" class="form-control" style="width: 100%">
                                                <option value="0">선택</option>
                                                <option value="1">회원관리</option>
                                                <option value="2">판매/결제</option>
                                                <option value="3">상품</option>
                                                <option value="4">취소/반품/교환</option>
                                                <option value="5">서비스/불편사항</option>
                                                <option value="6">기타</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>제목</th>
                                        <td><input id="title" name="title" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>내용</th>
                                        <td><input id="contents" name="contents" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>답변여부</th>
                                        <td>
                                            <select id="status_select" name="status" class="form-control" style="width: 100%">
                                                <option value="-1">선택</option>
                                                <option value="0">Y</option>
                                                <option value="1">N</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>등록일</th>
                                        <td><input id="regdate" name="regdate" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-12 col-lg-12" style="text-align: center;">
                            <button type="button" class="btn btn-secondary">초기화</button>
                            <button type="button" class="btn btn-secondary" onclick="que_search()">조회</button>
                        </div>
                    </div>
                </form>
                <div class="main-card card">
                    <div class="row">
                        <div class="col-sm-12 col-lg-12">
                            <div class="mb-3">
                                <div class="card-body">
                                    <table class="mb-0 table table-hover">
                                        <thead>
                                        <tr>
                                            <th>순번</th>
                                            <th>아이디</th>
                                            <th>이름</th>
                                            <th>본사명</th>
                                            <th>근무지점</th>
                                            <th>카테고리</th>
                                            <th>제목</th>
                                            <th>답변여부</th>
                                            <th>등록일</th>
                                        </tr>
                                        </thead>
                                        <tbody id="que_search">
                                        <c:forEach var="quelist" items="${agency_quelist}">
                                            <tr>
                                                <td>${quelist.idx}</td>
                                                <td style="display: none">${quelist.agc_idx}</td>
                                                <td>${quelist.id}</td>
                                                <td>${quelist.name}</td>
                                                <td>${quelist.company_name}</td>
                                                <td>${quelist.store_name}</td>
                                                <td>${quelist.cate}</td>
                                                <td>${quelist.title}</td>
                                                <td>${quelist.status == 0 ? "N" : "Y"}</td>
                                                <td><fmt:formatDate value="${quelist.regdate}"
                                                                    pattern="yyyy.MM.dd HH:mm"/></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 col-md-7">
                            <div class="dataTables_paginate paging_simple_numbers"
                                 style="float: right;">
                                <ul class="pagination">
                                    <li class="paginate_button page-item previous disabled"><a
                                            href="#" aria-controls="" data-dt-idx="0" tabindex="0"
                                            class="page-link">prev</a></li>
                                    <li class="paginate_button page-item active"><a href="#"
                                                                                    aria-controls="example"
                                                                                    data-dt-idx="1" tabindex="0"
                                                                                    class="page-link">1</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example" data-dt-idx="2"
                                                                              tabindex="0"
                                                                              class="page-link">2</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example" data-dt-idx="3"
                                                                              tabindex="0"
                                                                              class="page-link">3</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example" data-dt-idx="4"
                                                                              tabindex="0"
                                                                              class="page-link">4</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example" data-dt-idx="5"
                                                                              tabindex="0"
                                                                              class="page-link">5</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example" data-dt-idx="6"
                                                                              tabindex="0"
                                                                              class="page-link">6</a></li>
                                    <li class="paginate_button page-item next" id="example_next"><a
                                            href="#" aria-controls="example" data-dt-idx="7" tabindex="0"
                                            class="page-link">next</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-5">
                            <button type="button" class="btn btn-success" onclick="">다운로드</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page='<%="../common/vd_footer.jsp" %>'/>
