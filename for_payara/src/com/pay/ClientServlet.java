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
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        try
        {
        	clientDAO = new ClientDAO();
        } catch (Exception e)
        {
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
            	findClients(request,response);
                break;
            case "/insert":
            	insertClient(request,response);
                break;
            case "/delete":
                deleteClient(request,response);
                break;
            case "/edit":
            	editClient(request,response);
                break;
            case "/list":
                listClients(request,response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listClients(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Client> listclients = clientDAO.listAllClients();
        request.setAttribute("listClients", listclients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Clients.jsp");
        dispatcher.forward(request, response);
	}
	
	private void findClients(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Client> listclients = clientDAO.findClient(request.getParameter("name"),request.getParameter("surname"),request.getParameter("city"),request.getParameter("address"),request.getParameter("phone"));
        request.setAttribute("listClients", listclients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Clients.jsp");
        dispatcher.forward(request, response);
	}

	private void editClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Client cl = new Client(Integer.parseInt(request.getParameter("id")),request.getParameter("name"),request.getParameter("surname"),request.getParameter("city"),request.getParameter("adress"),request.getParameter("phone"));
        clientDAO.editClient(cl);
        response.sendRedirect("/for_payara/ClientServlet?dzialanie=/list");
	}
	
	private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	       	String name = request.getParameter("name"); 
	       	String surname = request.getParameter("surname");
	       	String city = request.getParameter("city");
	       	String address = request.getParameter("adress");
	       	String phone = request.getParameter("phone");
	        Client newClient = new Client(name,surname,city,address,phone);
	        clientDAO.insertClient(newClient);
	        response.sendRedirect("/for_payara/ClientServlet?dzialanie=/list");
	}
	
	private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
	        int id=Integer.parseInt(request.getParameter("id") );  
	        clientDAO.deleteClient(id);
	        response.sendRedirect("/for_payara/ClientServlet?dzialanie=/list");  
	}
	
}
