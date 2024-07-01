package com.muhammet.controller;

import com.muhammet.dto.request.UrunSaveRequestDto;
import com.muhammet.entity.Marka;
import com.muhammet.entity.Model;
import com.muhammet.entity.Urun;
import com.muhammet.service.MarkaService;
import com.muhammet.service.ModelService;
import com.muhammet.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/urun")
public class UrunController {
    private final MarkaService markaService;
    private final ModelService modelService;
    private final UrunService urunService;

    @PostMapping("/urun-save")
    @CrossOrigin("*")
    public ResponseEntity<Urun> urunSave(@RequestBody UrunSaveRequestDto dto){
        return ResponseEntity.ok(urunService.save(dto));
    }

    @GetMapping("/get-all")
    @CrossOrigin("*")
    public ResponseEntity<List<Urun>> getAll(){
        return ResponseEntity.ok(urunService.getAll());
    }

    @PostMapping("marka-save")
    @CrossOrigin("*")
    public ResponseEntity<Marka> markaSave(String ad){
        return ResponseEntity.ok(markaService.save(ad));
    }

    @PostMapping("model-save")
    @CrossOrigin("*")
    public ResponseEntity<Model> modelSave(String ad,Long markaId){
        return ResponseEntity.ok(modelService.save(ad,markaId));
    }

    @GetMapping("/get-all-marka")
    @CrossOrigin("*")
    public ResponseEntity<List<Marka>> getAllMarka(){
        return ResponseEntity.ok(markaService.getAll());
    }
    @GetMapping("/get-all-by-marka-id")
    @CrossOrigin("*")
    public ResponseEntity<List<Model>> getAllByMarkaId(Long markaId){
        return ResponseEntity.ok(modelService.getAllByMarkaId(markaId));
    }
}
