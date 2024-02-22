package controlller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.CartDAO;
import dao.ClientDAO;
import dao.OrderAdminDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Client;
import model.OrderAd;
import model.Product;
@WebServlet(urlPatterns = {"/home"})
public class ProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			HttpSession session = req.getSession();
			while(session.getAttribute("client_id") == null) {
				req.getRequestDispatcher("/views/clients/loginClient.jsp").forward(req, resp);
			}
			int client_id = (int) session.getAttribute("client_id");
			
			//Get list product in cart to show number of products symbol at upper right corner
			CartDAO daoc = new CartDAO();
			List<Cart> listC = daoc.getListCartByID(client_id);
			req.setAttribute("cartID", listC);
			ProductDAO dao = new ProductDAO();
			
			
			String page =req.getParameter("page");
			if (page == null) {
//				List phone products
				List<Product> list1 = new ArrayList<Product>();
				list1 = dao.getIphone();
				req.setAttribute("list1", list1);
//				List watch products
				List<Product> list2 = new ArrayList<Product>();
				list2 = dao.getSpeaker();
				req.setAttribute("list2", list2);
//				List speaker products
				List<Product> list3 = new ArrayList<Product>();
				list3 = dao.getWatch();
				req.setAttribute("list3", list3);
				req.getRequestDispatcher("/views/clients/index.jsp").forward(req, resp);
			}
			else if (page.equals("detail")) {
				int product_id = Integer.parseInt(req.getParameter("id"));
				Product pro = dao.getByID(product_id);
				req.setAttribute("listID", pro);
				req.getRequestDispatcher("/views/clients/productdetail.jsp").forward(req, resp);
			}
			
			else if (page.equals("clientInfo")) {
				ClientDAO daoInfo = new ClientDAO();
				Client clientInfo = daoInfo.getByClientID(client_id);
				req.setAttribute("clientInfo", clientInfo);
				req.getRequestDispatcher("/views/clients/clientInfo.jsp").forward(req, resp);
			}
			
			
			else if (page.equals("checkout")) {
				double total = Double.parseDouble(req.getParameter("total"));
				String address = req.getParameter("address");
				
				String note = req.getParameter("note");
				
				OrderAdminDAO daoOrder = new OrderAdminDAO();
				//Insert into orderAdmin database
				OrderAd orderAd = new OrderAd(client_id, total, address, note);
				daoOrder.insert(orderAd);
				
				
				//Get list product by client_id to take action change status from Incart to In Process
				CartDAO daoCheckout = new CartDAO();
				List<Cart> list = daoCheckout.getListCartByID(client_id);
				
					for (Cart c : list) {
//						c.setStatus("In Process");
						//Change status and insert order_id to cart table in database
						OrderAd orAd2 = daoOrder.getByTotal(client_id, total);
						int order_id = orAd2.getOrder_id();
						
						c.setOrder_id(order_id);
//						c.setClient_id(client_id);
						daoCheckout.updateStatusOrderID(order_id);
						
						ProductDAO daoProduct = new ProductDAO();
						daoProduct.updateSold(c.getProduct_id());
					}

					
				resp.sendRedirect("/ProjectShop/views/clients/thanks4shop.jsp");
				}
			else if (page.equals("logout")) {
				
				session.invalidate(); 
				resp.sendRedirect("/ProjectShop/views/clients/loginClient.jsp");
				
			}
			
		
	}
}
