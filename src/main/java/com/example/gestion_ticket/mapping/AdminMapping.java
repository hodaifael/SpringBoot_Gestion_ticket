package com.example.gestion_ticket.mapping;

import com.example.gestion_ticket.beans.Admin;
import com.example.gestion_ticket.beans.User;
import com.example.gestion_ticket.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/Admin")
public class AdminMapping {


    private final AdminServices adminServices;
    @Autowired
    public AdminMapping(AdminServices adminServices){
        this.adminServices=adminServices;
    }


    @GetMapping("/")
    public ResponseEntity<List<Admin>> getAllAdmins () {
        List<Admin> Admins = adminServices.findAllAdmins();
        return new ResponseEntity<>(Admins, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<Admin> login (@RequestBody Admin admin) {
        Admin admin1 = adminServices.findByLoginAndPassword(admin);
        return new ResponseEntity<>(admin1, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById (@PathVariable("id") Long id) {
        Optional<Admin> Admin = adminServices.findAdminById(id);
        return new ResponseEntity(Admin, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin Admin) {
        Admin newAdmin = adminServices.addAdmin(Admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin Admin) {
        Admin uAdmin = adminServices.updateAdmin(Admin);
        return new ResponseEntity<>(uAdmin, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable("id") Long id) {
        adminServices.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
