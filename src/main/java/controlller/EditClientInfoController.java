package controlller;

import java.io.IOException;

import dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Client;
@WebServlet(urlPatterns = {"/editClientInfo"})
public class EditClientInfoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get Client ID value
		HttpSession session = req.getSession();
		int client_id = (int) session.getAttribute("client_id");
		
		ClientDAO dao = new ClientDAO();
		Client client = dao.getByClientID(client_id);
		req.setAttribute("client", client);
		req.getRequestDispatcher("/views/clients/updateClientInfo.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("client_id");
		String fullname = req.getParameter("fullname");
		String password = req.getParameter("password");
		String phonenumber = req.getParameter("phonenumber");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		
		Client client = new Client(id, password, fullname, email, phonenumber, address);
		ClientDAO dao = new ClientDAO();
		dao.updateClientInfo(client);
		resp.sendRedirect("/ProjectShop/home?page=clientInfo");
		
		
		
	}
}
