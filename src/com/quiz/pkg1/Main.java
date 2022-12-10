package com.quiz.pkg1;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
public void getDetails() throws SQLException {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your choice");
		System.out.println("1. Register/LogIn");
		System.out.println("2. Student Data");
		System.out.println("3. Your Result");
		
		int c= sc.nextInt();
		/**/
		switch(c) {
		case 1:
			RegLogin rl= new RegLogin();
			rl.StudentRegister();
		break;
		case 2:
			Result rs= new Result();
			rs.getStudentsData();
		break;
		case 3:
			Result rs1= new Result();
			rs1.getYourResult() ;
		break;
		default: System.out.println("Please choose valid option");
		}
		

	}
	
	public static void main(String[] args) throws SQLException {
		
//		RegLogin rg =new RegLogin();
//		rg.registration();
//		
//		Question qs=new Question();
//		qs.getMultipleQuestion();
//		
//		
//		Options op=new Options();
//		op.insertOpt();
//		
		
		Main call= new Main();
		call.getDetails();
	}

}
