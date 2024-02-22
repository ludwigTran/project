package controlller;

import java.io.IOException;
import dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.Encoder;
@WebServlet(urlPatterns = "/Login")
public class LoginAdminController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		password = Encoder.toSHA1(password);
		
		
		ClientDAO dao = new ClientDAO();
		if(dao.loginAdmin(username, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("usernameAD",username);
			resp.sendRedirect("/ProjectShop/admin");
		}else {		
			req.setAttribute("loginError", "Sai tên đăng nhập hoặc mật khẩu");
			req.getRequestDispatcher("/views/admin/login.jsp").forward(req, resp);
		}
	}
	

}
