package com.pay;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PublisherDAO {

	ConnectionManager cm;
   public PublisherDAO() throws Exception {
	   cm = new ConnectionManager();
   }
   
   
   public List<Publisher> listAllPublishers() throws SQLException {
       List<Publisher> listPub = new ArrayList<>();
        
       String sql = "SELECT * FROM publishers";
        
       cm.open();
        
       Statement statement = cm.con.createStatement();
       ResultSet resultSet = statement.executeQuery(sql);
        
       while (resultSet.next()) {
           int id = resultSet.getInt("id_pub");
           String pub_name = resultSet.getString("pub_name"); 
           Publisher pub = new Publisher(id,pub_name);
           listPub.add(pub);
       }
        
       resultSet.close();
       statement.close();
        
       cm.close();
        
       return listPub;
   }
   
   public List<Publisher> findPublisher(String name) throws SQLException {
       List<Publisher> listPub = new ArrayList<>();
        
       String sql ="SELECT * FROM publishers where pub_name LIKE ?";
       
       cm.open();
        
       PreparedStatement statement = cm.con.prepareStatement(sql);
       statement.setString(1, "%" +name+ "%");
       ResultSet resultSet = statement.executeQuery();
        
       while (resultSet.next()) {
           int id = resultSet.getInt("id_pub");
           String pub_name = resultSet.getString("pub_name"); 
           Publisher pub = new Publisher(id,pub_name);
           listPub.add(pub);
       }
        
       resultSet.close();
       statement.close();
        
       cm.close();
        
       return listPub;
   }
   
   
   public boolean insertPublisher(Publisher publisher) throws SQLException {
       String sql = "INSERT INTO publishers (pub_name) VALUES (?)";
       cm.open();
        
       PreparedStatement statement = cm.con.prepareStatement(sql);
       statement.setString(1, publisher.getPub_name());
       boolean rowInserted = statement.executeUpdate() > 0;
       statement.close();
       cm.close();
       return rowInserted;
   }
   
   public boolean editPublisher(Publisher publisher) throws SQLException {
       String sql = "Update publishers set pub_name = ? where id_pub = ?";
       cm.open();
        
       PreparedStatement statement = cm.con.prepareStatement(sql);
       statement.setString(1, publisher.getPub_name());
       statement.setInt(2, publisher.getId());
       boolean rowInserted = statement.executeUpdate() > 0;
       statement.close();
       cm.close();
       return rowInserted;
   }
   
   public int deletePublisher(int id) throws SQLException
   {
   	cm.open();
       int status=0;  
       try{   
           PreparedStatement ps=cm.con.prepareStatement("delete from publishers where id_pub=?");  
           ps.setInt(1,id);  
           status=ps.executeUpdate();  
              
       }catch(Exception e){e.printStackTrace();}  
         cm.close();
       return status;  
   }
   
   
}
