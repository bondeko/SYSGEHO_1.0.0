package com.bondeko.sysgeho.ui.core.base;

import com.bondeko.sysgeho.be.admin.svco.utilisateur.IRemotePceJte;
import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;

public class SysGehoSvcoDeleguate {
	
	/**
	 * Service Locator avec gestion de cache
	 */
	private static CachingServiceLocator cachingServiceLocator;
	
	/**
	 * 
	 * @return
	 * @throws ServiceLocatorException
	 */
	public static CachingServiceLocator getCachingServiceLocator() throws ServiceLocatorException{
		if(cachingServiceLocator == null){
			cachingServiceLocator = CachingServiceLocator.getInstance();
			//cachingServiceLocator = CachingServiceLocator.getInstance("com.citech.ccolloc.ui.config.jndi");
		}
		return cachingServiceLocator;
	}

	/**
	 * Retourne le nom du Bean du Service compos� en fonction du nom de l'entit� (@param p$p$beanName)
	 * 
	 * @param p$beanName
	 * @return
	 */
	public static String getSvcoBeanName(String p$beanName, Class<?> p$remoteInterface){		
		
		return SvcoDeleguate.getSvcoBeanName(p$beanName,p$remoteInterface);
	}
		
	
	/*================================== Services compos�s G�n�riques =================================*/
	
	public static IRemotePceJte getSvcoPceJte() throws ServiceLocatorException{
        return (IRemotePceJte) SysGehoSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoPceJte", IRemotePceJte.class));
    }
	/**
	 * Methode g�n�rique retournant l' interface g�n�rique de CRUD en fonction du nom de l'entit� (p$beanName)
	 * 
	 * @param <T>
	 * @param p$beanName
	 * @return
	 * @throws ServiceLocatorException
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BaseEntity> IBaseSvco<T> getSvcoGeneric(String p$beanName,Class p$remoteInterface) throws ServiceLocatorException{
        return (IBaseSvco<T>) getCachingServiceLocator().lookup(getSvcoBeanName(p$beanName, p$remoteInterface));
    }		
	
	/**
	 * M�thode g�n�rique retournant le service compos� d'une entit� en fonction du nom (p$beanName)
	 * L'instance retourn�e devra etre cast�e chez le client en le type de retour ad�quat 
	 * 
	 * @param <T>
	 * @param type
	 * @param p$beanName
	 * @return
	 * @throws ServiceLocatorException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getSvco(T type, String p$beanName) throws ServiceLocatorException{
		return (T) getCachingServiceLocator().lookup(getSvcoBeanName(p$beanName, type.getClass() ));
	}
	
}
