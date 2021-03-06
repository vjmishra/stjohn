
/* DO NOT EDIT - Generated code from XSL file ValueObject.xsl */

package com.cleanwise.service.api.meta;

/**
 * Title:        ProfileAssocDataMeta
 * Description:  This is a meta class describing the object of database table  CLW_PROFILE_ASSOC.
 * Purpose:
 * Copyright:    Copyright (c) 2009
 * Company:      CleanWise, Inc.
 * @author Generated Code from XSL file ValueObjectMeta.xsl
 */

import com.cleanwise.service.api.dao.ProfileAssocDataAccess;
import com.cleanwise.service.api.value.TableObject;
import com.cleanwise.service.api.cachecos.TableObjectFieldMeta;
import com.cleanwise.service.api.cachecos.TableField;

/**
 * <code>ProfileAssocDataMeta</code> is a meta class describing the database table object CLW_PROFILE_ASSOC.
 */
public class ProfileAssocDataMeta extends com.cleanwise.service.api.cachecos.TableObjectMeta {

    private static final long serialVersionUID = -1L; //ERROR. No Serial Version Provided
       
    /**
     * Constructor.
     */
    public ProfileAssocDataMeta(TableObject pData) {
        
        super(ProfileAssocDataAccess.CLW_PROFILE_ASSOC);

        if (pData != null) {
            TableObjectFieldMeta fm = new TableObjectFieldMeta();
            fm.setField(ProfileAssocDataAccess.PROFILE_ASSOC_ID);
            fm.setValue(pData.getFieldValue(ProfileAssocDataAccess.PROFILE_ASSOC_ID));
            addField(fm);
        }
    
    }

    /**
     * Constructor.
     */
    public ProfileAssocDataMeta(TableField... fields) {
        
        super(ProfileAssocDataAccess.CLW_PROFILE_ASSOC);

        for (TableField field : fields) {
            TableObjectFieldMeta fm = new TableObjectFieldMeta();
            fm.setField(field.getName());
            fm.setValue(field.getValue());
            addField(fm);
        }
    
    }

}
    
