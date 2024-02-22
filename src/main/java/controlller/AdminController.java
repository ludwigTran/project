package controlller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(urlPatterns = {"/admin"})
public class AdminController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		if (page == null) {
			List<Product> product = new ArrayList<Product>();
			ProductDAO dao = new ProductDAO();
			product = dao.getAll();
			req.setAttribute("product",product);
	
			req.getRequestDispatcher("/views/admin/listProduct.jsp").forward(req, resp);
		}
		
		else if (page.equals("orderAdmin")) {
			OrderAdminDAO dao = new OrderAdminDAO();
			List<OrderAd> listOrd = dao.getorderadmin();
			req.setAttribute("listOrd", listOrd);
			
			req.getRequestDispatcher("/views/admin/list-order.jsp").forward(req, resp);
		}
		else if (page.equals("client")) {
			ClientDAO daoCl = new ClientDAO();
			List<Client> listCl = daoCl.getListclient();
			req.setAttribute("listCl", listCl);
			req.getRequestDispatcher("/views/admin/list-client.jsp").forward(req, resp);
		}
		else if (page.equals("updateOrdA")) {
			
			int order_id = Integer.parseInt(req.getParameter("id"));
			
			//set status in orderAdmin database
			OrderAdminDAO daoUp = new OrderAdminDAO();
			OrderAd ordUp = daoUp.getByOrderID(order_id);
			String status = "In Delivery";
			ordUp.setStatus(status);
			daoUp.updateStatus(ordUp);
			
			//set status in cart database
			CartDAO daoCartUp = new CartDAO();
			List<Cart> listCart1 = daoCartUp.getListCartByOrderID(order_id);
			for (Cart c: listCart1) {
				daoCartUp.updateStatus(status, order_id);
			}
			
			//Update sold
			List<Cart> listCart = new ArrayList<Cart>();
			listCart = daoCartUp.getListByClientID(order_id);
			for (Cart c : listCart) {
				ProductDAO daoProduct = new ProductDAO();
				daoProduct.updateSold(c.getProduct_id());
			}
			resp.sendRedirect("/ProjectShop/admin?page=orderAdmin");
		}
		else if (page.equals("updateOrdC")) {
			int order_id = Integer.parseInt(req.getParameter("id"));
			//set status in orderAdmin database
			OrderAdminDAO daoUp = new OrderAdminDAO();
			OrderAd ordUp = daoUp.getByOrderID(order_id);
			String status = "Cancel Order";
				ordUp.setStatus(status);
				//set status in cart database
				CartDAO daoCartUp = new CartDAO();
				Cart cartUp = daoCartUp.getByOrderID(order_id);
				cartUp.setStatus(status);
				
				//action sql in database
				daoCartUp.updateStatus(status, order_id);
				daoUp.updateStatus(ordUp);
				
				//Update Sold
				List<Cart> listCart = new ArrayList<Cart>();
				listCart = daoCartUp.getListByClientID(order_id);
				for (Cart c : listCart) {
					ProductDAO daoProduct = new ProductDAO();
					daoProduct.updateSold(c.getProduct_id());
				}
				resp.sendRedirect("/ProjectShop/admin?page=orderAdmin");	
		}
		else if (page.equals("detailOrder")) {
			int order_id = Integer.parseInt(req.getParameter("order_id"));
			int client_id = Integer.parseInt(req.getParameter("client_id"));
			
			
			//get list cart product by order_id
			CartDAO daoCart = new CartDAO();
			List<Cart> listDetail = new ArrayList<Cart>();
			listDetail = daoCart.getListByClientID(order_id);
			
			//get info of client to show
			ClientDAO daoClient = new ClientDAO();
			Client cl = daoClient.getByClientID(client_id);
			
			OrderAdminDAO daoAD = new OrderAdminDAO();
			OrderAd orderAd = daoAD.getByOrderID(order_id);
			req.setAttribute("orderAd", orderAd);
			
			req.setAttribute("clientDetail", cl);
			req.setAttribute("listCart", listDetail);
			req.getRequestDispatcher("/admin?page=orderAdmin").forward(req, resp);	
		}
		
		else if (page.equals("signout")) {
			HttpSession session = req.getSession();
			session.invalidate(); 
			resp.sendRedirect("/ProjectShop/views/admin/login.jsp");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		if (page.equals("addNew")) {
			String name = req.getParameter("name");
			double price = Double.parseDouble(req.getParameter("price"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			String image = req.getParameter("image");
			String desc = req.getParameter("desc");
			String categoryName = req.getParameter("category_id");
			
			int category_id;
			if(categoryName.equals("Phone")) category_id =1;
			else if(categoryName.equals("Phone")) category_id =2;
			else category_id =3;
			
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.searchProductName(name);
			
			
			if (list.isEmpty() == true) {
				Product proNew = new Product( name, price, quantity, image, desc, category_id);
				ProductDAO daoNew = new ProductDAO();
				daoNew.insert(proNew);
				resp.sendRedirect("/ProjectShop/admin");
			}
			else {
				req.setAttribute("errorProduct", "Your product name is duplicated!");
				req.getRequestDispatcher("/views/admin/addProduct.jsp").forward(req, resp);
			}
			
			
		}
	}
}
