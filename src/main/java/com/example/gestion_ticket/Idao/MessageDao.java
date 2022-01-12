package com.example.gestion_ticket.Idao;

import com.example.gestion_ticket.beans.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageDao extends JpaRepository<Message,Long> {


}
