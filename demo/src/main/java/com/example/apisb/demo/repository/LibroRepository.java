package com.example.apisb.demo.repository;

import com.example.apisb.demo.model.Libro;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
