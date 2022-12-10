package com.quiz.pkg1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QuestionsShuffle {
	
	Connection connection=null;
	PreparedStatement pst=null;
	
	String ans=null;
	static int count=0;
	
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	
	public void askQ() throws SQLException{
		int k=0;
		int i=1;
		
		//HashSet<Integer> hs= new HashSet<>();
		//int a[]=new int[10];
		
		
		try {
		
		ConnectionQuestion ct=new ConnectionQuestion();
		connection=ct.getConnectionDetails();
		
		Statement stmt=connection.createStatement();
	       //while(i<=10) 
	    	ResultSet rs=stmt.executeQuery("select id,qus from question ORDER BY RAND() limit 10");
	    	
	    	while(rs.next()) {
	    		System.out.println(rs.getString(2));
	    		k=(rs.getInt(1));
	    		showOptions(k);
	    	}
	
	      }
	      catch(Exception e)
	      {
		  e.printStackTrace();
	      }
	      finally {
		  connection.close();
		  pst.close();
		}
	}
	
	
	public void showOptions(int k) {
		try {
			
			ConnectionQuestion ct=new ConnectionQuestion();
			connection=ct.getConnectionDetails();
			
			
			pst=connection.prepareStatement("select * from options where id= '"+ k+"'");
			ResultSet rs=pst.executeQuery();
			
			
			while(rs.next()) {
				System.out.println("A="+rs.getString(2));
				System.out.println("B="+rs.getString(3));
				System.out.println("C="+rs.getString(4));
				System.out.println("D="+rs.getString(5));
				}
				connection.close();
				pst.close();
				rs.close();
				}
				catch(Exception e) {
				e.printStackTrace();
				}
			
			  writeAns();
			  checkAns(k);		
			
			
		}
       public void writeAns() {
		
		Scanner sc=new Scanner(System.in);
		 ans= sc.nextLine();
		
				
	}

   	public void checkAns(int k1) {
   		String correctAns = null;
   		
   		try{
   			ConnectionQuestion ct= new ConnectionQuestion();
   			connection=ct.getConnectionDetails();
   		
   			pst=connection.prepareStatement("select ans from question where id='"+k1+"'");
   			
   			ResultSet rs=pst.executeQuery();
   			
   				//
   			while(rs.next()) {
   				correctAns=(rs.getString(1));
   			}
   				if(correctAns.equalsIgnoreCase(ans)) {
   					
   					count++;
   					
   				}
   				//System.out.println(count);
   				
   				connection.close();
   				pst.close();
   				rs.close();
   				}
   				catch(Exception e) {
   				e.printStackTrace();
   				}
	}

}
