package com.example.soal1.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProyekLokasiEntity {
    @ManyToOne
    @JoinColumn(name = "proyek_id", nullable = false)
    private ProyekEntity proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id", nullable = false)
    private LokasiEntity lokasi;
}