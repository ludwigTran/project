package controlller;

import java.io.IOException;

import dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;
import util.Encoder;
@WebServlet(urlPatterns = {"/signup"})
public class SignUpClientController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("newPassword");
		
		password = Encoder.toSHA1(password);
		
		String fullname = req.getParameter("fullname");
		String phonenumber = req.getParameter("phonenumber");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		
		ClientDAO dao = new ClientDAO();
		Client client1 = dao.getByNameclient(username);
		Client client = new Client(username, password, fullname, email, phonenumber, address);
		if(client1 ==null) {
			dao.insert(client);
			resp.sendRedirect("home");
		}else {
			req.setAttribute("signupError", "Your username is already existed. Please try other username.");
			req.getRequestDispatcher("/views/clients/signupclient.jsp").forward(req, resp);
		}
		
	}
}
