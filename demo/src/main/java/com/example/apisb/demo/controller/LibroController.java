package com.example.apisb.demo.controller;

import com.example.apisb.demo.model.Libro;
import com.example.apisb.demo.service.LibroService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> obtenerTodos() {
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        Libro libro = libroService.BuscaLibroporId(id);
        if (libro != null) {
            return ResponseEntity.ok(libro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Libro guardar(@RequestBody Libro libro) {
        return libroService.GuardarLibro(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        Libro libroActualizado = libroService.ActualizarLibro(id, libro);
        if (libroActualizado != null) {
            return ResponseEntity.ok(libroActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        libroService.EliminarLibro(id);
        return ResponseEntity.noContent().build();
    }
}
