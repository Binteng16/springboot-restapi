package com.example.soal1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.soal1.entity.ProyekEntity;
import com.example.soal1.service.ProyekService;

@RestController
@RequestMapping("/Proyek")
public class ProyekController {

    @Autowired
    private ProyekService ProyekService;

    @GetMapping
    public List<ProyekEntity> getAllProducts() {
        return ProyekService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyekEntity> getProductById(@PathVariable Integer id) {
        return ProyekService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProyekEntity createProduct(@RequestBody ProyekEntity ProyekEntity) {
        return ProyekService.saveProyek(ProyekEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyekEntity> updateProyek(
            @PathVariable Integer id, @RequestBody ProyekEntity ProyekEntityDetails) {
        return ProyekService.findById(id)
                .map(ProyekEntity -> {
                    ProyekEntity.setNamaProyek(ProyekEntityDetails.getNamaProyek());
                    ProyekEntity.setClient(ProyekEntityDetails.getClient());
                    ProyekEntity.setTglMulai(ProyekEntityDetails.getTglMulai());
                    ProyekEntity.setTglSelesai(ProyekEntityDetails.getTglSelesai());
                    ProyekEntity.setTglSelesai(ProyekEntityDetails.getTglSelesai());
                    ProyekEntity.setPimpinanProyek(ProyekEntityDetails.getPimpinanProyek());
                    ProyekEntity.setKeterangan(ProyekEntityDetails.getKeterangan());
                    ProyekEntity updatedProyek = ProyekService.saveProyek(ProyekEntity);
                    return ResponseEntity.ok(updatedProyek);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProyek(@PathVariable Integer id) {
        return ProyekService.findById(id)
                .map(ProyekEntity -> {
                    ProyekService.deleteProyek(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
