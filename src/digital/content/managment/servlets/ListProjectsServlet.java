package digital.content.managment.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digital.content.managment.services.ManagerService;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ListProjectsServlet")
public class ListProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProjectsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Im here");
	    response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
				
		ManagerService manager = new ManagerService();
		
		try {
			
			manager.listProjects(out);			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Wrong");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong");
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
