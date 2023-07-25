package com.prueba.doublevpartners.persistence;

import com.prueba.doublevpartners.domain.models.Ticket;
import com.prueba.doublevpartners.domain.repository.TaskTicketRepository;
import com.prueba.doublevpartners.persistence.crud.TicketCrudReepository;
import com.prueba.doublevpartners.persistence.entity.TicketBD;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TicketRepository implements TaskTicketRepository {

    private final TicketCrudReepository ticketCrudReepository;

    public TicketRepository(TicketCrudReepository ticketCrudReepository) {
        this.ticketCrudReepository = ticketCrudReepository;
    }


    @Override
    public Ticket save(Ticket ticket) {
        TicketBD ticketBD =TicketBD.TicketToTicketBD(ticket);
        TicketBD ticketBDSave= ticketCrudReepository.save(ticketBD);
        return ticketBDSave.toTicket();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return ticketCrudReepository.findById(id).map(
                ticketBD -> ticketBD.toTicket());
    }

    @Override
    public List<Ticket> findAll(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<TicketBD> allTicketBD = (Page<TicketBD>) ticketCrudReepository.findAll(pageable);
        List<Ticket> allTicket = allTicketBD.stream()
                .map(TicketBD::toTicket)
                .collect(Collectors.toList());
        return allTicket;
    }



    @Override
    public Optional<List<Ticket>> findByUser(String user) {
        List<TicketBD> ticketBDList = ticketCrudReepository.findByUsuario(user);
        List<Ticket> ticketList = ticketBDList.stream()
                .map(TicketBD::toTicket)
                .collect(Collectors.toList());
        return Optional.of(ticketList);
    }

    @Override
    public void delete(Long id) {
        ticketCrudReepository.deleteById(id);
    }
}
