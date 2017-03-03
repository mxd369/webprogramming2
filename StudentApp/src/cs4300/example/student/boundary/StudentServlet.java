package cs4300.example.student.boundary;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs4300.example.student.logiclayer.UserLogicImpl;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String templateDir = "/WEB-INF/templates";
	private TemplateProcessor processor;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		processor = new TemplateProcessor(templateDir, getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String signup = request.getParameter("signup");
		String signin = request.getParameter("signin");
		String reg = request.getParameter("register");
		if (signup != null) {
			System.out.println("sign up clicked");
			showSignUpPage(request, response);
		}else if (signin != null) {
			System.out.println("sign In clicked");
			showSignInPage(request, response);
		}else if (reg != null) {
			createUser(request, response);
		}
		
	}
	

	private void createUser(HttpServletRequest request, HttpServletResponse response) {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserLogicImpl userCtrl = new UserLogicImpl();
		int inserted = userCtrl.insertUser(fname, lname, email, username, password);
		if (inserted == 0) {
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "error.ftl";
			processor.processTemplate(templateName, root, request, response);
		}else if (inserted == 1) {
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "userhome.ftl";
			processor.processTemplate(templateName, root, request, response);
 		} // end of if
	} // end of createUser
	
	private void showSignInPage(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void showSignUpPage(HttpServletRequest request, HttpServletResponse response) {
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "register.ftl";
		processor.processTemplate(templateName, root, request, response);
	} // end of showSignUpPage

}
