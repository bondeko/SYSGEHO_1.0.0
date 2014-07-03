package com.bondeko.sysgeho.ui.core.controleur;

import com.bondeko.sysgeho.ui.core.base.FacesUtil;




public class RequestCtrl {
	
	public RequestCtrl() {
								
	}

	public String pageBeforePreview(){
		return FacesUtil.getSessionMapValue("pageBeforePreview").toString();
	}
	

}
