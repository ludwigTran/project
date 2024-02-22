package controlller;

import java.io.IOException;

import dao.CartDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/removeCart"})
public class RemoveCartContr extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int client_id = (int) session.getAttribute("client_id");
		int product_id = Integer.parseInt(req.getParameter("id"));
		CartDAO dao = new CartDAO();
		dao.DeleteCart(product_id, client_id);
		resp.sendRedirect("cartsymbol");
	}
}
