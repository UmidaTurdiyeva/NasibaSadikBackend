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

import net.idrok.sadik.entity.Xodim;
import net.idrok.sadik.service.XodimService;

@RestController
@RequestMapping("/api/bola")
@CrossOrigin(maxAge = 3600)

public class XodimController {

    XodimService xodimService;
    public XodimController(XodimService xodimService){
        this.xodimService = xodimService;
    }

    @GetMapping
    public ResponseEntity<List<Xodim>> getAll(@RequestParam(value = "key", required = false) String key){
        if(key == null) key = "";
        return ResponseEntity.ok(xodimService.getAll(key));
    }

    @PostMapping
    public ResponseEntity<Xodim> create(@RequestBody Xodim xodim){
        try{
            Xodim x = xodimService.create(xodim);
            return ResponseEntity.created(URI.create("/api/xodim/" + x.getId())).body(x);
        }catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public Xodim update(@RequestBody Xodim xodim){
        return xodimService.update(xodim);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try{
            xodimService.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch(Exception ex){
            return ResponseEntity.notFound().header("error", "bunday xodim topilmadi").build();
        }
    }

    
}
