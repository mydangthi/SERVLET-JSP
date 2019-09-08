package jsp.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.demo.model.User;
import jsp.demo.dao.UserDAO;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		List<User> users = userDAO.getAll();
		System.out.println("-------->" + users.size());
		User user = userDAO.findUser(userName, password);
		request.getSession().setAttribute("userBean", user);
		if(user==null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
			rd.forward(request, response);
		}else
		{
			HttpSession session = request.getSession();
			session.setAttribute("userName", user.getUserName());
			
			response.sendRedirect(request.getContextPath() + "/homeAdmin");
		}
		}
}


