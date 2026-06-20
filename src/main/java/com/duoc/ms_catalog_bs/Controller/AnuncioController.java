package com.duoc.ms_catalog_bs.Controller;

import com.duoc.ms_catalog_bs.Model.Dto.AnuncioDto;
import com.duoc.ms_catalog_bs.Service.AnuncioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/bs/productos")

public class AnuncioController {
    @Autowired
    private AnuncioService anuncioService;

    @PostMapping
    public ResponseEntity<?>crearAnuncio(@Valid @RequestBody AnuncioDto dto){
       try{
           AnuncioDto creado = anuncioService.procesarPublicacion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    } catch (IllegalAccessException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error de conexión entre microservicios: " + e.getMessage());
    }
}

@GetMapping
public ResponseEntity<List<AnuncioDto>> listarTodo() {
    return ResponseEntity.ok(anuncioService.obtenerCatalogo());
}
}

