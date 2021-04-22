package com.pay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO 
{
	ConnectionManager cm;
	   public TransactionDAO() throws Exception {
		   cm = new ConnectionManager();
	   }
	   
	   public List<Transaction> listAllTransactions() throws SQLException {
	       List<Transaction> listTr = new ArrayList<>();
	        
	       String sql = "select id_tran,bookid,title,clientid,name + ' ' + surname as klient, t.quantity_b as quantity from transactions as t join clients as c on t.clientid=c.id_user join  books as b on b.id_book=t.bookid";
	        
	       cm.open();
	        
	       Statement statement = cm.con.createStatement();
	       ResultSet resultSet = statement.executeQuery(sql);
	        
	       while (resultSet.next()) {
	           int id = resultSet.getInt("id_tran");
	           int bookid = resultSet.getInt("bookid");
	           int clientid = resultSet.getInt("clientid");
	           String title = resultSet.getString("title"); 
	           String client = resultSet.getString("klient"); 
	           int quantity = resultSet.getInt("quantity");
	           Transaction tr = new Transaction(id,bookid,title,clientid,client,quantity);
	           listTr.add(tr);
	       }
	        
	       resultSet.close();
	       statement.close();
	        
	       cm.close();
	        
	       return listTr;
	   }
	   
	   
	   public List<Transaction> findTransactions(String _title, String _client) throws SQLException {
	       List<Transaction> listTr = new ArrayList<>();
	        
	       String sql = "select id_tran,bookid,title,clientid,name + ' ' + surname as klient, t.quantity_b as quantity from transactions as t join clients as c on t.clientid=c.id_user join  books as b on b.id_book=t.bookid where title LIKE ? AND ( name LIKE ? OR surname LIKE ? )" ;
	        
	       cm.open();
	        
	       PreparedStatement statement = cm.con.prepareStatement(sql);
	       statement.setString(1, "%" +_title+ "%");
	       statement.setString(2, "%" +_client+ "%");
	       statement.setString(3, "%" +_client+ "%");
	       ResultSet resultSet = statement.executeQuery();
	        
	       while (resultSet.next()) {
	           int id = resultSet.getInt("id_tran");
	           int bookid = resultSet.getInt("bookid");
	           int clientid = resultSet.getInt("clientid");
	           String title = resultSet.getString("title"); 
	           String client = resultSet.getString("klient"); 
	           int quantity = resultSet.getInt("quantity");
	           Transaction tr = new Transaction(id,bookid,title,clientid,client,quantity);
	           listTr.add(tr);
	       }
	        
	       resultSet.close();
	       statement.close();
	        
	       cm.close();
	        
	       return listTr;
	   }
	   
	   public int deleteTransaction(int id) throws SQLException
	   {
	   	cm.open();
	       int status=0;  
	       try{   
	           PreparedStatement ps=cm.con.prepareStatement("delete from transactions where id_tran=?");  
	           ps.setInt(1,id);  
	           status=ps.executeUpdate();  
	              
	       }catch(Exception e){e.printStackTrace();}  
	         cm.close();
	       return status;  
	   }
	   
	   public boolean insertTransaction(Transaction transaction) throws SQLException {
	       String sql = "INSERT INTO transactions VALUES (?,?,?)";
	       cm.open();
	        
	       PreparedStatement statement = cm.con.prepareStatement(sql);
	       statement.setInt(1, transaction.getBook_id());
	       statement.setInt(2, transaction.getClient_id());
	       statement.setInt(3, transaction.getQuantity());
	       boolean rowInserted = statement.executeUpdate() > 0;
	       statement.close();
	       
	       sql = "Update books set quantity = quantity - ? where id_book = ?";
	       cm.open();
	        
	       statement = cm.con.prepareStatement(sql);
	       statement.setInt(1, transaction.getQuantity());
	       statement.setInt(2, transaction.getBook_id());
	       statement.executeUpdate();
	       statement.close();
	       cm.close();
	       return rowInserted;
	   }
	   
	   public boolean editTransaction(Transaction transaction) throws SQLException {
	       String sql = "Update transactions set bookid = ?, clientid = ?, quantity_b = ? where id_tran = ?";
	       cm.open();
	        
	       PreparedStatement statement = cm.con.prepareStatement(sql);
	       statement.setInt(1, transaction.getBook_id());
	       statement.setInt(2, transaction.getClient_id());
	       statement.setInt(3, transaction.getQuantity());
	       statement.setInt(4, transaction.getId());
	       boolean rowInserted = statement.executeUpdate() > 0;
	       statement.close();
	       cm.close();
	       return rowInserted;
	   }
	   
}
