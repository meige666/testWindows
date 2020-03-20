package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.UserBean;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("autoLogin");
		if(!"".equals(userName) && !"".equals(password)) {
			UserBean user = new UserBean(userName,password);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if("on".equals(autoLogin)) {
				session.setMaxInactiveInterval(60*60*24*7);
				Cookie cookie = new Cookie("JSESSIONID",session.getId());
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
			//请求重定向,重新发请求才能经过过滤器的过滤
//			request.getRequestDispatcher("ProductListServlet").forward(request, response);
			response.sendRedirect("ProductListServlet");
		}else {
			String msg = "用户名或密码没填写";
			request.setAttribute("msg", msg);
			//必须用请求转发
			request.getRequestDispatcher("LoginPageServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
