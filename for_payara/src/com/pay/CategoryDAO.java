package com.pay;

import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDAO 
{

	 private ConnectionManager cm ;
	
    public CategoryDAO() throws Exception {
       cm = new ConnectionManager();
    }

    public List<Category> listAllCategories() throws SQLException {
        List<Category> listCat = new ArrayList<>();
         
        String sql = "SELECT * FROM categories";
         
        cm.open();
         
        Statement statement = cm.con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id_cat");
            String cat_name = resultSet.getString("cat_name"); 
            Category cat = new Category(id,cat_name);
            listCat.add(cat);
        }
         
        resultSet.close();
        statement.close();
         
        cm.close();
         
        return listCat;
    }
    public boolean insertCategory(Category category) throws SQLException {
        String sql = "INSERT INTO categories (cat_name) VALUES (?)";
        cm.open();
         
        PreparedStatement statement = cm.con.prepareStatement(sql);
        statement.setString(1, category.getCategory_name());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        cm.close();
        return rowInserted;
    }
    
    public boolean editCategory(Category category) throws SQLException {
        String sql = "Update categories set cat_name = ? where id_cat = ?";
        cm.open();
         
        PreparedStatement statement = cm.con.prepareStatement(sql);
        statement.setString(1, category.getCategory_name());
        statement.setInt(2, category.getId());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        cm.close();
        return rowInserted;
    }
    
    
    public int deleteCategory(int id) throws SQLException
    {
    	cm.open();
        int status=0;  
        try{   
            PreparedStatement ps=cm.con.prepareStatement("delete from categories where id_cat=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
               
        }catch(Exception e){e.printStackTrace();}  
          cm.close();
        return status;  
    }
    
    public List<Category> findCategories(String name) throws SQLException {
        List<Category> listCat = new ArrayList<>();
         
        String sql ="SELECT * FROM categories where cat_name LIKE ?";
        
        cm.open();
         
        PreparedStatement statement = cm.con.prepareStatement(sql);
        statement.setString(1, "%" +name+ "%");
        ResultSet resultSet = statement.executeQuery();
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id_cat");
            String cat_name = resultSet.getString("cat_name"); 
            Category cat = new Category(id,cat_name);
            listCat.add(cat);
        }
         
        resultSet.close();
        statement.close();
         
        cm.close();
         
        return listCat;
    }
    
}
