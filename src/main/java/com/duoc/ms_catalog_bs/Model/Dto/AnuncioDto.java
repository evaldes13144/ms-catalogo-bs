package com.duoc.ms_catalog_bs.Model.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AnuncioDto {
    private Long id;

    @NotNull(message = "El ID de la prestadora (chicaId) es obligatorio")
    private Long chicaId;

    @NotBlank(message = "El título del anuncio no puede estar vacío")
    private String tituloAnuncio;

    @NotBlank(message = "La descripción de los servicios es obligatoria")
    private String descripcion;

    @NotNull(message = "La tarifa es obligatoria")
    @Positive(message = "La tarifa debe ser mayor a cero")
    private BigDecimal tarifaHora;

    @NotBlank(message = "La ubicación o ciudad es obligatoria")
    private String ubicacionCiudad;

    private String estado;
}