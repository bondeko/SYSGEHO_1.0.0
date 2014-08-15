package com.bondeko.sysgeho.ui.imp.util;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.svco.IRemotePat;
import com.bondeko.sysgeho.be.imp.svco.IRemoteRdv;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoSvcoDeleguate;

public class DossierPatientSvcoDeleguate {
	
	BaseLogger logger = BaseLogger.getLogger(DossierPatientSvcoDeleguate.class);
	/**
	 * Retourne le nom du Bean du Service composé en fonction du nom de l'entité (@param p$p$beanName)
	 * 
	 * @param p$beanName
	 * @return
	 */
	private static String getSvcoBeanName(String p$beanName, Class<?> p$remoteInterface){		
		
		return SysGehoSvcoDeleguate.getSvcoBeanName(p$beanName, p$remoteInterface);
	}
				
	/*================================== Services composés de la Partie Technique =================================*/
	
	public static IRemotePat getSvcoPat() throws ServiceLocatorException{
        return (IRemotePat) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoPat", IRemotePat.class));
    }
	
	public static IRemoteRdv getSvcoRdv() throws ServiceLocatorException{
        return (IRemoteRdv) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoRdv", IRemoteRdv.class));
    }

	public BaseLogger getLogger() {
		return logger;
	}

	public void setLogger(BaseLogger logger) {
		this.logger = logger;
	}	

}
