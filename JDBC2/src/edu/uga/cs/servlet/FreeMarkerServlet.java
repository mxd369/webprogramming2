package edu.uga.cs.servlet;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Servlet implementation class FreeMarkerServlet
 */
@WebServlet("/FreeMarkerServlet")
public class FreeMarkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Configuration cfg = null;

	private String templateDir = "/WEB-INF/templates";


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FreeMarkerServlet() {
		super();
	}

	public void init() {
		// Create your Configuration instance, and specify if up to what FreeMarker
		// version (here 2.3.25) do you want to apply the fixes that are not 100%
		// backward-compatible. See the Configuration JavaDoc for details.
		cfg = new Configuration(Configuration.VERSION_2_3_25);

		// Specify the source where the template files come from.
		cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);

		// Sets how errors will appear.
		// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		// This handler outputs the stack trace information to the client, formatting it so 
		// that it will be usually well readable in the browser, and then re-throws the exception.
		//		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

		// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
		// Specifies if TemplateException-s thrown by template processing are logged by FreeMarker or not. 
		//		cfg.setLogTemplateExceptions(false);
	}

	public void runTemplate(HttpServletRequest request, HttpServletResponse response) {

		// You can use this structure for all of your objects to be sent to browser
		Template template = null;
		DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(df.build());
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String username = fname + " " + lname;
		root.put("user", username);
		Product p = new Product("Computer", "/product/systems.html");
		root.put("latestProduct", p);
		
		try {
			String templateName = "product.ftl";
			template = cfg.getTemplate(templateName );
			response.setContentType("text/html");
			Writer out = response.getWriter();
			template.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		runTemplate(request, response);
		System.out.println("Connecting to database...");
		Connection con = DatabaseAccess.connect();
		System.out.println("Connected to database successfully.");
		String query = "select * from actors";
		ResultSet rs = DatabaseAccess.retrieve(con, query);
		try {
			while(rs.next()) {
				System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseAccess.closeConnection(con);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}