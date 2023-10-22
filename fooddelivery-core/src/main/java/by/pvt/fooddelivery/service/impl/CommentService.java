package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dto.CommentDTO;
import by.pvt.fooddelivery.mapper.CommentMapper;
import by.pvt.fooddelivery.repository.CommentRepository;
import by.pvt.fooddelivery.service.CommentApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements CommentApi {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public void addComment(CommentDTO commentDTO) {
        commentRepository.addComment(commentMapper.toComment(commentDTO));
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteCommentById(commentId);
    }

    @Override
    public CommentDTO getCommentById(Long commentId) {
        return commentMapper.toDTO(commentRepository.getCommentById(commentId).orElseThrow(
                () -> new RuntimeException("Comment does not exist")));
    }

    @Override
    public List<CommentDTO> getAllComments() {
        return commentRepository.getAllComments().stream().map(commentMapper::toDTO).toList();
    }

    @Override
    public List<CommentDTO> getAllCommentsByUserId(Long userId) {
        return commentRepository.getAllCommentsByUserId(userId).stream().map(commentMapper::toDTO).toList();
    }

    @Override
    public void updateComment(CommentDTO commentDTO) {
        commentRepository.updateComment(commentMapper.toComment(commentDTO));
    }
}
