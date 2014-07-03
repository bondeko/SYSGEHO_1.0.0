package com.bondeko.sysgeho.be.util;

public enum SysGehoPrinterExportEnum {
	
	PDF,
	EXCEL,
	EXCELX,
	DOC,
	DOCX,
	HTML,
	CSV;
	
	public static SysGehoPrinterExportEnum getByName(String value){
		for(SysGehoPrinterExportEnum prt : SysGehoPrinterExportEnum.class.getEnumConstants()){
			if(prt.name().equalsIgnoreCase(value))
				return prt;
		}
		return null;
	}

}
