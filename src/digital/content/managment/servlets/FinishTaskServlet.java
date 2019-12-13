package digital.content.managment.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digital.content.managment.dao.WorkerDao;
import digital.content.managment.services.WorkerService;

/**
 * Servlet implementation class FinishTaskServlet
 */
@WebServlet("/FinishTaskServlet")
public class FinishTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinishTaskServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String taskId = request.getParameter("task_id");
		System.out.println("task_id= " + taskId);
		
		WorkerDao worker;
		WorkerService workerService = new WorkerService();
		try {
			
			worker = new WorkerDao();	
			worker.finishTask(taskId, workerService.setRealTaskDate(taskId), workerService.setRealFinish(taskId)+" days");

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			String page = "JspFiles/errorWorker.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
		}		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
