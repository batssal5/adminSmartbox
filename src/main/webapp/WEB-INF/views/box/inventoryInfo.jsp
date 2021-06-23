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
	var inventory_status = [
		{
			"value": 0,
			"name": "정리완료"
		},{
			"value": 1,
			"name": "정리진행중"
		}, {
			"value": 2,
			"name": "오류"
		}
	];
	$(function(){
		$("#gridContainer").dxDataGrid({
			dataSource: DevExpress.data.AspNet.createStore({
				key: "idx",
				loadUrl:   "./inventoryInfo/json?type=get",
				insertUrl: "./inventoryInfo/json?type=put",
				updateUrl: "./inventoryInfo/json?type=post",
				deleteUrl: "./inventoryInfo/json?type=delete",
				onBeforeSend: function(method, ajaxOptions) {
					ajaxOptions.xhrFields = { withCredentials: true };
				}
			}),
			keyExpr: "idx",
			columnAutoWidth: true,
			remoteOperations: true,
			filterRow: { visible: true },
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
					dataField: "idx",
					cssClass: "text-center",
					caption: "재고번호"
				}, {
					width: 95,
					cssClass: "text-center",
					dataField: "box_id",
					caption: "박스ID",
					cellTemplate: function(cellElement, cellInfo) {
						cellElement.text(zerofill(cellInfo.value,10))
					}
				}, {
					dataField: "box_name",
					caption: "박스명",
					cssClass: "text-center"
				}, {
					dataField: "company_nm",
					caption: "본사명"
				}, {
					dataField: "agc_sto_name",
					caption: "지점명"
				}, {
					dataField: "agc_mem_id",
					caption: "담당자ID",
					cssClass: "text-center"
				}, {
					dataField: "agc_mem_name",
					caption: "담당자명",
					cssClass: "text-center"
				}, {
					dataField: "status",
					caption: "재고정리",
					cssClass: "text-center",
					lookup: {
						dataSource: inventory_status,
						displayExpr: "name",
						valueExpr: "value"
					}
				}, {
					dataField: "regdate",
					caption: "거래일",
					width: 80,
					cssClass: "text-center",
					dataType: "date",
					format: "yy-MM-dd"
				}
			],
			showBorders: true,
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
			masterDetail: {
				enabled: true,
				template: function(container, options) {
					$("<div>")
							.dxDataGrid({
								columnAutoWidth: true,
								showBorders: true,
								columns: [
									{
										caption: "제품이미지",
										dataField: "image",
										allowFiltering: false,
										allowSorting: false,
										width: 94,
										cssClass: "text-center",
										cellTemplate: function (container, options) {
											$("<div>")
													.append($("<img>", { "src": options.value }).width(80).height(80))
													.appendTo(container);
										}
									}, {
										dataField: "goods_name",
										caption: "제품명"
									}, {
										dataField: "price_form",
										caption: "가격"
									}, {
										dataField: "quantity",
										caption: "수량"
									}
								],
								dataSource: DevExpress.data.AspNet.createStore({
									loadUrl: "./inventoryDetailInfo/json?type=get",
									key: "inv_idx",
									loadParams: { inv_idx : options.data.idx },
									onBeforeSend: function(method, ajaxOptions) {
										ajaxOptions.xhrFields = { withCredentials: true };
									}
								}),
								rowTemplate: function(container, item) {
									var data = item.data,
											markup = "<tbody class='employee dx-row " + ((item.rowIndex % 2) ? 'dx-row-alt' : '') + "'>" +
													"<tr class='main-row'>" +
													"<td rowspan='2'><img src='" + data.image + "' width='80' height='80'/></td>" +
													"<td>" + data.goods_name + "</td>" +
													"<td>" + data.price_form + "</td>" +
													"<td>" + data.quantity + "</td>" +
													"</tr>" +
													/*"<tr class='notes-row'>" +
													"<td colspan='6'><div>" + data.quantity + "</div></td>" +
													"</tr>" +*/
													"</tbody>";

									container.append(markup);
								}
							}).appendTo(container);
				}
			},
			//images/smartbox/goods/
			/*editing: {
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
									박스 > 재고관리 > 재고관리내역
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
