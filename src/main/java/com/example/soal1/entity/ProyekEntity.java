package com.example.soal1.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Proyek")
public class ProyekEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama_proyek", nullable = false)
    private String namaProyek;

    @Column(name = "client", nullable = false)
    private String client;

    @Column(name = "tgl_mulai", nullable = false)
    private LocalDateTime tglMulai;

    @Column(name = "tgl_selesai", nullable = false)
    private LocalDateTime tglSelesai;

    @Column(name = "pimpinan_proyek", nullable = false)
    private String pimpinanProyek;

    @Column(name = "keterangan", nullable = false, columnDefinition = "TEXT")
    private String keterangan;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @PrePersist
        public void prePersist() {
            this.createdAt = LocalDateTime.now();
        }
}