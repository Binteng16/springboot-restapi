package com.example.soal1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "proyek_lokasi")
@Entity
public class ProyekLokasiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "proyek_id", nullable = false)
    private ProyekEntity proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id", nullable = false)
    private LokasiEntity lokasi;
}