package com.example.theaterservice.repository;

import com.example.theaterservice.entity.Auditorium;
import com.example.theaterservice.entity.Theatre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Long> {

    List<Auditorium> findByTheatre_Id(Long id);
}
