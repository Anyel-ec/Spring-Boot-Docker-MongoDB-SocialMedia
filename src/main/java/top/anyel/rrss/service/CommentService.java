package top.anyel.rrss.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import top.anyel.rrss.model.Comment;
import top.anyel.rrss.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {
    CommentRepository commentRepository = new CommentRepository();

    public int countCommentsByPostId(Long postId) {
        return commentRepository.countCommentsByPostId(postId);
    }

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

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.getCommentsByPostId(postId);
    }

    public  Comment addReplyToComment(Long commentId, Comment reply) {
        return commentRepository.addReplyToComment(commentId, reply);
    }



    public Comment updateComment(Long id, Comment updatedComment) {
        Comment existingComment = commentRepository.getCommentById(id);
        if (existingComment != null) {
            return commentRepository.updateComment(id, updatedComment);
        }
        return null; // Manejo de error si el comentario no existe
    }




    public void deleteComment(Long id) {
        commentRepository.deleteComment(id);
    }





}
