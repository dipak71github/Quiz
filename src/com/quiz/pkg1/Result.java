package com.quiz.pkg1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Result {

	Connection connection=null;
	PreparedStatement pst=null;

	public void getStudentsData() throws SQLException {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter username: ");
		String user=sc.next();
		System.out.println("Enter password: ");
		String pass=sc.next();
		
		if(user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("root")) {

		try{
			ConnectionQuestion ct= new ConnectionQuestion();
			connection=ct.getConnectionDetails();

			Statement stmt= connection.createStatement();

			pst=connection.prepareStatement("SELECT Id,name,marks FROM student ORDER BY marks DESC");
			ResultSet rs=pst.executeQuery();
			System.out.println("ID\tName\tMarks ");
			while(rs.next()) {

				System.out.print(""+rs.getInt(1)+"\t");
				System.out.print(""+rs.getString(2)+"\t");
				System.out.print(""+rs.getString(3)+"\t");
				System.out.println();
			}
			
			System.out.println("Press any key for Main menu");
			char x= sc.next().charAt(0);
			Main call= new Main();
			call.getDetails();

		} 

		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			connection.close();
			pst.close();
		}
		}
		else {
			System.out.println("Invalid Username or Password! Please try again");
			Main call= new Main();
			call.getDetails();
		}

	}

	public void getYourResult() throws SQLException {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Id");
		int id= sc.nextInt();
		
		try{
			ConnectionQuestion ct= new ConnectionQuestion();
		connection=ct.getConnectionDetails();

		Statement stmt= connection.createStatement();

		pst=connection.prepareStatement("SELECT Id,name,marks, grade FROM student where id='"+id+"'");
		ResultSet rs=pst.executeQuery();
		
		System.out.println("Congratulations!");
		System.out.println("ID\tName\t\tMarks ");
		while(rs.next()) {

			System.out.print(""+rs.getInt(1)+"\t");
			System.out.print(""+rs.getString(2)+"\t");
			System.out.print(""+rs.getString(3));
			System.out.println();
		}
		System.out.println("Press any key for Main menu");
		char x= sc.next().charAt(0);
		Main call= new Main();
		call.getDetails();
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			connection.close();
			pst.close();
		}
	}

}
