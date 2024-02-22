package controlller;

import java.io.IOException;
import java.util.List;

import dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;
@WebServlet(urlPatterns = {"/deleteClient"})
public class DeleteClientAdminController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int client_id = Integer.parseInt(req.getParameter("client_id"));
		ClientDAO dao = new ClientDAO();
		
		dao.DeleteCartClient(client_id);
		dao.DeleteOrderClient(client_id);
		dao.DeleteClient(client_id);
		List<Client> listCl = dao.getListclient();
		req.setAttribute("listCL", listCl);
		req.getRequestDispatcher("/admin?page=client").forward(req, resp);
	}
}
