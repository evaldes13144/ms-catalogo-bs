package com.duoc.ms_catalog_bs.Service;

import com.duoc.ms_catalog_bs.Repository.ClienteBsFeignClient;
import com.duoc.ms_catalog_bs.Repository.AnuncioDbFeignClient;
import com.duoc.ms_catalog_bs.Model.Dto.AnuncioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service

public class AnuncioService {

    @Autowired
    private AnuncioDbFeignClient dbClient;

    @Autowired
    private ClienteBsFeignClient clienteClient;

    public static AnuncioDto procesarPublicacion(AnuncioDto dto) throws IllegalAccessException {
        log.info("[SERVICE-BS] Solicitando validación horizontal de usuario al MS de clientes...");

        // 1. Usamos tu cliente de la primera imagen para verificar con tu compañero
        boolean esChicaValida = clienteClient.verificarSiEsChicaValida(dto.getChicaId());

        if (!esChicaValida) {
            log.error("[SERVICE-BS] El ID de usuario provisto no es una acompañante activa.");
            throw new IllegalAccessException("El usuario no está registrado como proveedora autorizada.");
        }

        // 2. Aplicamos la regla de negocio
        dto.setEstado("DISPONIBLE");

        // 3. Usamos tu cliente de la segunda imagen para mandarlo a guardar a tu BD (8082)
        log.info("[SERVICE-BS] Todo OK. Enviando anuncio a guardar en la persistencia...");
        return dbClient.guardarEnDb(dto);
    }

    public List<AnuncioDto> obtenerCatalogo() {
        log.info("[SERVICE-BS] Solicitando listado general a la base de datos.");
        return dbClient.listarTodoDeDb();
    }
}