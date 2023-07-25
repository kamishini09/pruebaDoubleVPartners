package com.prueba.doublevpartners.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Ticket {
    private final Long idTicket;
    private final String id_Usuario;
    private final LocalDate fecha_Creacion;
    private final LocalDate fecha_Actualizacion;
    private final Boolean estatus;

    //mapeo

    public Ticket(Long idTicket, String id_Usuario, LocalDate fecha_Creacion, LocalDate fecha_Actualizacion, Boolean estatus) {
        this.idTicket = idTicket;
        this.id_Usuario = id_Usuario;
        this.fecha_Creacion = fecha_Creacion;
        this.fecha_Actualizacion = fecha_Actualizacion;
        this.estatus = estatus;
    }
}
