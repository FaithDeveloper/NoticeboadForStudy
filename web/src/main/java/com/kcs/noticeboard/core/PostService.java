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
    // DI 로 자동으로 생성
    @Autowired
    private PostRepository repository;

    // 자동으로 증가해준다. (쓰레드로 동작 시 유니크한 숫자를 배분할 수 있다.)
    private AtomicInteger lastId = new AtomicInteger(0);

    // GET API 호출로 저장된 데이터를 가져온다.
    public List<PostRegisterResult> findAll(){
        final List<Post> posts = repository.findAll();
        final List<PostRegisterResult> results = new ArrayList<>(posts.size());
        for(final Post post: posts){
            results.add(PostRegisterResult.of(post));
        }
        return results;
    }

    // POST API 파라미터로 들어오는 값을 활용하여 비즈니스 로직을 구성한다.
    @GetMapping
    public PostRegisterResult register(final PostRegisterCommand command){
        Post post = new Post();

        // 숫자를 1 증가 시켜 ID에 저장한다.
        post.setId(lastId.incrementAndGet());
        post.setTitle(command.getTitle());
        post.setContents(command.getContents());

        // 저장 요청 시 저장된 다음 값을 사용한다.
        final Post stored = repository.register(post);

        // response 값을 보낸다.
        return PostRegisterResult.of(stored);
    }
}
