package controlller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.CartDAO;
import dao.OrderAdminDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.OrderAd;
@WebServlet(urlPatterns = {"/cancel"})
public class CancelOrderClientController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int client_id = (int) session.getAttribute("client_id");
		CartDAO dao = new CartDAO();
		List<Cart> list = dao.getListCartByID(client_id);
		req.setAttribute("cartID", list);
		
		OrderAdminDAO daoA = new OrderAdminDAO();
		List<OrderAd> listC = daoA.getListOrderAD(client_id);
		int cancelorder_id = Integer.parseInt(req.getParameter("cancelorder_id"));

		req.setAttribute("listC", listC);

		//set status in orderAdmin database
		OrderAdminDAO daoUp = new OrderAdminDAO();
		OrderAd ordUp = daoUp.getByOrderID(cancelorder_id);
		String status = "Cancel Order";
		ordUp.setStatus(status);
		daoUp.updateStatus(ordUp);
		
		//set status in cart database
		CartDAO daoCartUp = new CartDAO();
		List<Cart> listCart1 = daoCartUp.getListCartByOrderID(cancelorder_id);
		for (Cart c: listCart1) {		
			daoCartUp.updateStatus(status, cancelorder_id);
		}	
			List<Cart> listCart = new ArrayList<Cart>();
			listCart = daoCartUp.getListByClientID(cancelorder_id);
			for (Cart c : listCart) {
				ProductDAO daoProduct = new ProductDAO();
				daoProduct.updateSold(c.getProduct_id());
			}
			req.getRequestDispatcher("/cartsymbol").forward(req, resp);
	}
}
