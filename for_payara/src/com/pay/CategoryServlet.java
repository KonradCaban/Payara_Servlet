package com.pay;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig) 	
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			categoryDAO = new CategoryDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("dzialanie");
 
        try {
            switch (action) {
            case "/find":
            	findCat(request,response);
                break;
            case "/insert":
            	insertCat(request, response);
                break;
            case "/delete":
                deleteCat(request,response);
                break;
            case "/edit":
            	editCat(request,response);
                break;
            case "/list":
                listCat(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    
  
    }
	
	private void listCat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Category> listcat = categoryDAO.listAllCategories();
        request.setAttribute("listCat", listcat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Categories.jsp");
        dispatcher.forward(request, response);
	}
	
	private void findCat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Category> listcat = categoryDAO.findCategories(request.getParameter("word"));
        request.setAttribute("listCat", listcat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Categories.jsp");
        dispatcher.forward(request, response);
	}
	
	private void insertCat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
	       	String name = request.getParameter("name"); 
	        Category newCat = new Category(name);
	        categoryDAO.insertCategory(newCat);
	        response.sendRedirect("/for_payara/CategoryServlet?dzialanie=/list");
	}
	
	private void deleteCat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
	        int id=Integer.parseInt(request.getParameter("id") );  
	        categoryDAO.deleteCategory(id);
	        response.sendRedirect("/for_payara/CategoryServlet?dzialanie=/list");  
	}
	
	private void editCat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Category cat = new Category(Integer.parseInt(request.getParameter("id")),request.getParameter("name"));
        categoryDAO.editCategory(cat);
        response.sendRedirect("/for_payara/CategoryServlet?dzialanie=/list");
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
