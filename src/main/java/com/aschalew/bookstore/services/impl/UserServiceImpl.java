package com.aschalew.bookstore.services.impl;

import com.aschalew.bookstore.model.User;
import com.aschalew.bookstore.repository.UserRepository;
import com.aschalew.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void addUser(User user) {
        if (user != null){
            userRepository.save(user);
        }
    }

    @Override
    public void updateUser(User user) {
        if (userRepository.existsById(user.getUserId())){
            userRepository.save(user);
        }
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.findById(userId).get();
        if (user != null){
            return user;
        }
        return null;
    }

    @Override
    public List<User> gerUsers() {
        return (List)userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).get();
        if (user != null){
            userRepository.delete(user);
        }
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
