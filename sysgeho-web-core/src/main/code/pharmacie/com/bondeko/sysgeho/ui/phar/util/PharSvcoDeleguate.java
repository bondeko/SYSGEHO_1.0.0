package com.bondeko.sysgeho.ui.phar.util;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.phar.svco.IRemoteCatProd;
import com.bondeko.sysgeho.be.phar.svco.IRemoteDepart;
import com.bondeko.sysgeho.be.phar.svco.IRemoteFour;
import com.bondeko.sysgeho.be.phar.svco.IRemoteMouvStock;
import com.bondeko.sysgeho.be.phar.svco.IRemoteProd;
import com.bondeko.sysgeho.be.phar.svco.IRemoteSousCatProd;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoSvcoDeleguate;

public class PharSvcoDeleguate {
	
	BaseLogger logger = BaseLogger.getLogger(PharSvcoDeleguate.class);
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
	
	public static IRemoteCatProd getSvcoCatProd() throws ServiceLocatorException{
        return (IRemoteCatProd) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoCatProd", IRemoteCatProd.class));
    }
	
	public static IRemoteSousCatProd getSvcoSousCatProd() throws ServiceLocatorException{
        return (IRemoteSousCatProd) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoSousCatProd", IRemoteSousCatProd.class));
    }
	
	public static IRemoteProd getSvcoProd() throws ServiceLocatorException{
        return (IRemoteProd) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoProd", IRemoteProd.class));
    }
	
	public static IRemoteFour getSvcoFour() throws ServiceLocatorException{
        return (IRemoteFour) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoFour", IRemoteFour.class));
    }
	
	public static IRemoteDepart getSvcoDepart() throws ServiceLocatorException{
        return (IRemoteDepart) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoDepart", IRemoteDepart.class));
    }
	
	public static IRemoteMouvStock getSvcoMouvStock() throws ServiceLocatorException{
        return (IRemoteMouvStock) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoMouvStock", IRemoteMouvStock.class));
    }
	
	public BaseLogger getLogger() {
		return logger;
	}



	public void setLogger(BaseLogger logger) {
		this.logger = logger;
	}	

}
