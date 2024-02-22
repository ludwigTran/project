package controlller;

import java.io.IOException;
import java.util.List;

import dao.CartDAO;
import dao.ClientDAO;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Client;
import util.Encoder;

@WebServlet(urlPatterns = {"/LoginC"})
public class LoginClientCon extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		password = Encoder.toSHA1(password);
		ClientDAO dao = new ClientDAO();
		
		
		if(dao.loginClient(username, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("usernameClient",username);
			Client cl = dao.getByNameclient(username);
			int client_id = cl.getId();
			
			session.setAttribute("client", cl);
			session.setAttribute("client_id", client_id);
			
			resp.sendRedirect("home");
			
		}else {		
			req.setAttribute("loginError", "Please try again! If no account yet, please sign up below! Thanks");
			req.getRequestDispatcher("/views/clients/loginClient.jsp").forward(req, resp);
		}
	}
	

}
