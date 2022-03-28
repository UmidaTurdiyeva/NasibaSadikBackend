package net.idrok.sadik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.sadik.entity.MahsulotTur;

@Repository
public interface MahsulotTurRepository extends JpaRepository <MahsulotTur, Long>{
    List<MahsulotTur> findAllByNomContainingIgnoreCaseOrderById(String key);
}
