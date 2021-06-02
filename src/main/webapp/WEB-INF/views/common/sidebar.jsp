<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">SmartBox<sup>Admin</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="/home">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>홈</span>
            </a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- 기본설정 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuBase"
                aria-expanded="true" aria-controls="menuBase">
                <span>기본설정</span>
            </a>
            <div id="menuBase" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">약관관리</h6>
						<a class="collapse-item" href="#">유저APP</a>
						<a class="collapse-item" href="#">관리자APP</a>
					<h6 class="collapse-header">사업자관리</h6>
						<a class="collapse-item" href="/default/agencyList">사업자설정</a>
					<h6 class="collapse-header">어플관리</h6>
						<a class="collapse-item" href="#">버전설정</a>
						<a class="collapse-item" href="#">제한설정</a>
					<h6 class="collapse-header">환불정책</h6>
						<a class="collapse-item" href="#">환불설정</a>
					<h6 class="collapse-header">결제수단관리</h6>
						<a class="collapse-item" href="#">카드설정</a>
                </div>
            </div>
        </li>

        <!-- 박스 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuBox"
                aria-expanded="true" aria-controls="menuBox">
                <span>박스</span>
            </a>
            <div id="menuBox" class="collapse" aria-labelledby="headingUtilities"
                data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">박스관리</h6>
						<a class="collapse-item" href="/box/boxList">박스리스트</a>
					<h6 class="collapse-header">재고관리</h6>
						<a class="collapse-item" href="#">재고처리내역</a>
                </div>
            </div>
        </li>

        <!-- 상품 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuGoods"
                aria-expanded="true" aria-controls="menuGoods">
                <span>상품</span>
            </a>
            <div id="menuGoods" class="collapse" aria-labelledby="headingUtilities"
                data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">상품관리</h6>
						<a class="collapse-item" href="/goods/goodsList">상품리스트</a>
						<a class="collapse-item" href="/goods/goodsDisplay">상품진열</a>
						<a class="collapse-item" href="#">상품가격</a>
						<a class="collapse-item" href="#">상품재고</a>
						<a class="collapse-item" href="#">상품기한</a>
                </div>
            </div>
        </li>

        <!-- 판매 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuSell"
                aria-expanded="true" aria-controls="menuSell">
                <span>판매</span>
            </a>
            <div id="menuSell" class="collapse" aria-labelledby="headingUtilities"
                data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">판매관리</h6>
						<a class="collapse-item" href="#">결제정보</a>
					<h6 class="collapse-header">정산관리</h6>
						<a class="collapse-item" href="#">정산조회</a>
					<h6 class="collapse-header">환불관리</h6>
						<a class="collapse-item" href="#">환불접수</a>
                </div>
            </div>
        </li>

        <!-- 회원 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuUser"
                aria-expanded="true" aria-controls="menuUser">
                <span>회원</span>
            </a>
            <div id="menuUser" class="collapse" aria-labelledby="headingUtilities"
                data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">회원관리</h6>
						<a class="collapse-item" href="#">유저리스트</a>
						<a class="collapse-item" href="#">블랙리스트</a>
						<a class="collapse-item" href="#">미납리스트</a>
						<a class="collapse-item" href="#">탈퇴회원</a>
						<a class="collapse-item" href="#">관리자회원</a>
						<a class="collapse-item" href="#">회원가입제한</a>
					<h6 class="collapse-header">푸시관리</h6>
						<a class="collapse-item" href="#">푸시발송</a>
                </div>
            </div>
        </li>

        <!-- 게시판 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuBoard"
                aria-expanded="true" aria-controls="menuBoard">
                <span>게시판</span>
            </a>
            <div id="menuBoard" class="collapse" aria-labelledby="headingUtilities"
                data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">관리자</h6>
						<a class="collapse-item" href="#">관리자1:1문의</a>
						<a class="collapse-item" href="#">관리자FAQ</a>
						<a class="collapse-item" href="#">관리자공지사항</a>
						<a class="collapse-item" href="#">관리자프로모션</a>
					<h6 class="collapse-header">유저</h6>
						<a class="collapse-item" href="#">유저1:1문의</a>
						<a class="collapse-item" href="#">유저FAQ</a>
						<a class="collapse-item" href="#">유저공지사항</a>
						<a class="collapse-item" href="#">유저이벤트</a>
                </div>
            </div>
        </li>

        <!-- 프로모션 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuPromotion"
                aria-expanded="true" aria-controls="menuPromotion">
                <span>프로모션</span>
            </a>
            <div id="menuPromotion" class="collapse" aria-labelledby="headingUtilities"
                data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                </div>
            </div>
        </li>

        <!-- 마케팅 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuMarketing"
                aria-expanded="true" aria-controls="menuMarketing">
                <span>마케팅</span>
            </a>
            <div id="menuMarketing" class="collapse" aria-labelledby="headingUtilities"
                data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">배너관리</h6>
						<a class="collapse-item" href="#">유저APP</a>
						<a class="collapse-item" href="#">관리자APP</a>
					<h6 class="collapse-header">팝업관리</h6>
						<a class="collapse-item" href="#">유저APP</a>
						<a class="collapse-item" href="#">관리자APP</a>
					<h6 class="collapse-header">동영상관리</h6>
						<a class="collapse-item" href="#">동영상설정</a>
                </div>
            </div>
        </li>


        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>



