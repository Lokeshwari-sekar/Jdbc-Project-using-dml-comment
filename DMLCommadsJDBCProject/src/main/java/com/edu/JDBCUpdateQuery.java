package com.edu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCUpdateQuery {

	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edudb"; //edudb is the database name of mysql
		String un="root";
		String pass="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id to update record");
		int id = sc.nextInt();
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,un,pass);
			st=conn.createStatement();
		  String sql="select * from details where id="+id; //get only one row
		  //check id exists
		  rs=st.executeQuery(sql);
		  if(rs.next()) { //if true record exists
			  //Update operation when record exists
			  System.out.println("Enter name to change");
				String name=sc.next(); 
			String upd="update details set name='"+name+"' where id="+id;
			int  i=st.executeUpdate(upd);
			
			if(i>0) {
				System.out.println("Record is Updated");
			}
			}//if
		  else {
			  System.out.println("Record not exists");
		  }
		  
	}catch(Exception e) {
		e.printStackTrace();
	}

	}

}
