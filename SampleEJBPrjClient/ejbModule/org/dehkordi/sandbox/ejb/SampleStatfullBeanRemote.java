package org.dehkordi.sandbox.ejb;

import javax.ejb.Remote;

@Remote
public interface SampleStatfullBeanRemote {
	
	void increase();
	void decrease();
	int getValue();

}
