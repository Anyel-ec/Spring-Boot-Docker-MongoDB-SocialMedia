package top.anyel.rrss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.anyel.rrss.model.Comment;
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

    @GetMapping("/contarComentariosPorPost/{postId}")
    public int countCommentsByPostId(@PathVariable Long postId) {
        return commentService.countCommentsByPostId(postId);
    }

    @PostMapping("/save")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

}
