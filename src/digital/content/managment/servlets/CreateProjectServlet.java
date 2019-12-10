package digital.content.managment.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import digital.content.managment.services.ManagerService;

/**
 * Servlet implementation class CreateProjectServlet
 */
@WebServlet("/CreateProjectServlet")
public class CreateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ManagerService manager = new ManagerService();
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("JspFiles/createProjectView.jsp");
		requestDispatcher.forward(request, response);
		
		String projectName = request.getParameter("project_name");
		String projectId = request.getParameter("project_id");
		String managerId = request.getParameter("manager_id");

		try {
			manager.createProjectService(projectName, projectId, managerId);
			
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter();
			out.println("Uda³o siê");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
