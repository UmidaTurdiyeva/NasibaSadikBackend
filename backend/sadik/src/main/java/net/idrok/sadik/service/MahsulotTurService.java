package net.idrok.sadik.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.idrok.sadik.entity.MahsulotTur;
import net.idrok.sadik.repository.MahsulotTurRepository;

@Service
public class MahsulotTurService {

    MahsulotTurRepository mahsulotTurRepository;
    public MahsulotTurService(MahsulotTurRepository mahsulotTurRepository){
        this.mahsulotTurRepository = mahsulotTurRepository;
    }

    public List<MahsulotTur> getAll(String key){
        return mahsulotTurRepository.findAllByNomContainingIgnoreCaseOrderById(key);
    }

    public MahsulotTur create(MahsulotTur mahsulotTur){
        if(mahsulotTur.getId() == null){
            return mahsulotTurRepository.save(mahsulotTur);
        }
        throw new RuntimeException("id bo'lmasligi kerak");
    }

    public MahsulotTur update(MahsulotTur mahsulotTur){
        if(mahsulotTur.getId() != null){
            return mahsulotTurRepository.save(mahsulotTur);
        }
        throw new RuntimeException("id bo'lishi shart");
    }

    public void deleteById(Long id){
        mahsulotTurRepository.deleteById(id);
    }
    
}
