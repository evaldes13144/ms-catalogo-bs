package com.duoc.ms_catalog_bs.Repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Se conecta al puerto 8181 (El microservicio Business Service de Clientes de tu compañero)
@FeignClient(name = "ms-clientes-bs", url = "http://localhost:8181")
public interface ClienteBsFeignClient {

    // Llama al endpoint de tu compañero para comprobar si la chica es real antes de dejarla publicar
    @GetMapping("/bs/clientes/validar-chica/{id}")
    boolean verificarSiEsChicaValida(@PathVariable("id") Long id);
}
