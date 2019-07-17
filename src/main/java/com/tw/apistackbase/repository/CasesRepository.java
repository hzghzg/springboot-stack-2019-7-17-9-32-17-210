package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LawCases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CasesRepository extends JpaRepository<LawCases,Long> {

}
