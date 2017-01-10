/**********************************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description: This filter is used to prevent unauthorized access to Welcome.jsp page
 * ********************************************************************************************/
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/Auth/*")
public class Authentication implements Filter {

private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		
		HttpSession session = req.getSession();
		
		//if user does not login yet and try to access welcome page through url, this will redirect user
		//back to login page without giving error message
		if(session.getAttribute("username")==null && uri.equals("/COMP3095/Auth/Welcome.jsp")){
			this.context.log("Unauthorized access request");
			res.sendRedirect("../Login.jsp");
		}else if(session.getAttribute("remember")=="remember" && session.getAttribute("username")!=null){
			res.sendRedirect("/Auth/Welcome.jsp");
		}
		else if (session.getAttribute("username")==null && uri.equals("/COMP3095/Auth/Post.jsp")){
			this.context.log("Unauthorized access request");
			res.sendRedirect("../Auth/WelcomeController");
		}
		else if (session.getAttribute("username")==null && uri.equals("/COMP3095/Auth/Comment.jsp")){
			this.context.log("Unauthorized access request");
			res.sendRedirect("../Auth/WelcomeController");
		}
		else{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
		
	}

	
	
	public void destroy() {
		//close any resources here	
	}

}
