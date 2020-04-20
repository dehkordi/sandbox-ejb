package org.dehkordi.sandbox.ejb.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dehkordi.sandbox.ejb.SampleStatfullBeanRemote;

/**
 * Servlet implementation class StatefullServlet
 */
@WebServlet("/StatefullServlet")
public class StatefullServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(mappedName="java:global/SampleEAPEAR/SampleEJBPrj/MySampleStatefullBean!org.dehkordi.sandbox.ejb.SampleStatfullBeanRemote")
	SampleStatfullBeanRemote statfullBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatefullServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Curret value: \n" + action());
	}

	private String action() {
		StringBuilder sb = new StringBuilder();
		sb.append("1. " + statfullBean.getValue()).append("\n");
		statfullBean.increase();
		sb.append("2. " + statfullBean.getValue()).append("\n");
		statfullBean.increase();
		sb.append("3. " + statfullBean.getValue()).append("\n");
		statfullBean.decrease();
		sb.append("4. " + statfullBean.getValue()).append("\n");
		return sb.toString();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
