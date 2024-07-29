package top.anyel.rrss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.rrss.repository.LikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.rrss.collections.Like;
import top.anyel.rrss.repository.LikeRepository;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public List<Like> getLikesByPostId(Long postId) {
        return likeRepository.findByPostId(postId);
    }

    public long countLikesByPostId(Long postId) {
        return likeRepository.countByPostIdAndLiked(postId, true);
    }

    public Like addOrUpdateLike(Long postId, Long userId, boolean liked) {
        Like existingLike = likeRepository.findByPostIdAndUserId(postId, userId);
        if (existingLike != null) {
            existingLike.setLiked(liked);
            return likeRepository.save(existingLike);
        } else {
            Like newLike = new Like();
            newLike.setPostId(postId);
            newLike.setUserId(userId);
            newLike.setLiked(liked);
            return likeRepository.save(newLike);
        }
    }

    public void removeLike(String id) {
        likeRepository.deleteById(id);
    }

    public void deleteLikesByPostId(Long postId) {
        likeRepository.deleteByPostId(postId);
    }

    public List<Like> getALlLikes() {
        return likeRepository.findAll();
    }
}
