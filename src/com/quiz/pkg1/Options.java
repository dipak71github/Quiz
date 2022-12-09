package com.quiz.pkg1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Options {
	
	Connection connection=null;
	PreparedStatement pst=null;
	
	
	public void insertOpt() throws SQLException
	{
		int i=0;
		try {
		ConnectionQuestion ct=new ConnectionQuestion();
		connection=ct.getConnectionDetails();
		
		
		pst=connection.prepareStatement("insert into Options(Option1,Option2,Option3,Option4)values(?,?,?,?)");
		
		
		pst.setString(1, "public");
		pst.setString(2, "private" );
		pst.setString(3, "protected");
		pst.setString(4, "throws" );
		i=pst.executeUpdate();             //q1
		
		pst.setString(1, "abstraction");
		pst.setString(2, "interface" );
		pst.setString(3, "method overloading");
		pst.setString(4, "encapsulation" );
		i=pst.executeUpdate();              //q2
		
		pst.setString(1, "variable");
		pst.setString(2, "static block" );
		pst.setString(3, "static method");
		pst.setString(4, "All of the above" );
		i=pst.executeUpdate();                 //q3
		
		pst.setString(1, "while");
		pst.setString(2, "if_else" );
		pst.setString(3, "switch");
		pst.setString(4, "continue" );
		i=pst.executeUpdate();                 //q4 a.while b.if_else c.switch d.continue
		
		pst.setString(1, "method overloading");
		pst.setString(2, "method overriding" );
		pst.setString(3, "both a and b");
		pst.setString(4, "none of the above" );
		i=pst.executeUpdate();   //q5 a.method overloading b.method overriding c. both a and b d.none of the above
		
		pst.setString(1, "throw");
		pst.setString(2, "throws" );
		pst.setString(3, "throwable");
		pst.setString(4, "error" );
		i=pst.executeUpdate();  //q6 a.throw b.throws c.throwable d.error
		
		pst.setString(1, "map");
		pst.setString(2, "list" );
		pst.setString(3, "set");
		pst.setString(4, "all of the above" );
		i=pst.executeUpdate();  //q7 a.map b. list c.set d.all of the above
		
		pst.setString(1, "this");
		pst.setString(2, "super" );
		pst.setString(3, "final");
		pst.setString(4, "finally" );
		i=pst.executeUpdate();  //q8 a.this b.super c.final d.finally
		
		pst.setString(1, "HashSet");
		pst.setString(2, "LinkedHashSet" );
		pst.setString(3, "TreeMap");
		pst.setString(4, "none of the above" );
		i=pst.executeUpdate();  //q9 a.HashSet b.LinkedHashSet c.TreeMap d.none of the above
		
		pst.setString(1, "Scanner");
		pst.setString(2, "HashSet" );
		pst.setString(3, "LinkedHashSet");
		pst.setString(4, "TreeMap" );
		i=pst.executeUpdate();  //q10 a.Scanner b.HashSet c.LinkedHashSet d.TreeMap
				
		System.out.println("Record is inserted successfully ..." +i);
		
	}
		
	catch(Exception e)
		{
		e.printStackTrace();
	    }
		
	 finally 
	   {
		 connection.close();
		 pst.close();
	   }
		
	}

}
