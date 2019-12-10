package digital.content.managment.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digital.content.managment.services.ManagerService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ManagerService manager = new ManagerService();
		
		if((manager.isLogged())) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/managerView.jsp");
			requestDispatcher.forward(request, response);	
		}else {
			String page = "JspFiles/login.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);	
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ManagerService manager = new ManagerService();
		
		String idLogin = request.getParameter("login");//biorê parametry z login.jsp
		String passwordPassed = request.getParameter("psw");
		System.out.println(idLogin);
		System.out.println(passwordPassed);
		
		try {
			
			System.out.println(passwordPassed);
			
			if(manager.loginManager(passwordPassed, idLogin)==true) {
				System.out.println("zalogowany");
				manager.setLogged(true);//zmieniam stan na zalogowany		
			}else {
				String page = "JspFiles/login.jsp";
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
				requestDispatcher.forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
		
	}

}
