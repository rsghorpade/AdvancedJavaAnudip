package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Hotel; 


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
