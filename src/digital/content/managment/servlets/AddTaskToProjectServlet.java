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
 * Servlet implementation class AddTaskToProject
 */
@WebServlet("/AddTaskToProject")
public class AddTaskToProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskToProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taskId = request.getParameter("task_id");
		String projectId = request.getParameter("project_id");
		String taskName = request.getParameter("task_name");
		String taskDeadline = request.getParameter("task_planned");
		
		ManagerService manager = new ManagerService();
		
		if(!(taskId==null||projectId==null||taskName==null||taskDeadline==null)){
			
			try {
				manager.addTaskToProject(taskId, taskName, projectId, taskDeadline);
				if(true) {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/manageProjects.jsp");
					requestDispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				System.out.println("Z³e dane");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/error.jsp");
				requestDispatcher.forward(request, response);
				
				e.printStackTrace();
			}
		}else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/addTask.jsp");
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
