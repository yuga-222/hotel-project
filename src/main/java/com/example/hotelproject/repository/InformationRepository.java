package com.example.hotelproject.repository;

import java.util.List;

import com.example.hotelproject.entity.Information;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {
     List<Information> findByHotelId(Long hotel_id);
}