package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Comment;
import by.pvt.fooddelivery.repository.CommentRepository;
import by.pvt.fooddelivery.service.CommentApi;

import java.util.List;

public class CommentService implements CommentApi {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteCommentById(commentId);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.getCommentById(commentId).orElseThrow(
                () -> new RuntimeException("Comment does not exist"));
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.getAllComments();
    }

    @Override
    public List<Comment> getAllCommentsByUserId(Long userId) {
        return commentRepository.getAllCommentsByUserId(userId);
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepository.updateComment(comment);
    }
}
