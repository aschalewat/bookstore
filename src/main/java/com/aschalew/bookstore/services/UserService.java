package com.aschalew.bookstore.services;

import com.aschalew.bookstore.domain.User;
import com.aschalew.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    //cruds

   void addUser(User user);

   void updateUser(User user);

   User getUser(Long userId);

   List<User> gerUsers();

   void deleteUser(Long userId);

   User findByUserName(String userName);

}
