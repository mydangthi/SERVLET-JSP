package jsp.demo.servlet;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jsp.demo.dao.ProductDAO;

import jsp.demo.model.Product;



@WebServlet("/insertProduct")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public InsertProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/view/insertProduct.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
	
		
		Product product = new Product();
		List<FileItem> items;
		
		try {
			// size items = 5
			items = servletFileUpload.parseRequest(request);
			
			for (FileItem item : items) {
				
				
				if (item.getFieldName().equals("productName")) {
					product.setProductName(item.getString());
	 		} else if (item.getFieldName().equals("price")) {
					product.setPrice(item.getString());
				} else if (item.getFieldName().equals("status")) {
					product.setStatus(item.getString());
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {// neu co file d
						final String dir = "D:\\upload";
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(dir + "/" + fileName);
						item.write(file);
						product.setImage(fileName);
					} else {
						product.setImage(null);
					}
				}
			}
		
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ProductDAO productDAO =new ProductDAO();
        productDAO.addProduct(product);
		response.sendRedirect("homeAdmin");
	}
}

