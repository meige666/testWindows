package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;

import java.io.PrintWriter;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>产品列表</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n");
		
		if(getServletContext().getAttribute("onlineNum")==null) {
			out.print("当前在线人数：0 <br>");
		}else {
			out.print("当前在线人数：" + getServletContext().getAttribute("onlineNum")+"<br>");
		}
		if(getServletContext().getAttribute("vipNum")==null) {
			out.print("当前在线会员数：0 <br>");
		}else {
			out.print("当前在线会员数：" + getServletContext().getAttribute("vipNum")+"<br>");
		}
		
		if(session.getAttribute("user")==null) {
			out.print("未登录");
			out.print("<a href='LoginPageServlet'>去登录</a><br>");
		}else {
			UserBean user = (UserBean)session.getAttribute("user");
			out.print("登录人："+user.getUserName());
			out.print("<a href='LogoutServlet'>注销</a><br>");
		}
		out.print("<a href=\"AddShoppingCartServlet?bookName=JavaEE指南\">JavaEE指南</a>\r\n" + 
				"<a href=\"AddShoppingCartServlet?bookName=JavaSE指南\">JavaSE指南</a>\r\n" + 
				"<a href=\"AddShoppingCartServlet?bookName=Spring指南\">Spring指南</a>\r\n" + 
				"<a href=\"ShowShoppingCartServlet\">查看购物车</a>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
