package com.bondeko.sysgeho.ui.ref.util;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.ref.svco.IRemoteAss;
import com.bondeko.sysgeho.be.ref.svco.IRemoteCatExam;
import com.bondeko.sysgeho.be.ref.svco.IRemoteChrHospi;
import com.bondeko.sysgeho.be.ref.svco.IRemoteLit;
import com.bondeko.sysgeho.be.ref.svco.IRemoteSoc;
import com.bondeko.sysgeho.be.ref.svco.IRemoteSpec;
import com.bondeko.sysgeho.be.ref.svco.IRemoteTypExam;
import com.bondeko.sysgeho.be.ref.svco.IRemoteTypRdv;
import com.bondeko.sysgeho.be.ref.svco.IRemoteTypSoin;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoSvcoDeleguate;

public class RefSvcoDeleguate {
	
	BaseLogger logger = BaseLogger.getLogger(RefSvcoDeleguate.class);
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
	
	public static IRemoteSoc getSvcoSoc() throws ServiceLocatorException{
        return (IRemoteSoc) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoSoc", IRemoteSoc.class));
    }
	
	public static IRemoteAss getSvcoAss() throws ServiceLocatorException{
        return (IRemoteAss) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoAss", IRemoteAss.class));
    }
	
	public static IRemoteCatExam getSvcoCatExam() throws ServiceLocatorException{
        return (IRemoteCatExam) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoCatExam", IRemoteCatExam.class));
    }
	
	public static IRemoteTypExam getSvcoTypExam() throws ServiceLocatorException{
        return (IRemoteTypExam) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoTypExam", IRemoteTypExam.class));
    }
	
	public static IRemoteTypSoin getSvcoTypSoin() throws ServiceLocatorException{
        return (IRemoteTypSoin) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoTypSoin", IRemoteTypSoin.class));
    }
	
	public static IRemoteSpec getSvcoSpec() throws ServiceLocatorException{
        return (IRemoteSpec) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoSpec", IRemoteSpec.class));
    }
	
	public static IRemoteTypRdv getSvcoTypRdv() throws ServiceLocatorException{
        return (IRemoteTypRdv) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoTypRdv", IRemoteTypRdv.class));
    }
	
	public static IRemoteChrHospi getSvcoChrHospi() throws ServiceLocatorException{
        return (IRemoteChrHospi) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoChrHospi", IRemoteChrHospi.class));
    }
	
	public static IRemoteLit getSvcoLit() throws ServiceLocatorException{
        return (IRemoteLit) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoLit", IRemoteLit.class));
    }

	public BaseLogger getLogger() {
		return logger;
	}



	public void setLogger(BaseLogger logger) {
		this.logger = logger;
	}	

}
