package top.anyel.rrss.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    private Long id;
    private Long postId;
    private Long userId;
    private String content;
}
