package com.cleanwise.service.api.util;

import java.util.Collection;
import com.cleanwise.service.api.value.*;
import com.cleanwise.service.api.util.RefCodeNames;
import java.io.Serializable;


public class CatalogNode implements Serializable
  {
    private CatalogCategoryData _cat;
    private CatalogItemView _prod;
    private String _type;

    private String _name;
    private boolean _collapsed=true;
    private Collection _subCat;
    private Collection _subProd;
    private boolean _hasSubCat=false;
    private boolean _hasSubProd=false;
    private int _level;
//    private boolean _srcFlag;
//    private boolean _destFlag;

    public CatalogNode(Object pItem, int pLevel, Collection pSubCat, Collection pSubProd) {
      if(pItem instanceof CatalogCategoryData) {
        _cat = (CatalogCategoryData) pItem;
        _prod = null;
        _type = RefCodeNames.ITEM_TYPE_CD.CATEGORY;
      } else {
        _cat =null;
        _prod = (CatalogItemView) pItem;
        _type = RefCodeNames.ITEM_TYPE_CD.PRODUCT;
      }
      _level = pLevel;
      _subCat = pSubCat;
      _subProd = pSubProd;
      _collapsed = true;
      _hasSubCat =(pSubCat!=null&&pSubCat.size()>0)?true:false;
      _hasSubProd =(pSubCat!=null&&pSubProd.size()>0)?true:false;
//      _srcFlag = false;
//      _destFlag = false;
    }

    public String getType() {
      return _type;
    }


    public int getId() {
      if (_cat!=null) {
        return _cat.getCatalogCategoryId();
      } else {
        return _prod.getItemId();
      }
    }

    public int getProductSku() {
      if (_prod==null) {
	  // This is not a product node.
	  return 0;
      }
      return _prod.getSkuNum();
    }

    public String getMajorCategoryName() {
      if (_cat!=null) {
        ItemData iD = _cat.getMajorCategory();
        if(iD!=null) {
          return iD.getShortDesc();
        } else {
          return null;
        }
      } else {
        return null;
      }
    }

    public ItemData getMajorCategory() {
      if (_cat!=null) {
        ItemData iD = _cat.getMajorCategory();
        return iD;
      } else {
        return null;
      }
    }

    public String getName() {
      if (_cat!=null) {
        return _cat.getCatalogCategoryShortDesc();
      } else {
        return _prod.getName();
      }
    }


    public void setObject(Object pObject) {
      if(pObject instanceof CatalogCategoryData) {
        _cat = (CatalogCategoryData) pObject;
        _prod = null;
        _type = RefCodeNames.ITEM_TYPE_CD.CATEGORY;
      } else if(pObject instanceof CatalogItemView) {
        _cat =null;
        _prod = (CatalogItemView) pObject;
        _type = RefCodeNames.ITEM_TYPE_CD.PRODUCT;
      }
    }
    public Object getObject() {
      if (_cat!=null) {
        return _cat;
      } else {
        return _prod;
      }
    }


    public void setCollapsed(boolean pCollapsed) {_collapsed = pCollapsed;}
    public boolean getCollapsed() {return _collapsed;}

    public void setSubCat(Collection pSubCat){
      _subCat=pSubCat;
      if(pSubCat.size()>0) {
        _hasSubCat=true;
      }
    }
    public Collection getSubCat() {return _subCat;}

    public void setSubProd(Collection pSubProd){
      _subProd=pSubProd;
      if(pSubProd.size()>0) {
        _hasSubProd=true;
      }
    }
    public Collection getSubProd() {return _subProd;}

    public boolean getHasSubCat() {return _hasSubCat;}

    public boolean getHasSubProd() {return _hasSubProd;}

    public boolean getHasSub() {return _hasSubCat||_hasSubProd;}

    public void setLevel (int pLevel) {_level = pLevel;}
    public int getLevel () {return _level;}

//    public void setSrcFlag (boolean pSrcFlag) {
//    _srcFlag=pSrcFlag;
//    }
//    public boolean isSrcFlag () {return _srcFlag;}
//    public boolean getSrcFlag () {return _srcFlag;}

//    public void setDestFlag (boolean pDestFlag) {_destFlag=pDestFlag;}
//    public boolean isDestFlag () {return _destFlag;}
  }
