package top.anyel.rrss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.anyel.rrss.model.Comment;
import top.anyel.rrss.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    CommentService commentService = new CommentService();

    @GetMapping("/obtenerComentarios")
    public List<Comment> getAllComments() {
        return commentService.getComments();
    }

}
