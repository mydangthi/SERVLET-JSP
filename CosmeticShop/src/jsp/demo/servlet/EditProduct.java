package jsp.demo.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.demo.dao.ProductDAO;
import jsp.demo.model.Product;



/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet( urlPatterns = { "/editProduct" })

public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO productDAO= new ProductDAO();
		Product product = productDAO.findProductById(id);

		request.setAttribute("product", product);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/editProduct.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String image = request.getParameter("image");
		String productName  = request.getParameter("productName");
	    String price = request.getParameter("price");
	    String status = request.getParameter("status");
	     
	    Product product = new Product();
	    product.setId(id);
	    product.setImage(image);
	    product.setProductName(productName);
	    product.setPrice(price);
	    product.setStatus(status);
	    
	    ProductDAO productDAO = new ProductDAO();
	    productDAO.updateProduct(product);
	    response.sendRedirect("homeAdmin");
	}

}