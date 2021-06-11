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
                    <h5>어플관리 > 제한설정</h5>
                </div>
                <form actoion="#" method="post">
                    <div class="row card mb-3">
                        <div class="col-sm-12 col-lg-12">
                            <div class="card-header">
                                <h5>유저어플</h5>
                            </div>
                            <div class="card-body col-sm-12 col-lg-12">
                                <table class="mb-0 table">
                                    <thead>
                                    <tr>
                                        <th style="border: none"></th>
                                        <th style="border: none">안드로이드</th>
                                        <th style="border: none">iOS</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>접속제한</th>
                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="user_connect_radio"
                                                               name="user_android_connect"
                                                               class="custom-control-input">
                                                        <label
                                                                class="custom-control-label"
                                                                for="user_connect_radio">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="user_connect_radio2"
                                                               name="user_android_connect"
                                                               class="custom-control-input">
                                                        <label
                                                                class="custom-control-label"
                                                                for="user_connect_radio2">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>

                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="user_connect_radio3"
                                                               name="user_ios_connect"
                                                               class="custom-control-input">
                                                        <label
                                                                class="custom-control-label"
                                                                for="user_connect_radio3">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="user_connect_radio4"
                                                               name="user_ios_connect"
                                                               class="custom-control-input">
                                                        <label
                                                                class="custom-control-label"
                                                                for="user_connect_radio4">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>구매제한</th>
                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="user_buy_radio"
                                                               name="user_android_buy"
                                                               class="custom-control-input"><label
                                                            class="custom-control-label"
                                                            for="user_buy_radio">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="user_buy_radio2"
                                                               name="user_android_buy"
                                                               class="custom-control-input"><label
                                                            class="custom-control-label"
                                                            for="user_buy_radio2">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>

                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="user_buy_radio3"
                                                               name="user_ios_buy"
                                                               class="custom-control-input"><label
                                                            class="custom-control-label"
                                                            for="user_buy_radio3">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="user_buy_radio4"
                                                               name="user_ios_buy"
                                                               class="custom-control-input"><label
                                                            class="custom-control-label"
                                                            for="user_buy_radio4">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>자동로그아웃</th>
                                        <td>
                                            <input type="number" min="0" max="60" name="user_android_timeout"/>
                                            <span> 분 이후</span>
                                        </td>

                                        <td>
                                            <input type="number" min="0" max="60" name="user_ios_timeout"/>
                                            <span> 분 이후</span>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row card">
                        <div class="col-sm-12 col-lg-12">
                            <div class="card-header">
                                <h5>관리자어플</h5>
                            </div>
                            <div class="card-body col-sm-12 col-lg-12">
                                <table class="mb-0 table">
                                    <thead>
                                    <tr>
                                        <th style="border: none"></th>
                                        <th style="border: none">안드로이드</th>
                                        <th style="border: none">iOS</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>재고관리제한</th>
                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="admin_radio"
                                                               name="admin_android_stock"
                                                               class="custom-control-input"><label
                                                            class="custom-control-label"
                                                            for="admin_radio">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="admin_radio2"
                                                               name="admin_android_stock"
                                                               class="custom-control-input"><label
                                                            class="custom-control-label"
                                                            for="admin_radio2">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="admin_radio3"
                                                               name="admin_ios_stock"
                                                               class="custom-control-input"><label
                                                            class="custom-control-label"
                                                            for="admin_radio3">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="admin_radio4"
                                                               name="admin_ios_stock"
                                                               class="custom-control-input"><label
                                                            class="custom-control-label"
                                                            for="admin_radio4">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>자동로그아웃</th>
                                        <td>
                                            <input type="number" min="0" max="60" name="admin_android_timeout"/>
                                            <span> 분 이후</span>
                                        </td>
                                        <td>
                                            <input type="number" min="0" max="60" name="admin_ios_timeout"/>
                                            <span> 분 이후</span>
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
