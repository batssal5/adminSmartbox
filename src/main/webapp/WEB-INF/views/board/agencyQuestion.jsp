<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page='<%="../common/vd_header.jsp" %>'/>
<script>

    function que_search(){

        var agc_idx = $('#agency_select option:selected').val();
        var store_idx = $('#store_select option:selected').val();
        var company_num = $('#company_num').val();
        var id = $('#id').val();
        var name = $('#name').val();
        var mobile = $('#mobile').val();
        var email = $('#email').val();
        var memo = $('#memo').val();
        var store_num = $('#store_num').val();
        var tel = $('#tel').val();
        var title = $('#title').val();
        var contents = $('#contents').val();

        $.ajax({
            url: "/board/ajax_search",
            type: "GET",
            data: {agc_idx : agc_idx,
                store_idx : store_idx,
                company_num : company_num,
                id : id,
                name : name,
                mobile : mobile,
                email : email,
                memo : memo,
                store_num : store_num,
                tel : tel,
                title : title,
                contents : contents
            },
            // dataType: "json",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            success: function (responseData){
                console.log("que : " + responseData)
                var data = JSON.parse(responseData);
                var html = '';
                $.each(data, function (index, item){
                    html += '<tr>';
                    html += '<td>'+1+'</td>';
                    html += '<td style="display:none;">'+item.agency_idx+'</td>';
                    html += '<td>'+item.id+'</td>';
                    html += '<td>'+item.name+'</td>';
                    html += '<td>'+item.company_name+'</td>';
                    html += '<td>'+item.store_name+'</td>';
                    html += '<td>'+item.cate+'</td>';
                    html += '<td>'+item.title+'</td>';
                    item.status == 0 ? html += '<td>N</td>' : html += '<td>Y</td>';
                    html += '<td>'+item.regdate+'</td>';
                    html += '</tr>';
                });

                var que_search = document.getElementById('que_search');
                que_search.innerHTML = html;
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
                    <div class="row">
                        <div class="col-sm-12 col-lg-12">
                            <h5>????????? > ?????????1:1??????</h5>
                        </div>
                        <div class="col-sm-12 col-lg-6 card">
                            <div class="card-body">
                                <table class="mb-0 table">
                                    <tbody>
                                    <tr>
                                        <th>?????????</th>
                                        <td>
                                            <select id="agency_select" class="form-control" style="width: 100%"
                                                    onchange="agencySelect()">
                                                <option value="0">??????</option>
                                                <c:forEach var="agc" items="${agcList}">
                                                    <option value="${agc.agc_idx}">${agc.company_name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>?????????????????????</th>
                                        <td><input id="company_num" name="company_num" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>?????????</th>
                                        <td><input id="id" name="id" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>??????</th>
                                        <td><input id="name" name="name" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>???????????????</th>
                                        <td>
                                            <select id="rate_select" name="rate" class="form-control" style="width: 100%">
                                                <option value="0">??????</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>????????????</th>
                                        <td><input id="mobile" name="mobile" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>?????????</th>
                                        <td><input id="email" name="email" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>??????</th>
                                        <td><input id="memo" name="memo" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-6 card">
                            <div class="card-body">
                                <table class="mb-0 table">
                                    <tbody>
                                    <tr>
                                        <th>????????????</th>
                                        <td>
                                            <select id="store_select" class="form-control" style="width: 100%">
                                                <option value="0">??????</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>?????????????????????</th>
                                        <td><input id="store_num" name="store_num" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>????????????</th>
                                        <td><input id="tel" name="tel" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>????????????</th>
                                        <td>
                                            <select id="cate_select" name="cate" class="form-control" style="width: 100%">
                                                <option value="0">??????</option>
                                                <option value="1">????????????</option>
                                                <option value="2">??????/??????</option>
                                                <option value="3">??????</option>
                                                <option value="4">??????/??????/??????</option>
                                                <option value="5">?????????/????????????</option>
                                                <option value="6">??????</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>??????</th>
                                        <td><input id="title" name="title" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>??????</th>
                                        <td><input id="contents" name="contents" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <th>????????????</th>
                                        <td>
                                            <select id="status_select" name="status" class="form-control" style="width: 100%">
                                                <option value="-1">??????</option>
                                                <option value="0">Y</option>
                                                <option value="1">N</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>?????????</th>
                                        <td><input id="regdate" name="regdate" type="text"
                                                   class="form-control"/></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-12 col-lg-12" style="text-align: center;">
                            <button type="button" class="btn btn-secondary">?????????</button>
                            <button type="button" class="btn btn-secondary" onclick="que_search()">??????</button>
                        </div>
                    </div>
                <div class="main-card card">
                    <div class="row">
                        <div class="col-sm-12 col-lg-12">
                            <div class="mb-3">
                                <div class="card-body">
                                    <table class="mb-0 table table-hover">
                                        <thead>
                                        <tr>
                                            <th>??????</th>
                                            <th>?????????</th>
                                            <th>??????</th>
                                            <th>?????????</th>
                                            <th>????????????</th>
                                            <th>????????????</th>
                                            <th>??????</th>
                                            <th>????????????</th>
                                            <th>?????????</th>
                                        </tr>
                                        </thead>
                                        <tbody id="que_search">
                                        <c:forEach var="quelist" items="${agency_quelist}">
                                            <tr>
                                                <td>${quelist.idx}</td>
                                                <td style="display: none">${quelist.agc_idx}</td>
                                                <td>${quelist.id}</td>
                                                <td>${quelist.name}</td>
                                                <td>${quelist.company_name}</td>
                                                <td>${quelist.store_name}</td>
                                                <td>${quelist.cate}</td>
                                                <td>${quelist.title}</td>
                                                <td>${quelist.status == 0 ? "N" : "Y"}</td>
                                                <td><fmt:formatDate value="${quelist.regdate}"
                                                                    pattern="yyyy.MM.dd HH:mm"/></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 col-md-7">
                            <div class="dataTables_paginate paging_simple_numbers"
                                 style="float: right;">
                                <ul class="pagination">
                                    <li class="paginate_button page-item previous disabled"><a
                                            href="#" aria-controls="" data-dt-idx="0" tabindex="0"
                                            class="page-link">prev</a></li>
                                    <li class="paginate_button page-item active"><a href="#"
                                                                                    aria-controls="example"
                                                                                    data-dt-idx="1" tabindex="0"
                                                                                    class="page-link">1</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example" data-dt-idx="2"
                                                                              tabindex="0"
                                                                              class="page-link">2</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example" data-dt-idx="3"
                                                                              tabindex="0"
                                                                              class="page-link">3</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example" data-dt-idx="4"
                                                                              tabindex="0"
                                                                              class="page-link">4</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example" data-dt-idx="5"
                                                                              tabindex="0"
                                                                              class="page-link">5</a></li>
                                    <li class="paginate_button page-item "><a href="#"
                                                                              aria-controls="example" data-dt-idx="6"
                                                                              tabindex="0"
                                                                              class="page-link">6</a></li>
                                    <li class="paginate_button page-item next" id="example_next"><a
                                            href="#" aria-controls="example" data-dt-idx="7" tabindex="0"
                                            class="page-link">next</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-5">
                            <button type="button" class="btn btn-success" onclick="">????????????</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page='<%="../common/vd_footer.jsp" %>'/>
