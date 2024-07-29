package top.anyel.rrss.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.rrss.collections.Comment;
import top.anyel.rrss.collections.CommentResponse;
import top.anyel.rrss.repository.CommentRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(String id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment addComment(Comment comment) {
        if (comment.getResponses() != null) {
            comment.getResponses().forEach(reply -> {
                if (reply.getId() == null) {
                    reply.setId(UUID.randomUUID().toString());
                }
            });
        }
        return commentRepository.save(comment);
    }

    public Comment updateComment(String id, Comment updatedComment) {
        updatedComment.setId(id);
        return commentRepository.save(updatedComment);
    }

    public Comment updateCommentByPostId(Long postId, String id, Comment updatedComment) {
        Comment existingComment = commentRepository.findByPostIdAndId(postId, id);
        if (existingComment != null) {
            updatedComment.setId(existingComment.getId());
            return commentRepository.save(updatedComment);
        }
        return null;
    }

    public void deleteComment(String id) {
        commentRepository.deleteById(id);
    }

    public int countCommentsByPostId(Long postId) {
        return commentRepository.countCommentsByPostId(postId);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.getCommentsByPostId(postId);
    }

    public Comment addResponseToComment(String commentId, CommentResponse response) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment != null) {
            response.setId(UUID.randomUUID().toString());
            comment.getResponses().add(response);
            return commentRepository.save(comment);
        }
        return null;
    }

    public void deleteCommentsByPostId(Long postId) {
        commentRepository.deleteCommentsByPostId(postId);
    }


    public Comment updateResponse(String commentId, String responseId, CommentResponse updatedResponse) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment != null) {
            List<CommentResponse> responses = comment.getResponses();
            for (int i = 0; i < responses.size(); i++) {
                if (responses.get(i).getId().equals(responseId)) {
                    updatedResponse.setId(responseId);
                    responses.set(i, updatedResponse);
                    return commentRepository.save(comment);
                }
            }
        }
        return null;
    }

    public Comment deleteResponse(String commentId, String responseId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment != null) {
            List<CommentResponse> responses = comment.getResponses();
            responses.removeIf(response -> response.getId().equals(responseId));
            return commentRepository.save(comment);
        }
        return null;
    }


}
