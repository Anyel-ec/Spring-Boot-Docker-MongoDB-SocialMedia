package top.anyel.rrss.repository;

import org.springframework.stereotype.Repository;
import top.anyel.rrss.model.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {
    List<Comment> comments = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1); // Inicialización con 1

    public Comment addComment(Comment comment) {
        comment.setId(idGenerator.getAndIncrement());
        comments.add(comment);
        return comment;
    }

    public List<Comment> findAll() {
        return comments;
    }

    public Comment getCommentById(Long id) {
        for (Comment comment : comments) {
            if (comment.getId().equals(id)) {
                return comment;
            }
        }
        return null;
    }
    // contar cuantos comentarios tiene un post
    public int countCommentsByPostId(Long postId) {
        int count = 0;
        for (Comment comment : comments) {
            if (comment.getPostId().equals(postId)) {
                count++;
            }
        }
        return count;
    }

    public Comment updateById(Long id, Comment comment) {
        for (Comment c : comments) {
            if (c.getId().equals(id)) {
                c.setContent(comment.getContent());
                return c;
            }
        }
        return null;
    }

    public String deleteCommentById(Long id) {
        for (Comment comment : comments) {
            if (comment.getId().equals(id)) {
                comments.remove(comment);
                return "Comment deleted";
            }
        }
        return "Comment not found";
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return comments.stream()
                .filter(comment -> comment.getPostId().equals(postId))
                .collect(Collectors.toList());
    }

    // Nuevo método para agregar un subcomentario
    public Comment addReplyToComment(Long commentId, Comment reply) {
        Comment parentComment = getCommentById(commentId);
        if (parentComment != null) {
            if (parentComment.getComments() == null) {
                parentComment.setComments(new ArrayList<>()); // Asegura que la lista no sea null
            }
            reply.setId(idGenerator.getAndIncrement());
            parentComment.getComments().add(reply);
            return reply;
        }
        return null;
    }

    public Comment updateComment(Long id, Comment updatedComment) {
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId().equals(id)) {
                comments.set(i, updatedComment);
                return updatedComment;
            }
        }
        return null; // Si no se encuentra el comentario
    }

    public void deleteComment(Long id) {
        comments.removeIf(comment -> comment.getId().equals(id));
    }







}
