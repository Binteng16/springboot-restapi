package com.example.soal1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.soal1.entity.LokasiEntity;
import com.example.soal1.repository.LokasiRepository;

public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    public List<LokasiEntity> findAll(){
        return lokasiRepository.findAll();
    }

    public Optional<LokasiEntity> findByid(Integer id){
        return lokasiRepository.findById(id);
    }

    public void saveLokasi(LokasiEntity lokasiEntity) {
        lokasiRepository.save(lokasiEntity);
    }

    public void deleteLokasi(Integer id) {
        lokasiRepository.deleteById(id);
    }
}
