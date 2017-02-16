package edu.uga.cs.servlet;

public class Product {

	private String name;
	private String url;
	
	public Product(String name, String url){
		this.name = name;
		this.url = url;
	}
	
	//Product p = new Product("Computers", "product/computersystems.html");
	//root.put("latestProduct", p);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}