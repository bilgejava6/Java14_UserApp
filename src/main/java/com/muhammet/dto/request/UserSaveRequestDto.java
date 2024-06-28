package com.muhammet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSaveRequestDto {
    Long id;
    String ad;
    String soyad;
    String adres;
    Integer yas;
}
