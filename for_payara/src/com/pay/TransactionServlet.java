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
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionDAO transactionDAO;
	private BookDAO bookDAO;
	private ClientDAO clientDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        
    try
    {
    	transactionDAO = new TransactionDAO();
    	bookDAO = new BookDAO();
    	clientDAO = new ClientDAO();
    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
    }}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("dzialanie");
		 
	        try {
	            switch (action) {
	            case "/find":
	            	findTran(request,response);
	                break;
	            case "/insert":
	            	insertTran(request,response);
	                break;
	            case "/delete":
	                deleteTran(request,response);
	                break;
	            case "/edit":
	            	editTran(request,response);
	                break;
	            case "/list":
	               listTran(request, response);
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
	
	private void listTran(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Transaction> listtr = transactionDAO.listAllTransactions();
        request.setAttribute("listTr", listtr);
        List<Book> listbook = bookDAO.listAllBooks();
        request.setAttribute("listbook", listbook);
        List<Client> listClient = clientDAO.listAllClients();
        
        request.setAttribute("listclient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Transactions.jsp");
        dispatcher.forward(request, response);
	}
	
	private void findTran(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Transaction> listtr = transactionDAO.findTransactions(request.getParameter("book"),request.getParameter("client"));
        request.setAttribute("listTr", listtr);
        List<Book> listbook = bookDAO.listAllBooks();
        request.setAttribute("listbook", listbook);
        List<Client> listClient = clientDAO.listAllClients();
        
        request.setAttribute("listclient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Transactions.jsp");
        dispatcher.forward(request, response);
	}
	
	private void deleteTran(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
	        int id=Integer.parseInt(request.getParameter("id") );  
	        transactionDAO.deleteTransaction(id);
	        response.sendRedirect("/for_payara/TransactionServlet?dzialanie=/list");  
	}
	
	private void insertTran(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	       	String quantity = request.getParameter("quantity"); 
	       	String client = request.getParameter("clients"); 
	       	String book = request.getParameter("books");

	       	
	        Transaction transaction = new Transaction(Integer.parseInt(book),Integer.parseInt(client),Integer.parseInt(quantity));
	        transactionDAO.insertTransaction(transaction);
	        response.sendRedirect("/for_payara/TransactionServlet?dzialanie=/list");
	}
	
	private void editTran(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	       	String quantity = request.getParameter("quantity"); 
	       	String client = request.getParameter("clients"); 
	       	String book = request.getParameter("books");
	       	String id = request.getParameter("id");

	       	
	        Transaction transaction = new Transaction(Integer.parseInt(id),Integer.parseInt(book),Integer.parseInt(client),Integer.parseInt(quantity));
	        transactionDAO.editTransaction(transaction);
	        response.sendRedirect("/for_payara/TransactionServlet?dzialanie=/list");
	}
	
	private void loadEdit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		String id = request.getParameter("id");
       	String book_id = request.getParameter("bookid");
       	String cl_id = request.getParameter("clid");
       	String quantity = request.getParameter("quantity");
       

        
        request.setAttribute("quantity",quantity);
        request.setAttribute("book_id",book_id);
        request.setAttribute("cl_id",cl_id);
        request.setAttribute("id",id);
        List<Book> listbook = bookDAO.listAllBooks();
        request.setAttribute("listbook",listbook);
        List<Client> listclient = clientDAO.listAllClients();
        request.setAttribute("listclient", listclient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditTran.jsp");
        dispatcher.forward(request, response);
	}


}
