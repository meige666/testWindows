package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
@WebFilter("/AuthorityFilter")
public class AuthorityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorityFilter() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String path = req.getRequestURL().toString();
		if(path.contains("LoginCheckServlet")) {
			if(request.getParameter("userName")==null) {
				HttpSession session = req.getSession();
				if(session.getAttribute("user")==null) {
					resp.sendRedirect("LoginPageServlet");
				}else {
					resp.sendRedirect("ProductListServlet");
				}
			}else {
				chain.doFilter(req, resp);
			}
		}else if(path.contains("AddShoppingCartServlet")) {
			if(req.getParameter("bookName")==null) {
				resp.sendRedirect("ProductListServlet");
			}else {
				HttpSession session = req.getSession();
				if(session.getAttribute("user")==null) {
					resp.sendRedirect("LoginPageServlet");
				}else {
					chain.doFilter(req, resp);
				}
			}
		}else if(path.contains("ShowShoppingCartServlet")) {
			HttpSession session = req.getSession();
			if(session.getAttribute("user")==null) {
				resp.sendRedirect("LoginPageServlet");
			}else {
				chain.doFilter(req, resp);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
