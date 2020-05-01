package com.kuebiko.main;

import java.util.Date;
import java.util.Scanner;

import com.kuebiko.dao.PersonDao;
import com.kuebiko.dao.PersonDaoImpl;
import com.kuebiko.dao.entity.PersonEntity;
import com.kuebiko.utils.DateUtils;


public class UpdatePersonMain {

	public static void main(String[] args) {
		PersonDao personDao=new PersonDaoImpl();
		personDao.findAll().forEach(System.out::println);
		//String INSERT_INTO_PERSON="insert into persons_tbl(userid,name,email,dob,mobile,salary,ssn,createdate,updatedate) values(?,?,?,?,?,?,?,?,?)";
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter userid");
		String userid=scanner.next();
		System.out.println("Enter new- Name");
		String name=scanner.next();
		System.out.println("Enter new-Email");
		String email=scanner.next();
		System.out.println("Enter new-dob");
		String dob=scanner.next();
		Date ddob=DateUtils.dateFromString(dob); //12-03-2020
		System.out.println("Enter new - mobile");
		long mobile=scanner.nextLong();
		System.out.println("Enter new -Salary");
		double salary=scanner.nextDouble();
		System.out.println("Enter new - ssn");
		int  ssn=scanner.nextInt();
		//int pid, String userid, String name, String email, Date dob, long mobile, double salary,
		//int ssn, Timestamp createdate, Timestamp updatedate
		PersonEntity entity=new PersonEntity(0, userid, name, email, ddob, mobile, salary, ssn, null, null);
		System.out.println("update it.............");
		personDao.update(entity);
		System.out.println("Showing data = ");
		personDao.findAll().forEach(System.out::println);
		scanner.close();
	}

}
