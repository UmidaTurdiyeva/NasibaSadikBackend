package net.idrok.sadik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.idrok.sadik.entity.Xodim;

@Repository
public interface XodimRepository extends JpaRepository <Xodim, Long> {

    @Query("FROM  Xodim WHERE UPPER(xodim.ism) like '%' || UPPER(:key) || '%' OR UPPER(xodim.familiya) like '%' || UPPER(:key) || '%' OR UPPER(xodim.sharif) like '%' || UPPER(:key) || '%' ORFER BY xodim.id ")
    List <Xodim> getAllWithKey(@Param("key") String key);
    
}
