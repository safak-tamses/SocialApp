package com.example.webapp.Services;

import com.example.webapp.Entities.User;
import com.example.webapp.Repository.UserRepository;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public void updateUserById(Long id, User user) throws Exception {
        Optional<User> tempUser=userRepository.findById(id);
        if (tempUser.isPresent()){
            User u = tempUser.get();
            u.setUserName(user.getUserName());
            u.setPassword(user.getPassword());
        }
        else throw new Exception("User not Found");
    }
    public void deleteUserById(Long id) throws Exception {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }else throw new Exception("User not Found");

    }
    public void saveUser(User user){
        userRepository.save(user);
    }
}
