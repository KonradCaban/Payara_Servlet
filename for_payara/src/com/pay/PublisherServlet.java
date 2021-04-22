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
 * Servlet implementation class PublisherServlet
 */
@WebServlet("/PublisherServlet")
public class PublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublisherDAO publisherDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublisherServlet() {
    	try {
			publisherDAO = new PublisherDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("dzialanie");
		 
	        try {
	            switch (action) {
	            case "/find":
	            	findPub(request,response);
	                break;
	            case "/insert":
	            	insertPub(request,response);
	                break;
	            case "/delete":
	                deletePub(request,response);
	                break;
	            case "/edit":
	            	editPub(request,response);
	                break;   
	            case "/list":
	                listPub(request, response);
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
	
	private void listPub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Publisher> listpub = publisherDAO.listAllPublishers();
        request.setAttribute("listPub", listpub);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Publishers.jsp");
        dispatcher.forward(request, response);
	}
	
	private void editPub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Publisher pub = new Publisher(Integer.parseInt(request.getParameter("id")),request.getParameter("name"));
        publisherDAO.editPublisher(pub);
        response.sendRedirect("/for_payara/PublisherServlet?dzialanie=/list");
	}
	
	private void findPub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Publisher> listpub = publisherDAO.findPublisher(request.getParameter("word"));
        request.setAttribute("listPub",listpub);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Publishers.jsp");
        dispatcher.forward(request, response);
	}
	
	private void insertPub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	       	String name = request.getParameter("name"); 
	        Publisher newPub = new Publisher(name);
	        publisherDAO.insertPublisher(newPub);
	        response.sendRedirect("/for_payara/PublisherServlet?dzialanie=/list");
	}
	
	private void deletePub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
	        int id=Integer.parseInt(request.getParameter("id") );  
	        publisherDAO.deletePublisher(id);
	        response.sendRedirect("/for_payara/PublisherServlet?dzialanie=/list");  
	}
	

}
