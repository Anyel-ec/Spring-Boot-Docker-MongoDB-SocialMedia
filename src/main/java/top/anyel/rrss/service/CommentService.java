package top.anyel.rrss.service;

import org.springframework.stereotype.Service;
import top.anyel.rrss.model.Comment;
import top.anyel.rrss.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {
    CommentRepository commentRepository = new CommentRepository();

    public Comment addComment(Comment comment) {
        return commentRepository.addComment(comment);
    }

    public Comment getCommentById(Long id) {
        return commentRepository.getCommentById(id);
    }
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment updateById(Long id, Comment comment) {
        return commentRepository.updateById(id, comment);
    }

    public String deleteCommentById(Long id) {
        return commentRepository.deleteCommentById(id);
    }





}
