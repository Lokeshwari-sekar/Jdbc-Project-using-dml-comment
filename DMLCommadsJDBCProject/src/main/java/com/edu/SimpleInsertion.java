package com.edu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SimpleInsertion {

	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edudb"; //edudb is the database name of mysql
		String un="root";
		String pass="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id to insert record");
		int id = sc.nextInt();
		
		String sql = "select * from details where id="+id;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,un,pass);
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			 if(!rs.next()) {
			   System.out.println("Enter name ");
			   String name=sc.next();
			   System.out.println("Enter email id ");
			   String emailid=sc.next();
			   String ins="insert into login values("+id+",'"+name+"','"+emailid+"')";
			   
			  int i= st.executeUpdate(ins);
			   if(i>0) {
				   System.out.println("Record is inserted successfully");
			   }
			   
			 }else {
				 System.out.println("Id already exists choose different id ");
			 }
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
