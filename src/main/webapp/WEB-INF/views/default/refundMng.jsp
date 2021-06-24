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
        getRefund();
    });

    function timeInput(){
        var time = $("input[name=refund_time]").val();

        if (24 <= time){
            var set_time = time%24;
            var set_day = time/24;

            $("input[name=refund_day]").val(Math.floor(set_day));
            $("input[name=refund_time]").val(set_time);
        }
    };

    function getRefund(){
        $.ajax({
            url:"/default/ajax_getRefund",
            type:"GET",
            success:function (responseData){
                var data = JSON.parse(responseData);

                if(data[0]["idx"] == 1){
                    if(data[0]["refund_value"] == "어플신청"){
                        $('#refund_on').attr('checked', true);
                    } else {
                        $('#refund_off').attr('checked', true);
                    }
                }

                if(data[1]["idx"] == 2){
                    if(data[1]["refund_value"] >= 24){

                        var set_time = data[1]["refund_value"]%24;
                        var set_day = data[1]["refund_value"]/24;

                        $("input[name=refund_day]").val(Math.floor(set_day));
                        $("input[name=refund_time]").val(set_time);
                    }else {
                        $("input[name=refund_time]").val(data[1]["refund_value"]);
                    }
                }
            }
        });
    };

    function refundSave(){

        var params = $('#refundForm').serialize();

        $.ajax({
            url:"/default/ajax_postRefund",
            type: "POST",
            data: params,
            success:function (){
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
                    <h5>어플관리 > 환불설정</h5>
                </div>
                <form id="refundForm" name="refundForm" method="post">
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
                                                               id="refund_on"
                                                               name="refundRequest"
                                                               class="custom-control-input"
                                                               value="어플신청"><label
                                                                class="custom-control-label"
                                                                for="refund_on">어플신청</label></div>
                                                    <div class="custom-radio custom-control"
                                                         style="display: inline-block">
                                                        <input type="radio"
                                                               id="refund_off"
                                                               name="refundRequest"
                                                               class="custom-control-input"
                                                               value="환불불가"><label
                                                                class="custom-control-label"
                                                                for="refund_off">환불불가</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="width: 200px">환불신청기간</th>
                                        <td>
                                            <div style="min-width: 130px">
                                                <input type="number" min="0" max="999" name="refund_day"/>
                                                <span style="margin-right: 50px;"> 일</span>
                                                <input type="number" min="0" max="999" oninput="timeInput()" name="refund_time"/>
                                                <span> 시간</span>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>`
                    <div class="row">
                        <div class="col-sm-12 col-lg-12" style="text-align: center; margin-top: 20px">
                            <button type="button" class="btn btn-success" style="width: 100px; float: right" onclick="refundSave()">저장</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page='<%="../common/vd_footer.jsp" %>'/>
