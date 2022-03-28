package net.idrok.sadik.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.idrok.sadik.entity.MahsulotUlchov;
import net.idrok.sadik.repository.MahsulotUlchovRepository;

@Service
public class MahsulotUlchovService {
    
    MahsulotUlchovRepository mahsulotUlchovRepository;
    public MahsulotUlchovService(MahsulotUlchovRepository mahsulotUlchovRepository){
        this.mahsulotUlchovRepository = mahsulotUlchovRepository;
    }

    public List<MahsulotUlchov> getAll(String key){
        return mahsulotUlchovRepository.findAllByNomContainingIgnoreCaseOrderById(key);
    }

    public MahsulotUlchov create(MahsulotUlchov mahsulotUlchov){
        if(mahsulotUlchov.getId() == null){
            return mahsulotUlchovRepository.save(mahsulotUlchov);
        }
        throw new RuntimeException("id bo'lmasligi kerak");
    }

    public MahsulotUlchov update(MahsulotUlchov mahsulotUlchov){
        if(mahsulotUlchov.getId() != null){
            return mahsulotUlchovRepository.save(mahsulotUlchov);
        }
        throw new RuntimeException("id bo'lishi kerak");
    }

    public void deleteById(Long id){
        mahsulotUlchovRepository.deleteById(id);
    }

}
