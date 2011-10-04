package edu.neumont.ccjudge.controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.neumont.ccjudge.model.TeamMember;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class AdminSecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminSecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpSession session = hreq.getSession();
		TeamMember member = (TeamMember) session.getAttribute("member");
		request.setAttribute("redir", hreq.getRequestURI()+"?"+hreq.getQueryString());
		if (member==null || !member.getRole().equals("admin")) {
			hreq.getRequestDispatcher("/views/login.jsp").forward(hreq, response);
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/*
	 * <security-role>
    <role-name>admin</role-name>
  </security-role>
  <security-role>
    <role-name>participant</role-name>
  </security-role>
  <login-config>
    <auth-method>FORM</auth-method>
    <form-login-config>
      <form-login-page>/views/login.jsp</form-login-page>
      <form-error-page>/views/login_error.jsp</form-error-page>
    </form-login-config>
  </login-config>
  <security-constraint>
    <web-resource-collection>
      <web-resource-name>allResources</web-resource-name>
      <url-pattern>/home/submit</url-pattern>
      <url-pattern>/login</url-pattern>
    </web-resource-collection>
    <auth-constraint>
      <role-name>participant</role-name>
      <role-name>admin</role-name>
    </auth-constraint>
  </security-constraint>
  <security-constraint>
    <web-resource-collection>
      <web-resource-name>adminOnly</web-resource-name>
      <url-pattern>/contest/*</url-pattern>
      <url-pattern>/team/*</url-pattern>
      <url-pattern>/problem/*</url-pattern>
      <url-pattern>/member/*</url-pattern>
      <url-pattern>/submission/*</url-pattern>
      <url-pattern>/contest</url-pattern>
      <url-pattern>/team</url-pattern>
      <url-pattern>/problem</url-pattern>
      <url-pattern>/member</url-pattern>
      <url-pattern>/submission</url-pattern>
    </web-resource-collection>
    <auth-constraint>
      <role-name>admin</role-name>
    </auth-constraint>
  </security-constraint>
	 */
}
