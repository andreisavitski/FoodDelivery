package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    void addComment(Comment comment);

    void deleteCommentById(Long commentId);

    Optional<Comment> getCommentById(Long commentId);

    List<Comment> getAllComments();

    List<Comment> getAllCommentsByUserId(Long userId);

    void updateComment(Comment comment);
}
