package com.kcs.noticeboard.core.dto;

import com.kcs.noticeboard.core.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PostRegisterResult {
    private Integer id;

    public static PostRegisterResult of(Post post){
        final PostRegisterResult result = new PostRegisterResult();
                result.id = post.getId();
                return result;
    }
}
