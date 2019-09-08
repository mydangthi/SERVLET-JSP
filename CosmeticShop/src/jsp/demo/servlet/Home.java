/**
 *
 */
package jsp.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.demo.dao.ProductDAO;
import jsp.demo.model.Product;



@WebServlet(urlPatterns = {"/home"})
public class Home extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		
		List<Product> product =productDAO.getAll();
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/homePage.jsp");
        dispatcher.forward(request, response);
	        
	   }
	 
	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       doGet(request, response);
	   }
}
