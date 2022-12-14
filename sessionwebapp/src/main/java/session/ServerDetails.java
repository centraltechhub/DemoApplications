package session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;

/**
 * Servlet implementation class SystemDetails
 */
@WebServlet("/ServerDetails")
public class ServerDetails extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServerDetails()
    {
    
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		Server server;
		
		if (session.getAttribute("server")==null)
		{
			server = new Server();
			System.out.println("New Session");
		}
		else
		{
		   server = (Server)session.getAttribute("server");
		   System.out.println("Reloading new session");
		   System.out.println("Value of session counter upon loading from existing session:  "+ server.sessionCounter);
		}
	    server.sessionCounter();
	    server.getHostName();
	    server.getIPDetails();
		session.setAttribute("server", server);
		
		PrintWriter writer = response.getWriter();
     	writer.println(convertObjecttoJSON(server));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

	private static String convertObjecttoJSON(Server server)
	{
		Gson gson = new Gson();
		return gson.toJson(server);
	
	}
	
	
	

}
