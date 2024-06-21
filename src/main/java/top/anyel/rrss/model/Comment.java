package top.anyel.rrss.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Comment {
    private Long id;
    private Long postId;
    private Long userId;
    private String content;
    private LocalDateTime timeCreated;
    private List<Comment> comments;

    // Constructor sin argumentos
    public Comment() {
        this.comments = new ArrayList<>(); // Inicializa la lista en el constructor
    }
}
