package com.github.noticeboard.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Like {

    private Integer commentId;
    private Integer userId;

}
