package net.idrok.sadik.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.idrok.sadik.entity.Xodim;
import net.idrok.sadik.repository.XodimRepository;

@Service
public class XodimService {

    XodimRepository xodimRepository;
    public XodimService(XodimRepository xodimRepository){
        this.xodimRepository = xodimRepository;
    }

    public List<Xodim> getAll(String key){
        return xodimRepository.getAllWithKey(key);
    }

    public Xodim create(Xodim xodim){
        if(xodim.getId() == null){
            return xodimRepository.save(xodim);
        }
        throw new RuntimeException("id bo'lmasligi kerak");
    }


    public Xodim update(Xodim xodim){
        if(xodim.getId() != null){
            return xodimRepository.save(xodim);
        }
        throw new RuntimeException("id bo'lishi shart");
    }

    public void deleteById(Long id){
        xodimRepository.deleteById(id);
    }

    
}
