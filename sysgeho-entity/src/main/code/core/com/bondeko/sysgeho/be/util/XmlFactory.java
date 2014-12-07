package com.bondeko.sysgeho.be.util;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlFactory {
	
	private static XStream serializer = null;
	public static final String XML_ENCODING = "ISO-8859-1"; //"UTF-8"; 
	
	static{
		serializer = new XStream(new DomDriver(XML_ENCODING));
		serializer.registerConverter(new MapEntryConverter());
	}

	public static String getXmlStream(Object entity) throws Exception {
		try {
			String v$xmlString = "";			
			v$xmlString = serializer.toXML(entity);
			return v$xmlString;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("getXmlStream" + e.getMessage(), e);
		}
	}
}

