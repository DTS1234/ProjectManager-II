package digital.content.managment.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digital.content.managment.services.WorkerService;

/**
 * Servlet implementation class LoginManager
 */
@WebServlet("/LoginWorkerServlet")
public class LoginWorkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginWorkerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WorkerService worker = new WorkerService();
		
		if((worker.isLogged())) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/workerView.jsp");
			requestDispatcher.forward(request, response);	
		}else {
			String page = "JspFiles/loginWorker.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idLogin = request.getParameter("login");//biorê parametry z login.jsp
		String passwordPassed = request.getParameter("psw");
		
		WorkerService worker = new WorkerService();
		
		try {
			if(worker.loginWorker(passwordPassed, idLogin)) {
				System.out.println(idLogin);
				System.out.println(passwordPassed);
				System.out.println("zalogowany");
				worker.setLogged(true);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("fail login worker");
			e.printStackTrace();
			
		}
		
		
		
		doGet(request, response);
	}

}
