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
	var sb_status = [
		{
			"value": 0,
			"name": "정상(online)"
		},{
			"value": 1,
			"name": "비정상(offline)"
		}, {
			"value": 2,
			"name": "미사용(off)"
		}
	];
	var sb_cate = [
		{
			"value": -1,
			"name": "미사용"
		},{
			"value": 0,
			"name": "미사용2"
		},{
			"value": 1,
			"name": "번화가"
		},{
			"value": 2,
			"name": "사무실"
		}
	];
	$(function(){
		$("#gridContainer").dxDataGrid({
			dataSource: DevExpress.data.AspNet.createStore({
				key: "box_id",
				loadUrl:   "./boxList/json?type=get",
				insertUrl: "./boxList/json?type=put",
				updateUrl: "./boxList/json?type=post",
				deleteUrl: "./boxList/json?type=delete",
				onBeforeSend: function(method, ajaxOptions) {
					ajaxOptions.xhrFields = { withCredentials: true };
				}
			}),
			remoteOperations: true,
/*{
   "box_idx":"1",
   "agc_idx":"1",
   "store_idx":"1",
   "serial":"e8ba572d803fbf264dec51774c03804_",
   "box_id":"1930",
   "box_name":"휘닉스밴딩박스_1",
   "agency_name":"(주)휘닉스밴딩",
   "store_name":"성무관1층 지점",
   "store_num":"1",
   "status":2,
   "regdate":"Jun 23, 2020, 11:42:27 PM",
   "moddate":"Jun 15, 2021, 2:44:03 PM",
   "description":"3c000d",
   "cate":"1"
}*/
			columns: [
				{
					caption: '#',
					cellTemplate: function(cellElement, cellInfo) {
						cellElement.text(cellInfo.row.rowIndex+1)
					},
					width: 40,
					cssClass: "text-center",
					allowEditing: false
				}, {
					width: 100,
					dataField: "box_id",
					caption: "박스ID",
					cssClass: "text-center",
					cellTemplate: function(cellElement, cellInfo) {
						cellElement.text(zerofill(cellInfo.value,10))
					}/*,
					validationRules: [{ type: "required" }, {
						type: "pattern",
						message: 'Your phone must have "(555) 555-5555" format!',
						pattern: /^\(\d{3}\) \d{3}-\d{4}$/i
					}]*/
				}, {
					dataField: "box_name",
					caption: "박스명"
				}, {
					dataField: "agc_idx",
					caption: "본사명",
					setCellValue: function(rowData, value) {
						rowData.agc_idx = value;
						rowData.store_num = null;
					},
					lookup: {
						dataSource: {
							paginate: true,
							store: new DevExpress.data.CustomStore({
								key: "agc_idx",
								loadMode: "raw",
								load: function() {
									return $.getJSON("/lookup/agencyJson");
								}
							}),
							sort: "agency_name"
						},
						valueExpr: "agc_idx",
						displayExpr: "agency_name"
					}
				}, {
					dataField: "store_num",
					caption: "지점명",
					lookup: {
						dataSource: function(options) {
							return {
								paginate: true,
								store: new DevExpress.data.CustomStore({
									key: "store_idx",
									loadMode: "raw",
									load: function() {
										return $.getJSON("/lookup/storeJson");
									}
								}),
								filter: options.data ? ["agc_idx", "=", options.data.agc_idx] : null,
								sort: "store_name"
							};
						},
						valueExpr: "store_idx",
						displayExpr: "store_name"
					}
				}, {
					dataField: "store_company_num",
					caption: "지점사업자번호"
				}, {
					width: 80,
					dataField: "status",
					caption: "박스상태",
					cssClass: "text-center",
					lookup: {
						dataSource: sb_status,
						displayExpr: "name",
						valueExpr: "value"
					},
					cellTemplate: function(container, options) {
						if (options.value == 0) {
							//var html =  "<img src=\"/bootstrab/assets/images/workup1.jpg\" width=\"25\" height=\"25\"></img>";
							var html =  "<div class=\"d-inline text-success pr-1\">\n" +
									"   <i class=\"ion-locked\"></i>\n" +
									"</div>";
							$(html).appendTo(container);
						} else if (options.value == 1) {
							var html =  "<div class=\"d-inline text-danger pr-1\">\n" +
										"   <i class=\"ion-unlocked\"></i>\n" +
										"</div>";
							$(html).appendTo(container);
						} else {
							var html =  "<div class=\"d-inline text-danger pr-1\">\n" +
									"   <i class=\"fa fa-exclamation-triangle\"></i>\n" +
									"</div>";
							$(html).appendTo(container);
						}
					}
				}, {
					dataField: "serial",
					caption: "박스시리얼넘버",
					visible: false
				}, /*{
					dataField: "cate",
					caption: "상권",
					visible: false,
					allowEditing: false,
					lookup: {
						displayExpr: "name",
						valueExpr: "value",
						dataSource: sb_cate
					}
				},*/ {
					dataField: "regdate",
					caption: "등록일",
					width: 80,
					cssClass: "text-center",
					dataType: "date",
					format: "yy-MM-dd"
				}, {
					dataField: "description",
					caption: "메모",
					visible: false
				}
			],
			/*filterRow: {
				visible: true
			},
			headerFilter: {
				visible: true
			},
			groupPanel: {
				visible: true
			},*/
			showBorders: true,
			/*allowColumnReordering: true,
			grouping: {
				autoExpandAll: true,
			},
			searchPanel: {
				visible: true
			},
			paging: {
				pageSize: 10
			},
			groupPanel: {
				visible: true
			},*/
			scrolling: {
				rowRenderingMode: 'virtual'
			},
			pager: {
				visible: true,
				allowedPageSizes: [15, 30, 'all'],
				showPageSizeSelector: true,
				showInfo: true,
				showNavigationButtons: true
			},
			paging: {
				pageSize: 15
			},
			height: 650,
			/*masterDetail: {
				enabled: true,
				template: function(container, options) {
					$("<div>")
							.dxDataGrid({
								dataSource: DevExpress.data.AspNet.createStore({
									loadUrl: url + "/OrderDetails",
									loadParams: { orderID : options.data.OrderID },
									onBeforeSend: function(method, ajaxOptions) {
										ajaxOptions.xhrFields = { withCredentials: true };
									}
								}),
								showBorders: true
							}).appendTo(container);
				}
			},*/
			editing: {
				mode: "form",
				useIcons: true,
				allowAdding: true,
				allowUpdating: true,
				allowDeleting: true,
				texts: {
					confirmDeleteMessage: "해당 데이터를 삭제 합니다."
				}
			},
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
					if (e.dataField === "box_id") {
						e.editorOptions.readOnly = true;
					}
					if (e.dataField === "regdate") {
						e.editorOptions.readOnly = true;
					}
					if (e.dataField === "agency_name") {
						e.editorOptions.readOnly = true;
					}
					if (e.dataField === "description") {
						e.editorName = "dxTextArea";
					}
				}

				if (e.parentType === "dataRow" && e.row.isEditing && e.row.isNewRow) {//등록일 때 활성화
					/*if (e.dataField === "agency_name") {
						e.editorOptions.allowEditing = true;
					}*/
					if (e.dataField === "description") {
						e.editorName = "dxTextArea";
					}
					if (e.dataField === "regdate") {
						e.editorOptions.readOnly = true;
					}
				}
				//회사 미선택시 지점 선택 불가처리
				if(e.parentType === "dataRow" && e.dataField === "store_num") {
					e.editorOptions.disabled = (typeof e.row.data.agc_idx !== "number");
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
									박스리스트
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
