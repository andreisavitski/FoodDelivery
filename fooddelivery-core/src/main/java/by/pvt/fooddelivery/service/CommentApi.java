package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.CommentDTO;

import java.util.List;

public interface CommentApi {
    void addComment(CommentDTO commentDTO);

    void deleteCommentById(Long commentId);

    CommentDTO getCommentById(Long commentId);

    List<CommentDTO> getAllComments();

    List<CommentDTO> getAllCommentsByUserId(Long userId);

    void updateComment(CommentDTO commentDTO);
}
