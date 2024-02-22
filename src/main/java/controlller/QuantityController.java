package controlller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
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

@WebServlet(urlPatterns = {"/quantity"})
public class QuantityController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		int quantity = Integer.parseInt(req.getParameter("quantity"));

		try {
			HttpSession session = req.getSession();
			int client_id = (int) session.getAttribute("client_id");
			CartDAO dao = new CartDAO();
			List<Cart> list = dao.getListCartByID(client_id);
			if (action!=null ) {
				
				if (action.equals("quantity")) {
					int product_id = Integer.parseInt(req.getParameter("id"));
					ProductDAO daoproduct = new ProductDAO();
					Product pro = daoproduct.getByID(product_id);
					int stock = pro.getQuantity()- pro.getSold();
					for (Cart c : list) {
						if (c.getProduct_id()== product_id) {
							System.out.println(quantity);
							
							if (quantity == 0) {
								CartDAO daoDelete = new CartDAO();
								daoDelete.DeleteCart(product_id, client_id);
							}
							else if (quantity > stock) {
								quantity = stock;
								c.setQuantity(quantity);
								CartDAO daoQuanity = new CartDAO();
								daoQuanity.updateQuantity(c);
								req.setAttribute("error", "Your quantity is exceed the stock= "+stock);
								JOptionPane.showMessageDialog(null, "Your quantity is exceed the stock!","quantity error",JOptionPane.WARNING_MESSAGE);
							}
							else {
								c.setQuantity(quantity);
								CartDAO daoQuanity = new CartDAO();
								daoQuanity.updateQuantity(c);
							}
							

							
						}
						
					}
					resp.sendRedirect("cartsymbol");
				}
			
			}
		} catch (Exception e) {
			resp.sendRedirect("home");
		}
			
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
