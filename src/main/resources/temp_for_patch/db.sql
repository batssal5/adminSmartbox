/*가입 정보 약관 관련 정의*/
create table policy_terms_of_service
(
    app_type int null,
    catagory varchar(20) null,
    c_context varchar(10240) null,
    a_context varchar(10240) null
)
    comment '가입약관정보관련정의';

create index policy_terms_of_service_index
	on policy_terms_of_service (app_type, catagory);


/*앱 제한 설정 관련 정보 필드 추가*/
alter table app_info   add c_auth_conn int default 0 null;

alter table app_info
    add c_auth_purchase int default 0 null;

alter table app_info
    add c_auto_logout_min int default 30 null;

alter table app_info
    add a_auth_inventory int default 0 null;

alter table app_info
    add a_auto_logout_min int default 30 null;

/*반품 정책 관련 테이블*/
create table policy_refound
(
    idx int auto_increment,
    name varchar(30) null,
    value varchar(30) null,
    constraint app_policy_refound_pk
        primary key (idx)
)
    comment '앱관련 환불정책';

/*결제수단 정책 관련 테이블*/
create table policy_payment
(
    idx int auto_increment,
    card_type int default 0 null,
    using_type int default 0 null,
    value int default 0 null,
    constraint policy_payment_pk
        primary key (idx)
)
    comment '결제수단설정';

/*사업자 매장 필드추가*/
alter table agency_store   add pg_comm float default 0.0 NOT NULL COMMENT 'PG수수료';
alter table agency_store   add vd_comm float default 0.0 NOT NULL COMMENT 'VD수수료';
