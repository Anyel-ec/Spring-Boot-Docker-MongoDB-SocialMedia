package top.anyel.rrss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.anyel.rrss.service.LikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.rrss.collections.Like;
import top.anyel.rrss.service.LikeService;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @GetMapping("/post/{postId}")
    public List<Like> getLikesByPostId(@PathVariable Long postId) {
        return likeService.getLikesByPostId(postId);
    }

    @GetMapping("/")
    public List<Like> getAllLikes() {
        return likeService.getALlLikes();
    }
    @GetMapping("/post/{postId}/count")
    public long countLikesByPostId(@PathVariable Long postId) {
        return likeService.countLikesByPostId(postId);
    }

    @PostMapping("/post/{postId}/user/{userId}")
    public ResponseEntity<Like> addOrUpdateLike(@PathVariable Long postId, @PathVariable Long userId, @RequestParam boolean liked) {
        Like like = likeService.addOrUpdateLike(postId, userId, liked);
        return ResponseEntity.ok(like);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeLike(@PathVariable String id) {
        likeService.removeLike(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/post/{postId}/delete")
    public ResponseEntity<Void> deleteLikesByPostId(@PathVariable Long postId) {
        likeService.deleteLikesByPostId(postId);
        return ResponseEntity.noContent().build();
    }
}