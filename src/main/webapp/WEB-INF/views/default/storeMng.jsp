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
    var lookup_used = [
        {
            "value": 0,
            "name": "Y"
        },{
            "value": 1,
            "name": "N"
        }
    ];
    var lookup_contract = [
        {
            "value": 0,
            "name": "Y"
        },{
            "value": 1,
            "name": "N"
        }
    ];
    var sb_cate = [
        {
            "value": -1,
            "name": "미사용"
        },{
            "value": 0,
            "name": "미지정"
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
                key: "store_idx",
                loadUrl:   "./storeMng/json?type=get",
                insertUrl: "./storeMng/json?type=put",
                updateUrl: "./storeMng/json?type=post",
                deleteUrl: "./storeMng/json?type=delete",
                onBeforeSend: function(method, ajaxOptions) {
                    ajaxOptions.xhrFields = { withCredentials: true };
                }
            }),
            remoteOperations: true,
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
                        displayExpr: "agency_name",
                        visible: false
                    }
                }, {
                    width: 60,
                    dataField: "store_idx",
                    caption: "지점ID",
                    cssClass: "text-center",
                    allowEditing: false,
                    visible: false
                }, {
                    dataField: "store_name",
                    caption: "지점명"
                }, {
                    dataField: "store_company_num",
                    caption: "지점사업번호"
                }, {
                    dataField: "store_address",
                    caption: "주소"
                }, {
                    dataField: "store_addr_detail",
                    caption: "주소상세",
                    visible: false
                }, {
                    dataField: "store_zipcode",
                    caption: "우편번호",
                    visible: false
                }, {
                    dataField: "cate",
                    caption: "상권",
                    visible: false,
                    lookup: {
                        displayExpr: "name",
                        valueExpr: "value",
                        dataSource: sb_cate
                    }
                }, {
                    width: 75,
                    dataField: "contract",
                    caption: "계약여부",
                    cssClass: "text-center",
                    lookup: {
                        displayExpr: "name",
                        valueExpr: "value",
                        dataSource: lookup_contract
                    }
                }, {
                    width: 75,
                    dataField: "used",
                    caption: "사용여부",
                    cssClass: "text-center",
                    lookup: {
                        displayExpr: "name",
                        valueExpr: "value",
                        dataSource: lookup_used
                    }
                }, {
                    width: 80,
                    dataField: "pg_comm",
                    cssClass: "text-center",
                    caption: "PG수수료"
                }, {
                    width: 80,
                    dataField: "vd_comm",
                    cssClass: "text-center",
                    caption: "VD수수료"
                }, {
                    dataField: "store_regdate",
                    caption: "등록일",
                    width: 80,
                    cssClass: "text-center",
                    dataType: "date",
                    format: "yy-MM-dd",
                    allowEditing: false
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
                                    기본설정 > 사업자관리 > 지점관리
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
