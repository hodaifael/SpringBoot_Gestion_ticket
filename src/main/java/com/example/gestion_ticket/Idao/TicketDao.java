package com.example.gestion_ticket.Idao;

import com.example.gestion_ticket.beans.Ticket;
import com.example.gestion_ticket.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketDao extends JpaRepository<Ticket,Long> {
    @Modifying
    @Query("Update Ticket u set u.admin.id=:d1 where u.id=:d2")
    void updateAdminId(@Param("d1")Long id1,@Param("d2") Long id2);

    List<Ticket> findAllByUserId(Long id);
}
