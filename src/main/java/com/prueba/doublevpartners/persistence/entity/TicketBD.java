package com.prueba.doublevpartners.persistence.entity;

import com.prueba.doublevpartners.domain.models.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="TBL_TICKET")
public class TicketBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false)
    private LocalDate fechaActualizacion;

    @Column(nullable = false)
    private Boolean estado;

    public TicketBD() {
    }
    public TicketBD(Long id, String usuario, LocalDate fechaCreacion, LocalDate fechaActualizacion, Boolean estado) {
        this.id = id;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.estado = estado;
    }


    public static TicketBD TicketToTicketBD(Ticket ticket){
        return new TicketBD(
                ticket.getIdTicket() ,
                ticket.getId_Usuario(),
                ticket.getFecha_Creacion(),
                ticket.getFecha_Actualizacion(),
                ticket.getEstatus()
        );
    }


    public Ticket toTicket(){
        return new Ticket(id,usuario,fechaCreacion ,fechaActualizacion ,estado);

    }


}
