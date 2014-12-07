package com.bondeko.sysgeho.ui.admin.util;

/**
 * 
 */

import com.bondeko.sysgeho.be.admin.svco.utilisateur.IRemoteRol;
import com.bondeko.sysgeho.be.admin.svco.utilisateur.IRemoteSvc;
import com.bondeko.sysgeho.be.admin.svco.utilisateur.IRemoteUsr;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoSvcoDeleguate;

public class AdminSvcoDeleguate {

	BaseLogger logger = BaseLogger.getLogger(AdminSvcoDeleguate.class);
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
	
	/**
	 * Retourne le service composé pour la gestion des Utilisateurs
	 * 
	 * @return
	 * @throws ServiceLocatorException
	 */
	public static IRemoteUsr getSvcoUsr() throws ServiceLocatorException{
        return (IRemoteUsr) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoUsr", IRemoteUsr.class));
    }
	
	public static IRemoteSvc getSvcoSvc() throws ServiceLocatorException{
        return (IRemoteSvc) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoSvc", IRemoteSvc.class));
    }
	
	public static IRemoteRol getSvcoRol() throws ServiceLocatorException{
        return (IRemoteRol) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoRol", IRemoteRol.class));
    }
	
	public BaseLogger getLogger() {
		return logger;
	}

	public void setLogger(BaseLogger logger) {
		this.logger = logger;
	}	
	
}
