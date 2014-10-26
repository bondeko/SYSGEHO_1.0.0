package com.bondeko.sysgeho.ui.fac.util;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.fac.svco.IRemoteFacConv;
import com.bondeko.sysgeho.be.fac.svco.IRemoteFacCour;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoSvcoDeleguate;

public class FactureSvcoDeleguate {
	
	BaseLogger logger = BaseLogger.getLogger(FactureSvcoDeleguate.class);
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
	
	public static IRemoteFacCour getSvcoFacCour() throws ServiceLocatorException{
        return (IRemoteFacCour) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoFacCour", IRemoteFacCour.class));
    }
	
	public static IRemoteFacConv getSvcoFacConv() throws ServiceLocatorException{
        return (IRemoteFacConv) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoFacConv", IRemoteFacConv.class));
    }
	
	public BaseLogger getLogger() {
		return logger;
	}

	public void setLogger(BaseLogger logger) {
		this.logger = logger;
	}	

}
