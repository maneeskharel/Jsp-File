package com.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerAdd {
	public static void main(String[] args) {
		
		//JDBC Programming
		try {
			//1.... loading the driver
			//every database has it;s own driver
			Class.forName("com.mysql.jdbc.Driver");
			//Making connection to the driver
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/keubiko_db","root","mysql@1234");
			if(conn!=null){
				System.out.println("Db connection is established!!!!!!!!");
			}
			
			//Taking input from the user
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter name ");
			String name=scanner.next();
			System.out.println("Enter email ");
			String email=scanner.next();
			System.out.println("Enter age ");
			int age=scanner.nextInt();
			System.out.println("Enter address ");
			String address=scanner.next();
			System.out.println("Enter marks ");
			int marks=scanner.nextInt();

			//Writting query
			String sql="insert into customer_tbl(name,email,age,address,marks,doe) values(?,?,?,?,?,?)";
			//Compiling query and creating object of PreparedStatement
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//setting values insid the compiled query
			pstmt.setString(1,name);
			pstmt.setString(2,email);
			pstmt.setInt(3,age);
			pstmt.setString(4,address);
			pstmt.setInt(5,marks);
			pstmt.setTimestamp(6,new Timestamp(new Date().getTime()));
			//Fire the query
			int rows=pstmt.executeUpdate();
			System.out.println("Rows = "+rows);
			System.out.println("Now customer data is = ");
			showCustomers(conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void showCustomers(Connection conn) throws SQLException {
		//Writting query
		String sql="select name,email,age,address,marks,doe from customer_tbl";
		//Compiling query and creating object of PreparedStatement
		PreparedStatement pstmt=conn.prepareStatement(sql);
		//Fire the query
		ResultSet resultSet=pstmt.executeQuery();
		List<Customer> customers=new ArrayList<>();
		while(resultSet.next()) {
			String name=resultSet.getString(1);
			String email=resultSet.getString(2);
			int age=resultSet.getInt(3);
			String address=resultSet.getString(4);
			int marks=resultSet.getInt(5);
			Timestamp doe=resultSet.getTimestamp(6);
			Customer customer=new Customer(name, email, age, address, marks,doe);
			customers.add(customer);
		}
		//printing all the customers from the list
		customers.forEach(System.out::println);
	}
}
