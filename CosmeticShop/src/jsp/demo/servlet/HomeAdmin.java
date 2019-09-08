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



@WebServlet("/homeAdmin")
public class HomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HomeAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO productDao = new ProductDAO();
		List<Product> productList = productDao.getAll();
		request.setAttribute("productList", productList);
		RequestDispatcher rd = request.getRequestDispatcher("/view/homeAdmin.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
