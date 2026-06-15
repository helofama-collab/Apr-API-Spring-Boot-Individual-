package com.example.apisb.demo.service;

import com.example.apisb.demo.repository.LibroRepository;
import org.springframework.stereotype.Service;
import com.example.apisb.demo.model.Libro;
import java.util.List;


@Service
public class LibroService {


    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }



    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }
    
    public Libro BuscaLibroporId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro GuardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro ActualizarLibro(Long id, Libro libro) {
        if (libroRepository.existsById(id)) {
            libro.setId(id);
            return libroRepository.save(libro);
        } else {
            return null;
        }
    }

    public void EliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

}
