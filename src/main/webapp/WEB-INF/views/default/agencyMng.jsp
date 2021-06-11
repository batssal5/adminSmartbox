<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='<%="../common/vd_header.jsp"%>'/>
<div class="header-mobile-wrapper">
    <div class="app-header__logo">
        <a href="#" data-toggle="tooltip" data-placement="bottom"
           title="Smart Box Admin" class="logo-src"></a>
        <button type="button"
                class="hamburger hamburger--elastic mobile-toggle-sidebar-nav">
			<span class="hamburger-box"> <span class="hamburger-inner"></span>
			</span>
        </button>
        <div class="app-header__menu">
			<span>
				<button type="button"
                        class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
					<span class="btn-icon-wrapper"> <i
                            class="fa fa-ellipsis-v fa-w-6"></i>
					</span>
				</button>
			</span>
        </div>
    </div>
</div>
<div class="app-inner-layout app-inner-layout-page" style>
    <jsp:include page='<%="../common/vd_top_tabmenu.jsp"%>'/>
    <div class="app-inner-layout__wrapper">
        <div class="app-inner-layout__content">
            <div class="container-fluid">
                <form action="#">
                    <div class="row">
                        <div class="col-sm-12 col-lg-12">
                            <h5>사업관리자 > 사업자설정</h5>
                        </div>
                        <div class="col-sm-12 col-lg-6 card">
                            <div class="card-body">
                                <table class="mb-0 table">
                                    <tbody>
                                    <tr>
                                        <th>본사명</th>
                                        <td>
                                                <select class="multiselect-dropdown form-control" data-select2-id="1" style="width: 100%">
                                                    <option selected>전체</option>
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>본사사업자번호</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>담당자명</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>휴대전화</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>일반전화</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>주소</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>등록일자</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>메모</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
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
                                        <th>지점명</th>
                                        <td>
                                            <select class="multiselect-dropdown form-control" data-select2-id="1" style="width: 100%">
                                                <option selected>전체</option>
                                                <option value="1">One</option>
                                                <option value="2">Two</option>
                                                <option value="3">Three</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>지점사업자번호</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>상권</th>
                                        <td>
                                            <select class="multiselect-dropdown form-control" data-select2-id="1" style="width: 100%">
                                                <option selected>전체</option>
                                                <option value="1">One</option>
                                                <option value="2">Two</option>
                                                <option value="3">Three</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>PG수수료</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>VD수수료</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>이메일</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>계약여부</th>
                                        <td>
                                            <select class="multiselect-dropdown form-control" data-select2-id="1" style="width: 100%">
                                                <option selected>전체</option>
                                                <option value="1">One</option>
                                                <option value="2">Two</option>
                                                <option value="3">Three</option>
                                            </select>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 col-lg-12" style="text-align: center;">
                            <button type="button" class="btn btn-secondary">초기화</button>
                            <input type="submit" class="btn btn-secondary" value="조회">
                            <button type="button" class="btn btn-info" style="float: right;"
                                    onclick="">등록
                            </button>
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
                                            <th>본사명</th>
                                            <th>본사사업자번호</th>
                                            <th>지점명</th>
                                            <th>지점사업자번호</th>
                                            <th>PG수수료</th>
                                            <th>VD수수료</th>
                                            <th>계약여부</th>
                                            <th>등록일자</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="list" items="list">
                                            <tr>
                                                <td>dd</td>
                                                <td>dd</td>
                                                <td>dd</td>
                                                <td>dd</td>
                                                <td>dd</td>
                                                <td>dd</td>
                                                <td>dd</td>
                                                <td>dd</td>
                                                <td>dd</td>
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

<jsp:include page='<%="../common/vd_footer.jsp"%>'/>
