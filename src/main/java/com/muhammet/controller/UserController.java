package com.muhammet.controller;

import com.muhammet.dto.request.UserSaveRequestDto;
import com.muhammet.entity.User;
import com.muhammet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<User> save(@RequestBody UserSaveRequestDto dto){
        return ResponseEntity.ok(userService.save(dto));
    }

    @PostMapping("/update-user")
    public ResponseEntity<User> update(@RequestBody UserSaveRequestDto dto){
        return ResponseEntity.ok(userService.update(dto));
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<Void> delete(Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
}
