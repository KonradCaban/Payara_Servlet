package com.pay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO 
{
	ConnectionManager cm;
	   public ClientDAO() throws Exception {
		   cm = new ConnectionManager();
	   }
	   
	   
	   public List<Client> listAllClients() throws SQLException {
	       List<Client> listClient = new ArrayList<>();
	        
	       String sql = "SELECT * FROM clients";
	        
	       cm.open();
	        
	       Statement statement = cm.con.createStatement();
	       ResultSet resultSet = statement.executeQuery(sql);
	        
	       while (resultSet.next()) {
	           int id = resultSet.getInt("id_user");
	           String name = resultSet.getString("name"); 
	           String surname = resultSet.getString("surname"); 
	           String city = resultSet.getString("city"); 
	           String adress = resultSet.getString("adress"); 
	           String phone = resultSet.getString("phone"); 
	           Client client = new Client(id,name,surname,city,adress,phone);
	           listClient.add(client);
	       }
	        
	       resultSet.close();
	       statement.close();
	        
	       cm.close();
	        
	       return listClient;
	   }
	   
	   public boolean insertClient(Client client) throws SQLException {
	       String sql = "INSERT INTO clients VALUES (?,?,?,?,?)";
	       cm.open();
	        
	       PreparedStatement statement = cm.con.prepareStatement(sql);
	       statement.setString(1, client.getName());
	       statement.setString(2, client.getSurname());
	       statement.setString(3, client.getCity());
	       statement.setString(4, client.getAdress());
	       statement.setString(5, client.getPhone());
	       boolean rowInserted = statement.executeUpdate() > 0;
	       statement.close();
	       cm.close();
	       return rowInserted;
	   }
	   
	   public boolean editClient(Client client) throws SQLException {
	       String sql = "Update clients set name = ?, surname = ?, city = ?, adress = ?, phone = ? where id_user = ?";
	       cm.open();
	        
	       PreparedStatement statement = cm.con.prepareStatement(sql);
	       statement.setString(1, client.getName());
	       statement.setString(2, client.getSurname());
	       statement.setString(3, client.getCity());
	       statement.setString(4, client.getAdress());
	       statement.setString(5, client.getPhone());
	       statement.setInt(6, client.getId());
	       boolean rowInserted = statement.executeUpdate() > 0;
	       statement.close();
	       cm.close();
	       return rowInserted;
	   }
	   
	   public List<Client> findClient(String _name,String _surname, String _city, String _address, String _phone) throws SQLException {
	       List<Client> listClient = new ArrayList<>();
	        
	       String sql ="SELECT * FROM Clients where name LIKE ? AND surname LIKE ? AND city LIKE ? AND adress LIKE ? AND phone LIKE ?";
	       
	       cm.open();
	        
	       PreparedStatement statement = cm.con.prepareStatement(sql);
	       statement.setString(1, "%" +_name+ "%");
	       statement.setString(2, "%" +_surname+ "%");
	       statement.setString(3, "%" +_city+ "%");
	       statement.setString(4, "%" +_address+ "%");
	       statement.setString(5, "%" +_phone+ "%");
	       ResultSet resultSet = statement.executeQuery();
	        
	       while (resultSet.next()) {
	           int id = resultSet.getInt("id_user");
	           String name = resultSet.getString("name"); 
	           String surname = resultSet.getString("surname"); 
	           String city = resultSet.getString("city"); 
	           String adress = resultSet.getString("adress"); 
	           String phone = resultSet.getString("phone"); 
	           Client client = new Client(id,name,surname,city,adress,phone);
	           listClient.add(client);
	       }
	        
	       resultSet.close();
	       statement.close();
	        
	       cm.close();
	        
	       return listClient;
	   }
	   
	   public int deleteClient(int id) throws SQLException
	   {
	   	cm.open();
	       int status=0;  
	       try{   
	           PreparedStatement ps=cm.con.prepareStatement("delete from clients where id_user=?");  
	           ps.setInt(1,id);  
	           status=ps.executeUpdate();  
	              
	       }catch(Exception e){e.printStackTrace();}  
	         cm.close();
	       return status;  
	   }
	   
}
