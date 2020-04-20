package org.dehkordi.sandbox.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class SampleStatfullBean
 */
@Stateful(name="MySampleStatefullBean")
@LocalBean
public class SampleStatfullBean implements SampleStatfullBeanRemote {

	private int value = 0;
	
    /**
     * Default constructor. 
     */
    public SampleStatfullBean() {
    }

	@Override
	public void increase() {
		value++;
	}

	@Override
	public void decrease() {
		value--;
	}

	@Override
	public int getValue() {
		return value;
	}

}
