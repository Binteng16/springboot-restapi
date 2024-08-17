package com.example.soal1.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProyekLokasi {
    @ManyToOne
    @JoinColumn(name = "proyek_id", nullable = false)
    private Proyek proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id", nullable = false)
    private Lokasi lokasi;
}
