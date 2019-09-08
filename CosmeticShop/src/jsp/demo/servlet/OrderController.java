package jsp.demo.servlet;



import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.demo.dao.OrderDAO;
import jsp.demo.dao.ProductDAO;
import jsp.demo.model.Order;
import jsp.demo.model.Product;



@WebServlet("/order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public OrderController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO productDao = new ProductDAO();
		Product product = productDao.findProductById(id);
		request.setAttribute("product", product);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/order.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		String customeName = request.getParameter("customeName");
		int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
		String address = request.getParameter("address");
		String total = request.getParameter("total");
		
		Order order = new Order();
		
		order.setCustomerName(customeName);
		order.setPhoneNumber(phoneNumber);
		order.setAddress(address);
		order.setProductId(productId);
		order.setTotal(total);
		
		OrderDAO orderDao = new OrderDAO();
		orderDao.addOrder(order);
		response.sendRedirect("orderList");
	}
	}


