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

import net.idrok.sadik.entity.Mahsulot;
import net.idrok.sadik.service.MahsulotService;

@RestController
@RequestMapping("/api/mahsulot")
@CrossOrigin
public class MahsulotController {
   
    MahsulotService mahsulotService;
    public MahsulotController(MahsulotService mahsulotService){
        this.mahsulotService = mahsulotService;
    }

    @GetMapping
    public ResponseEntity <List<Mahsulot>> getAll(@RequestParam (value = "key", required = false) String key){
        if(key == null) key = "";
        return ResponseEntity.ok(mahsulotService.getAll(key));
    }

    @PostMapping
    public ResponseEntity<Mahsulot> create(@RequestBody Mahsulot mahsulot){
        try{
            Mahsulot m = mahsulotService.create(mahsulot);
            return ResponseEntity.created(URI.create("/api/mahsulot" + m.getId())).body(m);
        }catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public Mahsulot update(@RequestBody Mahsulot mahsulot){
        return mahsulotService.update(mahsulot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try{
            mahsulotService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            return ResponseEntity.notFound().header("error", "bunaqasi yo'q").build();
        }
    }

}
