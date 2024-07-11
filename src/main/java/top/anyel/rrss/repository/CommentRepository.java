package top.anyel.rrss.repository;

import org.springframework.boot.web.server.Cookie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import top.anyel.rrss.collections.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Long> {

    int countCommentsByPostId(Long postId);

    List<Comment> getCommentsByPostId(Long postId);
}