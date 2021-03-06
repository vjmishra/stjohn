package com.johnsondiversey.msds.msdswebservice.jdimsds;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2012-06-06T17:33:59.188-04:00
 * Generated source version: 2.6.0
 * 
 */
@WebService(targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS", name = "JohnsonDiversey_x0020_MSDS_x0020_Web_x0020_ServicesSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface JohnsonDiverseyX0020MSDSX0020WebX0020ServicesSoap {

    /**
     * Method to get JohnsonDiversey MSDS by supplying Stock Keeping Units(SKU), ISO Country Code and ISO Language Code in XML format
     */
    @WebResult(name = "GetMSDSXMLResult", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS")
    @RequestWrapper(localName = "GetMSDSXML", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS", className = "com.johnsondiversey.msds.msdswebservice.jdimsds.GetMSDSXML")
    @WebMethod(operationName = "GetMSDSXML", action = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS/GetMSDSXML")
    @ResponseWrapper(localName = "GetMSDSXMLResponse", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS", className = "com.johnsondiversey.msds.msdswebservice.jdimsds.GetMSDSXMLResponse")
    public java.lang.String getMSDSXML(
        @WebParam(name = "XMLParameters", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS")
        java.lang.String xmlParameters
    );

    /**
     * Method to get JohnsonDiversey MSDS by supplying Stock Keeping Units(SKU), ISO Country Code and ISO Language Code.
     */
    @WebResult(name = "GetMSDSResult", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS")
    @RequestWrapper(localName = "GetMSDS", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS", className = "com.johnsondiversey.msds.msdswebservice.jdimsds.GetMSDS")
    @WebMethod(operationName = "GetMSDS", action = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS/GetMSDS")
    @ResponseWrapper(localName = "GetMSDSResponse", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS", className = "com.johnsondiversey.msds.msdswebservice.jdimsds.GetMSDSResponse")
    public java.lang.String getMSDS(
        @WebParam(name = "SKU", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS")
        java.lang.String sku,
        @WebParam(name = "CountryCode", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS")
        java.lang.String countryCode,
        @WebParam(name = "LanguageCode", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS")
        java.lang.String languageCode
    );

    /**
     * Method to get JohnsonDiversey MSDS by supplying Stock Keeping Units(SKU), ISO Country Code and ISO Language Code.
     */
    @WebResult(name = "GetMSDSProductLevelResult", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS")
    @RequestWrapper(localName = "GetMSDSProductLevel", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS", className = "com.johnsondiversey.msds.msdswebservice.jdimsds.GetMSDSProductLevel")
    @WebMethod(operationName = "GetMSDSProductLevel", action = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS/GetMSDSProductLevel")
    @ResponseWrapper(localName = "GetMSDSProductLevelResponse", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS", className = "com.johnsondiversey.msds.msdswebservice.jdimsds.GetMSDSProductLevelResponse")
    public java.lang.String getMSDSProductLevel(
        @WebParam(name = "Productid", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS")
        java.lang.String productid,
        @WebParam(name = "CountryCode", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS")
        java.lang.String countryCode,
        @WebParam(name = "LanguageCode", targetNamespace = "http://msds.johnsondiversey.com/MSDSWebService/JDIMSDS")
        java.lang.String languageCode
    );
}
