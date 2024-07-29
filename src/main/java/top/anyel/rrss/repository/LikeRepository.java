package top.anyel.rrss.repository;

import org.springframework.stereotype.Repository;
import top.anyel.rrss.collections.Like;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface LikeRepository extends MongoRepository<Like, String> {

    List<Like> findByPostId(Long postId);

    long countByPostIdAndLiked(Long postId, boolean liked);

    Like findByPostIdAndUserId(Long postId, Long userId);

    void deleteByPostId(Long postId);  
}