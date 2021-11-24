/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elcacharrero.cacharrero.app.repository;

import com.elcacharrero.cacharrero.app.model.User;
import com.elcacharrero.cacharrero.app.repository.interfaces.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KUKURU
 */
@Repository
public class UserRepository {
    
  @Autowired
    //metodos que van a llamar las acciones del crud repository
    private UserCrudRepository repository;
  
    /**
     * 
     * @return
     */
    public List<User> getAll(){
        return (List<User>)repository.findAll();
    }
    /**
     * 
     * @param user
     * @return
     */
    public User save(User user){
        return repository.save(user);
    }
    /**
     * 
     * @param name
     * @return 
     */
    public Optional <User> getUserByName(String name){
        return repository.findByName(name);
    }
    /**
     * 
     * @param email
     * @return 
     */
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }
    
    /**
     * 
     * @param name
     * @param email
     * @return 
     */
    public List<User> getUserByNameOrEmail(String name,String email){
        return repository.findByNameOrEmail(name, email);
    }
    
    /**
     * 
     * @param email
     * @param name
     * @return 
     */
    public Optional<User> getUserByEmailAndPassword(String email,String name){
        return repository.findByEmailAndPassword(email, name);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }
}
