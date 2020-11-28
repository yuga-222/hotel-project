package com.example.hotelproject.repository;

import com.example.hotelproject.entity.Photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

}