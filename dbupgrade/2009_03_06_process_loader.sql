alter table CLW_TASK_PROPERTY add TASK_PROPERTY_STATUS_CD VARCHAR2(30);
alter table CLW_TASK_REF add TASK_REF_STATUS_CD VARCHAR2(30);

update CLW_TASK_PROPERTY set TASK_PROPERTY_STATUS_CD = 'ACTIVE' where TASK_PROPERTY_STATUS_CD is null;
update CLW_TASK_REF set TASK_REF_STATUS_CD = 'ACTIVE' where TASK_REF_STATUS_CD is null;
