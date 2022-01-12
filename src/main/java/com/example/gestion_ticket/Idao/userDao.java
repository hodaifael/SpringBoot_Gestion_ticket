package com.example.gestion_ticket.Idao;

import com.example.gestion_ticket.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userDao extends JpaRepository<User,Long> {

    User findByLoginAndPassword(String nom, String password);
}
