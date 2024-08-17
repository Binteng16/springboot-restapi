package com.example.soal1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.soal1.entity.ProyekEntity;

public interface ProyekRepository extends JpaRepository<ProyekEntity, Integer> {
}
