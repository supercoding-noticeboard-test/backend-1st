package com.github.noticeboard.service;

import com.github.noticeboard.repository.comment.CommentEntity;
import com.github.noticeboard.repository.comment.CommentRepository;
import com.github.noticeboard.repository.user.UserEntity;
import com.github.noticeboard.repository.user.UserRepository;
import com.github.noticeboard.service.mapper.CommentMapper;
import com.github.noticeboard.web.dto.comment.CommentBody;
import com.github.noticeboard.web.dto.comment.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Transactional("tmJpa1")
    public String createComment(CommentBody commentBody) {
        LocalDateTime date = LocalDateTime.now();
        UserEntity user = userRepository.findByEmail(commentBody.getAuthor());

        CommentEntity commentEntity = CommentMapper.INSTANCE.commentBodytoCommentEntity(commentBody, user.getUserId());
        commentEntity.setCreatedAt(date);
        commentRepository.save(commentEntity);
        return "댓글이 성공적으로 작성되었습니다.";
    }

    @Transactional("tmJpa1")
    public String updateComment(Integer commentId, CommentBody commentBody) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(commentId);
        if (commentEntity.isPresent()) {
            commentEntity.get().setContent(commentBody.getContent());
            commentRepository.save(commentEntity.get());
            return "댓글이 성공적으로 수정되었습니다.";
        } else {
            throw new NoSuchElementException();
        }
    }

    public List<CommentResponse> getCommentsAll() {
        List<CommentEntity> foundCommentAll = commentRepository.findAll();
        return foundCommentAll.stream()
                .map((Object comment) -> CommentResponse.from((CommentEntity) comment, userRepository.findById(((CommentEntity) comment).getUserId())))
                .toList();
    }
}
