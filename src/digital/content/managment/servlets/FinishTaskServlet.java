package digital.content.managment.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digital.content.managment.dao.ManagerDao;
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
				
		String taskId = request.getParameter("task_button");
		
		WorkerDao worker;
		WorkerService workerService = new WorkerService();
		try {
			
			worker = new WorkerDao();
			ManagerDao managerDao = new ManagerDao();
			
			if(managerDao.checkIfTasksIsDone(taskId)) {
				worker.finishTask(taskId, workerService.setRealTaskDate(taskId), workerService.setRealFinish(taskId)+" days");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/workerView.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("task done");
			}else {
				System.out.println("task is not done or depends on other task");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/taskError.jsp");
				requestDispatcher.forward(request, response);
			}
			
			

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
