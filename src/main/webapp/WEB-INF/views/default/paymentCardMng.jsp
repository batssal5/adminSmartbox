<%
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.addHeader("Cache-Control","no-store");
    response.setDateHeader("Expires",0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page = '<%="../common/vd_header.jsp" %>'/>
<script>
    $(function (){
        getPayment();
    });

    function getPayment(){

        $.ajax({
            url:"/default/ajax_getPayment",
            type:"GET",
            success:function (responseData){
                var data = JSON.parse(responseData);
                console.log(data);

                $.each(data, function (index, item){
                    switch (item.idx){
                        case 1 :
                            if (item.pay_value == 0) {
                                $('#creditcard_app_on').attr('checked', true);
                            } else {
                                $('#creditcard_app_off').attr('checked', true);
                            }
                            break;
                        case 2 :
                            if (item.pay_value == 0) {
                                $('#creditcard_real_on').attr('checked', true);
                            } else {
                                $('#creditcard_real_off').attr('checked', true);
                            }
                            break;
                        case 3 :
                            if (item.pay_value == 0) {
                                $('#checkcard_app_on').attr('checked', true);
                            } else {
                                $('#checkcard_app_off').attr('checked', true);
                            }
                            break;
                        case 4 :
                            if (item.pay_value == 0) {
                                $('#checkcard_real_on').attr('checked', true);
                            } else {
                                $('#checkcard_real_off').attr('checked', true);
                            }
                            break;
                        default :
                            break;
                    };
                });
            }
        });
    };

    function postPayment(){

        var params = $('#payForm').serialize();

        $.ajax({
            url:"/default/ajax_postPayment",
            type: "POST",
            data: params,
            success:function (){
                alert("수정완료");
            }
        })

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
    <jsp:include page = '<%="../common/vd_top_tabmenu.jsp" %>'/>
    <div class="app-inner-layout__wrapper">
        <div class="app-inner-layout__content">
            <div class="container-fluid">
                <div class="col-sm-12 col-lg-12 mb-3">
                    <h5>결제수단관리 > 카드설정</h5>
                </div>
                <form id="payForm" name="payForm" method="post">
                    <div class="row card mb-3">
                        <div class="col-sm-12 col-lg-12">
                            <div class="card-body col-sm-12 col-lg-12">
                                <table class="mb-0 table">
                                    <thead>
                                    <tr>
                                        <th style="border: none"></th>
                                        <th style="border: none">어플 등록 카드</th>
                                        <th style="border: none">실물 플라스틱 카드</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>신용카드</th>
                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block; margin-right: 50px">
                                                        <input type="radio"
                                                               id="creditcard_app_on"
                                                               name="creditcard_app"
                                                               class="custom-control-input"
                                                               value="0"><label
                                                                class="custom-control-label"
                                                                for="creditcard_app_on">on</label></div>

                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="creditcard_app_off"
                                                               name="creditcard_app"
                                                               class="custom-control-input"
                                                               value="1"><label
                                                                class="custom-control-label"
                                                                for="creditcard_app_off">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>

                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block; margin-right: 50px">
                                                        <input type="radio"
                                                               id="creditcard_real_on"
                                                               name="creditcard_real"
                                                               class="custom-control-input"
                                                               value="0"><label
                                                                class="custom-control-label"
                                                                for="creditcard_real_on">on</label></div>

                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="creditcard_real_off"
                                                               name="creditcard_real"
                                                               class="custom-control-input"
                                                               value="1"><label
                                                                class="custom-control-label"
                                                                for="creditcard_real_off">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>체크카드</th>
                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block; margin-right: 50px">
                                                        <input type="radio"
                                                               id="checkcard_app_on"
                                                               name="checkcard_app"
                                                               class="custom-control-input"
                                                               value="0"><label
                                                            class="custom-control-label"
                                                            for="checkcard_app_on">on</label></div>

                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block; margin-right: 50px">
                                                        <input type="radio"
                                                               id="checkcard_app_off"
                                                               name="checkcard_app"
                                                               class="custom-control-input"
                                                               value="1"><label
                                                            class="custom-control-label"
                                                            for="checkcard_app_off">off</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>

                                        <td>
                                            <div class="position-relative form-group">
                                                <div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block; margin-right: 50px">
                                                        <input type="radio"
                                                               id="checkcard_real_on"
                                                               name="checkcard_real"
                                                               class="custom-control-input"
                                                               value="0"><label
                                                            class="custom-control-label"
                                                            for="checkcard_real_on">on</label></div>

                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="checkcard_real_off"
                                                               name="checkcard_real"
                                                               class="custom-control-input"
                                                               value="1"><label
                                                            class="custom-control-label"
                                                            for="checkcard_real_off">off</label>
                                                    </div>
                                                </div>
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
                            <button type="button" class="btn btn-success" onclick="postPayment()" style="width: 100px; float: right">저장</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page = '<%="../common/vd_footer.jsp" %>'/>
