package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Comment;
import by.pvt.fooddelivery.dto.CommentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment toComment(CommentDTO commentDTO);

    CommentDTO toDTO(Comment comment);
}
