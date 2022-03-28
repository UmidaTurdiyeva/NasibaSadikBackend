package net.idrok.sadik.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.idrok.sadik.entity.MahsulotTur;
import net.idrok.sadik.service.MahsulotTurService;

@RestController
@RequestMapping("/api/mahsulotTur")
@CrossOrigin(maxAge = 3600)
public class MahsulotTurController {
    
    MahsulotTurService mahsulotTurService;

    public MahsulotTurController(MahsulotTurService mahsulotTurService){
        this.mahsulotTurService = mahsulotTurService;
    }

    @GetMapping
    public ResponseEntity<List<MahsulotTur>> getAll(@RequestParam(value = "key", required = false) String key){
        if(key == null) key = "";
        return ResponseEntity.ok(mahsulotTurService.getAll(key));
    }

    @PostMapping
    public ResponseEntity<MahsulotTur> create(@RequestBody MahsulotTur mahsulotTur){
        try{
            MahsulotTur mt = mahsulotTurService.create(mahsulotTur);
            return ResponseEntity.created(URI.create("/api/mahsulotTur" + mt.getId())).body(mt);
        } catch( Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public MahsulotTur update(@RequestBody MahsulotTur mahsulotTur){
        return mahsulotTurService.update(mahsulotTur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try{
            mahsulotTurService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            return ResponseEntity.notFound().header("error", " id si topilmadi").build();
        }
    }



}
