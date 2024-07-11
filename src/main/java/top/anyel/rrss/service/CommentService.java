package top.anyel.rrss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.rrss.collections.Comment;
import top.anyel.rrss.collections.CommentResponse;
import top.anyel.rrss.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment updatedComment) {
        updatedComment.setId(id);
        return commentRepository.save(updatedComment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public int countCommentsByPostId(Long postId) {
        return commentRepository.countCommentsByPostId(postId);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.getCommentsByPostId(postId);
    }

    public Comment addResponseToComment(Long commentId, CommentResponse response) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment != null) {
            response.setCommentId(commentId);
            comment.getResponses().add(response);
            commentRepository.save(comment);
            return comment;
        }
        return null; // O manejar el caso en que el comentario no exista
    }


}
