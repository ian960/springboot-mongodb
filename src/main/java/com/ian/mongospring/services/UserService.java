package com.ian.mongospring.services;

import com.ian.mongospring.domain.User;
import com.ian.mongospring.dto.UserDTO;
import com.ian.mongospring.repository.UserRepository;
import com.ian.mongospring.services.exception.ObjectNotFoundException;
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

    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
            return repo.insert(obj);
    }
    public User fromDTO(UserDTO objDto){
            return new User(objDto.getId(), objDto.getName(), objDto.getEmail());


    }

}
