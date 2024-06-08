package com.kimlog.api.service;

import com.kimlog.api.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostService {

    public void write(PostCreate postCreate){
        //repository.save(postCreate)
    }
}
