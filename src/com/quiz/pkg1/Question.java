package com.quiz.pkg1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question {
	
	Connection connection;
	PreparedStatement pst;
	
	
	public void getMultipleQuestion() throws SQLException {
		int i=0;
		
		try {
		ConnectionQuestion cmq=new ConnectionQuestion();
		connection=cmq.getConnectionDetails();
		
		pst=connection.prepareStatement("insert into question (qus,ans) values (?,?)");
		
		pst.setString(1, "which one of the following is not access specifier?");
		pst.setString(2, "throws");
		i = pst.executeUpdate();  //q1
		
		pst.setString(1, "In which of the following we can use multiple inheritance?");
		pst.setString(2, "interface");
		i = pst.executeUpdate();  //q2
		
		pst.setString(1, "Static keyword applicable for?");
		pst.setString(2, "All of the above");
		i = pst.executeUpdate(); //q3
		
		pst.setString(1, "How we can iterate statement?"); //q4
		pst.setString(2, "while");
		i = pst.executeUpdate();
		
		pst.setString(1, "how we can achieve polymorphism?");//q5
		pst.setString(2, "both a and b");
		i = pst.executeUpdate();
		
		pst.setString(1, "which is super class in the exception?"); //q6
		pst.setString(2, "throwable");
		i = pst.executeUpdate();
		
		pst.setString(1, "which one is not child interface of collection?");
		pst.setString(2, "map");
		i = pst.executeUpdate();  //Q7 
		
		pst.setString(1, "which keyword is used to refer current class variable?");
		pst.setString(2, "this");
		i = pst.executeUpdate(); //q8 
		
		pst.setString(1, "which of the following is a legacy class?");
		pst.setString(2, "none of the above");
		i = pst.executeUpdate();  //q9
		
		pst.setString(1, "which class we can use to obtain input from user?");
		pst.setString(2, "Scanner");
		i = pst.executeUpdate(); //q10 
				
		System.out.println("Record is inserted successfully.." + i);
		
		pst.close();
		connection.close();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
		finally
		{
		 connection.close();
		 pst.close();
		}
}

}
