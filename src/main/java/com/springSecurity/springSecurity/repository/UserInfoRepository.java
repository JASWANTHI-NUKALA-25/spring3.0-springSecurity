package com.springSecurity.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springSecurity.springSecurity.model.UserData;

@Repository
public interface UserInfoRepository extends JpaRepository<UserData, Integer> {
	
	Optional<UserData> findByName(String username);

}
