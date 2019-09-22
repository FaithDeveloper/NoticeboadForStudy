package com.kcs.noticeboard.core;

import com.kcs.noticeboard.core.dto.PostRegisterCommand;
import com.kcs.noticeboard.core.dto.PostRegisterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MVC
 *
 * controller <->service
 *
 * 로직부분
 */
@Service
public class PostService {
    @Autowired
    private PostRepository repository;
    private AtomicInteger lastId = new AtomicInteger(0);

    public List<PostRegisterResult> findAll(){
        final List<Post> posts = repository.findAll();
        final List<PostRegisterResult> results = new ArrayList<>(posts.size());
        for(final Post post: posts){
            results.add(PostRegisterResult.of(post));
        }
        return results;
    }

    @GetMapping
    public PostRegisterResult register(final PostRegisterCommand command){
        Post post = new Post();

        post.setId(lastId.incrementAndGet());
        post.setTitle(command.getTitle());
        post.setContents(command.getContents());

        // 저장 요청 시 저장된 다음 값을 사용한다.
        final Post stored = repository.register(post);

        return PostRegisterResult.of(post);
    }
}
