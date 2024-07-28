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

    @PutMapping("/{id}/update")
    public ResponseEntity<Comment> updateComment(@PathVariable String id, @RequestBody Comment updatedComment) {
        Comment existingComment = commentService.getCommentById(id);
        if (existingComment != null) {
            Comment updated = commentService.updateComment(id, updatedComment);
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }


    // Endpoint para agregar respuesta a un comentario
    @DeleteMapping("/{id}/delete")
    public void deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
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


    /*@PostMapping("/{commentId}/reply")
    public ResponseEntity<Comment> addReplyToComment(@PathVariable Long commentId, @RequestBody Comment reply) {
        Comment savedReply = commentService.addReplyToComment(commentId, reply);
        return ResponseEntity.ok(savedReply);
    }*/

}
