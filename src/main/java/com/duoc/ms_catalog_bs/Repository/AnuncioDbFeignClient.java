package com.duoc.ms_catalog_bs.Repository;

import com.duoc.ms_catalog_bs.Model.Dto.AnuncioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@FeignClient(name= "ms-catalogo-db",url= "http://localhost:8082")
public interface AnuncioDbFeignClient {
    @PostMapping("/db/catalog")
    AnuncioDto guardarEnDb(@RequestBody AnuncioDto dto);

    @GetMapping("/db/catalog")
    List<AnuncioDto> listarTodoDeDb();
}

