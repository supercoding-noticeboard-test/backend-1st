package com.github.noticeboard.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Like {

    private Integer commentId;
    private Integer userId;

}
