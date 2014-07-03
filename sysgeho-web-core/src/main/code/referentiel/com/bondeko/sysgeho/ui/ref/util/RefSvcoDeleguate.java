package com.bondeko.sysgeho.ui.ref.util;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.ui.core.base.SysGehoSvcoDeleguate;

public class RefSvcoDeleguate {
	
	BaseLogger logger = BaseLogger.getLogger(RefSvcoDeleguate.class);
	/**
	 * Retourne le nom du Bean du Service compos� en fonction du nom de l'entit� (@param p$p$beanName)
	 * 
	 * @param p$beanName
	 * @return
	 */
	private static String getSvcoBeanName(String p$beanName, Class<?> p$remoteInterface){		
		
		return SysGehoSvcoDeleguate.getSvcoBeanName(p$beanName, p$remoteInterface);
	}
				
	/*================================== Services compos�s de la Partie Technique =================================*/

	public BaseLogger getLogger() {
		return logger;
	}



	public void setLogger(BaseLogger logger) {
		this.logger = logger;
	}	

}
