package com.github.noticeboard.web.dto.post;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class PostUpdateBody {

    private String title;
    private String content;

}
