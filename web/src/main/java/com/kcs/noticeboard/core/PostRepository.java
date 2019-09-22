package com.kcs.noticeboard.core;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();

    Post register(Post post);
}
