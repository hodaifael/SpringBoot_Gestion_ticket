package com.example.gestion_ticket.mapping;

import com.example.gestion_ticket.beans.Message;
import com.example.gestion_ticket.beans.Ticket;
import com.example.gestion_ticket.services.MessageServices;
import com.example.gestion_ticket.services.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/ticket")
public class TicketMapping {

    private final TicketServices ticketServices;
    @Autowired
    public TicketMapping(TicketServices ticketServices){
        this.ticketServices=ticketServices;
    }


    @GetMapping("/")
    public ResponseEntity<List<Ticket>> getAllTickets () {
        List<Ticket> Ticket = ticketServices.findAllTickets();
        return new ResponseEntity<>(Ticket, HttpStatus.OK);
    }
    @GetMapping("/byuser/{id}")
    public ResponseEntity<List<Ticket>> getAllTicketsByuserid (@PathVariable("id") Long id) {
        List<Ticket> Ticket = ticketServices.findAllTicketsById(id);
        return new ResponseEntity<>(Ticket, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById (@PathVariable("id") Long id) {
        Optional<Ticket> Ticket = ticketServices.findTicketById(id);
        return new ResponseEntity(Ticket, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket Ticket) {
        Ticket newTicket = ticketServices.addTicket(Ticket);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }

    @PutMapping("/{id1}/{id2}")
    public ResponseEntity<Ticket> updateAdminId(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2) {
        ticketServices.updateAdminId(id1,id2);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket Ticket) {
        Ticket uTicket = ticketServices.updateTickets(Ticket);
        return new ResponseEntity<>(uTicket, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id) {
        ticketServices.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


