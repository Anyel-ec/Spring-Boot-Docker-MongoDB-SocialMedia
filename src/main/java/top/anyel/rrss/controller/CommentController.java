package top.anyel.rrss.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.rrss.collections.Comment;
import top.anyel.rrss.collections.CommentResponse;
import top.anyel.rrss.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public List<Comment> getAllComments() {
        return commentService.getComments();
    }

    // Endpoint para agregar comentario
    @PostMapping("/save")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.addComment(comment);
        return ResponseEntity.ok(savedComment);
    }


    @GetMapping("/count/{postId}")
    public int countCommentsByPostId(@PathVariable Long postId) {
        return commentService.countCommentsByPostId(postId);
    }


    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @PutMapping("/post/{postId}/comment/{id}/update")
    public ResponseEntity<Comment> updateCommentByPostId(@PathVariable Long postId, @PathVariable String id, @RequestBody Comment updatedComment) {
        Comment updated = commentService.updateCommentByPostId(postId, id, updatedComment);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/{commentId}/response")
    public ResponseEntity<Comment> addResponseToComment(@PathVariable String commentId, @RequestBody CommentResponse response) {
        Comment updatedComment = commentService.addResponseToComment(commentId, response);
        if (updatedComment != null) {
            return ResponseEntity.ok(updatedComment);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/post/{postId}/delete")
    public ResponseEntity<Void> deleteCommentsByPostId(@PathVariable Long postId) {
        commentService.deleteCommentsByPostId(postId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Comment> updateComment(@PathVariable String id, @RequestBody Comment updatedComment, @RequestParam Long userId) {
        Comment updated = commentService.updateComment(id, updatedComment, userId);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteComment(@PathVariable String id, @RequestParam Long userId) {
        commentService.deleteComment(id, userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{commentId}/response/{responseId}/update")
    public ResponseEntity<Comment> updateResponse(@PathVariable String commentId, @PathVariable String responseId, @RequestBody CommentResponse updatedResponse, @RequestParam Long userId) {
        Comment updatedComment = commentService.updateResponse(commentId, responseId, updatedResponse, userId);
        if (updatedComment != null) {
            return ResponseEntity.ok(updatedComment);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{commentId}/response/{responseId}/delete")
    public ResponseEntity<Comment> deleteResponse(@PathVariable String commentId, @PathVariable String responseId, @RequestParam Long userId) {
        Comment updatedComment = commentService.deleteResponse(commentId, responseId, userId);
        if (updatedComment != null) {
            return ResponseEntity.ok(updatedComment);
        }
        return ResponseEntity.notFound().build();
    }


}
