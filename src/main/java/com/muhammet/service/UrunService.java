package com.muhammet.service;

import com.muhammet.dto.request.UrunSaveRequestDto;
import com.muhammet.entity.Urun;
import com.muhammet.repository.UrunRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrunService {
  private final   UrunRepository repository;

    public Urun save(UrunSaveRequestDto dto) {
      return repository.save(Urun.builder()
                      .markaId(dto.getMarkaId())
                      .modelId(dto.getModelId())
                      .fiyat(dto.getFiyat())
                      .stok(dto.getStok())
              .build());
    }

  public List<Urun> getAll() {
      return repository.findAll();
  }
}
