package com.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.demo.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query(name="select l from login_details l where l.username=?1 and l.password =?2")
	public Users checkValidUser(String userName,String password);

	
}
