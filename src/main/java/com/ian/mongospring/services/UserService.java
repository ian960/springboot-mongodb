package com.ian.mongospring.services;

import com.ian.mongospring.domain.User;
import com.ian.mongospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

        @Autowired
        private UserRepository repo;

        public List<User> findAll(){
            return repo.findAll();
        }
}
