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
    $(function () {
        getAuth();
    });

    function getAuth() {
        $.ajax({
            url: "/default/ajax_getAppAuth",
            type: "GET",
            success: function (responseData) {
                var data = JSON.parse(responseData);

                //안드로이드 접속제한
                if ((data[0]["c_auth_conn"]) == 0) {
                    $('#a_connect_on').attr('checked', true);
                } else {
                    $('#a_connect_off').attr('checked', true);
                }

                //iOS 접속제한
                if ((data[1]["c_auth_conn"]) == 0) {
                    $('#i_connect_on').attr('checked', true);
                } else {
                    $('#i_connect_off').attr('checked', true);
                }

                //안드로이드 구매제한
                if ((data[0]["c_auth_purchase"]) == 0) {
                    $('#a_purchase_on').attr('checked', true);
                } else {
                    $('#a_purchase_off').attr('checked', true);
                }

                //iOS 구매제한
                if ((data[1]["c_auth_purchase"]) == 0) {
                    $('#i_purchase_on').attr('checked', true);
                } else {
                    $('#i_purchase_off').attr('checked', true);
                }

                //안드로이드 관리자 재고관리제한
                if ((data[0]["a_auth_inventory"]) == 0) {
                    $('#a_inventory_on').attr('checked', true);
                } else {
                    $('#a_inventory_off').attr('checked', true);
                }

                //iOS 관리자 재고관리제한
                if ((data[1]["a_auth_inventory"]) == 0) {
                    $('#i_inventory_on').attr('checked', true);
                } else {
                    $('#i_inventory_off').attr('checked', true);
                }

                //자동로그아웃
                $('#a_user_autoLogout').val(data[0]["c_auto_logout_min"]);
                $('#i_user_autoLogout').val(data[1]["c_auto_logout_min"]);
                $('#a_admin_autoLogout').val(data[0]["a_auto_logout_min"]);
                $('#i_admin_autoLogout').val(data[1]["a_auto_logout_min"]);

            }
        });
    };

    function AuthSave() {

        var params = $('#authForm').serialize();

        $.ajax({
            url: "/default/ajax_postAppAuth",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            data: params,
            success: function () {
                alert("수정완료")
            }
        });

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
            <div class="container-fluid">
                <div class="col-sm-12 col-lg-12 mb-3">
                    <h5>어플관리 > 제한설정</h5>
                </div>
                <form id="authForm" name="authForm" method="post">
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
                                                               id="a_connect_on"
                                                               name="a_connect"
                                                               class="custom-control-input"
                                                               value="0"><label
                                                                class="custom-control-label"
                                                                for="a_connect_on">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="a_connect_off"
                                                               name="a_connect"
                                                               class="custom-control-input"
                                                               value="1"><label
                                                                class="custom-control-label"
                                                                for="a_connect_off">off</label>
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
                                                               id="i_connect_on"
                                                               name="i_connect"
                                                               class="custom-control-input"
                                                               value="0"><label
                                                                class="custom-control-label"
                                                                for="i_connect_on">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="i_connect_off"
                                                               name="i_connect"
                                                               class="custom-control-input"
                                                               value="1"><label
                                                                class="custom-control-label"
                                                                for="i_connect_off">off</label>
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
                                                               id="a_purchase_on"
                                                               name="a_purchase"
                                                               class="custom-control-input"
                                                               value="0"><label
                                                            class="custom-control-label"
                                                            for="a_purchase_on">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="a_purchase_off"
                                                               name="a_purchase"
                                                               class="custom-control-input"
                                                               value="1"><label
                                                            class="custom-control-label"
                                                            for="a_purchase_off">off</label>
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
                                                               id="i_purchase_on"
                                                               name="i_purchase"
                                                               class="custom-control-input"
                                                               value="0"><label
                                                            class="custom-control-label"
                                                            for="i_purchase_on">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="i_purchase_off"
                                                               name="i_purchase"
                                                               class="custom-control-input"
                                                               value="1"><label
                                                            class="custom-control-label"
                                                            for="i_purchase_off">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>자동로그아웃</th>
                                        <td>
                                            <input id="a_user_autoLogout" name="a_user_autoLogout" type="number" min="0"
                                                   max="60"/>
                                            <span> 분 이후</span>
                                        </td>

                                        <td>
                                            <input id="i_user_autoLogout" name="i_user_autoLogout" type="number" min="0"
                                                   max="60"/>
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
                                                               id="a_inventory_on"
                                                               name="a_inventory"
                                                               class="custom-control-input"
                                                               value="0"><label
                                                            class="custom-control-label"
                                                            for="a_inventory_on">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="a_inventory_off"
                                                               name="a_inventory"
                                                               class="custom-control-input"
                                                               value="1"><label
                                                            class="custom-control-label"
                                                            for="a_inventory_off">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="i_inventory_on"
                                                               name="i_inventory"
                                                               class="custom-control-input"
                                                               value="0"><label
                                                            class="custom-control-label"
                                                            for="i_inventory_on">on</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="i_inventory_off"
                                                               name="i_inventory"
                                                               class="custom-control-input"
                                                               value="1"><label
                                                            class="custom-control-label"
                                                            for="i_inventory_off">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>자동로그아웃</th>
                                        <td>
                                            <input id="a_admin_autoLogout" name="a_admin_auto_logout" type="number"
                                                   min="0" max="60"/>
                                            <span> 분 이후</span>
                                        </td>
                                        <td>
                                            <input id="i_admin_autoLogout" name="i_admin_auto_logout" type="number"
                                                   min="0" max="60"/>
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
                            <button type="button" class="btn btn-success" onclick="AuthSave()" style="width: 100px; float: right">저장
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page='<%="../common/vd_footer.jsp" %>'/>
