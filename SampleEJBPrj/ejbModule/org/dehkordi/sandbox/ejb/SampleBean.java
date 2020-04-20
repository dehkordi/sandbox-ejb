package org.dehkordi.sandbox.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SampleBean
 */
@Stateless(name="MySampleBean")
@LocalBean
public class SampleBean implements SampleBeanRemote {

    /**
     * Default constructor. 
     */
    public SampleBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
