package com.example.gestion_ticket.Idao;

import com.example.gestion_ticket.beans.Admin;
import com.example.gestion_ticket.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Long> {
    Admin findByLoginAndPassword(String nom, String password);
}
