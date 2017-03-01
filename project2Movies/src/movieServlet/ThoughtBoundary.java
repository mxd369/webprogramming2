package movieServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import freemarker.template.TemplateExceptionHandler;

/**
 * Servlet implementation class ThoughtBoundary
 */
@WebServlet("/ThoughtBoundary")
public class ThoughtBoundary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String templateDir = "/WEB-INF/templates";
	private TemplateProcessor processor;
	//private ThoughtBank thoughtBank;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThoughtBoundary() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		processor = new TemplateProcessor(templateDir, getServletContext());
		//thoughtBank = new ThoughtBank();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		String textField = request.getParameter("textField");
		//String addThought = request.getParameter("addthought");
		//String viewThought = request.getParameter("viewthought");
		if (textField == "actors") {
			System.out.println("Actors");//print all actors;
		} else if (textField == "movies") {
			System.out.println("movies");//print all movies;
		} else if (textField == "directors") {
			System.out.println("directors");//print all directors;
		} else{
			System.out.println("Error");//throw error page
		}
		/*
		if (signin != null) {
			loadUserHomePage(request,response);
		}else if (addThought != null) {
			saveNewThought(request, response);
		}else if (viewThought != null) {
			showThoughts(request, response);
		}
		*/
		// what
		
		
		
		// what
		
	} // end of doGet
/*
	private void showThoughts(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("uname");
		//List<Thought> thoughts = thoughtBank.getThoughts(username);
		//for (Thought t : thoughts) {
		//	System.out.println(t.getThought());
		}
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "viewthoughts.ftl";
		//root.put("user", username);
		//root.put("thoughts", thoughts);
		//root.put("numOfThoughts", thoughts.size());
		//processor.processTemplate(templateName, root, request, response);
	} // end of showThoughts

	private void saveNewThought(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("uname");
		String thoughtString = request.getParameter("newthought");
		//Thought thought = new Thought(thoughtString);
		//thoughtBank.add(username, thought);
		//System.out.println("thoughts:" + thoughtBank.getSize());
		//System.out.println("thoughts:" + thoughtBank);
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "userhomepage.ftl";
		root.put("user", username);
		processor.processTemplate(templateName, root, request, response);
	} // end of saveNewThought

	private void loadUserHomePage(HttpServletRequest request, HttpServletResponse response) {
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "userhomepage.ftl";
		String username = request.getParameter("username");
		root.put("user", username);
		processor.processTemplate(templateName, root, request, response);
	} // end of loadUserHomePage
*/	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
