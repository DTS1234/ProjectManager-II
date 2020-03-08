package digital.content.managment.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digital.content.managment.services.ManagerService;

/**
 * Servlet implementation class AssignWorkerServlet
 */
@WebServlet("/AssignWorkerServlet")
public class AssignWorkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignWorkerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String projectId = request.getParameter("assign_button");
		ManagerService manager = new ManagerService();
		
		try {
			List<String> tasks = manager.createTasksList(projectId);
	        request.setAttribute("tasks", tasks);
	        
	        List<String> workers = manager.createWorkersList(projectId);
	        request.setAttribute("workers", workers);
	        
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/assignWorker.jsp");
	        requestDispatcher.forward(request, response);

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		String taskName = request.getParameter("tasks");
		String workerName = request.getParameter("workers");
		
		try {
			
			String taskId = manager.findIdOfTask(taskName);
			System.out.println(taskId+"ejjj");
			String workerId = manager.findIdOfWorker(workerName);
			System.out.println(workerId);
			
			manager.assignService(taskId, workerId);
			
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/success.jsp");
//			requestDispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/error.jsp");
//			requestDispatcher.forward(request, response);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
