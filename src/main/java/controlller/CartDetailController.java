package controlller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CartDAO;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Product;
@WebServlet(urlPatterns = {"/cartDetail"})
public class CartDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			HttpSession session = req.getSession();
			int client_id = (int) session.getAttribute("client_id");
			int product_id = Integer.parseInt(req.getParameter("product_id"));
					
			CartDAO dao = new CartDAO();
			ProductDAO dao1 = new ProductDAO();
			Product pro = dao1.getByID(product_id);
			Cart checkCart = dao.getByIdProduct(client_id, product_id);
			
			if (checkCart == null) {
				String product_name  = pro.getName();
				double price = pro.getPrice();
				int quantity = 1;
				String product_image = pro.getImage();
				Cart cart = new Cart(client_id, product_id, product_name, price, quantity, product_image);
				dao.insert(cart);
				List<Cart> list = dao.getListCartByID(client_id);
				req.setAttribute("cartID", list);
				req.getRequestDispatcher("home").forward(req, resp);
			}
			
			else if (checkCart !=null && checkCart.getOrder_id()!=0) {
				String product_name  = pro.getName();
				double price = pro.getPrice();
				int quantity = 1;
				String product_image = pro.getImage();
				Cart cart = new Cart(client_id, product_id, product_name, price, quantity, product_image);
				dao.insert(cart);
				List<Cart> list = dao.getListCartByID(client_id);
				req.setAttribute("cartID", list);
				req.getRequestDispatcher("home").forward(req, resp);
				
			}
			else {
				List<Cart> list = dao.getListCartByID(client_id);
				for (Cart c : list) {
					if(c.getProduct_id()==product_id) {
						if (c.getProduct_id()== product_id) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							CartDAO daoQuanity = new CartDAO();
							daoQuanity.updateQuantity(c);
						}						
						resp.sendRedirect("home");
					}
				}				
			}	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
				
	}
}
