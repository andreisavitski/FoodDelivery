package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.Comment;

import java.util.List;

public interface CommentApi {
    void addComment(Comment comment);

    void deleteCommentById(Long commentId);

    Comment getCommentById(Long commentId);

    List<Comment> getAllComments();

    List<Comment> getAllCommentsByUserId(Long userId);

    void updateComment(Comment comment);
}
