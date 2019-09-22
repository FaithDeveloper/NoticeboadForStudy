package com.kcs.noticeboard.core.impl;

import com.kcs.noticeboard.core.Post;
import com.kcs.noticeboard.core.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


// interface PostRepository 을 구현한 클래스.
@Repository
public class MemoryPostRepository implements PostRepository {
    private Map<Integer, Post> data = new ConcurrentHashMap<>();

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Post register(final Post post) {
        data.put(post.getId(), post);
        return data.get(post.getId());
    }


}
