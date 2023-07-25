package com.prueba.doublevpartners.web.controller;

import com.prueba.doublevpartners.domain.models.Ticket;
import com.prueba.doublevpartners.domain.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ticket")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.save(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<Optional<Ticket>> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.findById(id);
        if (ticket != null) {
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<List<Ticket>> getAllTickets(@PathVariable int page) {
        List<Ticket> tickets = ticketService.findAll(page);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<Ticket>> getTicketsByUser(@PathVariable String user) {
        return ticketService.findByUser(user)
                .map(tickets -> new ResponseEntity<>(tickets, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTicket(@PathVariable Long id) {

        if (ticketService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
