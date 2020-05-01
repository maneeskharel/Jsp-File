package com.kuebiko.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

import com.kuebiko.dao.PersonDao;
import com.kuebiko.dao.PersonDaoImpl;
import com.kuebiko.dao.entity.PersonEntity;
import com.kuebiko.utils.DateUtils;

public class InsertPersonMain {
	
	public static void main(String[] args) {
		PersonDao personDao=new PersonDaoImpl();
		//String INSERT_INTO_PERSON="insert into persons_tbl(userid,name,email,dob,mobile,salary,ssn,createdate,updatedate) values(?,?,?,?,?,?,?,?,?)";
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter userid");
		String userid=scanner.next();
		System.out.println("Enter Name");
		String name=scanner.next();
		System.out.println("Enter Email");
		String email=scanner.next();
		System.out.println("Enter dob");
		String dob=scanner.next();
		Date ddob=DateUtils.dateFromString(dob); //12-03-2020
		System.out.println("Enter mobile");
		long mobile=scanner.nextLong();
		System.out.println("Enter Salary");
		double salary=scanner.nextDouble();
		System.out.println("Enter ssn");
		int  ssn=scanner.nextInt();
		
		scanner.close();
		//int pid, String userid, String name, String email, Date dob, long mobile, double salary,
		//int ssn, Timestamp createdate, Timestamp updatedate
		PersonEntity entity=new PersonEntity(0, userid, name, email, ddob, mobile, salary, ssn, null, null);
		System.out.println("Saving it.............");
		personDao.save(entity);
		System.out.println("Showing data = ");
		personDao.findAll().forEach(System.out::println);
		System.out.println("=====================================");

		System.out.println("Highest salary among the list : ");
		personDao.highestSal().forEach(System.out::println);




		
	}

}
