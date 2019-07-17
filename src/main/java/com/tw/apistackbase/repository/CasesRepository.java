package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LawCases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasesRepository extends JpaRepository<LawCases,Long> {
}
