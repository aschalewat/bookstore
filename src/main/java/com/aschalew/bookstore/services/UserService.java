package com.aschalew.bookstore.services;

import com.aschalew.bookstore.model.User;

import java.util.List;

public interface UserService {

    //cruds check this branch

   void addUser(User user);

   void updateUser(User user);

   User getUser(Long userId);

   List<User> gerUsers();

   void deleteUser(Long userId);

   User findByUserName(String userName);

}
