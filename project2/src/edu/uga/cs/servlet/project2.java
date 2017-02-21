/*

package edu.uga.cs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 // Servlet implementation class HelloServlet
 
@WebServlet("ThoughtsBank")
public class ThoughtsBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     // @see HttpServlet#HttpServlet()
    public ThoughtsBank() {
        super();
        // TODO Auto-generated constructor stub
    }

	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	 // @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		response.setContentType("text/html");
		System.out.println("This is a test.");
		out.println("<!DOCTYPE html>\n"
				+ "<html>"
				+ "<body>"
				+ "<h2>Thought Bank</h2>"
				+ "<h3>" + fname + "</h3>"
				+ "<h3>" + lname + "</h3>"
				+ "</body>"
				+ "</html>");
	}

}
*/

package edu.uga.cs.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Servlet implementation class project2
 */
@WebServlet("/project2")
public class project2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Configuration cfg = null;

    private String templateDir = "/WEB-INF/templates";


    /**
     * @see HttpServlet#HttpServlet()
     */
    public project2() {
        super();
  
        // TODO Auto-generated constructor stub
    }
public void init(){
     cfg = new Configuration();
    cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

}

public void runTemplate(HttpServletRequest request, HttpServletResponse response) {

    // You can use this structure for all of your objects to be sent to browser
    Template template = null;
    //DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
    Map <String,Object> root = new HashMap<String,Object>();
    
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    root.put("username", username);
    root.put("password", password);
    //Product p = new Product("Computer", "/product/systems.html");
    //root.put("latestProduct", p);
    
    try {
        String templateName = "homepage.ftl";
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
        // TODO Auto-generated method stub
        runTemplate(request, response);    
    
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
