package com.example.soal1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soal1.entity.LokasiEntity;
import com.example.soal1.repository.LokasiRepository;

@Service
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    public List<LokasiEntity> findAll(){
        return lokasiRepository.findAll();
    }

    public Optional<LokasiEntity> findById(Integer id){
        return lokasiRepository.findById(id);
    }

    public LokasiEntity saveLokasi(LokasiEntity lokasiEntity) {
        return lokasiRepository.save(lokasiEntity);
    }

    public void deleteLokasi(Integer id) {
        lokasiRepository.deleteById(id);
    }
}
