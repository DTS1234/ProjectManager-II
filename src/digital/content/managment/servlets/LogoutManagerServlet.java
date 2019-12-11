package digital.content.managment.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digital.content.managment.services.ManagerService;
import digital.content.managment.services.WorkerService;

/**
 * Servlet implementation class LogoutManagerServlet
 */
@WebServlet("/LogoutManagerServlet")
public class LogoutManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String logout = request.getParameter("logout_button");
		System.out.println(logout);
		if(logout.equals("logout")) {
			ManagerService managerService = new ManagerService();
			managerService.setLogged(false);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("http://localhost:8080/ProjectManagment/LoginServlet");
			requestDispatcher.forward(request, response);
		}else if(logout.equals("logout_worker")) {
			WorkerService workerService = new WorkerService();
			workerService.setLogged(false);
			workerService.setLoginId("");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginWorkerServlet");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
