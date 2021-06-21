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
                key: "idx",
                loadUrl:   "./agencyMng/json?type=get",
                insertUrl: "./agencyMng/json?type=put",
                updateUrl: "./agencyMng/json?type=post",
                deleteUrl: "./agencyMng/json?type=delete",
                onBeforeSend: function(method, ajaxOptions) {
                    ajaxOptions.xhrFields = { withCredentials: true };
                }
            }),
            remoteOperations: true,
            columns: [
                {
                    width: 100,
                    dataField: "idx",
                    caption: "사업자ID",
                    cssClass: "text-center",
                    visible: false,
                    allowEditing: false,
                    visible:false
                }, {
                    dataField: "company_nm",
                    caption: "사업자명"
                }, {
                    dataField: "company_num",
                    caption: "사업자번호"
                }, {
                    dataField: "rep_nm",
                    caption: "대표자명"
                }, {
                    dataField: "rep_tel",
                    caption: "대표번호"
                }, {
                    dataField: "rep_email",
                    caption: "이메일"
                }, {
                    dataField: "address",
                    caption: "주소"
                }, {
                    dataField: "addr_detail",
                    caption: "주소상세",
                    visible: false
                }, {
                    dataField: "zipcode",
                    caption: "우편번호",
                    visible: false
                }, {
                    dataField: "regdate",
                    caption: "등록일",
                    width: 80,
                    cssClass: "text-center",
                    dataType: "date",
                    format: "yy-MM-dd"
                }, {
                    dataField: "description",
                    caption: "소개글",
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
