package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.domain.Comment;
import by.pvt.fooddelivery.repository.CommentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepositoryHibernate extends RepositoryCRUD implements CommentRepository {
    private final SessionFactory sessionFactory;

    public CommentRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addComment(Comment comment) {
        add(comment);
    }

    @Override
    public void deleteCommentById(Long commentId) {
        deleteById(Comment.class, commentId);
    }

    @Override
    public Optional<Comment> getCommentById(Long commentId) {
        return getById(Comment.class, commentId);
    }

    @Override
    public List<Comment> getAllComments() {
        return getAll(Comment.class);
    }

    @Override
    public List<Comment> getAllCommentsByUserId(Long userID) {
        Session session = sessionFactory.openSession();
        String allCommentsByUserId = "select c from Comment c where c.user.id =:id ";
        Query query = session.createQuery(allCommentsByUserId);
        List<Comment> comments = query.getResultList();
        session.close();
        return comments;
    }

    @Override
    public void updateComment(Comment comment) {
        update(comment);
    }
}
