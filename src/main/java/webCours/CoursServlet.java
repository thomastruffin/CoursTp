package webCours;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import job.bll.CoursBll;

/**
 * Servlet implementation class CoursServlet
 */
@WebServlet("/cours.do")
public class CoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private CoursBll coursBll;
    @Override
    public void init() throws ServletException {
    	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", coursBll.getAll());
		request.getRequestDispatcher("./WEB-INF/cours.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str =request.getParameter("");
		coursBll.delete(Integer.parseInt(str));
		}

}
