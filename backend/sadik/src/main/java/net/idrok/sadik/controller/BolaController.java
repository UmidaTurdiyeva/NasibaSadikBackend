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

import net.idrok.sadik.entity.Bola;
import net.idrok.sadik.service.BolaService;

@RestController
@RequestMapping("/api/bola")
@CrossOrigin(value = "*", maxAge = 3600)
public class BolaController {

    BolaService bolaService;

    public BolaController(BolaService bolaService) {
        this.bolaService = bolaService;
    }

    @GetMapping
    public ResponseEntity<List<Bola>> getAll(@RequestParam(value = "key", required = false) String key) {
        if (key == null)
            key = "";
        return ResponseEntity.ok(bolaService.getAll(key));
    }

    @PostMapping
    public ResponseEntity<Bola> create(@RequestBody Bola bola) {
        try {
            Bola b = bolaService.create(bola);
            return ResponseEntity.created(URI.create("/api/bola/" + b.getId())).body(b);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public Bola update(@RequestBody Bola bola) {
        return bolaService.update(bola);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try{
        bolaService.deleteById(id);
        return ResponseEntity.noContent().build();
        }catch(Exception ex){
        return ResponseEntity.notFound().header("error", "Bunday id li bola topilmadi").build();
       }
    }

}
