package net.idrok.sadik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.idrok.sadik.entity.Mahsulot;

@Repository
public interface MahsulotRepository extends JpaRepository <Mahsulot, Long> {

    @Query("FROM Mahsulot mah WHERE UPPER(mah.nom) like '%' ||  UPPER(:key) || '%' OR UPPER(mah.mahsulotUlchov) like '%' || UPPER(:key) || '%' OR  UPPER(mah.mahsulotTur) like '%' || UPPER(:key) || '%' ORDER BY id ")
    List<Mahsulot> getAllWithKey(@Param("key") String key);
}
