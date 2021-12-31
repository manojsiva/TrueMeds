package com.src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.src.model.Input;

@Repository
public interface InputRepository extends JpaRepository<Input, Integer> {

}
