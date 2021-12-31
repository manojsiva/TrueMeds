package com.src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.src.model.Output;

@Repository
public interface OutputRepository extends JpaRepository<Output, Integer>{

}
