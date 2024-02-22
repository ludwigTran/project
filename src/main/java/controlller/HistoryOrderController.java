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
@WebServlet(urlPatterns = {"/historyOrder"})
public class HistoryOrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			int client_id = (int) session.getAttribute("client_id");
			OrderAdminDAO daoAd = new OrderAdminDAO();
			List<OrderAd> listH = daoAd.getListOrderHistory(client_id);
			req.setAttribute("listH", listH);
			System.out.println(listH.get(0).getOrder_id());
			
			
			//Get list products in cart by order_id
			String order_idS = req.getParameter("order_id");
			
			if (order_idS != null) {
				int order_id = Integer.parseInt(order_idS);
				CartDAO daoCart = new CartDAO();
				List<Cart> cartListH = daoCart.getListByClientID(order_id);
				req.setAttribute("cartListH", cartListH);
				req.getRequestDispatcher("/views/clients/historyCart.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/views/clients/historyCart.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("errorH", "Your history is empty.");
			req.getRequestDispatcher("/views/clients/cartDetail1.jsp").forward(req, resp);
		}
		
		
		
	}
}
