package com.pay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	ConnectionManager cm;
	   public BookDAO() throws Exception {
		   cm = new ConnectionManager();
	   }
	   
	   public List<Book> listAllBooks() throws SQLException {
	       List<Book> listBooks = new ArrayList<>();
	        
	       String sql = "select * from books as b join publishers as p on b.pubid=p.id_pub join categories as c on c.id_cat=b.catid";
	        
	       cm.open();
	        
	       Statement statement = cm.con.createStatement();
	       ResultSet resultSet = statement.executeQuery(sql);
	        
	       while (resultSet.next()) {
	           Book book = new Book(resultSet.getInt("id_book"),resultSet.getString("title"),resultSet.getString("autor"),resultSet.getInt("catid"),resultSet.getString("cat_name"),resultSet.getInt("pubid"),resultSet.getString("pub_name"),resultSet.getDouble("price"),resultSet.getInt("quantity") );
	           listBooks.add(book);
	       }
	        
	       resultSet.close();
	       statement.close();
	        
	       cm.close();
	        
	       return listBooks;
	   }
	   
	   
	   public List<Book> findBooks(String _title, String _author, String _catname, String _pubname) throws SQLException {
	       List<Book> listBooks = new ArrayList<>();
	        
	       String sql = "select * from books as b join publishers as p on b.pubid=p.id_pub join categories as c on c.id_cat=b.catid where title LIKE ? AND autor LIKE ? AND cat_name LIKE ? AND pub_name LIKE ?";
	        
	       cm.open();
	        
	       PreparedStatement statement = cm.con.prepareStatement(sql);
	       statement.setString(2, "%" +_author+ "%");
	       statement.setString(1, "%" +_title+ "%");
	       statement.setString(3, "%" +_catname+ "%");
	       statement.setString(4, "%" +_pubname+ "%");
	       ResultSet resultSet = statement.executeQuery();
	        
	       while (resultSet.next()) {
	           Book book = new Book(resultSet.getInt("id_book"),resultSet.getString("title"),resultSet.getString("autor"),resultSet.getInt("catid"),resultSet.getString("cat_name"),resultSet.getInt("pubid"),resultSet.getString("pub_name"),resultSet.getDouble("price"),resultSet.getInt("quantity") );
	           listBooks.add(book);
	       }
	        
	       resultSet.close();
	       statement.close(); 
	       cm.close();
	       return listBooks;
	   }
	    
	   
	   
	   public int deleteBook(int id) throws SQLException
	   {
	   	cm.open();
	       int status=0;  
	       try{   
	           PreparedStatement ps=cm.con.prepareStatement("delete from books where id_book=?");  
	           ps.setInt(1,id);  
	           status=ps.executeUpdate();  
	              
	       }catch(Exception e){e.printStackTrace();}  
	         cm.close();
	       return status;  
	   }
	   
	   public boolean insertBook(Book book) throws SQLException {
	       String sql = "INSERT INTO books VALUES (?,?,?,?,?,?)";
	       cm.open();
	        
	       PreparedStatement statement = cm.con.prepareStatement(sql);
	       statement.setString(1, book.getTitle());
	       statement.setString(2, book.getAuthor());
	       statement.setInt(3, book.getCatid());
	       statement.setInt(4, book.getPubid());
	       statement.setDouble(5, book.getPrice());
	       statement.setInt(6,book.getQuantity());
	       boolean rowInserted = statement.executeUpdate() > 0;
	       statement.close();
	       cm.close();
	       return rowInserted;
	   }
	   
	   public boolean editBook(Book book) throws SQLException {
	       String sql = "update books set title = ?, autor = ?, catid = ?, pubid = ?, price = ?, quantity = ? where id_book = ?";
	       cm.open();
	        
	       PreparedStatement statement = cm.con.prepareStatement(sql);
	       statement.setString(1, book.getTitle());
	       statement.setString(2, book.getAuthor());
	       statement.setInt(3, book.getCatid());
	       statement.setInt(4, book.getPubid());
	       statement.setDouble(5, book.getPrice());
	       statement.setInt(6,book.getQuantity());
	       statement.setInt(7,book.getId());
	       boolean rowInserted = statement.executeUpdate() > 0;
	       statement.close();
	       cm.close();
	       return rowInserted;
	   }
	   
}
