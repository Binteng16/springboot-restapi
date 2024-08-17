package com.example.soal1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.soal1.entity.ProyekLokasiEntity;
import com.example.soal1.repository.ProyekLokasiRepository;
public class ProyekLokasiService {
    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    public List<ProyekLokasiEntity> findAll(){
        return proyekLokasiRepository.findAll();
    }

    public Optional<ProyekLokasiEntity> findById(Integer id){
        return proyekLokasiRepository.findById(id);
    }

    public void saveProyekLokasi(ProyekLokasiEntity proyekLokasiEntity){
        proyekLokasiRepository.save(proyekLokasiEntity);
    }

    public void deleteProyekLokasi(ProyekLokasiEntity proyekLokasiEntity){
        proyekLokasiRepository.delete(proyekLokasiEntity);
    }
}
