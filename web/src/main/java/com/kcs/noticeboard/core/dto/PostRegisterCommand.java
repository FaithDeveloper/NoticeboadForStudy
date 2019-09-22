package com.kcs.noticeboard.core.dto;

// ToString 필드들을 json 형태로 만들어 준다.
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PostRegisterCommand {
    private String title;
    private String contents;
}
