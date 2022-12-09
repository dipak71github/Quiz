package com.quiz.pkg1;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		Question qs=new Question();
		qs.getMultipleQuestion();
		
		
		Options op=new Options();
		op.insertOpt();
		
		
	}

}
