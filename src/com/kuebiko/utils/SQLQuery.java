package com.kuebiko.utils;

public interface SQLQuery {
	
	String INSERT_INTO_PERSON="insert into persons_tbl(userid,name,email,dob,mobile,salary,ssn,createdate,updatedate) values(?,?,?,?,?,?,?,?,?)";
	String SELECT_ALL_PERSON="select  pid,userid,name,email,dob,mobile,salary,ssn,createdate,updatedate from persons_tbl";
	String SELECT_PERSON_BY_ID="select  pid,userid,name,email,dob,mobile,salary,ssn,createdate,updatedate from persons_tbl where pid  = ?";
	String SELECT_PERSON_BY_PERSON_ID="select  pid,userid,name,email,dob,mobile,salary,ssn,createdate,updatedate from persons_tbl where userid  = ?";
	String DELETE_PERSON_BY_ID="delete from persons_tbl where pid  = ?";
	String UPDATE_PERSON="update  persons_tbl set name = ?, email =? , dob = ?  , mobile = ? , salary =? , ssn =? , updatedate =?  where userid = ?";
	String HIGHEST_PERSON_BY_ID = "Select * from persons_tbl where salary = (select MAX(salary) from persons_tbl)";



}
