package com.week4.production_Ready.services;

import com.week4.production_Ready.dtos.PostDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createPost(PostDTO postDTO);

    PostDTO getPostById( Long id);

}
