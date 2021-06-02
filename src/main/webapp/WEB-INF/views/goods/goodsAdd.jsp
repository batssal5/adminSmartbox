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
                        <h1 class="h3 mb-0 text-gray-800">상품관리 > 상품리스트 > 등록</h1>
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
	                                            <td>skuid</td>
	                                            <td><input type="text" id="skuid" name="skuid" style="width:100%;"></td>
	                                            <td>바코드</td>
	                                            <td><input type="text" id="barcode" name="barcode" style="width:100%;"></td>
	                                        </tr>
	                                        <tr>
	                                            <td>브랜드</td>
	                                            <td>
	                                            	<input type="hidden" id="brand" name="brand" value="">
			                                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropBrand" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                                            전체
			                                        </button>
			                                        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">
                        			                    <a class="dropdown-item" href="javascript:onBrand(0,'전체')">전체</a>
                                                        <c:forEach var="sub" items="${brandList}">
			                                            <a class="dropdown-item" href="javascript:onBrand('${sub.idx}','${sub.brand}')"><c:out value="${sub.brand}" /></a>
			                                            </c:forEach>
			                                        </div>
	                                            </td>
	                                            <td>상품코드</td>
	                                            <td><input type="text" id="gcode" name="gcode" style="width:100%;"></td>
	                                        </tr>
	                                        <tr>
	                                            <td>상품명</td>
	                                            <td><input type="text" id="name" name="name" style="width:100%;"></td>
	                                            <td>기본가격</td>
	                                            <td><input type="text" id="price" name="price" style="width:100%;"></td>
	                                        </tr>
	                                        <tr>
	                                        	<td>이미지</td>
	                                        	<td>
												<input type="file" name="imgFile" id="imgFile" />
	                                        	
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

						<a href="javascript:history.back();" class="btn btn-success btn-icon-split" style="float:right;margin-left:10px">
							<span class="text">취소</span>
						</a>
						&nbsp;&nbsp;
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

	function onBrand(idx, name) {
		$('#dropBrand').html(name);
		$('#brand').val(idx);
	}	

	
	// 등록하기
	function add() {


		var url="/goods/ajax_Add";

		$.ajax({ 
			url : url, 
			type: "POST",
			data: new FormData($('#addForm')[0]),
			enctype: 'multipart/form-data',
			processData: false,
	        contentType: false, 
			success : function(responseData){

				// agc_idx return
				var data = JSON.parse(responseData);

				if(data.ret == 0) {
					alert("추가하였습니다.");
					location.replace("/goods/goodsList");
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

