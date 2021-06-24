<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<jsp:include page='<%="../common/vd_header.jsp"%>'/>
<script>
    function ajax_policyList() {
        var terms = "이용약관";
        var policy = "개인정보처리방침";
        var subinfo = "가입안내";
        var secession = "탈퇴안내";
        var appType = $('#app_type option:selected').val();
        var location = window.location.pathname;
        var admin = "/default/adminApp";

        $.ajax({
            url: "/default/ajax_getApp",
            type: "GET",
            data: {appType: appType},
            success: function (responseData) {
                var data = JSON.parse(responseData);
                $.each(data, function (index, item) {
                    switch (item.cate) {
                        case terms :
                            if (location === admin) {
                                $('#terms').val(item.a_context);
                            } else {
                                $('#terms').val(item.c_context);
                            }
                            break;
                        case policy :
                            if (location === admin) {
                                $('#policy').val(item.a_context);
                            } else {
                                $('#policy').val(item.c_context);
                            }
                            break;
                        case subinfo :
                            if (location === admin) {
                                $('#subinfo').val(item.a_context);
                            } else {
                                $('#subinfo').val(item.c_context);
                            }
                            break;
                        case secession :
                            if (location === admin) {
                                $('#secession').val(item.a_context);
                            } else {
                                $('#secession').val(item.c_context);
                            }
                            break;
                        default :
                            break;
                    }
                });
            }
        });
    };

    function ajax_policySave() {

        var appType = $('#app_type option:selected').val();
        var terms = $('#terms').val();
        var policy = $('#policy').val();
        var subinfo = $('#subinfo').val();
        var secession = $('#secession').val();
        var location = window.location.pathname;

        $.ajax({
            url: "/default/ajax_postApp",
            type: "POST",
            enctype: 'multipart/form-data',
            data: {
                terms: terms,
                policy: policy,
                subinfo: subinfo,
                secession: secession,
                appType: appType,
                location: location
            },
            success: function () {
                alert("수정완료");
            }
        });
    };

    function ajax_fileUpload() {

        var formData = new FormData($('#imgForm')[0]);

        formData.append("1", $('#file_input1')[0].files[0]);
        formData.append("2", $('#file_input2')[0].files[0]);
        formData.append("3", $('#file_input3')[0].files[0]);
        formData.append("4", $('#file_input4')[0].files[0]);
        formData.append("5", $('#file_input5')[0].files[0]);

        if($('#file_input1')[0].files[0] == null){
            alert("파일을 선택하세요")
        }else {
            $.ajax({
                url: "/default/ajax_uploadImg",
                type: "POST",
                enctype: 'multipart/form-data',
                processData: false,
                contentType: false,
                data: formData,
                success: function (responseData) {
                    var data = JSON.parse(responseData);
                    var html = '';
                    $.each(data, function (index, item){
                        html += '<img class="tutorialImg" id="tutorial_'+(index+1)+'" style="width: 100px; height: 100px; object-fit: cover" src="'+item+'"/>';
                    });
                    var imgWrap = document.getElementById('img-wrap');
                    imgWrap.innerHTML = html;

                    var button = document.getElementById('img_save_button');
                    var btn = '<button id="imgUsed" style="width: 100px" onclick="ajax_imgSave()">저장</button>';
                    button.innerHTML = btn;
                }
            });
        }
    };

    function ajax_imgSave(){
        var imgWrap = $('#img-wrap');
        var location = window.location.pathname;
        var dataList = new Array();
        var appType = $('#app_type option:selected').val();
        var osType = location == "/default/adminApp" ? 1 : 0;

        for (var i=0; i<imgWrap.find('img').length;i++){
            var data = new Object();
            data.os = osType;
            data.app = appType;
            data.sort = imgWrap.find('img').eq(i).attr('id').substr(-1,1);
            data.src = imgWrap.find('img').eq(i).attr('src');
            dataList.push(data);
        }

        var jsonData = JSON.stringify(dataList);
        console.log(jsonData);

        $.ajax({
            url:"/default/ajax_postImg",
            type: 'POST',
            dataType: 'json',
            data: {jsonData : jsonData},
            success: function (){

            }
        })

    };

    $(function () {
        ajax_policyList();

        $('.img_del').click(function () {
            $(this).prev().val('');
        });

        $('#imgForm').submit(function (e){
            e.preventDefault();
        });

    });
</script>
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
<div class="app-inner-layout app-inner-layout-page">
    <jsp:include page='<%="../common/vd_top_tabmenu.jsp"%>'/>
    <div class="app-inner-layout__wrapper">
        <div class="app-inner-layout__content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-lg-12">
                        <h5>약관관리 > 관리자APP</h5>
                        <select id="app_type" onchange="ajax_policyList()">
                            <option value="0">안드로이드</option>
                            <option value="1">아이폰</option>
                        </select>
                    </div>
                    <div class="col-sm-12 col-lg-6">
                        <div class="mb-3 card">
                            <div class="card-header-tab card-header">
                                <div
                                        class="card-header-title font-size-lg text-capitalize font-weight-normal">
                                    이용약관
                                </div>
                            </div>
                            <div class="p-2 card-body">
									<textarea id="terms" rows="1" class="form-control autosize-input" name=""
                                              style="max-height: 260px; height: 260px; margin-top: 0px; margin-bottom: 0px;"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-lg-6">
                        <div class="mb-3 card">
                            <div class="card-header-tab card-header">
                                <div
                                        class="card-header-title font-size-lg text-capitalize font-weight-normal">
                                    개인정보 처리방침
                                </div>
                            </div>
                            <div class="p-2 card-body">
									<textarea id="policy" rows="1" class="form-control autosize-input" name=""
                                              style="max-height: 260px; height: 260px; margin-top: 0px; margin-bottom: 0px;"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 col-lg-6">
                        <div class="mb-3 card">
                            <div class="card-header-tab card-header">
                                <div
                                        class="card-header-title font-size-lg text-capitalize font-weight-normal">
                                    가입안내
                                </div>
                            </div>

                            <div class="p-2 card-body">
									<textarea id="subinfo" rows="1" class="form-control autosize-input" name=""
                                              style="max-height: 260px; height: 260px; margin-top: 0px; margin-bottom: 0px;"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-lg-6">
                        <div class="mb-3 card">
                            <div class="card-header-tab card-header">
                                <div
                                        class="card-header-title font-size-lg text-capitalize font-weight-normal">
                                    탈퇴안내
                                </div>
                            </div>
                            <div class="p-2 card-body">
									<textarea id="secession" rows="1" class="form-control autosize-input" name=""
                                              style="max-height: 260px; height: 260px; margin-top: 0px; margin-bottom: 0px;"></textarea>
                            </div>
                        </div>
                        <button id="adminAppSave" style="width: 100px"
                                onclick="ajax_policySave()">저장
                        </button>
                    </div>
                </div>
                <div class="row">
                    <!--튜토리얼 이미지 업로드-->
                    <div class="col-sm-12 col-lg-12">
                        <div class="mb-12 card">
                            <div class="card-header-tab card-header">
                                <div
                                        class="card-header-title font-size-lg text-capitalize font-weight-normal">
                                    튜토리얼
                                </div>
                            </div>
                            <div class="p-2 card-body">
                                <div class="row">
                                    <div class="col-lg-7">
                                        <div class="img-group" id="img-wrap" style="display:inline-block "></div>
                                        <div id="img_save_button">
                                        </div>
                                    </div>
                                    <div class="col-lg-5">
                                        <div class="file-upload-group">
                                            <form id="imgForm" method="post" enctype="multipart/form-data">
                                                <div>
                                                    <label>이미지1</label>
                                                    <input class="img_upload" id="file_input1" style="width: 50%"
                                                           type="file" accept="image/*"/>
                                                    <button class="img_del">X</button>
                                                </div>
                                                <div>
                                                    <label>이미지2</label>
                                                    <input class="img_upload" id="file_input2" style="width: 50%"
                                                           type="file" accept="image/*"/>
                                                    <button class="img_del">X</button>
                                                </div>
                                                <div>
                                                    <label>이미지3</label>
                                                    <input class="img_upload" id="file_input3" style="width: 50%"
                                                           type="file" accept="image/*"/>
                                                    <button class="img_del">X</button>
                                                </div>
                                                <div>
                                                    <label>이미지4</label>
                                                    <input class="img_upload" id="file_input4" style="width: 50%"
                                                           type="file" accept="image/*"/>
                                                    <button class="img_del">X</button>
                                                </div>
                                                <div>
                                                    <label>이미지5</label>
                                                    <input class="img_upload" id="file_input5" style="width: 50%"
                                                           type="file" accept="image/*"/>
                                                    <button class="img_del">X</button>
                                                </div>
                                                <div>
                                                    <button id="imgUpload" style="width: 100px"
                                                            onclick="ajax_fileUpload()">저장
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page='<%="../common/vd_footer.jsp"%>'/>
