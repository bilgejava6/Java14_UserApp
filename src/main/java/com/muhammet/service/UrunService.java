package com.muhammet.service;

import com.muhammet.dto.request.UrunSaveRequestDto;
import com.muhammet.dto.response.UrunGetAllResponseDto;
import com.muhammet.entity.Marka;
import com.muhammet.entity.Model;
import com.muhammet.entity.Urun;
import com.muhammet.repository.UrunRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UrunService {
  private final   UrunRepository repository;
  private final ModelService modelService;
  private final MarkaService markaService;
    public Urun save(UrunSaveRequestDto dto) {
      return repository.save(Urun.builder()
                      .markaId(dto.getMarkaId())
                      .modelId(dto.getModelId())
                      .fiyat(dto.getFiyat())
                      .stok(dto.getStok())
                      .ad(dto.getAd())
              .build());
    }

  public List<UrunGetAllResponseDto> getAll() {
      List<Urun> urunList = repository.findAll();
      List<UrunGetAllResponseDto> result = new ArrayList<>();
      List<Marka> markaList = markaService.findAll();
      List<Model> modelList = modelService.findAll();
    /**
     * Urun listesi DTO olarak geri dönülecek, çünkü ürün içerisinde
     * marka ve model in ID bilgisi tutuluyor.Kullanıcılara bu bilgilerin
     * ad alanları iletilmeli bu nedenle dönüşüm yapıyoruz.
     * DİKKAT!!!!!
     * Eğer tüm datayı tek tek sorgu ile çekersek
     * findById -> isteğin işlem süresi 1ms
     * iki istek -> 2ms.
     * 900 adet ürünün olsun toplam -> 2sn sürer
     * -------------
     * 3 istek yapılır -> 3ms.
     * muhtemelen -> 4-5ms
     */
    urunList.forEach(urun->{
        result.add(UrunGetAllResponseDto.builder()
                        .ad(urun.getAd())
                        .fiyat(urun.getFiyat())
                        .stok(urun.getStok())
                        .marka(markaList.stream().filter(x-> x.getId().equals(urun.getMarkaId())).findFirst().get().getAd())
                        .model(modelList.stream().filter(x-> x.getId().equals(urun.getModelId())).findFirst().get().getAd())
                .build());
      });
      return result;
  }
}
