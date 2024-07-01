package com.muhammet.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UrunGetAllResponseDto {
    String marka;
    String model;
    String ad;
    Double fiyat;
    Integer stok;
}
