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
                        <h1 class="h3 mb-0 text-gray-800">박스관리 > 박스리스트 > 등록</h1>
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
	                                            <td style="width:20%;">본사명</td>
	                                            <td >
	                                            	<input type="hidden" id="inputAgency" name="agc_idx" value="0">
			                                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropAgency" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                                            전체
			                                        </button>
			                                        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">
                                                        <c:forEach var="sub" items="${agencyList}">
			                                            <a class="dropdown-item" href="javascript:onAgency('${sub.idx}','${sub.company_name}')"><c:out value="${sub.company_name}" /></a>
			                                            </c:forEach>
			                                        </div>
	                                    		</td>
	                                        </tr>
	                                        <tr>
	                                            <td>지점명</td>
	                                            <td>
	                                            	<input type="hidden" id="inputStore" name="store_idx" value="0">
			                                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropStore" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                                            전체
			                                        </button>
			                                        <div class="dropdown-menu animated--fade-in" id="menuStore" aria-labelledby="dropdownMenuButton" style="">
	                                                </div>
												</td>
	                                        </tr>
	                                        <tr>
	                                        	<td>박스시리얼넘버</td>
	                                        	<td>
				                                    <input type="text" name="serial" id="serial" value="" style="max-width: 350px;width: 100%;">
	                                        	</td>
	                                        </tr>
	                                        <tr>
	                                        	<td>박스ID</td>
	                                        	<td>
				                                    <input type="text" name="box_id" id="box_id" value="" style="max-width: 350px;width: 100%;">
	                                        	</td>
	                                        </tr>
	                                        <tr>
	                                        	<td>박스시리얼넘버</td>
	                                        	<td>
				                                    <input type="text" name="box_name" id="box_name" value="" style="max-width: 350px;width: 100%;">
	                                        	</td>
	                                        </tr>
	                                        <tr>
	                                        	<td>메모</td>
	                                        	<td>
				                                    <input type="text" name="description" id="description" value="" style="max-width: 350px;width: 100%;">
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


	// 본사명 클릭 이벤트
	function onAgency(agency_idx, name) {

		$('#dropAgency').html(name);
		$('#inputAgency').val(agency_idx);
		$('#dropStore').html("전체");
		$('#inputStore').val(0);

		getStoreList();	
	}

	// 지점명 클릭 이벤트
	function onStore(store_idx, name) {
		$('#dropStore').html(name);
		$('#inputStore').val(store_idx);
	}

	// 본사명 클릭시 지점명 불러오기 
	function getStoreList() {

		var agency_idx = $('#inputAgency').val();
		
		var url="/default/ajax_store";
		
		var form_data = {
				agency_idx: agency_idx,
				is_ajax: 1
			};
		
		var ajax = $.ajax({ 
			url : url
			, type: "GET"
			, daataType : "jason"
			, contentType: 'application/x-www-form-urlencoded; charset=UTF-8' 
			, data : form_data
			, beforeSend:function(response){
				
			}	
			, success : function(responseData){

				var data = JSON.parse(responseData);
				//alert(data);
				var menu = '<a class="dropdown-item" href="javascript:onStore(0,\'전체\')">전체</a>';

				$.each(data, function(index, item){
	                menu += '<a class="dropdown-item" href="javascript:onStore(\''+item.idx+'\',\''+item.store_name+'\')">';
	                menu += ''+item.store_name+'</a>';
				});

				$("#menuStore").html(menu);
			}
			,complete: function(response){
			}
			, error:function(e) {
			}
			, fail: function(){
			}
		});
	
		// ajax 실행문
		jQuery.ajax.done; // (function(data){})
	}
	
	
	// 등록하기
	function add() {


		var url="/box/ajax_Add";

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
					location.replace("/box/boxList");
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

