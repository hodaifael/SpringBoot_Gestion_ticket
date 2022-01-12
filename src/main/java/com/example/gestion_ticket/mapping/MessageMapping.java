package com.example.gestion_ticket.mapping;

import com.example.gestion_ticket.beans.Message;
import com.example.gestion_ticket.services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/message")
public class MessageMapping {

    private final MessageServices messageServices;
    @Autowired
    public MessageMapping(MessageServices messageServices){
        this.messageServices=messageServices;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessagesByTicket () {
        List<Message> Messages = messageServices.findAllMessagesByTicket();
        return new ResponseEntity<>(Messages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById (@PathVariable("id") Long id) {
        Optional<Message> Message = messageServices.findMessageById(id);
        return new ResponseEntity(Message, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Message> addMessage(@RequestBody Message Message) {
        Message newMessage = messageServices.addMessage(Message);
        return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Message> updateMessage(@RequestBody Message Message) {
        Message uMessage = messageServices.updateMessage(Message);
        return new ResponseEntity<>(uMessage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable("id") Long id) {
        messageServices.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

