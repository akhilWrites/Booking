package com.booking.Booking.service;

import com.booking.Booking.Repositories.UserRepository;
import com.booking.Booking.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User edit(User user){
        user.setEmail(user.getEmail());
        return userRepository.save(user);
    }

}
