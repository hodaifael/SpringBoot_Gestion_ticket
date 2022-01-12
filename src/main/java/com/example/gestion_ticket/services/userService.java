package com.example.gestion_ticket.services;


import com.example.gestion_ticket.Idao.userDao;
import com.example.gestion_ticket.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class userService {
    private final userDao userIdao;
    @Autowired
    public userService(userDao userIdao){
        this.userIdao=userIdao;
    }
    public User findByLoginAndPassword(User user){
        return userIdao.findByLoginAndPassword(user.getLogin(),user.getPassword());
    }
    public User adduser(User user) {
        return userIdao.save(user);
    }
    public List<User> findAllusers(){
        return userIdao.findAll();
    }
    public User updateuser(User user){
        return userIdao.save(user);
    }
    public Optional<User> finduserById (long id){
        return userIdao.findById(id);
    }
    public void deleteuser(long id){
        userIdao.deleteById(id);
    }

}
