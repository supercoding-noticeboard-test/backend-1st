package com.github.noticeboard.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LikeBody {

    private Integer commentId;
    private Integer userId;

}
