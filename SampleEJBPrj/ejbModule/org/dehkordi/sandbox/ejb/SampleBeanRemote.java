package org.dehkordi.sandbox.ejb;

import javax.ejb.Remote;

@Remote
public interface SampleBeanRemote {
	
	String sayHello(String name);

}
