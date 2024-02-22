package controlller;

import java.io.IOException;
import java.util.List;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
@WebServlet(urlPatterns = {"/search"})
public class SearchController extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String text = req.getParameter("text");
			ProductDAO dao = new ProductDAO();
			if (text == "") {
				resp.sendRedirect("/ProjectShop/home");
			}else {
				
				List<Product> listSearch = dao.search(text);
				int x = listSearch.size();
				req.setAttribute("listSearch", listSearch);
				req.setAttribute("x", x);
				req.getRequestDispatcher("/views/clients/search.jsp").forward(req, resp);
			}

		}
}
