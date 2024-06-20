package top.anyel.rrss.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private Long id;
    private Long userId;
    private String content;
    private String timeCreated;
    private int likes; // consumir
    private int comments; // consumir
    private List<Comment> commentList; //
}
