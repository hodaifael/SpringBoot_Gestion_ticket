package com.example.gestion_ticket.services;

import com.example.gestion_ticket.Idao.AdminDao;
import com.example.gestion_ticket.beans.Admin;
import com.example.gestion_ticket.beans.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServices {
    private final AdminDao adminDao;

    public AdminServices(AdminDao adminDao){
        this.adminDao=adminDao;
    }
    public Admin findByLoginAndPassword(Admin admin){
            return adminDao.findByLoginAndPassword(admin.getLogin(),admin.getPassword());
    }
    public Admin addAdmin(Admin admin) {

        return adminDao.save(admin);
    }
    public List findAllAdmins(){
        return adminDao.findAll();
    }
    public Admin updateAdmin (Admin admin){
        return adminDao.save(admin);
    }
    public Optional<Admin> findAdminById (long id){
        return adminDao.findById(id);
    }
    public void deleteAdmin(long id){
        adminDao.deleteById(id);
    }

}
