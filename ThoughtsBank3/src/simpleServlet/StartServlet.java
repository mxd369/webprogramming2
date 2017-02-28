package simpleServlet;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet("/index.html") // This url-mapping makes even the home page a freemarker template
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String templateDir = "/WEB-INF/templates";
	private TemplateProcessor processor;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		processor = new TemplateProcessor(templateDir, getServletContext());
	}
    
    private void loadIndexPage(HttpServletRequest request, HttpServletResponse response) {
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		root.put("user", "Not logged in");
		String templateName = "index.ftl";
		processor.processTemplate(templateName, root, request, response);
	} // end of loadIndexPage

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadIndexPage(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
