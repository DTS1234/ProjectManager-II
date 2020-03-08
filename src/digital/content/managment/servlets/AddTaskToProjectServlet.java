package digital.content.managment.servlets;

import java.io.IOException;
import java.sql.Date;
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
		
		ManagerService manager = new ManagerService();
		
		try {
			List<String> projects = manager.createProjectsList(manager.getLoginId());
			request.setAttribute("projects", projects);
			
			List<String> tasks = manager.createTasksList2();
	        request.setAttribute("tasks", tasks);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/addTask.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		String projectName = request.getParameter("projects");
		String taskId = request.getParameter("task_id");
		String taskName = request.getParameter("task_name");
		String taskDeadline = request.getParameter("task_planned");
		String taskStart = request.getParameter("task_start_date");
		String taskDependency = request.getParameter("tasks");
		
		
		Date taskDeadLine = Date.valueOf(taskDeadline);
		
		if(taskDeadLine.after(new Date(System.currentTimeMillis()))){
			
			try {
				
				String projectId = manager.findIdOfProject(projectName);
				manager.addTaskToProject(taskId, taskName, projectId, taskDeadline, taskStart, taskDependency);
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			
			}
		}else {
			
			System.out.println("Z³e dane");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
