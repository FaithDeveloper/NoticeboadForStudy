package com.kcs.noticeboard.ui.rest;

import com.kcs.noticeboard.core.Post;
import com.kcs.noticeboard.core.PostService;
import com.kcs.noticeboard.core.dto.PostRegisterCommand;
import com.kcs.noticeboard.core.dto.PostRegisterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService service;

    /*public PostController() {
        this.service = new PostService();
    }*/

    // GET
    // {url}/post?all 로 호출
    @GetMapping
    public List<PostRegisterResult> all(){
        return service.findAll();
    }

    // POST
    // {url}/post?register 로 호출, 값은 json 으로 보낸다.
    @PostMapping
    public PostRegisterResult register(final @RequestBody PostRegisterCommand command){
        return service.register(command);
    }
}