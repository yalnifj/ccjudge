package edu.neumont.ccjudge.controllers;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class BaseController  extends javax.servlet.http.HttpServlet {

	protected String defaultAction;
	protected Validator validator;
	protected Logger log = Logger.getLogger("BaseController");
	protected String errorPage = "/views/error.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] parts = request.getRequestURI().split("/");
		String action = null;
		if (parts.length>3) action = parts[3];
		String baseURL = (String)getServletContext().getAttribute("baseURL");
		if (parts.length>2 && baseURL.equals("")) action = parts[2];
		
		try {
			if (action==null || action.isEmpty()) action = defaultAction;
			log.log(Level.FINE, "action="+action);
			Method method = this.getClass().getMethod(action, HttpServletRequest.class);
			String view = null;
			if (method!=null) {
				view = (String)method.invoke(this, request);
				log.log(Level.FINE, "view="+view);
				if (view==null) log.log(Level.SEVERE, "view is null");
				else {
					if (view.startsWith("redirect:")) response.sendRedirect(view.replaceAll("redirect:", "")); 
					else request.getRequestDispatcher(view).forward(request, response);
				}
			}
			else log.log(Level.SEVERE, "action method not found: "+action);
		} catch (NoSuchMethodException e) {
			
			//-- check if request and response method
			try {
				Method method = this.getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
				if (method!=null) {
					method.invoke(this, request, response);
					return;
				}
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
				request.setAttribute("error", "Invalid action "+action+" specified");
				request.setAttribute("except", e1);
				request.getRequestDispatcher(errorPage).forward(request, response);
			} catch (Exception e1) {
				e1.printStackTrace();
				request.setAttribute("error", "An error occurred during processing: "+e.getMessage());
				request.setAttribute("except", e1);
				request.getRequestDispatcher(errorPage).forward(request, response);
			}
			
			e.printStackTrace();
			request.setAttribute("error", "Invalid action "+action+" specified");
			request.setAttribute("except", e);
			request.getRequestDispatcher(errorPage).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "An error occurred during processing: "+e.getMessage());
			request.setAttribute("except", e);
			request.getRequestDispatcher(errorPage).forward(request, response);
		}
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@SuppressWarnings("unchecked")
	public void init() throws ServletException {
		super.init();
		String baseURL = getServletContext().getInitParameter("baseURL");
		if (baseURL==null) baseURL = "/"+getServletContext().getServletContextName();
		getServletContext().setAttribute("baseURL", baseURL);
		
		String validator = getServletContext().getInitParameter("validator");
		if (validator==null || validator.isEmpty()) validator = "edu.neumont.ccjudge.controllers.Validator";
		try {
			Class v = Class.forName(validator);
			this.validator = (Validator) v.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if (this.validator==null) {
				this.validator = new Validator();
			}
		}
		
	}
}
