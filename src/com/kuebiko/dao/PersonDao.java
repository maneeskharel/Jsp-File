package com.kuebiko.dao;

import java.util.List;

import com.kuebiko.dao.entity.PersonEntity;

public interface PersonDao {
	String save(PersonEntity entity);
	List<PersonEntity> findAll();
	PersonEntity findById(int pid);
	int deleteById(int pid);
	List<PersonEntity> highestSal();
	 String update(PersonEntity entity);
	PersonEntity findByUserid(String userid);


}
