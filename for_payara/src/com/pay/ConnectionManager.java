package com.pay;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.sql.DataSource;

public class ConnectionManager {
	DataSource src;
	Connection con;
	
   public ConnectionManager() throws Exception {
       try
       {
       	Object ic = Class.forName("javax.naming.InitialContext").newInstance();

        this.src = (DataSource)((Context) ic).lookup("jdbc/sqlse"); //The string should be the same name you're giving to your JNDI in Glassfish.
       }
       catch(Exception e) { throw e; }
   }

   public void open() throws SQLException {
       try
       {
           if(this.con==null || this.con.isClosed())
               this.con = src.getConnection();
       }
       catch(SQLException e) { throw e; }
   }

   public void close() throws SQLException {
       try
       {
           if(this.con!=null && !this.con.isClosed())
               this.con.close();
       }
       catch(SQLException e) { throw e; }
   }

}
