package org.dehkordi.sandbox.ejb;

import javax.ejb.Remote;

@Remote
public interface SingeltonBeanRemote {
	
	String getData();
	
	void addToData(String txt);

}
