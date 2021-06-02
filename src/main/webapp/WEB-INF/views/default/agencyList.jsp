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
                        <h1 class="h3 mb-0 text-gray-800">사업자관리 > 사업자설정</h1>
                    </div>
		
	                <div class="container-fluid">

			
	                    <div class="card shadow mb-4">
	                        <div class="card-body">
	                            <div class="table-responsive">
	                            
	                            
                  			        <form action="#" id="searchForm" name="searchForm"> 
	                            
	                                <table class="table table-bordered" id="inputTable" width="100%" cellspacing="0">
	                                    <thead>
	                                    </thead>
	                                    <tbody>
	                                        <tr>
	                                            <td>본사명</td>
	                                            <td>
	                                            	<input type="hidden" id="inputAgency" name="agency_idx" value="0">
			                                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropAgency" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                                            전체
			                                        </button>
			                                        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">
                        			                    <a class="dropdown-item" href="javascript:onAgency(0,'전체')">전체</a>
                                                        <c:forEach var="sub" items="${agencyList}">
			                                            <a class="dropdown-item" href="javascript:onAgency('${sub.idx}','${sub.company_name}')"><c:out value="${sub.company_name}" /></a>
			                                            </c:forEach>
			                                        </div>
	                                    		</td>
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
	                                            <td>본사사업자번호</td>
	                                            <td><input type="text" id="inputAgencyNum" name="agency_num" style="width:100%;"></td>
	                                            <td>지점사업자번호</td>
	                                            <td><input type="text" id="inputStoreNum" name="store_num" style="width:100%;"></td>
	                                        </tr>
	                                        <tr>
	                                            <td>등록일자</td>
	                                            <td><input type="text" id="datePicker1" name="reg1" value="" style="width:40%;"> ~ <input type="text" id="datePicker2" name="reg2" value="" style="width:40%;"></td>
	                                            <td>PG수수료</td>
	                                            <td><input type="text"id="inputPgCommission1" name="pg1"  style="width:30%;"> ~ <input type="text" id="inputPgCommission2" name="pg2" style="width:30%;"></td>
	                                        </tr>
	                                        <tr>
	                                            <td>계약여부</td>
	                                            <td>
	                                            	<input type="hidden" id="inputContract" name="contract_idx" value="0">
			                                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropContract" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                                            전체
			                                        </button>
			                                        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">
                        			                    <a class="dropdown-item" href="javascript:onContract(-1,'전체')">전체</a>
                        			                    <a class="dropdown-item" href="javascript:onContract(0,'N')">N</a>
                        			                    <a class="dropdown-item" href="javascript:onContract(1,'Y')">Y</a>
			                                        </div>
	                                            </td>
	                                            <td>VD수수료</td>
	                                            <td><input type="text" id="inputVdCommission1" name="vd1" style="width:30%;"> ~ <input type="text" id="inputVdCommission2" name="vd2" style="width:30%;"></td>
	                                        </tr>
	                                        <%-- <tr>
	                                            <td>담당자명</td>
	                                            <td><input type="text" style="width:100%;"></td>
	                                            <td>상권</td>
	                                            <td>
	                                            	<input type="hidden" id="inputArea" value="">
	                                            	<button class="btn btn-primary dropdown-toggle" type="button" id="dropArea" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                                            	전체
			                                        </button>
			                                        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">
			                                        	<a class="dropdown-item" onclick="onArea(this);" cate="0">전체</a>
                                                        <c:forEach var="sub" items="${cateList}">
			                                            <a class="dropdown-item" onclick="onArea(this)" cate="${sub.cate_vu}"><c:out value="${sub.cate_nm}" /></a>
			                                            </c:forEach>
	                                                </div>
	                                            
												</td>
	                                        </tr> --%>
<!-- 	                                        <tr>
	                                            <td>휴대전화</td>
	                                            <td><input type="text" style="width:100%;"></td>
	                                            <td>PG수수료</td>
	                                            <td><input type="text" style="width:100%;"></td>
	                                        </tr>
	                                        <tr>
	                                            <td>일반전화</td>
	                                            <td><input type="text" style="width:100%;"></td>
	                                            <td>VD수수료</td>
	                                            <td><input type="text" style="width:100%;"></td>
	                                        </tr>
	                                        <tr>
	                                            <td>주소</td>
	                                            <td><input type="text" style="width:100%;"></td>
	                                            <td>이메일</td>
	                                            <td><input type="text" style="width:100%;"></td>
	                                        </tr>
	                                        <tr>
	                                            <td>등록일자</td>
	                                            <td><input type="text" style="width:100%;"></td>
	                                            <td>계약여부</td>
	                                            <td><input type="text" style="width:100%;"></td>
	                                        </tr>
	                                        <tr>
	                                            <td>메모</td>
	                                            <td colspan="3"><input type="text" style="width:100%;"></td>
	                                        </tr>
 -->
	                                    </tbody>
	                                </table>
                          			</form>
	                                
	                            </div>
	                            
                				<a href="javascript:location.reload(true);" class="btn btn-danger btn-icon-split">
									<span class="text">초기화</span>
								</a>
								
								<a href="javascript:search();" class="btn btn-success btn-icon-split">
                                    <span class="text">조회</span>
                                </a>
	                            
	                            <a href="/default/agencyAdd" class="btn btn-primary btn-icon-split" style="float:right;">
                                    <span class="text">등록</span>
                                </a>
	                        </div>
	                        
	                    </div>


	                    <!-- DataTales Example -->
	                    <div class="card shadow mb-4">
	                        <div class="card-body">
	                            <div class="table-responsive">
	                            
	                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                                    <thead>
	                                        <tr>
	                                            <th>순번</th>
	                                        	<th style="display:none">agc_idx</th>
	                                            <th>본사명</th>
	                                            <th>본사사업자번호</th>
	                                            <th>지점명</th>
	                                            <th>지점사업자번호</th>
	                                            <th>PG수수료</th>
	                                            <th>VD수수료</th>
	                                            <th>계약여부</th>
	                                            <th>등록일자</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody id="searchBody">
                            	           	<c:forEach var="sub" items="${storeList}">
	                                        <%-- <tr onclick="onModify('${sub.agc_idx}')"> --%>
	                                        <tr>
                                            <td>${sub.idx}</td>
                                            <td style="display:none">${sub.agc_idx}</td>
                                            <td>${sub.company_name}</td>
                                            <td>${sub.company_num}</td>
                                            <td>${sub.store_name}</td>
                                            <td>${sub.store_num}</td>
                                            <td>${sub.commission_pg}</td>
                                            <td>${sub.commission_vd}</td>
                                            <td>
	                                            <c:if test="${sub.contract == 0}">
												    N
												</c:if>
	                                            <c:if test="${sub.contract != 0}">
												    Y
												</c:if> 
											</td>
                                            <td><fmt:formatDate value="${sub.regdate}" pattern="yyyy.MM.dd HH:mm" /></td>
                                            
                                                    
                                            
                                            </tr>
                                            </c:forEach>

	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>
	
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
	$(function(){


		$('#dataTable').DataTable( {
			});

	    $('#dataTable tr').on( 'click', function () {
			location.href = "/default/agencyModify?idx="+$(this).children().eq(1).text();
	    });

	});

	function onModify(idx) {
		location.href = "/default/agencyModify?idx="+idx
	}

	
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

	// 계약여부 클릭 이벤트	// -1-전체 0-N 1-Y 
	function onContract(contract_idx, name) {
		$('#dropContract').html(name);
		$('#inputContract').val(contract_idx);
	}

	// 상권 클릭 이벤트 
	function onArea(obj) {
		var cate = $(obj).attr('cate');
		var name = $(obj).html();
		
		$('#dropArea').html(name);
		$('#inputArea').val(cate);
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


	// 조회 클릭시 리스트 불러오기
	function search() {
		
		var url="/default/ajax_search";
		
		var ajax = $.ajax({ 
			url : url
			, type: "GET"
			, daataType : "jason"
			, contentType: 'application/x-www-form-urlencoded; charset=UTF-8' 
			, data : $('#searchForm').serialize()
			, beforeSend:function(response){
				
			}	
			, success : function(responseData){

				var data = JSON.parse(responseData);
				//alert(data);
				var html = '';
				var menu = '<a class="dropdown-item" href="javascript:search(0)">전체</a>';

				var tableData = [];

				$.each(data, function(index, item){

					if(!item.store_num) {
						item.store_num = "-";
					}


					var date = new Date(item.regdate);
					
/* 					tableData[index] = [
						item.idx,
						item.agc_idx,
						item.company_name,
						item.company_num,
						item.store_name,
						item.store_num,
						item.commission_pg,
						item.commission_vd,
						item.contract == 0 ? "N" : "Y",
						getDateToString(date)];
 */
					
					
 					html += '<tr>';
					html += '<td>'+item.idx+'</td>';
					html += '<td style="display:none;">'+item.agc_idx+'</td>';
					html += '<td>'+item.company_name+'</td>';
					html += '<td>'+item.company_num+'</td>';
					html += '<td>'+item.store_name+'</td>';
					html += '<td>'+item.store_num+'</td>';
					html += '<td>'+item.commission_pg+'</td>';
					html += '<td>'+item.commission_vd+'</td>';
					if(item.contract == 0) {
						html += '<td>N</td>';
					} else {
						html += '<td>Y</td>';
					}

					var date = new Date(item.regdate);
					html += '<td>'+getDateToString(date)+'</td>';
					html += '</tr>';


	                menu += '<a class="dropdown-item" href="javascript:onStore(\''+item.idx+'\',\''+item.store_name+'\')">';
	                menu += ''+item.store_name+'</a>';
					
				});

				$('#dataTable').DataTable().destroy();
/* 				$('#dataTable').DataTable( {
					   data: tableData,
				        columnDefs: [ 
				            {
				                "targets": [ 1 ],
				                "visible": false,
				            }]
					});
 */
				
 				var searchBody = document.getElementById("searchBody");
				searchBody.innerHTML = html;


 				$('#dataTable').DataTable();
 			    $('#dataTable tr').on( 'click', function () {
					location.href = "/default/agencyModify?idx="+$(this).children().eq(1).text();
			    });
				
				$("#menuStore").html(menu);


				
				
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

	
	function getDateToString(date)
	{
			var dd = date.getDate();
			var mm = date.getMonth()+1; //January is 0!
		
			var yyyy = date.getFullYear();
			if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm}
			
			yyyy = yyyy.toString();
			mm = mm.toString();
			dd = dd.toString();
			
			var h = date.getHours();
			var m = date.getMinutes();

			if(h<10){h='0'+h} if(m<10){m='0'+m}
			h = h.toString();
			m = m.toString();
		
			var s1 = yyyy+"."+mm+"."+dd+" "+h+":"+m;
			return s1;
	}
</script>
<script>
	$(function() {	
		$('#datePicker1').datepicker({
		    format: "yyyy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
/* 		    startDate: '-10d',	//달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
		    endDate: '+10d',	//달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
 */		    autoclose : true,	//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
		    calendarWeeks : false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
		    clearBtn : true, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
		    /* datesDisabled : ['2019-06-24','2019-06-26'],//선택 불가능한 일 설정 하는 배열 위에 있는 format 과 형식이 같아야함. */
		    /* daysOfWeekDisabled : [0,6],	//선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일 */
		    /* daysOfWeekHighlighted : [3], //강조 되어야 하는 요일 설정 */
		    disableTouchKeyboard : false,	//모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
		    immediateUpdates: false,	//사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
		    multidate : false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false 
		    multidateSeparator :",", //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
		    templates : {
		        leftArrow: '&laquo;',
		        rightArrow: '&raquo;'
		    }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
		    showWeekDays : true ,// 위에 요일 보여주는 옵션 기본값 : true
/* 		    title: "테스트",	//캘린더 상단에 보여주는 타이틀
 */		    todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false 
		    toggleActive : false,	//이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
		    weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
		    language : "ko"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
		    
		});//datepicker end

		$('#datePicker2').datepicker({
		    format: "yyyy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
    		autoclose : true,	//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
   		    calendarWeeks : false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
   		    clearBtn : true, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
   		    disableTouchKeyboard : false,	//모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
   		    immediateUpdates: false,	//사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
   		    multidate : false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false 
   		    multidateSeparator :",", //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
   		    templates : {
   		        leftArrow: '&laquo;',
   		        rightArrow: '&raquo;'
   		    }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
   		    showWeekDays : true ,// 위에 요일 보여주는 옵션 기본값 : true
 			todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false 
   		    toggleActive : false,	//이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
   		    weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
		    		    
		});
	});//ready end


	
</script>

</html>

