package com.example.demo.controllers;

import com.example.demo.models.MusicWork;
import com.example.demo.models.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.view.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Miles
 * @create 2022-08-01 10:18 PM
 * @email miles.j.hoo@gmail.com
 **/
@RequestMapping()
@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    public static final Set<Long> tokens = new HashSet<>();

    /**
     *
     * @return
     */
    @PostMapping("/users/login")
    public ResponseEntity<Long> login(@RequestBody Users users){
        List<Users> all = usersRepository.findAll();
        List<Users> collect = all.stream().filter(e -> e.getUserName().equals(users.getUserName()) && e.getUserPassword().equals(users.getUserPassword())).collect(Collectors.toList());
        if (collect.isEmpty()) {
            return new ResponseEntity<Long>().fail("username and password does not exist.");
        }
        long token = System.currentTimeMillis();
        tokens.add(token);
        return new ResponseEntity<Long>().success(token);
    }

    /**
     *
     * @return
     */
    @PostMapping("/users/register")
    public ResponseEntity<Long> register(@RequestBody Users users){
        try {
            usersRepository.save(users);
        } catch (Exception e) {
            return new ResponseEntity<Long>().fail("username exists.");
        }
        return new ResponseEntity<Long>().success(null);
    }

}
