package com.jdbc.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class MochaTest {
	
	public static void main(String[] args) {
		  Customer customer1=new Customer("Raj", "raj@gmail.com",20,"Fremont",12,new Timestamp(new Date().getTime()+191));
		  Customer customer2=new Customer("Raj", "raj@gmail.com",30,"Fremont",90,new Timestamp(new Date().getTime()+3445));
		  Customer customer3=new Customer("Raj", "raj@gmail.com",20,"Fremont",12,new Timestamp(new Date().getTime()+191));
		  Customer customer4=new Customer("Raj", "raj@gmail.com",20,"Fremont",12,new Timestamp(new Date().getTime()+191));
		  Customer customer5=new Customer("Raj", "raj@gmail.com",20,"Fremont",12,new Timestamp(new Date().getTime()+191));
		  Customer customer6=new Customer("Raj", "raj@gmail.com",20,"Fremont",12,new Timestamp(new Date().getTime()+191));
		  Customer customer7=new Customer("Raj", "raj@gmail.com",20,"Fremont",12,new Timestamp(new Date().getTime()+191));
		  Customer customer8=new Customer("Raj", "raj@gmail.com",20,"Fremont",12,new Timestamp(new Date().getTime()+191));
		  Customer customer9=new Customer("Raj", "raj@gmail.com",20,"Fremont",12,new Timestamp(new Date().getTime()+191));
		  Customer customer10=new Customer("Raj", "raj@gmail.com",20,"Fremont",12,new Timestamp(new Date().getTime()+191));
		  Customer customer11=new Customer("Raj", "raj@gmail.com",20,"Fremont",12,new Timestamp(new Date().getTime()+191));
		 // List<Customer> customers=List.of(customer1,customer2,customer3,customer4,customer5,customer6); 	
	}

}
