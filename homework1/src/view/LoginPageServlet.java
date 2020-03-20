package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginPageServlet
 */
@WebServlet("/LoginPageServlet")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if(session.getAttribute("user") == null) {
			out.print("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"UTF-8\">\r\n" + 
					"<title>登录页面</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n");
			if(request.getAttribute("msg") != null) {
				out.print("<font color=\"red\">"+request.getAttribute("msg")+"</font>");
			}
			out.print("	<form action=\"LoginCheckServlet\">\r\n" + 
					"		用户名：<input type=\"text\" name=\"userName\"><br>\r\n" + 
					"		密码：<input type=\"password\" name=\"password\"><br>\r\n" + 
					"		<input type=\"checkbox\" name=\"autoLogin\">7天内自动登录<br>\r\n" + 
					"		<input type=\"submit\" value=\"登录\">\r\n" + 
					"	</form>\r\n" + 
					"</body>\r\n" + 
					"</html>");
		}else {
			request.getRequestDispatcher("ProductListServlet").forward(request,response);
		}
		
		
//		out.print("<html>"
//				+ "	<head>"
//				+ "		<title>登录页面</title>"
//				+ "	</head>"
//				+ "	<body>"
//				+ "		<form>"
//				+ "			用户名：<input type='text' name='userName'><br>"
//				+ "			密码：<input type='password' name='password'><br>"
//				+ "			<input type='checkbox' name='autoLogin'>7天内自动登录<br>"
//				+ "			<input type='submit' value='登录'>"
//				+ "		</form>"
//				+ "	</body>"
//				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
