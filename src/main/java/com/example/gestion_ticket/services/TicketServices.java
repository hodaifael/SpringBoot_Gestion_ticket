package com.example.gestion_ticket.services;


import com.example.gestion_ticket.Idao.MessageDao;
import com.example.gestion_ticket.Idao.TicketDao;
import com.example.gestion_ticket.beans.Message;
import com.example.gestion_ticket.beans.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TicketServices {
    private final TicketDao ticketDao;
    @Autowired
    public TicketServices(TicketDao ticketDao){
        this.ticketDao=ticketDao;
    }

    public Ticket addTicket(Ticket Ticket) {

        return ticketDao.save(Ticket);
    }
    public List<Ticket> findAllTickets(){
        return ticketDao.findAll();
    }

    public List<Ticket> findAllTicketsById(Long id){
        return ticketDao.findAllByUserId(id);
    }

    public Ticket updateTickets(Ticket Ticket){
        return ticketDao.save(Ticket);
    }
    public void updateAdminId(Long id1,Long id2){
        ticketDao.updateAdminId(id1,id2);
    }
    public Optional<Ticket> findTicketById (long id){
        return ticketDao.findById(id);
    }
    public void deleteTicket(long id){
        ticketDao.deleteById(id);
    }

}

