package com.muhammet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblurun")
@NamedQuery(name = "joinMarkaAndModel", query = "select u.ad, u.fiyat, u.stok, m.ad as markaAdi, mo.ad as modelAdi from Urun u left join Marka m on m.id=u.markaId left join Model mo on mo.id=u.modelId")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long markaId;
    Long modelId;
    String ad;
    Double fiyat;
    Integer stok;
}
