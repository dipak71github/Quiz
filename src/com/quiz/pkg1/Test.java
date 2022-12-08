package com.quiz.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		//same
		//make the connection(url,hostname ,DB name, username,password)
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo5","root","root");
		
		
		//sql query
		
		
		String sql="insert into Employee(questions,option1,option2,option3,option4,answer) values('which one of the following is not access specifier?','public','private','protected','throws','throws')";
//		//by statement
	     Statement stmt=connection.createStatement();
//		
		stmt.execute(sql);
//		//by prepared statement
//		int sernum=1;
		String questions="which one of the following is not access specifier?";
		String option1="public";
		String option2="private";
		String option3="protected";
		String option4="throws";
		String answer="throws";
		
		
		PreparedStatement pps= connection.prepareStatement("insert into employee(questions,option1,option2,option3,option4,answer) values(?,?,?,?,?,?)");
		
//		pps.setInt(1,sernum);
		pps.setString(1,questions);
		pps.setString(2,option1);
		pps.setString(3,option2);
		pps.setString(4,option3);
		pps.setString(5,option4);
		pps.setString(6,answer);
		
		
		pps.execute();
		System.out.println("record inserted successfully");
		connection.close();
		stmt.close();

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		
	}
	
	}
	

}
