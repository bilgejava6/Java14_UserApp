package com.muhammet.service;

import com.muhammet.entity.Model;
import com.muhammet.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ModelService {
    private final ModelRepository repository;

    public Model save(String ad, Long markaId) {
        return repository.save(Model.builder()
                        .ad(ad)
                        .markaId(markaId)
                .build());
    }

    public List<Model> getAllByMarkaId(Long markaId) {
        return repository.findAllByMarkaId(markaId);
    }
}
