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
@WebServlet(urlPatterns = {"/updateP"})
public class UpdateProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProductDAO daoP = new ProductDAO();
		Product proP = daoP.getByID(id);
		req.setAttribute("pro", proP);
		req.getRequestDispatcher("/views/admin/updateProduct.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProductDAO dao = new ProductDAO();
		Product prd = dao.getByID(id);
		
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		int quantity = Integer.parseInt(req.getParameter("quantity")) + prd.getQuantity();
		String image = req.getParameter("image");
		String desc = req.getParameter("desc");
		String categoryName = req.getParameter("category_id");
		
		int category_id;
		if(categoryName.equals("Phone")) category_id =1;
		else if(categoryName.equals("Phone")) category_id =2;
		else category_id =3;
		
		String status = req.getParameter("status");
		//prd.getname. equal(name) || name
		
		List<Product> list = dao.checkNameProduct(name, id);
		if (list.isEmpty()) {
			Product proForm = new Product(id, name, price, quantity, image, desc, category_id, status);
			ProductDAO daoForm = new ProductDAO();
			daoForm.update(proForm);
			
			
			resp.sendRedirect("/ProjectShop/admin");
		}
		else {
			
			req.setAttribute("errorName", "Your product name is duplicated!");
			doGet(req, resp);
			req.getRequestDispatcher("/views/admin/updateProduct.jsp").forward(req, resp);
			
		}
		
		
		
	}
}
