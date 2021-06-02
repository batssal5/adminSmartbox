<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en">

<jsp:include page = '<%="../common/header.jsp" %>'/>


<link rel="stylesheet" href=/bootstrab/css/bootstrap-datepicker.css>
<script src="/bootstrab/js/bootstrap-datepicker.js"></script>
<script src="/bootstrab/js/bootstrap-datepicker.ko.min.js"></script> 


<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
	
		<!-- SideBar -->
		<jsp:include page = '<%="../common/sidebar.jsp" %>'/>
	
	    <!-- Content Wrapper -->
	    <div id="content-wrapper" class="d-flex flex-column">
	        <!-- Main Content -->
	        <div id="content">
	        
	            <!-- Topbar -->
				<jsp:include page = '<%="../common/toolbar.jsp" %>'/>
	
	            <!-- Begin Page Content -->
	            <div class="container-fluid">
		
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">사업자관리 > 사업자등록</h1>
                    </div>
		
	                <div class="container-fluid">

			
	                    <div class="card shadow mb-4">
	                        <div class="card-body">
	                            <div class="table-responsive">
	                            
	                            
                  			        <form action="#" id="addForm" name="addForm"> 
	                            
	                                <table class="table table-bordered" id="inputTable" width="100%" cellspacing="0">
	                                    <thead>
	                                    </thead>
	                                    <tbody>
	                                        <tr>
	                                            <td>본사명</td>
	                                            <td><input type="text" id="company_name" name="company_name" value="" style="width:100%;"></td>
	                                            <td>PG수수료</td>
	                                            <td><input type="text"id="commission_pg" name="commission_pg"  style="width:90%;">%</td>
	                                        </tr>
	                                        <tr>
	                                            <td>본사사업자번호</td>
	                                            <td><input type="text" id="company_num" name="company_num" style="width:100%;"></td>
	                                            <td>VD수수료</td>
	                                            <td><input type="text" id="commission_vd" name="commission_vd" style="width:90%;">%</td>
	                                        </tr>
	                                        <tr>
	                                            <td>담당자명</td>
	                                            <td><input type="text" id="rep_nm" name="rep_nm" style="width:100%;"></td>
	                                            <td>이메일</td>
	                                            <td><input type="text" id="rep_email" name="rep_email" style="width:100%;"></td>
	                                        </tr>
	                                        <tr>
	                                            <td>휴대전화</td>
	                                            <td><input type="text" id="rep_mobile" name="rep_mobile" style="width:100%;"></td>
	                                            <td>일반전화</td>
	                                            <td><input type="text" id="rep_tel" name="rep_tel" style="width:100%;"></td>
	                                        </tr>
	                                        <tr>
				                                <td>주소</td>
				                                <td>
				                                    <input type="text" name="zipcode" id="zipcode" size="5" class="form-control" placeholder="우편번호" readonly value="" style="display:inline-block;width:20%;"> 
				                                    <i class="fas fa-search" onclick="sample6_execDaumPostcode()" style="cursor:pointer;font-size:24px;"></i>
   				                                    <input type="text" name="address" id="address" class="form-control mb-3" value="" style="display:inline-block;width:60%;">
				                                </td>
	                                            <td>계약여부</td>
	                                            <td>
	                                            	<input type="hidden" id="input_dropContractAgency" name="contract" value="0">
			                                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropContractAgency" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                                            N
			                                        </button>
			                                        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">
                        			                    <a class="dropdown-item" href="javascript:onContract(0,'N','dropContractAgency')">N</a>
                        			                    <a class="dropdown-item" href="javascript:onContract(1,'Y','dropContractAgency')">Y</a>
			                                        </div>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<td></td>
	                                        	<td>
				                                    <input type="text" name="addr_detail" id="addr_detail" value="" style="width:100%;">
	                                        	</td>
	                                        	<td>메모</td>
	                                        	<td>
				                                    <input type="text" name="description" id="description" value="" style="width:100%;">
	                                        	</td>
	                                        </tr>
	                                    </tbody>
	                                </table>
                          			</form>
	                                
	                            </div>
	                        </div>
	                        
	                    </div>


	                    <!-- DataTales Example -->
	                    <div class="card shadow mb-4">
	                        <div class="card-body">
	                            <div class="table-responsive">
	                            
                   			        <form action="#" id="storeForm" name="storeForm">
									<input type="hidden" name="agc_idx" id="agc_idx" value="0" >
                   			         
	                                <table class="table table-bordered" id="storeTable" width="100%" cellspacing="0">
	                                    <thead>
	                                        <tr>
	                                            <th>지점명</th>
	                                            <th>지점사업자번호</th>
	                                            <th>상권</th>
	                                            <th>PG수수료</th>
	                                            <th>VD수수료</th>
	                                            <th>계약여부</th>
	                                            <th></th>
	                                        </tr>
	                                    </thead>
	                                    <tbody id="storeBody">
	                                        <tr>
	                                            <td><input type="text" name="list[0].store_name" id="store_name" value="" style="width:100%;"></td>
	                                            <td><input type="text" name="list[0].store_num" id="store_num" value="" style="width:100%;"></td>
	                                            <td>
	                                            	<input type="hidden" id="input_dropAreaStore0" name="list[0].cate" value="0">
	                                            	<button class="btn btn-primary dropdown-toggle" type="button" id="dropAreaStore0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                                            	전체
			                                        </button>
			                                        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">
			                                        	<a class="dropdown-item" onclick="onArea(this,'dropAreaStore0');" cate="0">전체</a>
	                                                       <c:forEach var="sub" items="${cateList}">
			                                            <a class="dropdown-item" onclick="onArea(this,'dropAreaStore0')" cate="${sub.cate_vu}"><c:out value="${sub.cate_nm}" /></a>
			                                            </c:forEach>
	                                                </div>
	                                            
												</td>
	                                            <td><input type="text" name="list[0].commission_pg" id="description" value="" style="width:100%;"></td>
	                                            <td><input type="text" name="list[0].commission_vd" id="description" value="" style="width:100%;"></td>
	                                            <td>
	                                            	<input type="hidden" id="input_dropContractStore0" name="list[0].contract" value="0">
			                                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropContractStore0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                                            N
			                                        </button>
			                                        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">
	                       			                    <a class="dropdown-item" href="javascript:onContract(0,'N','dropContractStore0')">N</a>
	                       			                    <a class="dropdown-item" href="javascript:onContract(1,'Y','dropContractStore0')">Y</a>
			                                        </div>
												</td>
												<td><a href="javascript:rowDelete(0);" class="btn btn-danger btn-icon-split" style="float:right;"><span class="text">삭제</span></a></td>
												
                                            </tr>

	                                    </tbody>
	                                </table>
	                               	</form> 
	                            </div>
               			<a href="javascript:rowAdd();" class="btn btn-primary btn-icon-split" style="float:right;">
							<span class="text">지점 추가</span>
						</a>
	                        </div>
	                        
	                    </div>
	
	
		                            
						<a href="javascript:history.back();" class="btn btn-success btn-icon-split" style="float:right;">
							<span class="text">취소</span>
						</a>
						
						<a href="javascript:add();" class="btn btn-primary btn-icon-split" style="float:right;">
							<span class="text">등록</span>
						</a>
	
	
	                </div>
	                <!-- /.container-fluid -->
		
	            </div>
	            <!-- /.container-fluid -->
	
	        </div>
	        <!-- End of Main Content -->
	
	    </div>
	    <!-- End of Content Wrapper -->
	
	</div>


</body>

<script>

	var rowIndex = 0;
	
	$(function(){

/* 	    $('#dataTable').DataTable();
 */		
		/* $("#menuSell").addClass("show"); */

	});

	// 계약여부 클릭 이벤트	//  0-N 1-Y
	function onContract(contract_idx, name, id) {
		$('#'+id).html(name);
		$('#input_'+id).val(contract_idx);
	}


	// 상권 클릭 이벤트 
	function onArea(obj, id) {
		var cate = $(obj).attr('cate');
		var name = $(obj).html();
		
		$('#'+id).html(name);
		$('#input_'+id).val(cate);
	}	

	function rowAdd() {
		rowIndex += 1;
		
		var table = $('#storeTable');
		var html = '<tr>';
            html += '<td><input type="text" name="list['+rowIndex+'].store_name" id="store_name" value="" style="width:100%;"></td>';
            html += '<td><input type="text" name="list['+rowIndex+'].store_num" id="store_num" value="" style="width:100%;"></td>';
            html += '<td>';
            html +=	'<input type="hidden" id="input_dropAreaStore'+rowIndex+'" name="list['+rowIndex+'].cate" value="0">';
            html +=	'<button class="btn btn-primary dropdown-toggle" type="button" id="dropAreaStore'+rowIndex+'" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">전체</button>';
            html +=    '<div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">';
            html +=    	'<a class="dropdown-item" onclick="onArea(this,\'dropAreaStore'+rowIndex+'\');" cate="0">전체</a>';
            html +=      '<c:forEach var="sub" items="${cateList}"><a class="dropdown-item" onclick="onArea(this,\'dropAreaStore'+rowIndex+'\')" cate="${sub.cate_vu}"><c:out value="${sub.cate_nm}" /></a></c:forEach>';
            html +=    '</div>';
            html += '</td>';
            html += '<td><input type="text" name="list['+rowIndex+'].commission_pg" id="description" value="" style="width:100%;"></td>';
            html += '<td><input type="text" name="list['+rowIndex+'].commission_vd" id="description" value="" style="width:100%;"></td>';
            html += '<td>';
            html +=	'<input type="hidden" id="input_dropContractStore'+rowIndex+'" name="list['+rowIndex+'].contract" value="0">';
            html +=    '<button class="btn btn-primary dropdown-toggle" type="button" id="dropContractStore'+rowIndex+'" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">N</button>';
            html +=    '<div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">';
            html +=            '<a class="dropdown-item" href="javascript:onContract(0,\'N\',\'dropContractStore'+rowIndex+'\')">N</a>';
            html +=            '<a class="dropdown-item" href="javascript:onContract(1,\'Y\',\'dropContractStore'+rowIndex+'\')">Y</a>';
            html +=    '</div>';
            html += '</td>';
            html += '<td><a href="javascript:rowDelete('+rowIndex+');" class="btn btn-danger btn-icon-split" style="float:right;"><span class="text">삭제</span></a></td>';
            html += '</tr>';

    	table.append(html);
	}

	function rowDelete(index) {
		document.getElementById("storeTable").deleteRow(index+1);
	}

	
	// 등록하기
	function add() {

		
		var url="/default/ajax_Add";

		
		var ajax = $.ajax({ 
			url : url
			, type: "GET"
			, daataType : "jason"
			, contentType: 'application/x-www-form-urlencoded; charset=UTF-8' 
			, data : $('#addForm, #storeForm').serialize()
			, beforeSend:function(response){
				
			}	
			, success : function(responseData){

				// agc_idx return
				var data = JSON.parse(responseData);

				if(data.ret == 0) {
					alert("추가하였습니다.");
					location.replace("/default/agencyList");
				} else {
					alert(data.error);
				}
			}
						
			,complete: function(response){
				
				// var ul = document.getElementById("ul_dynaList");
				// ul.innerHTML = "";	
			}
			, error:function(e) {
				// var ul = document.getElementById("ul_dynaList");
				// ul.innerHTML = "";			
			}
			, fail: function(){
				
			}
		});
	
		// ajax 실행문
		jQuery.ajax.done; // (function(data){})
		
	}

	function storeAdd() {
		var url="/default/ajax_StoreAdd";
		
		var ajax = $.ajax({ 
			url : url
			, type: "GET"
			, daataType : "jason"
			, contentType: 'application/x-www-form-urlencoded; charset=UTF-8' 
			, data : $('#storeForm').serialize()
			, beforeSend:function(response){
				
			}	
			, success : function(responseData){

				var data = JSON.parse(responseData);

				if(data.ret == 0) {
					alert("추가하였습니다.");
					location.replace("/default/agencyList");
				} else {
					alert(data.error);
				}
			}
			,complete: function(response){
				
				// var ul = document.getElementById("ul_dynaList");
				// ul.innerHTML = "";	
			}
			, error:function(e) {
				// var ul = document.getElementById("ul_dynaList");
				// ul.innerHTML = "";			
			}
			, fail: function(){
				
			}
		});
	
		// ajax 실행문
		jQuery.ajax.done; // (function(data){})
	}
	

</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> 
<script> 
	 function sample6_execDaumPostcode() { 
		 new daum.Postcode({ 
			 oncomplete: function(data) { 
				  // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분. 
				  // 각 주소의 노출 규칙에 따라 주소를 조합한다. 
				  // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다. 
				  var fullAddr = ''; // 최종 주소 변수 
				  var extraAddr = ''; // 조합형 주소 변수 
				  // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다. 
				  if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우 
					   fullAddr = data.roadAddress; 
				  } else { // 사용자가 지번 주소를 선택했을 경우(J) 
					   fullAddr = data.jibunAddress; 
				  } 
				  // 사용자가 선택한 주소가 도로명 타입일때 조합한다. 
				  if(data.userSelectedType === 'R'){ 
				   //법정동명이 있을 경우 추가한다. 
				  if(data.bname !== ''){ 
					   extraAddr += data.bname; 
				  } 
				  // 건물명이 있을 경우 추가한다. 
				  if(data.buildingName !== ''){ 
					   extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName); 
				  } 
				  // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다. 
					   fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : ''); 
				  } 
				  // 우편번호와 주소 정보를 해당 필드에 넣는다. 
				  document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용 
				  document.getElementById('address').value = fullAddr; 
				  // 커서를 상세주소 필드로 이동한다. 
				  document.getElementById('addr_detail').focus(); 
			 } 
		 }).open(); 
	} 
</script>

</html>

