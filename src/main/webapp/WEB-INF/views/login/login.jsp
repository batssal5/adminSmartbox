<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Login Boxed - Kero HTML Bootstrap 4 Dashboard Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no"
    />
    <meta name="description" content="SmartBoxAdmin">

    <!-- Disable tap highlight on IE -->
    <meta name="msapplication-tap-highlight" content="no">

    <link rel="stylesheet" href=/bootstrab/css/vd-style.css>
    <script src="/bootstrab/js/jquery-3.4.0.min.js"></script>
    <script language="javascript">

    function funLoginCheck(){
        if($("#inputLoginId").val()=="admin" && $("#inputLoginPw").val()=="admin"){
            var sessionData = "1234";
            sessionStorage.setItem("vdsession", sessionData ); // 저장
            alert(sessionStorage.getItem("vdsession"));
            $(location).attr("href", "/home/dashboard");
        }else{
            alert("ID 혹은 Password를 확인 하세요.");
        }
    }
    $(function () {

        sessionStorage.clear(); // 전체삭제

        $("#btnLogin").click(function () {
            funLoginCheck();
        });
        $("input").on("keyup",function(key){
            if(key.keyCode==13) {
                funLoginCheck();
            }
        });
    });
    </script>
</head>
<body>
<div class="app-container app-theme-white body-tabs-shadow">
    <div class="app-container">
        <div class="h-100 bg-plum-plate bg-animation">
            <div class="d-flex h-100 justify-content-center align-items-center">
                <div class="mx-auto app-login-box col-md-8">
                    <div class="app-logo-inverse mx-auto mb-3"></div>
                    <div class="modal-dialog w-100 mx-auto">
                        <div class="modal-content">
                            <div class="modal-body">
                                <div class="h5 modal-title text-center">
                                    <h4 class="mt-2">
                                        <div>SmartBox Admin</div>
                                        <%--<span>Please sign in to your account below.</span>--%>
                                    </h4>
                                </div>
                                <form class="">
                                    <div class="form-row">
                                        <div class="col-md-12">
                                            <div class="position-relative form-group"><input name="email" id="inputLoginId" placeholder="ID" type="email" class="form-control"></div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="position-relative form-group"><input name="password" id="inputLoginPw" placeholder="Password" type="password" class="form-control"></div>
                                        </div>
                                    </div>
                                    <div class="position-relative form-check"><input name="check" id="exampleCheck" type="checkbox" class="form-check-input"><label for="exampleCheck" class="form-check-label">로그인 유지</label></div>
                                </form>
                                <div class="divider"></div>
                                <h6 class="mb-0"><a href="javascript:void(0);" class="text-primary">가입하기</a></h6>
                            </div>
                            <div class="modal-footer clearfix">
                                <div class="float-left"><a href="javascript:void(0);" class="btn-lg btn btn-link">비밀번호 찾기</a></div>
                                <div class="float-right">
                                    <button class="btn btn-primary btn-lg" id="btnLogin">로그인</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="text-center text-white opacity-8 mt-3">Copyright © VD Company 2021.</div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/bootstrab/js/vd-js-engine-min.js"></script>
</body>
</html>