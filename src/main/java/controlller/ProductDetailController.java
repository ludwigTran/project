package controlller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
@WebServlet(urlPatterns = {"/detail"})
public class ProductDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		ProductDAO dao = new ProductDAO();
		Product pro = new Product();
		pro = dao.getByID(id);
		req.setAttribute("listID", pro);
		req.getRequestDispatcher("/views/clients/productdetail.jsp").forward(req, resp);
	}
}
