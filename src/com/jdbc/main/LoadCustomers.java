package com.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LoadCustomers {
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
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
