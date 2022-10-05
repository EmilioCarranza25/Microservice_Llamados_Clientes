package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Long> {
//	List<Register> findByPublished(boolean estado);
//	List<Register> findByTitleContaining(String firsName);
}
