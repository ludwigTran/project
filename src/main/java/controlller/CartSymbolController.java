package controlller;

import java.io.IOException;
import java.util.List;

import dao.CartDAO;
import dao.OrderAdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.OrderAd;

@WebServlet(urlPatterns = {"/cartsymbol"})
public class CartSymbolController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			int client_id = (int) session.getAttribute("client_id");
			
			CartDAO dao = new CartDAO();
			List<Cart> list = dao.getListCartByID(client_id);
			req.setAttribute("cartID", list);
			
			
			String page = req.getParameter("page");
			if (page ==null) {
				OrderAdminDAO daoA = new OrderAdminDAO();
				List<OrderAd> listC = daoA.getListOrderAD(client_id);
				String order_idS = req.getParameter("order_id");
				if (listC !=null && order_idS==null) {
					req.setAttribute("listC", listC);
					req.getRequestDispatcher("/views/clients/cartDetail1.jsp").forward(req, resp);
				}
				else if (listC !=null) {
					int order_id = Integer.parseInt(order_idS);
					List<Cart> listDelivery = dao.getListCartByOrderID(order_id);
					req.setAttribute("order", order_id);
					req.setAttribute("listDeli", listDelivery);
					req.setAttribute("listC", listC);
					req.getRequestDispatcher("/views/clients/cartDetail1.jsp").forward(req, resp);
					
					
				}
			
			
			}
			else if (page.equals("checkout")) {
				double total = Double.parseDouble(req.getParameter("total"));
				req.setAttribute("grandTotal", total);
				req.getRequestDispatcher("/views/clients/checkout.jsp").forward(req, resp);
				
			}	
			
			else if (page.equals("received")) {
				int order_id = Integer.parseInt(req.getParameter("order_id"));
				OrderAdminDAO daoReceived = new OrderAdminDAO();
				daoReceived.updateStatusReceive(order_id);
				
				CartDAO daocart = new CartDAO();
				daocart.updateStatus("Received", order_id);
				resp.sendRedirect("/ProjectShop/cartsymbol");
			}
		
	}
}
