CREATE TABLE tmp_1003
AS
     SELECT   manufacturer, store_id
       FROM   #LOADING_TABLE_NAME# loaded
      WHERE   NOT EXISTS
                 (SELECT   *
                    FROM   clw_bus_entity, clw_bus_entity_assoc
                   WHERE   (clw_bus_entity.bus_entity_id =
                               clw_bus_entity_assoc.bus_entity1_id)
                           AND (clw_bus_entity.bus_entity_type_cd =
                                   'MANUFACTURER')
                           AND (clw_bus_entity_assoc.bus_entity_assoc_cd =
                                   'MANUFACTURER OF STORE')
                           AND (loaded.manufacturer = clw_bus_entity.short_desc)
                           AND (loaded.store_id =
                                   clw_bus_entity_assoc.bus_entity2_id))
   GROUP BY   manufacturer, store_id;

CREATE TABLE tmp_1004
AS
   SELECT   clw_bus_entity_seq.NEXTVAL AS new_bus_entity_id,
            manufacturer,
            store_id
     FROM   tmp_1003;

INSERT   ALL
  INTO   clw_bus_entity
         (
             bus_entity_id,
             short_desc,
             long_desc,
             eff_date,
             exp_date,
             bus_entity_type_cd,
             bus_entity_status_cd,
             workflow_role_cd,
             locale_cd,
             erp_num,
             add_date,
             add_by,
             mod_date,
             mod_by,
             time_zone_cd
         )
VALUES
         (
             new_bus_entity_id,
             manufacturer,
             NULL,
             NULL,
             NULL,
             'MANUFACTURER',
             'ACTIVE',
             'UNKNOWN',
             'en_US',
             NULL,
             CURRENT_DATE,
             '#USER_NAME#',
             CURRENT_DATE,
             '#USER_NAME#',
             NULL
         )
  INTO   clw_bus_entity_assoc
         (
             bus_entity_assoc_id,
             bus_entity1_id,
             bus_entity2_id,
             bus_entity_assoc_cd,
             add_date,
             add_by,
             mod_date,
             mod_by
         )
VALUES
         (
             clw_bus_entity_assoc_seq.NEXTVAL,
             new_bus_entity_id,
             store_id,
             'MANUFACTURER OF STORE',
             CURRENT_DATE,
             '#USER_NAME#',
             CURRENT_DATE,
             '#USER_NAME#'
         )
  INTO   tmp_mnf_alias
         (
	         manuf_id, 
			 alias
         )
VALUES
         (
             new_bus_entity_id,
             manufacturer
         )
   SELECT   new_bus_entity_id, manufacturer, store_id FROM tmp_1004;

