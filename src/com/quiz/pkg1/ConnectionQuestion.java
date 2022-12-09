package com.quiz.pkg1;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionQuestion {
	
	Connection connection=null;
	PreparedStatement pst=null;
	public Connection getConnectionDetails() throws ClassNotFoundException, SQLException {
	    
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1", "root","root");
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return connection;
	}

}
