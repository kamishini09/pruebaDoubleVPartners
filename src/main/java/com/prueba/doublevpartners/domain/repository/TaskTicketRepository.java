package com.prueba.doublevpartners.domain.repository;

import com.prueba.doublevpartners.domain.models.Ticket;

import java.util.List;
import java.util.Optional;

public interface TaskTicketRepository {
    Ticket save(Ticket ticket);

    Optional<Ticket> findById(Long id);

    List<Ticket> findAll(int page);

    Optional<List<Ticket>> findByUser(String user);

    void delete(Long id);
}
