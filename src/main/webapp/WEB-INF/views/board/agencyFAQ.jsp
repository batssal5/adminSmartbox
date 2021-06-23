<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page='<%="../common/vd_header.jsp" %>'/>
<script>
    function mainFluidHidden(){
        $('.main_fluid').hide();
        $('.sub_fluid').show();
    };
    function subFluidHidden(){
        $('.sub_fluid').hide();
        $('.main_fluid').show();
    };
</script>
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
            <div class="container-fluid main_fluid">
                <div class="col-sm-12 col-lg-12 mb-3">
                    <h5>관리자 > 관리자FAQ</h5>
                </div>
                <form actoion="#" method="post">
                    <div class="row card">
                        <div class="col-sm-12 col-lg-12">
                            <div class="card-body col-sm-12 col-lg-12">
                                <table class="mb-0 table">
                                    <tbody>
                                    <tr>
                                        <th>아이디</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                        <th>카테고리</th>
                                        <td>
                                            <select class="form-control" style="width: 100%">
                                                <option value="0">전체</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>이름</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                        <th>질문</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>휴대전화</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                        <th>답변</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>이메일</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                        <th>게시여부</th>
                                        <td>
                                            <select class="form-control" style="width: 100%">
                                                <option value="0">전체</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th></th><td></td>
                                        <th>등록일</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-12 col-lg-12" style="text-align: center;">
                            <button type="button" class="btn btn-secondary">초기화</button>
                            <button type="button" class="btn btn-secondary" onclick="store_search()">조회</button>
                            <button type="button" class="btn btn-info" style="float: right;"
                                    onclick="mainFluidHidden()">등록
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
                                            <th>아이디</th>
                                            <th>이름</th>
                                            <th>카테고리</th>
                                            <th>질문</th>
                                            <th>답변</th>
                                            <th>게시여부</th>
                                            <th>등록일</th>
                                        </tr>
                                        </thead>
                                        <tbody id="">
                                        <%--                                        <c:forEach var="" items="" varStatus="storeListName">--%>
                                        <%--                                            <tr>--%>
                                        <%--                                                <td>${}</td>--%>
                                        <%--                                                <td>${}</td>--%>
                                        <%--                                                <td>${}</td>--%>
                                        <%--                                                <td>${}</td>--%>
                                        <%--                                                <td>${}</td>--%>
                                        <%--                                                <td>${}</td>--%>
                                        <%--                                                <td>${}</td>--%>
                                        <%--                                                <td>${ == 0 ? "N" : "Y"}</td>--%>
                                        <%--                                                <td><fmt:formatDate value="${}"--%>
                                        <%--                                                                    pattern="yyyy.MM.dd HH:mm"/></td>--%>
                                        <%--                                            </tr>--%>
                                        <%--                                        </c:forEach>--%>
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
                                                                              aria-controls="example"
                                                                              data-dt-idx="2"
                                                                              tabindex="0"
                                                                              class="page-link">2</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example"
                                                                              data-dt-idx="3"
                                                                              tabindex="0"
                                                                              class="page-link">3</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example"
                                                                              data-dt-idx="4"
                                                                              tabindex="0"
                                                                              class="page-link">4</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example"
                                                                              data-dt-idx="5"
                                                                              tabindex="0"
                                                                              class="page-link">5</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example"
                                                                              data-dt-idx="6"
                                                                              tabindex="0"
                                                                              class="page-link">6</a></li>
                                    <li class="paginate_button page-item next"><a
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
            <%--mainfluid end--%>

            <div class="container-fluid sub_fluid" style="display: none">
                <div class="col-sm-12 col-lg-12 mb-3">
                    <h5>관리자 > 관리자FAQ</h5>
                </div>
                <form actoion="#" method="post">
                    <div class="row card">
                        <div class="col-sm-12 col-lg-12">
                            <div class="card-body col-sm-12 col-lg-12">
                                <table class="mb-0 table">
                                    <tbody>
                                    <tr>
                                        <th>카테고리</th>
                                        <td>
                                            <select class="form-control" style="width: 100%">
                                                <option value="0">선택</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>질문</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th>답변</th>
                                        <td><input name="" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-12 col-lg-12" style="text-align: center;">
                            <button type="button" class="btn btn-secondary">취소</button>
                            <button type="button" class="btn btn-info" style="float: right;"
                                    onclick="subFluidHidden()">저장
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page='<%="../common/vd_footer.jsp" %>'/>
