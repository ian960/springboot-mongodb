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
    public void delete(String id){
            findById(id);
            repo.deleteById(id);
    }
    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }


    private void updateData(User newObj, User obj) {
            newObj.setName(obj.getName());
            newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
            return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
