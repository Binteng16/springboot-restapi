package com.example.soal1.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.soal1.entity.ProyekEntity;
import com.example.soal1.repository.ProyekRepository;
import java.util.List;
import java.util.Optional;
public class ProyekService {
    @Autowired
    private ProyekRepository proyekRepository;

    public List<ProyekEntity> findAll(){
        return proyekRepository.findAll();
    }

    public Optional<ProyekEntity> findById(Integer id){
        return proyekRepository.findById(id);
    }

    public void saveProyek(ProyekEntity proyekEntity) {
        proyekRepository.save(proyekEntity);
    }

    public void deleteProyek(Integer id) {
        proyekRepository.deleteById(id);
    }
}
