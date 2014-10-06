package com.bondeko.sysgeho.ui.imp.util;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.svco.IRemoteConsul;
import com.bondeko.sysgeho.be.imp.svco.IRemoteCpteRenduConsul;
import com.bondeko.sysgeho.be.imp.svco.IRemoteCpteRenduExam;
import com.bondeko.sysgeho.be.imp.svco.IRemoteExam;
import com.bondeko.sysgeho.be.imp.svco.IRemoteHospi;
import com.bondeko.sysgeho.be.imp.svco.IRemotePat;
import com.bondeko.sysgeho.be.imp.svco.IRemoteRdv;
import com.bondeko.sysgeho.be.imp.svco.IRemoteSoin;
import com.bondeko.sysgeho.be.imp.svco.IRemoteVisMedEmb;
import com.bondeko.sysgeho.be.imp.svco.IRemoteVisMedPerio;
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
	
	public static IRemoteCpteRenduConsul getSvcoCpteRenduConsul() throws ServiceLocatorException{
        return (IRemoteCpteRenduConsul) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoCpteRenduConsul", IRemoteCpteRenduConsul.class));
    }
	
	public static IRemoteConsul getSvcoConsul() throws ServiceLocatorException{
        return (IRemoteConsul) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoConsul", IRemoteConsul.class));
    }
	
	public static IRemoteHospi getSvcoHospi() throws ServiceLocatorException{
        return (IRemoteHospi) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoHospi", IRemoteHospi.class));
    }
	
	public static IRemoteCpteRenduExam getSvcoCpteRenduExam() throws ServiceLocatorException{
        return (IRemoteCpteRenduExam) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoCpteRenduExam", IRemoteCpteRenduExam.class));
    }
	
	public static IRemoteExam getSvcoExam() throws ServiceLocatorException{
        return (IRemoteExam) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoExam", IRemoteExam.class));
    }
	
	public static IRemoteSoin getSvcoSoin() throws ServiceLocatorException{
        return (IRemoteSoin) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoSoin", IRemoteSoin.class));
    }
	
	public static IRemoteVisMedEmb getSvcoVisMedEmb() throws ServiceLocatorException{
        return (IRemoteVisMedEmb) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoVisMedEmb", IRemoteVisMedEmb.class));
    }
	
	public static IRemoteVisMedPerio getSvcoVisMedPerio() throws ServiceLocatorException{
        return (IRemoteVisMedPerio) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoVisMedPerio", IRemoteVisMedPerio.class));
    }

	public BaseLogger getLogger() {
		return logger;
	}

	public void setLogger(BaseLogger logger) {
		this.logger = logger;
	}	

}
