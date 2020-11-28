package com.example.hotelproject.repository;

import java.util.List;

import com.example.hotelproject.entity.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
        List<Hotel> findByNameContaining(String name);
    }