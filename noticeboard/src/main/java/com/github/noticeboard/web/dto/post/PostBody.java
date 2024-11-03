package com.github.noticeboard.web.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostBody {

    private String title;
    private String content;
    private String author;

}
