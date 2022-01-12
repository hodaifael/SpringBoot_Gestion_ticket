package com.example.gestion_ticket.mapping;

import com.example.gestion_ticket.beans.User;
import com.example.gestion_ticket.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/user")
public class userMapping {


    private final userService userService;
    @Autowired
    public userMapping(userService userService){
        this.userService=userService;
    }


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.findAllusers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login (@RequestBody User user) {
        User User = userService.findByLoginAndPassword(user);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
        Optional<User> user = userService.finduserById(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping(value = "/"/*,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newuser = userService.adduser(user);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatevoiture = userService.updateuser(user);
        return new ResponseEntity<>(updatevoiture, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteuser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

