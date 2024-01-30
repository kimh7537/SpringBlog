package com.kimlog.api.controller;

import com.kimlog.api.request.PostCreate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PostController {

    //SSR -> JPS, thymeleaf, mustache, freemarker
    //SPQ ->
    //     vue -> vue + SSR = nuxt
    //     react -> react + SSR = next

    @PostMapping("/posts")
    public Map<String, String> get(@RequestBody @Valid PostCreate params){

        return Map.of();
    }


}
