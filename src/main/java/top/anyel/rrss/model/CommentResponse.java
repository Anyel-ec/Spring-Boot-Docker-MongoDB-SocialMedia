package top.anyel.rrss.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private Long commentId;
    private Long userId;
    private String content;
    private LocalDateTime timeCreated;
}
