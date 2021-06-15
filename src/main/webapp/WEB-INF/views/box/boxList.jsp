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
	$(function(){
		var url = "http://localhost:8888/box";
		$("#gridContainer").dxDataGrid({
			dataSource: DevExpress.data.AspNet.createStore({
				key: "box_idx",
				loadUrl: url + "/boxList/json?type=get",
				insertUrl: url + "/boxList/json?type=get",
				updateUrl: url + "/boxList/json?type=get",
				deleteUrl: url + "/boxList/json?type=get",
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
			columns: [{
				dataField: "box_idx",
				caption: "Box Id",
				validationRules: [{
					type: "stringLength",
					message: "The field Customer must be a string with a maximum length of 5.",
					max: 5
				}]
			}, {
				dataField: "box_name",
				caption: "박스명"
			}, {
				dataField: "ShipCountry",
				validationRules: [{
					type: "stringLength",
					message: "The field ShipCountry must be a string with a maximum length of 15.",
					max: 15
				}]
			}, {
				dataField: "ShipVia",
				caption: "Shipping Company"/*,
				dataType: "number",
				lookup: {
					dataSource: DevExpress.data.AspNet.createStore({
						key: "Value",
						loadUrl: url + "/ShippersLookup",
						onBeforeSend: function(method, ajaxOptions) {
							ajaxOptions.xhrFields = { withCredentials: true };
						}
					}),
					valueExpr: "Value",
					displayExpr: "Text"
				}*/
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
			scrolling: {
				rowRenderingMode: 'virtual'
			},
			pager: {
				visible: true,
				allowedPageSizes: [10, 25, 'all'],
				showPageSizeSelector: true,
				showInfo: true,
				showNavigationButtons: true
			},
			paging: {
				pageSize: 10
			},
			height: 600,
			showBorders: true,
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
				allowAdding: true,
				allowUpdating: true,
				allowDeleting: true
			},
			grouping: {
				autoExpandAll: false
			},
			summary: {
				totalItems: [{
					column: "Freight",
					summaryType: "sum"
				}],
				groupItems: [{
					column: "Freight",
					summaryType: "sum"
				}, {
					summaryType: "count"
				}
				]
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
