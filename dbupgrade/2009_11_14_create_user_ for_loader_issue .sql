CREATE USER DWTMP IDENTIFIED BY "DWTMP"
  DEFAULT TABLESPACE USERS
  TEMPORARY TABLESPACE TEMP
  PROFILE DEFAULT
  ACCOUNT UNLOCK;
  -- 1 Role for DWTMP 
  GRANT DBA TO DWTMP;
  ALTER USER DWTMP DEFAULT ROLE ALL;
  -- 1 System Privilege for DWTMP 
  GRANT UNLIMITED TABLESPACE TO DWTMP;
  -- 1 Tablespace Quota for DWTMP 
  ALTER USER DWTMP QUOTA UNLIMITED ON USERS;

  -- Grant privileges to DW_STJOHN_STAGE 
  connect  DWTMP/DWTMP@STAGING; 
  GRANT CREATE ANY INDEX TO DW_STJOHN_STAGE;
  GRANT CREATE ANY TABLE TO DW_STJOHN_STAGE;
  GRANT DROP ANY INDEX   TO DW_STJOHN_STAGE;
  GRANT DROP ANY TABLE   TO DW_STJOHN_STAGE;
  GRANT SELECT ANY TABLE TO DW_STJOHN_STAGE;
  GRANT UPDATE ANY TABLE TO DW_STJOHN_STAGE;
  GRANT INSERT ANY TABLE TO DW_STJOHN_STAGE;
  -- Grant privileges to DW_QADATABASE 
/*
connect  DWTMP/DWTMP@STAGING; 
  GRANT CREATE ANY INDEX TO DW_QADATABASE;
  GRANT CREATE ANY TABLE TO DW_QADATABASE;
  GRANT DROP ANY INDEX   TO DW_QADATABASE;
  GRANT DROP ANY TABLE   TO DW_QADATABASE;
  GRANT SELECT ANY TABLE TO DW_QADATABASE;
  GRANT UPDATE ANY TABLE TO DW_QADATABASE;
  GRANT INSERT ANY TABLE TO DW_QADATABASE;
*/


  