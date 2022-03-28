package net.idrok.sadik.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.idrok.sadik.entity.Bola;
import net.idrok.sadik.repository.BolaRepository;


@Service
public class BolaService {
    BolaRepository bolaRepository;
    public BolaService(BolaRepository bolaRepository){
        this.bolaRepository = bolaRepository;
    }

    public List<Bola> getAll(String key){
        return bolaRepository.getAllWithKey(key);        
    }

    public Bola  create(Bola bola){
        if(bola.getId()==null){
            return bolaRepository.save(bola);
        }
        throw new RuntimeException("bola id bo'lmasligi shart");
    }

    public Bola update(Bola bola){
        if(bola.getId()!=null){
            return bolaRepository.save(bola);
        }
        throw new RuntimeException("bolani id si bo'lishi shart");
    }

    public void deleteById(Long id){
        bolaRepository.deleteById(id);
    }
}
