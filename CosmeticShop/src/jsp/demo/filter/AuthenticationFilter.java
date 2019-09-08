package jsp.demo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter({"/editProduct","/homeAdmin","/deleteProduct","/insertProduct","/orderList"})
public class AuthenticationFilter implements Filter {

    
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		if (session != null && session.getAttribute("userName")!= null) {
		chain.doFilter(request, response);
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
		rd.forward(request, response);
	}

	}
	public void init(FilterConfig filterconfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
