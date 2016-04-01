
drop table "CNP01_OWN"."GNP_INBOUND_EVENT";
drop table "CNP01_OWN"."GNP_INBOUND_EVENT_TYPE_LKUP";


CREATE TABLE "CNP01_OWN"."GNP_INBOUND_EVENT"
   (	"ID" NUMBER(19,0) NOT NULL ENABLE,
	"CREATED_AT" DATE,
	"TYPE_ID"  NUMBER(19,0),
	"NOTIFICATION_ID" VARCHAR2(255 CHAR),
	"REMOTEIP" VARCHAR2(255 CHAR),
	"REQUEST_HEADERS" CLOB,
	"UA_STRING" VARCHAR2(3000 CHAR),
	 PRIMARY KEY ("ID"));


CREATE TABLE "CNP01_OWN"."GNP_INBOUND_EVENT_TYPE_LKUP"
(	"ID" NUMBER(10,0) NOT NULL ENABLE,
   "TYPE" VARCHAR2(255 CHAR),
  PRIMARY KEY ("ID"));

alter table gnp_inbound_event
add constraint FK_tq7eegvqnnmmbdfr3ecyaafsh
foreign key (type_id)
references gnp_inbound_event_type_lkup;

insert into GNP_INBOUND_EVENT_TYPE_LKUP (ID, TYPE) values (1, 'send');
insert into GNP_INBOUND_EVENT_TYPE_LKUP (ID, TYPE) values (2, 'open');
insert into GNP_INBOUND_EVENT_TYPE_LKUP (ID, TYPE) values (3, 'cta');
insert into GNP_INBOUND_EVENT_TYPE_LKUP (ID, TYPE) values (4, 'bounce');
