/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elcacharrero.cacharrero.app.service;

import com.elcacharrero.cacharrero.app.model.User;
import com.elcacharrero.cacharrero.app.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUKURU
 */
@Service
public class UserService {
    
    @Autowired
     private UserRepository repository;
    
    /**
     * 
     * @return
     */
    public List<User>getAll(){
        return repository.getAll();
    }
    
    /**
     * 
     * @param user
     * @return
     */
    public User save(User user){
        if(user.getName()==null || user.getEmail()==null || user.getPassword()==null){
            return user;
        }else{
            List<User> existUser = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
            if(existUser.isEmpty()){
                if(user.getId()==null){
                    return repository.save(user);
                }else{
                    Optional<User> existUser2 = repository.getUserById(user.getId());
                    if(existUser2.isEmpty()){
                        return repository.save(user);
                    }else{
                        return user;
                    }
                }
            }else{
                return user;
            }
        }
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public User getByEmailPass(String email, String password){
        Optional<User> userExist = repository.getUserByEmailAndPassword(email, password);
        if(userExist.isPresent()){
            return userExist.get();
        }else{
            return new User(null,email,password,"NO DEFINIDO");
        }
    }
}
