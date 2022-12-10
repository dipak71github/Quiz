package com.quiz.pkg1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class RegLogin {
	
	Connection connection=null;
	PreparedStatement pst=null;
	Scanner sc = new Scanner(System.in);
	int id=0;
	public void login() throws SQLException {
		String n="";
		String p="";
		/*System.out.print("Enter your Id: ");
		int i=sc.nextInt();*/
		System.out.print("Enter your name: ");
		sc.nextLine();
		String name=sc.nextLine();

		System.out.print("Enter your Password: ");
		String pass=sc.next();

		try{
			ConnectionQuestion ct= new ConnectionQuestion();
			connection=ct.getConnectionDetails();

			Statement stmt= connection.createStatement();

			ResultSet rs=stmt.executeQuery("select id,name, pass from Student where pass='"+pass+"'");

			while(rs.next()) {
				id=rs.getInt(1);
				n=(rs.getString(2)); 
				p=(rs.getString(3));
			
			}
		if(n.equals(name) &&  p.equals(pass)) {
			System.out.println("LogIn Successful..\n You can Start your Test");
			QuestionsShuffle sq= new QuestionsShuffle();
			sq.askQ();
			System.out.println("Your Test submitted Successfully..");
			displayMarks(id);
		}
		else if(n.equals(name) || p.equals(pass)) {
			System.out.println("Incorrect UserName or Password");
			StudentRegister();
		}
		else {
			System.out.println("If you are new user then try to Register first");
			registration();
		}
			

		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			connection.close();
			pst.close();
		}


	}

	public void registration() throws SQLException {

		String n="";
		String p="";
		int stdId=0;
		System.out.print("Enter your name: ");
		sc.nextLine();
		String name=sc.nextLine();

		System.out.print("Enter your Password: ");
		String pass=sc.next();

		try{
			ConnectionQuestion ct= new ConnectionQuestion();
			connection=ct.getConnectionDetails();

			Statement stmt= connection.createStatement();

			ResultSet rs=stmt.executeQuery("select name, pass from student where name='"+name+"'");

			while(rs.next()) {
				n=(rs.getString(1)); 
				p=(rs.getString(2));
			}

			if(n.equals(name) && p.equals(pass)) {
				System.out.println("You are already register. \n Please LogIn");
				login();
			}
			else {
				try{
					pst = connection.prepareStatement("insert into student (name, pass) values(?,?)");
					pst.setString(1, name);
					pst.setString(2, pass);
					int i = pst.executeUpdate();
					
					rs=stmt.executeQuery("select id from student where pass='"+pass+"'");

					while(rs.next()) {
						stdId=(rs.getInt(1)); 
						}
				}
				catch (Exception e) {
					e.printStackTrace();
				} 

				System.out.println("Registration Successful..\n student Id: "+stdId);
				System.out.println("Remember your Id for the future");
				StudentRegister();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			connection.close();
			pst.close();
		}
	}

	public void displayMarks(int id) throws SQLException {

		int m=0;
		String g=null;
		QuestionsShuffle sq= new QuestionsShuffle();
		int t= sq.getCount();

		String gr=grade(t);
		
		//System.out.println(t);
		System.out.println("Your Grade: "+gr);

		try{
			ConnectionQuestion ct= new ConnectionQuestion();
			connection=ct.getConnectionDetails();

			Statement stmt= connection.createStatement();

			pst=connection.prepareStatement("update student set marks='"+t+"', grade='"+gr+"' where id='"+id+"'");
			//stmt.executeUpdate("INSERT INTO 'student' (marks, grade) values ('"+t+"','"+gr+"')");
			//pst.setInt(1,t); 
			//pst.setString(2,gr);

			int i = pst.executeUpdate();
			
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

	public String grade(int t) {

		if(t>=8 && t<=10) {
			return "A";
		}
		else if(t>=6 && t<8) {
			return "B";
		}
		else if(t==5) {
			return "C";
		}
		else {
			return "FAIL";
		}
	}

	public void StudentRegister() throws SQLException{
		//int i=0;
		System.out.println("Select Option 1 for LogIn \nSelect Option 2 for New Registration");		
		char a=sc.next().charAt(0);

		switch(a) {
		case '1':

			login();
			break;

		case '2':
			registration();
			break;
		default: System.out.println("Please choose correct option");
		StudentRegister();

		}
	}

}
