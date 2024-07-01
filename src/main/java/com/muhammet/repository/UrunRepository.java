package com.muhammet.repository;

import com.muhammet.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrunRepository extends JpaRepository<Urun,Long> {
}
