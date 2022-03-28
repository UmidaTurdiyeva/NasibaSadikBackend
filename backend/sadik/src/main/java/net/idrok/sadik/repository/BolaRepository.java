package net.idrok.sadik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.idrok.sadik.entity.Bola;

@Repository
public interface BolaRepository extends JpaRepository <Bola, Long> {
    
    @Query("FORM Bola WHERE UPPER(bola.ism) like '%' || UPPER (:key) || '%' OR UPPER(bola.familiya) like '%' || UPPER(:key) || '%' OR UPPER(bola.sharif) like '%' || UPPER(:key) || '%' ORDER BY bola.id ")
    List<Bola> getAllWithKey(@Param("key") String key);

}
