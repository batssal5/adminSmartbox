<%
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-Control","no-cache");
	response.addHeader("Cache-Control","no-store");
	response.setDateHeader("Expires",0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page = '<%="../common/vd_header.jsp" %>'/>

<script type="text/javascript" src="/bootstrab/js/js-datagrid.js"></script>
<script type="text/javascript" src="/bootstrab/js/js-aspnet-data.js"></script>

<link rel="stylesheet" href=/bootstrab/css/js-datagrid-style.css>

<script language="javascript">
	var lookup_status = [
		{
			"value": 0,
			"name": "판매중"
		},{
			"value": 1,
			"name": "판매종료"
		}
	];
	var lookup_used = [
		{
			"value": 0,
			"name": "Y"
		},{
			"value": 1,
			"name": "N"
		}
	];

	function cellTemplate(container, options) {
		let imgElement = document.createElement("img");
		imgElement.setAttribute("src", options.value);
		imgElement.setAttribute('width', '30');
		imgElement.setAttribute('height', '30');
		container.append(imgElement);
	}

	function editCellTemplate(cellElement, cellInfo) {
		let buttonElement = document.createElement("div");
		buttonElement.classList.add("retryButton");
		let retryButton = $(buttonElement).dxButton({
			text: "Retry",
			visible: false,
			onClick: function() {
				// The retry UI/API is not implemented. Use a private API as shown at T611719.
				for (var i = 0; i < fileUploader._files.length; i++) {
					delete fileUploader._files[i].uploadStarted;
				}
				fileUploader.upload();
			}
		}).dxButton("instance");

		let fileUploaderElement = document.createElement("div");
		let fileUploader = $(fileUploaderElement).dxFileUploader({
			name: "filedata",
			multiple: false,
			value: [],
			accept: "image/*",
			uploadMode: "instantly",
			uploadUrl: "/goods/goodsList/imageUpload",
			onValueChanged: function(e) {
				let reader = new FileReader();
				reader.onload = function(args) {
					imageElement.setAttribute('src', args.target.result);
					//console.log("result:"+args.target.result);
				}
				//console.log("e.value[0]:"+e.value[0]);
				reader.readAsDataURL(e.value[0]);
				this.value = e.value[0];
			},
			onUploaded: function(e){
				cellInfo.setValue(e.request.responseText);
				//console.log(e.request.responseText)
				retryButton.option("visible", false);
			},
			onUploadError: function(e){
				let xhttp = e.request;
				if(xhttp.status === 400){
					e.message = e.error.responseText;
				}
				if(xhttp.readyState === 4 && xhttp.status === 0) {
					e.message = "Connection refused";
				}
				retryButton.option("visible", true);
			}
		}).dxFileUploader("instance");

		let imageElement = document.createElement("img");
		imageElement.classList.add("uploadedImage");
		imageElement.setAttribute('src', cellInfo.value);
		imageElement.setAttribute('height', '80');

		cellElement.append(imageElement);
		cellElement.append(buttonElement);
		cellElement.append(fileUploaderElement);
	}
	$(function(){
		$("#gridContainer").dxDataGrid({
			dataSource: DevExpress.data.AspNet.createStore({
				key: "idx",
				loadUrl:   "./goodsList/json?type=get",
				insertUrl: "./goodsList/json?type=put",
				updateUrl: "./goodsList/json?type=post",
				deleteUrl: "./goodsList/json?type=delete",
				onBeforeSend: function(method, ajaxOptions) {
					ajaxOptions.xhrFields = { withCredentials: true };
				}
			}),
			remoteOperations: true,
			filterRow: { visible: true },
			columnAutoWidth: true,
			columns: [
				{
					caption: '#',
					cellTemplate: function(cellElement, cellInfo) {
						cellElement.text(function (){
							//var cnt       = $("#gridContainer").dxDataGrid("instance").pageCount();
							var pageSize  = $("#gridContainer").dxDataGrid("instance").pageSize();
							var pageIndex = $("#gridContainer").dxDataGrid("instance").pageIndex();
							var rowNum = (pageSize*pageIndex)+cellInfo.row.rowIndex+1;

							return rowNum;
						})
					},
					cssClass: "text-center",
					allowEditing: false
				}, {
					dataField: "skuid",
					cssClass: "text-center",
					caption: "SKUID"
				}, {
					dataField: "barcode",
					cssClass: "text-center",
					caption: "바코드"
				}, {
					dataField: "idx",
					cssClass: "text-center",
					caption: "상품코드"
				}, {
					dataField: "brand",
					caption: "브랜드",
					lookup: {
						dataSource: {
							paginate: true,
							store: new DevExpress.data.CustomStore({
								key: "brand",
								loadMode: "raw",
								load: function() {
									return $.getJSON("/lookup/brandJson");
								}
							}),
							sort: "brand_name"
						},
						valueExpr: "brand",
						displayExpr: "brand_name",
						visible: false
					}
				}, {
					dataField: "image",
					caption: "이미지",
					width: 50,
					cssClass: "text-center",
					cellTemplate: cellTemplate,
					editCellTemplate: editCellTemplate
				}, {
					dataField: "goods_name",
					caption: "상품명"
				}, {
					dataField: "price",
					cssClass: "text-right",
					caption: "기본가격",
					cellTemplate: function(cellElement, cellInfo) {
						cellElement.text(numberWithCommas(cellInfo.value))
					}
				}, {
					dataField: "regdate",
					caption: "등록일",
					width: 80,
					cssClass: "text-center",
					dataType: "date",
					format: "yy-MM-dd"
				}, {
					dataField: "weight",
					visible: false,
					caption: "상품무게"
				}, {
					dataField: "used",
					visible: false,
					caption: "판매여부",
					cssClass: "text-center",
					lookup: {
						displayExpr: "name",
						valueExpr: "value",
						dataSource: lookup_used
					}
				}, {
					dataField: "status",
					visible: false,
					caption: "상태",
					cssClass: "text-center",
					lookup: {
						displayExpr: "name",
						valueExpr: "value",
						dataSource: lookup_status
					}
				}
			],
			showBorders: true,
			scrolling: {
				rowRenderingMode: 'virtual'
			},
			pager: {
				visible: true,
				allowedPageSizes: [10, 20, 30, 'all'],
				showPageSizeSelector: true,
				showInfo: true,
				showNavigationButtons: true
			},
			paging: {
				pageSize: 10
			},
			height: 630,
			masterDetail: {
				enabled: true,
				template: function(container, options) {
					$("<div>")
							.dxDataGrid({
								columnAutoWidth: true,
								showBorders: true,
								columns: [
									{
										dataField: "agency_idx",
										caption: "고객사명",
										setCellValue: function(rowData, value) {
											rowData.agency_idx = value;
											rowData.store_num = null;
										},
										lookup: {
											dataSource: {
												paginate: true,
												store: new DevExpress.data.CustomStore({
													key: "agency_idx",
													loadMode: "raw",
													load: function() {
														return $.getJSON("/lookup/agencyJson");
													}
												}),
												sort: "agency_name"
											},
											valueExpr: "agency_idx",
											displayExpr: "agency_name",
											visible: false
										}
									}
								],
								dataSource: DevExpress.data.AspNet.createStore({
									loadUrl: "./goodsExhibitionDetail/json?type=get",
									insertUrl: "./goodsExhibitionDetail/json?type=put",
									updateUrl: "./goodsExhibitionDetail/json?type=post",
									deleteUrl: "./goodsExhibitionDetail/json?type=delete",
									key: "box_idx",
									loadParams: { goods_idx : options.data.idx },
									onBeforeSend: function(method, ajaxOptions) {
										ajaxOptions.xhrFields = { withCredentials: true };
									}
								}),
								masterDetail: {
									enabled: true,
									template: function(container, options) {
										$("<div>")
												.dxDataGrid({
													showBorders: true,
													columns: [
														{
															dataField: "sto_name",
															caption: "매장명",
															allowEditing: false
														},
														{
															dataField: "box_name",
															caption: "박스명",
															allowEditing: false
														},
														{
															dataField: "goods_price",
															caption: "기본가격",
															allowEditing: false,
															cellTemplate: function(cellElement, cellInfo) {
																cellElement.text(numberWithCommas(cellInfo.value))
															}
														},
														{
															dataField: "price",
															caption: "실판매 가격",
															allowEditing: false,
															cellTemplate: function(container, cellInfo) {
																var html =  "";
																html +=	"<div class=\"d-inline text-success pr-1\">\n";
																html += numberWithCommas(cellInfo.value)+"</div>";
																$(html).appendTo(container);
															}
														},
														{
															dataField: "agc_used",
															caption: "고객사별 가격 사용 유무",
															cssClass: "text-center",
															lookup: {
																displayExpr: "name",
																valueExpr: "value",
																dataSource: lookup_used
															},
															visible: false
														},
														{
															dataField: "agc_price",
															caption: "고객사별 가격",
															cssClass: "text-left",
															cellTemplate: function(container, cellInfo) {
																var html =  "";
																if(cellInfo.data.agc_used==0 && cellInfo.data.sto_used!=0 && cellInfo.data.box_used!=0){
																	html +=	"<div class=\"d-inline text-primary pr-1\">\n";
																}else{
																	html +=	"<div class=\"d-inline text-dark pr-1\">\n";
																}
																if(cellInfo.data.agc_used==0) {
																	html +=		"   <i class=\"ion-android-checkbox-outline\"></i>&nbsp;"
																}else{
																	html +=		"   <i class=\"ion-android-checkbox-outline-blank\"></i>&nbsp;"
																}
																if (cellInfo.value == -1) {
																	html += "미등록";
																} else {
																	html += numberWithCommas(cellInfo.value);
																}
																html += "</div>";
																$(html).appendTo(container);
															}
														},
														{
															dataField: "sto_used",
															caption: "매장별 가격 사용 유무",
															cssClass: "text-center",
															lookup: {
																displayExpr: "name",
																valueExpr: "value",
																dataSource: lookup_used
															},
															visible: false
														},
														{
															dataField: "sto_price",
															caption: "매장별 가격",
															cssClass: "text-left",
															cellTemplate: function(container, cellInfo) {
																var html =  "";
																if(cellInfo.data.sto_used==0 && cellInfo.data.box_used!=0){
																	html +=	"<div class=\"d-inline text-primary pr-1\">\n";
																}else{
																	html +=	"<div class=\"d-inline text-dark pr-1\">\n";
																}
																if(cellInfo.data.sto_used==0) {
																	html +=		"   <i class=\"ion-android-checkbox-outline\"></i>&nbsp;"
																}else{
																	html +=		"   <i class=\"ion-android-checkbox-outline-blank\"></i>&nbsp;"
																}
																if (cellInfo.value == -1) {
																	html += "미등록";
																} else {
																	html += numberWithCommas(cellInfo.value);
																}
																html += "</div>";
																$(html).appendTo(container);
															}
														},
														{
															dataField: "box_used",
															caption: "박스별 가격 사용 유무",
															cssClass: "text-center",
															lookup: {
																displayExpr: "name",
																valueExpr: "value",
																dataSource: lookup_used
															},
															visible: false
														},
														{
															dataField: "box_price",
															caption: "박스별 가격",
															cssClass: "text-left",
															cellTemplate: function(container, cellInfo) {
																var html = "";
																if(cellInfo.data.box_used==0){
																	html +=	"<div class=\"d-inline text-primary pr-1\">\n";
																}else{
																	html +=	"<div class=\"d-inline text-dark pr-1\">\n";
																}
																if (cellInfo.data.box_used == 0) {
																	html += "   <i class=\"ion-android-checkbox-outline\"></i>&nbsp;"
																} else {
																	html += "   <i class=\"ion-android-checkbox-outline-blank\"></i>&nbsp;"
																}
																if (cellInfo.value == -1) {
																	html += "미등록";
																} else {
																	html += numberWithCommas(cellInfo.value);
																}
																html += "</div>";
																$(html).appendTo(container);
															}
														}
													],
													editing: {
														mode: "form",
														useIcons: true,
														allowAdding: false,
														allowUpdating: true,
														allowDeleting: false,
														texts: {
															confirmDeleteMessage: "해당 데이터를 삭제 합니다."
														}
													},
													dataSource: DevExpress.data.AspNet.createStore({
														loadUrl: "./goodsExhibitionDetail/json?type=get",
														insertUrl: "./goodsExhibitionDetail/json?type=put",
														updateUrl: "./goodsExhibitionDetail/json?type=post",
														deleteUrl: "./goodsExhibitionDetail/json?type=delete",
														key: ["box_idx","goods_idx","agency_idx","agc_sto_idx"],
														loadParams: { goods_idx : options.data.goods_idx, agency_idx : options.data.agency_idx },
														onBeforeSend: function(method, ajaxOptions) {
															ajaxOptions.xhrFields = { withCredentials: true };
														}
													})
												}).appendTo(container);
									}
								}
							}).appendTo(container);
				}
			},
			/*
			editing: {
				mode: "form",
				useIcons: true,
				allowAdding: true,
				allowUpdating: true,
				allowDeleting: true,
				texts: {
					confirmDeleteMessage: "해당 데이터를 삭제 합니다."
				}
			},*/
			grouping: {
				autoExpandAll: false
			},
			onCellPrepared: function(e, cellInfo) {
				if (e.rowType == "header") {
					e.cellElement.css("text-align", "center");
				}
				if (e.rowType == "data") {
					e.cellElement.css("text-align", "left");
				}
			},
			onEditorPreparing: function(e) {

				if (e.parentType === "dataRow" && e.row.isEditing && !e.row.isNewRow) {//수정일때는 readonly처리
					if (e.dataField === "regdate") {
						e.editorOptions.readOnly = true;
					}
					if (e.dataField === "idx") {
						e.editorOptions.readOnly = true;
						e.editorOptions.disabled = true;
					}
				}

				if (e.parentType === "dataRow" && e.row.isEditing && e.row.isNewRow) {//등록일 때 활성화
					if (e.dataField === "regdate") {
						e.editorOptions.readOnly = true;
					}
					if (e.dataField === "idx") {
						e.editorOptions.readOnly = true;
						e.editorOptions.disabled = true;
					}
				}
			}
		});
	});
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
	<jsp:include page = '<%="../common/vd_top_tabmenu.jsp" %>'/>
	<div class="app-inner-layout__wrapper">
		<div class="app-inner-layout__content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-12 col-lg-12">
						<div class="mb-3 card">
							<div class="card-header-tab card-header">
								<div class="card-header-title font-size-lg text-capitalize font-weight-normal">
									<i class="header-icon lnr-cloud-download icon-gradient bg-happy-itmeo"> </i>
									상품 > 상품관리 > 상품진열/가격관리
								</div>
								<div class="btn-actions-pane-right text-capitalize actions-icon-btn">
									<div class="btn-group dropdown">
										<button type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn-icon btn-icon-only btn btn-link">
											<i class="pe-7s-menu btn-icon-wrapper"></i>
										</button>
										<div tabindex="-1" role="menu" aria-hidden="true" class="dropdown-menu-right rm-pointers dropdown-menu-shadow dropdown-menu-hover-link dropdown-menu">
											<h6 tabindex="-1" class="dropdown-header">Header</h6>
											<button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-inbox"> </i><span>Menus</span>
											</button>
											<button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-file-empty"> </i><span>Settings</span>
											</button>
											<button type="button" tabindex="0" class="dropdown-item"><i class="dropdown-icon lnr-book"> </i><span>Actions</span>
											</button>
											<div tabindex="-1" class="dropdown-divider"></div>
											<div class="p-3 text-right">
												<button class="mr-2 btn-shadow btn-sm btn btn-link">
													View Details
												</button>
												<button class="mr-2 btn-shadow btn-sm btn btn-primary">
													Action
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="p-2 card-body">
								<div id="gridContainer"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page = '<%="../common/vd_footer.jsp" %>'/>
