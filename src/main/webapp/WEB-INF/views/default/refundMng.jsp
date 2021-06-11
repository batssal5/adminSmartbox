<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
                <div class="col-sm-12 col-lg-12 mb-3">
                    <h5>어플관리 > 환불설정</h5>
                </div>
                <form actoion="#" method="post">
                    <div class="row card mb-3">
                        <div class="col-sm-12 col-lg-12">
                            <div class="card-body col-sm-12 col-lg-12">
                                <table class="mb-0 table">
                                    <tbody>
                                    <tr>
                                        <th style="width: 200px">환불신청</th>
                                        <td style="min-width: 130px;">
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block; min-width: 130px">
                                                        <input type="radio"
                                                               id="refund_radio"
                                                               name="refund"
                                                               class="custom-control-input">
                                                        <label
                                                                class="custom-control-label"
                                                                for="refund_radio">어플신청</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="refund_radio2"
                                                               name="refund_radio"
                                                               class="custom-control-input">
                                                        <label
                                                                class="custom-control-label"
                                                                for="refund_radio2">환불불가</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="width: 200px">환불신청기간</th>
                                        <td>
                                            <div style="min-width: 130px">
                                                <input type="number" min="0" max="60" name="refund_day"/>
                                                <span style="margin-right: 50px;"> 일</span>
                                                <input type="number" min="0" max="24" name="refund_hour"/>
                                                <span> 시간</span>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 col-lg-12" style="text-align: center; margin-top: 20px">
                            <button type="button" class="btn btn-danger" style="width: 100px">취소</button>
                            <input type="submit" class="btn btn-success" value="저장" style="width: 100px"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page='<%="../common/vd_footer.jsp" %>'/>
