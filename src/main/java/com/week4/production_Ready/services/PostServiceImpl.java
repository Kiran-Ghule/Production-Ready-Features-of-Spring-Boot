package com.week4.production_Ready.services;

import com.week4.production_Ready.Exception.ResourceNotFound;
import com.week4.production_Ready.dtos.PostDTO;
import com.week4.production_Ready.entities.PostEntity;
import com.week4.production_Ready.repositories.PostRepo;
import jakarta.persistence.PostRemove;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {


    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {

         return postRepo.findAll()
                 .stream()
                 .map(entity -> modelMapper.map(entity,PostDTO.class))
                 .collect(Collectors.toList());
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        PostEntity post = modelMapper.map(postDTO,PostEntity.class);
        return modelMapper.map( postRepo.save(post),PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long id) {
        return modelMapper.map(postRepo
                    .findById(id)
                    .orElseThrow(()->new ResourceNotFound("Post Not found with id : "+id))
                    ,PostDTO.class);
    }


}
