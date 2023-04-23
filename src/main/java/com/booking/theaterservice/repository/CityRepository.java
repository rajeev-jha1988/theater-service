package com.example.theaterservice.repository;

import com.example.theaterservice.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

}
