<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page='<%="../common/vd_header.jsp"%>'/>
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
<div class="app-inner-layout app-inner-layout-page" style>
    <jsp:include page='<%="../common/vd_top_tabmenu.jsp"%>'/>
    <div class="app-inner-layout__wrapper">
        <div class="app-inner-layout__content">
            <div class="container-fluid">
                <form action="#">
                    <div class="row">
                        <div class="col-sm-12 col-lg-12">
                            <h5>사업관리자 > 사업자설정 > 등록</h5>
                        </div>
                        <div class="col-sm-12 col-lg-12 card">
                            <div class="card-header">
                                 본사정보
                            </div>
                            <div class="card-body">
                                <table class="mb-0 table">
                                    <tbody>
                                    <tr>
                                        <th scope="row">본사명</th>
                                        <td colspan="2"><input name="company_name" type="text"
                                                   class="form-control"></td>
                                        <th scope="row">PG수수료</th>
                                        <td colspan="2"><input name="pg_comm" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">본사사업자번호</th>
                                        <td colspan="2"><input name="company_num" type="text"
                                                   class="form-control"></td>
                                        <th scope="row">VD수수료</th>
                                        <td colspan="2"><input name="vd_comm" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">담당자명</th>
                                        <td colspan="2"><input name="rep_nm" type="text"
                                                   class="form-control"></td>
                                        <th scope="row">이메일</th>
                                        <td colspan="2"><input name="req_email" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">휴대전화</th>
                                        <td colspan="2"><input name="rep_mobile" type="text"
                                                   class="form-control"></td>
                                        <th scope="row">일반전화</th>
                                        <td colspan="2"><input name="rep_tel" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">주소</th>
                                        <td><input name="zipcode" type="text"
                                                   class="form-control">
                                        </td>
                                        <td><button>주소검색</button></td>
                                        <td><input name="address" type="text"
                                                   class="form-control"></td>
                                        <th scope="row">계약여부</th>
                                        <td>
                                            <select class="form-control" style="width: 100%">
                                                <option value="1">Y</option>
                                                <option value="2">N</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th></th>
                                        <td>
                                        <input name="addr_detail" type="text"
                                               class="form-control">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>메모</th>
                                        <td><input name="description" type="text"
                                                   class="form-control"></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 col-lg-12 card">
                            <div class="card-header">
                                지점정보
                            </div>
                            <div class="card-body">
                                <table class="mb-0 table">
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>지점명</th>
                                            <th>지점사업자번호</th>
                                            <th>상권</th>
                                            <th>PG수수료</th>
                                            <th>VD수수료</th>
                                            <th>계약여부</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th></th>
                                        <td><input name="store_name" type="text"
                                                   class="form-control"></td>
                                        <td><input name="store_num" type="text"
                                                   class="form-control"></td>
                                        <td><input name="store_contract" type="text"
                                                   class="form-control"></td>
                                        <td><input name="pg_comm" type="text"
                                                   class="form-control"></td>
                                        <td><input name="vd_comm" type="text"
                                                   class="form-control"></td>
                                        <td><input name="pg_comm" type="text"
                                                   class="form-control"></td>
                                        <td><button class="store_delete" onclick="">삭제</button></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page='<%="../common/vd_footer.jsp"%>'/>
