package net.idrok.sadik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.sadik.entity.MahsulotUlchov;

@Repository
public interface MahsulotUlchovRepository extends JpaRepository <MahsulotUlchov, Long> {
    List<MahsulotUlchov> findAllByNomContainingIgnoreCaseOrderById(String key);
}
