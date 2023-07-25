package com.prueba.doublevpartners.domain.service;

import com.prueba.doublevpartners.domain.models.Ticket;
import com.prueba.doublevpartners.domain.repository.TaskTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TicketService {

    @Autowired
    private TaskTicketRepository taskTicketRepository;


    public Ticket save(Ticket ticket){
        return taskTicketRepository.save(ticket);
    };

    public Optional<Ticket> findById(Long id){
        return taskTicketRepository.findById(id);
    };

    public List<Ticket> findAll(int page){
        return taskTicketRepository.findAll(page);
    };

    public Optional<List<Ticket>> findByUser(String user){
        return taskTicketRepository.findByUser(user);
    };

    public Boolean delete(Long id){
        return findById(id).map(ticket -> {
            taskTicketRepository.delete(id);
            return true;
        }).orElse(false);

    };
}
