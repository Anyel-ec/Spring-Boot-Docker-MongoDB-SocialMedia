package top.anyel.rrss.repository;

import org.springframework.stereotype.Repository;
import top.anyel.rrss.model.Comment;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentRepository {
    List<Comment> comments = new ArrayList<>();

    public Comment addComment(Comment comment) {
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


}
