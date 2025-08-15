package com.example.demo.repository;

import com.example.demo.model.PersonalInfo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
	List<PersonalInfo> findByNameContaining(String name);
}

