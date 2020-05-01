package com.kuebiko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kuebiko.dao.entity.PersonEntity;
import com.kuebiko.utils.SQLConnectionUtil;
import com.kuebiko.utils.SQLQuery;

public class PersonDaoImpl  implements PersonDao {

	@Override
	public String save(PersonEntity entity) {
		int rowcount = 0;
		//Try with resource - Java7 features
		try (Connection conn = SQLConnectionUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(SQLQuery.INSERT_INTO_PERSON);) {
			System.out.println(entity);
			pstmt.setString(1, entity.getUserid());
			pstmt.setString(2, entity.getName());
			pstmt.setString(3, entity.getEmail());
			pstmt.setDate(4, new java.sql.Date(entity.getDob().getTime()));
			pstmt.setLong(5, entity.getMobile());
			pstmt.setDouble(6, entity.getSalary());
			pstmt.setInt(7, entity.getSsn());
			pstmt.setTimestamp(8, new Timestamp(new Date().getTime()));
			pstmt.setTimestamp(9, new Timestamp(new Date().getTime()));
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount > 0 ? "success" : "no rows updated";
	}

	@Override
	public PersonEntity findById(int pid) {
		PersonEntity personEntity = null;
		try (Connection conn = SQLConnectionUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(SQLQuery.SELECT_PERSON_BY_ID)) {
			pstmt.setInt(1, pid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				personEntity = new PersonEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getLong(6), rs.getDouble(7), rs.getInt(8), rs.getTimestamp(9), rs.getTimestamp(10));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personEntity;
	}

	@Override
	public List<PersonEntity> findAll() {
		List<PersonEntity> personEntities = new ArrayList<PersonEntity>();
		try (Connection conn = SQLConnectionUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(SQLQuery.SELECT_ALL_PERSON);) {
			ResultSet rs = pstmt.executeQuery();
			//select  pid,userid,name,email,dob,mobile,salary,ssn,createdate,updatedate
			while (rs.next()) {
				PersonEntity personEntity = new PersonEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getLong(6), rs.getDouble(7), rs.getInt(8), rs.getTimestamp(9), rs.getTimestamp(10));
				personEntities.add(personEntity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personEntities;
	}

	@Override
	public int deleteById(int pid) {
		int rowcount = 0;
		try (Connection conn = SQLConnectionUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(SQLQuery.DELETE_PERSON_BY_ID)) {
			pstmt.setInt(1, pid);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}

	@Override
	public String update(PersonEntity entity) {
		int rowcount = 0;
		// Try with resource - Java7 features
		try (Connection conn = SQLConnectionUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(SQLQuery.UPDATE_PERSON);) {

			PersonEntity dbpersonEntity = findByUserid(entity.getUserid());

			boolean status=false;

			if (entity.getUserid() != null) {
				dbpersonEntity.setUserid(entity.getUserid());
			}else {
				return "user id not present!";
			}

			if (entity.getDob() != null) {
				dbpersonEntity.setDob(entity.getDob());
				status=true;
			}
			if (entity.getEmail() != null) {
				dbpersonEntity.setEmail(entity.getEmail());
				status=true;
			}
			if (entity.getMobile() != 0) {
				dbpersonEntity.setMobile(entity.getMobile());
				status=true;
			}
			if (entity.getName() != null) {
				dbpersonEntity.setName(entity.getName());
				status=true;
			}

			if (entity.getSalary() != 0) {
				dbpersonEntity.setSalary(entity.getSalary());
				status=true;
			}

			if (entity.getSsn() != 0) {
				dbpersonEntity.setSsn(entity.getSsn());
				status=true;
			}

			if (entity.getUpdatedate() != null) {
				status=true;
				dbpersonEntity.setUpdatedate(entity.getUpdatedate());
			}


			//	// String UPDATE_PERSON="update persons_tbl set name = ?, email =? , dob = ? ,
			// mobile = ? , salary =? , ssn =? , updatedate =? where userid = ?";
			System.out.println(dbpersonEntity);
			if(status) {
				pstmt.setString(1, dbpersonEntity.getName());
				pstmt.setString(2, dbpersonEntity.getEmail());
				pstmt.setDate(3, new java.sql.Date(entity.getDob().getTime()));
				pstmt.setLong(4, dbpersonEntity.getMobile());
				pstmt.setDouble(5, dbpersonEntity.getSalary());
				pstmt.setInt(6, dbpersonEntity.getSsn());
				pstmt.setTimestamp(7, new Timestamp(new Date().getTime()));
				pstmt.setString(8, dbpersonEntity.getUserid());
				rowcount = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount > 0 ? "success" : "no rows updated";
	}

	@Override
	public PersonEntity findByUserid(String userid) {
		PersonEntity personEntity = null;
		try (Connection conn = SQLConnectionUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(SQLQuery.SELECT_PERSON_BY_PERSON_ID)) {
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				personEntity = new PersonEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getLong(6), rs.getDouble(7), rs.getInt(8), rs.getTimestamp(9),
						rs.getTimestamp(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personEntity;
	}



	@Override
	public List<PersonEntity> highestSal() {
		List<PersonEntity> personEntities = new ArrayList<PersonEntity>();
		try (Connection conn = SQLConnectionUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(SQLQuery.HIGHEST_PERSON_BY_ID);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PersonEntity personEntity = new PersonEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getLong(6), rs.getDouble(7), rs.getInt(8), rs.getTimestamp(9), rs.getTimestamp(10));
				personEntities.add(personEntity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personEntities;
	}



}







