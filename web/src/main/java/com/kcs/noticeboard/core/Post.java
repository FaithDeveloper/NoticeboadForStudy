package com.kcs.noticeboard.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Post {
    private Integer id;
    private String title;
    private String contents;
}
