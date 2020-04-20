package org.dehkordi.sandbox.ejb.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dehkordi.sandbox.ejb.SampleBeanRemote;
import org.dehkordi.sandbox.ejb.SampleStatfullBeanRemote;
import org.dehkordi.sandbox.ejb.SingeltonBeanRemote;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(mappedName="java:global/SampleEAPEAR/SampleEJBPrj/MySampleBean!org.dehkordi.sandbox.ejb.SampleBeanRemote")
	private SampleBeanRemote sampleBean;
	
	@EJB(mappedName="java:global/SampleEAPEAR/SampleEJBPrj/MySampleStatefullBean!org.dehkordi.sandbox.ejb.SampleStatfullBeanRemote")
	private SampleStatfullBeanRemote statfullBean;
	
	@EJB(mappedName="java:global/SampleEAPEAR/SampleEJBPrj/MySingeltonEJB!org.dehkordi.sandbox.ejb.SingeltonBeanRemote")
	private SingeltonBeanRemote singeltonBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = statefullAction();
		sb.append("\n\n");
		
		String res = sampleBean.sayHello("Mahmud");
		sb.append(res);
		
		
		singeltonBean.addToData("\n\nNew data added to the singelton bean (1)\n");
		singeltonBean.addToData("New data added to the singelton bean (2)\n");
		
		sb.append(singeltonBean.getData());
		
		response.getWriter().append(sb.toString());
	}
	
	private StringBuilder statefullAction() {
		StringBuilder sb = new StringBuilder();
		sb.append("1. " + statfullBean.getValue()).append("\n");
		statfullBean.increase();
		sb.append("2. " + statfullBean.getValue()).append("\n");
		statfullBean.increase();
		sb.append("3. " + statfullBean.getValue()).append("\n");
		statfullBean.decrease();
		return sb.append("4. " + statfullBean.getValue()).append("\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
