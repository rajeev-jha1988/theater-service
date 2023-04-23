package com.booking.theaterservice.repository;

import com.booking.theaterservice.entity.Auditorium;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Long> {

    List<Auditorium> findByTheatre_Id(Long id);
}
