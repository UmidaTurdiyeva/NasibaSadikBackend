package net.idrok.sadik.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.idrok.sadik.entity.Mahsulot;
import net.idrok.sadik.repository.MahsulotRepository;

@Service
public class MahsulotService {

    MahsulotRepository mahsulotRepository;
    public  MahsulotService(MahsulotRepository mahsulotRepository){
        this.mahsulotRepository = mahsulotRepository;
    }

    public List<Mahsulot> getAll(String key){
        return mahsulotRepository.getAllWithKey(key);
    }

    public Mahsulot create( Mahsulot mahsulot){
        if(mahsulot.getId() == null){
            return mahsulotRepository.save(mahsulot);
        }
        throw new RuntimeException ("id bo'lmasligi kerak");
    }
   
    public Mahsulot update( Mahsulot mahsulot){
        if(mahsulot.getId() != null){
            return mahsulotRepository.save(mahsulot);
        }
        throw new RuntimeException ("id bo'lishi kerak");
    }

    public void deleteById(Long id){
        mahsulotRepository.deleteById(id);
    }
    
}
