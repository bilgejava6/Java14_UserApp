package com.muhammet.service;

import com.muhammet.dto.request.UserSaveRequestDto;
import com.muhammet.entity.User;
import com.muhammet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User save(UserSaveRequestDto dto){
        repository.save(User.builder()
                        .ad(dto.getAd())
                        .soyad(dto.getSoyad())
                        .adres(dto.getAdres())
                        .yas(dto.getYas())
                .build());
        return null;
    }

    public User update(UserSaveRequestDto dto){
        repository.save(User.builder()
                .id(dto.getId())
                .ad(dto.getAd())
                .soyad(dto.getSoyad())
                .adres(dto.getAdres())
                .yas(dto.getYas())
                .build());
        return null;
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public List<User> getAll(){
        return repository.findAll();
    }

}
