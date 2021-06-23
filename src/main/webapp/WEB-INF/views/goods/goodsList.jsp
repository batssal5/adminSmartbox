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
	let backendURL = "http://localhost:8888/"

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
					console.log("result:"+args.target.result);
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
					dataField: "brand_name",
					caption: "브랜드"
				}, {
					dataField: "image",
					caption: "이미지",
					width: 50,
					cssClass: "text-center",
					cellTemplate: cellTemplate,
					editCellTemplate: editCellTemplate
					/*cellTemplate: function (container, options) {
						$("<div>")
								.append($("<img>", { "src": options.value }).width(30).height(30))
								.appendTo(container);
					}*//*,
					editCellTemplate: function (cellElement, cellInfo) {
						$("<div />")
								.dxFileUploader({
									buttonText: 'Select File',
									labelText: cellInfo.value,
									multiple: false,
									accept: 'image/!*',
									onValueChanged: function (e) {
										this.labelText = e.value;
										cellInfo.setValue(e.value);
									}
								})
								.appendTo(cellElement);
					}*/
				}, {
					dataField: "goods_name",
					caption: "상품명"
				},{
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
					if (e.dataField === "regdate") {
						e.editorOptions.readOnly = true;
					}
					/*if (e.dataField === "image") {

						const defaultValueChangeHandler = e.editorOptions.onValueChanged;
						//e.editorName = "dxTextArea";
						e.editorOptions.onValueChanged = function (args) {  // Override the default handler
							// ...
							// Custom commands go here
							// ...
							// If you want to modify the editor value, call the setValue function:
							 e.setValue("newValue");
							 console.log("aa");
							// Otherwise, call the default handler:
							defaultValueChangeHandler(args);
						}
					}*/
				}

				if (e.parentType === "dataRow" && e.row.isEditing && e.row.isNewRow) {//등록일 때 활성화
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
									기본설정 > 사업자관리 > 매장관리
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
