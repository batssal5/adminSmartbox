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
                        <h1 class="h3 mb-0 text-gray-800">상품관리 > 상품리스트</h1>
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
	                                            <td><input type="text"id="price1" name="price1"  style="width:30%;"> ~ <input type="text" id="price2" name="price2" style="width:30%;"></td>
	                                        </tr>
	                                        <tr>
	                                            <td>등록일자</td>
	                                            <td colspan=""><input type="text" id="datePicker1" name="regdate1" value="" style="width:40%;"> ~ <input type="text" id="datePicker2" name="regdate2" value="" style="width:40%;"></td>
	                                            <td></td>
	                                            <td></td>
	                                        </tr>
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
	                            
	                            <a href="/goods/goodsAdd" class="btn btn-primary btn-icon-split" style="float:right;">
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
	                                            <th>이미지</th>
	                                            <th>skuid</th>
	                                            <th>바코드</th>
	                                            <th>상품코드</th>
	                                            <th>브랜드</th>
	                                            <th>상품명</th>
	                                            <th>기본가격</th>
	                                            <th>등록일</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody id="searchBody">
                            	           	<c:forEach var="sub" items="${goodsList}">
	                                        <%-- <tr onclick="onModify('${sub.idx}')"> --%>
	                                        <tr>
                                            <td>${sub.idx}</td>
                                            <td><img src="${sub.image}" alt="Goods Image" height="50" width="50"></td>
                                            <td>${sub.skuid}</td>
                                            <td>${sub.barcode}</td>
                                            <td>${sub.gcode}</td>
                                            <td>${sub.brand}</td>
                                            <td>${sub.name}</td>
                                            <td>${sub.price}</td>
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

	    var table = $('#dataTable').DataTable();
		
		/* $("#menuSell").addClass("show"); */

	    $('#dataTable tr').on( 'click', function () {
			location.href = "/goods/goodsModify?idx="+$(this).children().eq(0).text();
	    });
		
	});

	function onModify(idx) {
		location.href = "/goods/goodsModify?idx="+idx
	}

	function onBrand(idx, name) {
		$('#dropBrand').html(name);
		$('#brand').val(idx);
	}	
	

	// 조회 클릭시 리스트 불러오기
	function search() {
		
		var url="/goods/ajax_search";
		
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

				var tableData = [];

				
				$.each(data, function(index, item){

					if(!item.store_num) {
						item.store_num = "-";
					}

					var date = new Date(item.regdate);
					
					tableData[index] = [item.idx,
						'<img src="'+item.image+'" alt="Goods Image" height="50" width="50">',
						item.skuid,
						item.barcode,
						item.gcode,
						item.brand_name,
						item.name,
						item.price,
						getDateToString(date)];

					html += '<tr>';
					html += '<td>'+item.idx+'</td>';
					html += '<td><img src="'+item.image+'" alt="Goods Image" height="50" width="50"></td>';
					html += '<td>'+item.skuid+'</td>';
					html += '<td>'+item.barcode+'</td>';
					html += '<td>'+item.gcode+'</td>';
					html += '<td>'+item.brand_name+'</td>';
					html += '<td>'+item.name+'</td>';
					html += '<td>'+item.price+'</td>';
					html += '<td>'+getDateToString(date)+'</td>';
					html += '</tr>';
					
				});

				$('#dataTable').DataTable().destroy();
				$('#dataTable').DataTable( {
				   data: tableData  
				});
			    $('#dataTable tr').on( 'click', function () {
					location.href = "/goods/goodsModify?idx="+$(this).children().eq(0).text();
			    });

				
/* 				var searchBody = document.getElementById("searchBody");
				searchBody.innerHTML = html;

			    $('#dataTable').DataTable();
 */			}
				
						
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
		    language : "ko"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
		});
	});//ready end


	
</script>

</html>

