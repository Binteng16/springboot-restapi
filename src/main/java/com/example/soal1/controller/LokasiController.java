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

import com.example.soal1.entity.LokasiEntity;
import com.example.soal1.service.LokasiService;

@RestController
@RequestMapping("/Lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @GetMapping
    public List<LokasiEntity> getAllProducts() {
        return lokasiService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LokasiEntity> getProductById(@PathVariable Integer id) {
        return lokasiService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public LokasiEntity createProduct(@RequestBody LokasiEntity lokasiEntity) {
        return lokasiService.saveLokasi(lokasiEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LokasiEntity> updateLokasi(
            @PathVariable Integer id, @RequestBody LokasiEntity lokasiEntityDetails) {
        return lokasiService.findById(id)
                .map(lokasiEntity -> {
                    // Memperbarui entitas dengan detail baru
                    lokasiEntity.setNamaLokasi(lokasiEntityDetails.getNamaLokasi());
                    LokasiEntity updatedLokasi = lokasiService.saveLokasi(lokasiEntity);
                    return ResponseEntity.ok(updatedLokasi);
                })
                .orElse(ResponseEntity.notFound().build()); // Mengembalikan 404 jika entitas tidak ditemukan
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLokasi(@PathVariable Integer id) {
        return lokasiService.findById(id)
                .map(lokasiEntity -> {
                    lokasiService.deleteLokasi(id);
                    return ResponseEntity.noContent().build(); // 204 No Content
                })
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

}
