package com.example.soal1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.soal1.entity.LokasiEntity;

public interface LokasiRepository extends JpaRepository<LokasiEntity, Integer> {
}
