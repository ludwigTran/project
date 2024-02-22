package controlller;

import java.io.IOException;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/deleteP"})
public class DeleteProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		ProductDAO dao = new ProductDAO();
		dao.DeleteP(id);
		resp.sendRedirect("/ProjectShop/admin");
	}
}
