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
import util.Encoder;
@WebServlet(urlPatterns = {"/password"})
public class ChangePasswordClientController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.sendRedirect("/ProjectShop/views/clients/changePassword.jsp");
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	HttpSession session = req.getSession();
	int client_id = (int) session.getAttribute("client_id");
	
	String password = req.getParameter("password");
	String pwSHA = Encoder.toSHA1(password);
	
	
	String newpass = req.getParameter("newPassword");
	String newSHA = Encoder.toSHA1(newpass);
	
	ClientDAO dao = new ClientDAO();
	Client client = dao.getByClientID(client_id);
	
	if(client.getPassword().equals(pwSHA)){
		
		client.setPassword(newSHA);
		dao.updateClientPassword(newSHA, client_id);
		resp.sendRedirect("/ProjectShop/home?page=clientInfo");
		}

	else {
		req.setAttribute("error", "Your old password is incorrect");
		req.getRequestDispatcher("/views/clients/changePassword.jsp").forward(req, resp);
	}
	
	
	
	}
}
