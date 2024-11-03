package com.github.noticeboard.web.dto.like;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LikeBody {

    private Integer commentId;
    private Integer userId;

}
