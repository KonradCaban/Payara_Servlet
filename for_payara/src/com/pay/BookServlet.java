package com.pay;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
	private PublisherDAO publisherDAO;
	private CategoryDAO categoryDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        
    	try {
			bookDAO = new BookDAO();
			publisherDAO = new PublisherDAO();
			categoryDAO = new CategoryDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("dzialanie");
		 
	        try {
	            switch (action) {
	            case "/find":
	            	findBooks(request,response);
	                break;
	            case "/insert":
	            	insertBook(request,response);
	                break;
	            case "/delete":
	               deleteBook(request,response);
	                break;
	            case "/edit":
	            	editBook(request,response);
	                break;
	            case "/list":
	                listBook(request, response);
	                break;
	            case "/load_edit":
	            	loadEdit(request,response);
	            	break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void loadEdit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		String id = request.getParameter("id");
       	String title = request.getParameter("title"); 
       	String author = request.getParameter("author"); 
       	String cat_id = request.getParameter("catid");
       	String pub_id = request.getParameter("pubid");
       	String price = request.getParameter("price");
       	String quantity = request.getParameter("quantity");
       

        
        request.setAttribute("quantity",quantity);
        request.setAttribute("price",price);
        request.setAttribute("pub_id",pub_id);
        request.setAttribute("cat_id",cat_id);
        request.setAttribute("author",author);
        request.setAttribute("title",title);
        request.setAttribute("id",id);
        List<Publisher> listpublisher = publisherDAO.listAllPublishers();
        request.setAttribute("listpublisher",listpublisher);
        List<Category> listcategory = categoryDAO.listAllCategories();
        request.setAttribute("listcategory", listcategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditBook.jsp");
        dispatcher.forward(request, response);
	}
	
	private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Book> listbook = bookDAO.listAllBooks();
        request.setAttribute("listBook",listbook);
        List<Publisher> listpublisher = publisherDAO.listAllPublishers();
        request.setAttribute("listpublisher",listpublisher);
        List<Category> listcategory = categoryDAO.listAllCategories();
        request.setAttribute("listcategory", listcategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Books.jsp");
        dispatcher.forward(request, response);
	}
	
	private void findBooks(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Book> listbook = bookDAO.findBooks(request.getParameter("title"),request.getParameter("author"),request.getParameter("catname"),request.getParameter("pubname"));
        request.setAttribute("listBook",listbook);
        List<Publisher> listpublisher = publisherDAO.listAllPublishers();
        request.setAttribute("listpublisher",listpublisher);
        List<Category> listcategory = categoryDAO.listAllCategories();
        request.setAttribute("listcategory", listcategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Books.jsp");
        dispatcher.forward(request, response);
	}
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
	        int id=Integer.parseInt(request.getParameter("id") );  
	        bookDAO.deleteBook(id);
	        response.sendRedirect("/for_payara/BookServlet?dzialanie=/list");  
	}
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	       	String title = request.getParameter("title"); 
	       	String author = request.getParameter("author"); 
	       	String cat_id = request.getParameter("categories");
	       	String pub_id = request.getParameter("publishers");
	       	String price = request.getParameter("price");
	       	String quantity = request.getParameter("quantity");
	       	
	        Book book = new Book(title,author,Integer.parseInt(cat_id),Integer.parseInt(pub_id),Double.parseDouble(price),Integer.parseInt(quantity));
	        bookDAO.insertBook(book);
	        response.sendRedirect("/for_payara/BookServlet?dzialanie=/list");
	}
	
	private void editBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
			String id = request.getParameter("id");
	       	String title = request.getParameter("title"); 
	       	String author = request.getParameter("author"); 
	       	String cat_id = request.getParameter("categories");
	       	String pub_id = request.getParameter("publishers");
	       	String price = request.getParameter("price");
	       	String quantity = request.getParameter("quantity");
	       	
	        Book book = new Book(Integer.parseInt(id),title,author,Integer.parseInt(cat_id),Integer.parseInt(quantity),Integer.parseInt(pub_id),Double.parseDouble(price));
	        bookDAO.editBook(book);
	        response.sendRedirect("/for_payara/BookServlet?dzialanie=/list");
	}

}
