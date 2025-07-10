package com.ian.mongospring.services;

import com.ian.mongospring.domain.Post;
import com.ian.mongospring.domain.User;
import com.ian.mongospring.dto.UserDTO;
import com.ian.mongospring.repository.PostRepository;
import com.ian.mongospring.repository.UserRepository;
import com.ian.mongospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

        @Autowired
        private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
