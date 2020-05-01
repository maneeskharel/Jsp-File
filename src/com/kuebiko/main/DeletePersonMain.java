package com.kuebiko.main;

import java.util.Scanner;

import com.kuebiko.dao.PersonDao;
import com.kuebiko.dao.PersonDaoImpl;

public class DeletePersonMain {
	public static void main(String[] args) {
		PersonDao personDao=new PersonDaoImpl();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter id");
		int pid = scanner.nextInt();
		scanner.close();
	    personDao.deleteById(pid);
	    System.out.println("Showing data after deletion:  ");
		 personDao.findAll().forEach(System.out::println);
}

}
