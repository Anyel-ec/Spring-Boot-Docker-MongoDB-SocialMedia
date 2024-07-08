package top.anyel.rrss.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private Long commentId;
    private Long userId;
    private String content;
    private LocalDateTime timeCreated;
}
