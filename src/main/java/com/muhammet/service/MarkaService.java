package com.muhammet.service;

import com.muhammet.entity.Marka;
import com.muhammet.repository.MarkaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MarkaService {
    private final MarkaRepository repository;

    public Marka save(String ad) {
        return repository.save(Marka.builder()
                        .ad(ad)
                .build());
    }

    public List<Marka> getAll() {
        return repository.findAll();
    }
}
