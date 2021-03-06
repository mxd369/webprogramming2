package edu.uga.cs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
public class FreeMarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Configuration cfg = null;
	
	private String templateDir = "/WEB-INF/templates";

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeMarketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void init(){
    	cfg = new Configuration(Configuration.VERSION_2_3_25);
    	cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);
    	cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
    }


    public void runTemplate(HttpServletRequest request, HttpServletResponse Response){
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
    		template = cfg.getTemplate(templateName);
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request, response);
		runTemplate(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		/*
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		response.setContentType("text/html");
		System.out.println("This is a test.");
		out.println("<!DOCTYPE html>\n"
				+ "<html>"
				+ "<body>"
				+ "<h2>Hello World!</h2>"
				+ "<h3>" + fname + "</h3>"
				+ "<h3>" + lname + "</h3>"
				+ "</body>"
				+ "</html>");
		*/
	}
}