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

import net.idrok.sadik.entity.MahsulotUlchov;
import net.idrok.sadik.service.MahsulotUlchovService;

@RestController
@RequestMapping("/api/MahsulotUlchov")
@CrossOrigin(maxAge = 3600)
public class MahsulotUlchovController {
    
    MahsulotUlchovService mahsulotUlchovService;

    public MahsulotUlchovController(MahsulotUlchovService mahsulotUlchovService){
        this.mahsulotUlchovService = mahsulotUlchovService;
    }

    @GetMapping
    public ResponseEntity<List<MahsulotUlchov>> getAll(@RequestParam(value = "key", required = false) String key){
        if(key == null) key = "";
        return ResponseEntity.ok(mahsulotUlchovService.getAll(key));
    }

    @PostMapping
    public ResponseEntity<MahsulotUlchov> create(@RequestBody MahsulotUlchov mahsulotUlchov){
        try{
            MahsulotUlchov mt = mahsulotUlchovService.create(mahsulotUlchov);
            return ResponseEntity.created(URI.create("/api/MahsulotUlchov" + mt.getId())).body(mt);
        } catch( Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public MahsulotUlchov update(@RequestBody MahsulotUlchov mahsulotUlchov){
        return mahsulotUlchovService.update(mahsulotUlchov);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try{
            mahsulotUlchovService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            return ResponseEntity.notFound().header("error", " id si topilmadi").build();
        }
    }



}
