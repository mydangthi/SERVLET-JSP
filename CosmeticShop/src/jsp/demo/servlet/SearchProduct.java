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


@WebServlet(urlPatterns = {"/searchProduct"})
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		ProductDAO productDAO = new ProductDAO();
		List<Product> products = productDAO.finByNameProduct(productName);
		request.setAttribute("product", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/homePage.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

