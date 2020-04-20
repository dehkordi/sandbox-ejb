package org.dehkordi.sandbox.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class SingeltonBean
 */
@Singleton(name="MySingeltonEJB")
@LocalBean
public class SingeltonBean implements SingeltonBeanRemote {

	StringBuilder data;
	
    /**
     * Default constructor. 
     */
    public SingeltonBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String getData() {
		return data.toString();
	}

	@Override
	public void addToData(String txt) {
		data.append(txt);
	}
	
	@PostConstruct
	@PostActivate
	private void createDataInstance() {
		data = new StringBuilder();
	}
	
	
	@PrePassivate
	@PreDestroy
	private void destroyDataInstance() {
		data = null;
	}

}
