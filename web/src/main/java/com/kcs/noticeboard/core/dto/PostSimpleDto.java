package com.kcs.noticeboard.core.dto;

import com.kcs.noticeboard.core.Post;
import lombok.Getter;

@Getter
public class PostSimpleDto {
    private Integer id;

    private String title;

    private String contents;

    public static PostSimpleDto of(final Post post){
        final PostSimpleDto dto = new PostSimpleDto();
        dto.id = post.getId();
        dto.title = post.getTitle();
        dto.contents = post.getContents();

        return dto;
    }
}
