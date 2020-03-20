package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;

/**
 * Servlet implementation class AddShoppingCartServlet
 */
@WebServlet("/AddShoppingCartServlet")
public class AddShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		HttpSession session = request.getSession();
		Object object = session.getAttribute("shoppingCart");
		List shoppingCart;
		if(object != null) {
			shoppingCart = (ArrayList)object;
		}else {
			shoppingCart = new ArrayList();
		}
		shoppingCart.add(bookName);
		session.setAttribute("shoppingCart", shoppingCart);
		//request.getRequestDispatcher("ShowShoppingCartServlet").forward(request, response);
		//在这里用请求重定向，这样浏览器重新向服务器发出请求，这个请求才会经过编码过滤器，编码方式才能得到修改
		response.sendRedirect("ShowShoppingCartServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
