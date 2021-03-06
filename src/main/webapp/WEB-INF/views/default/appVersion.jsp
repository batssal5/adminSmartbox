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
    $(function (){
        getVersion();
    });

    function getVersion(){
        $.ajax({
            url:"/default/ajax_appVersion",
            type: "GET",
            success:function (responseData){
                var data = JSON.parse(responseData);

                $('#and_c_ver').text(data[0]["c_version"]);
                $('#and_c_pre').val(data[0]["c_version_pre"]);
                $('#and_a_ver').text(data[0]["a_version"]);
                $('#and_a_pre').val(data[0]["a_version_pre"]);
                $('#ios_c_ver').text(data[1]["c_version"]);
                $('#ios_c_pre').val(data[1]["c_version_pre"]);
                $('#ios_a_ver').text(data[1]["a_version"]);
                $('#ios_a_pre').val(data[1]["a_version_pre"]);
            }
        });
    };

    function postVersion(){

        $.ajax({
            url:"/default/ajax_postVersion",
            type:"POST",
            data:{
                and_c_pre : $('#and_c_pre').val(),
                and_a_pre : $('#and_a_pre').val(),
                ios_c_pre : $('#ios_c_pre').val(),
                ios_a_pre : $('#ios_a_pre').val()
            },
            success:function (){
                alert("수정완료");
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
                    <h5>어플관리 > 버전설정</h5>
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
                                        <th style="border: none"></th>
                                        <th style="border: none">iOS</th>
                                    </tr>
                                    </thead>
                                    <tbody id="appVersion">
                                    <tr>
                                        <th>현재버전</th>
                                        <td id="and_c_ver">1.00</td>
                                        <th>현재버전</th>
                                        <td id="ios_c_ver">1.00</td>
                                    </tr>
                                    <tr>
                                        <th>최소버전</th>
                                        <td><input id="and_c_pre" type="text"
                                                   class="form-control"></td>
                                        <th>최소버전</th>
                                        <td><input id="ios_c_pre" type="text"
                                                   class="form-control"></td>
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
                                        <th style="border: none"></th>
                                        <th style="border: none">iOS</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>현재버전</th>
                                        <td id="and_a_ver">1.00</td>
                                        <th>현재버전</th>
                                        <td id="ios_a_ver">1.00</td>
                                    </tr>
                                    <tr>
                                        <th>최소버전</th>
                                        <td><input id="and_a_pre" type="text"
                                                   class="form-control"></td>
                                        <th>최소버전</th>
                                        <td><input id="ios_a_pre" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 col-lg-12" style="text-align: center; margin-top: 20px">
                            <button type="button" class="btn btn-success" onclick=" postVersion()" style="width: 100px; float: right">저장</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page='<%="../common/vd_footer.jsp" %>'/>
