package top.anyel.rrss.collections;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Comment {

    @Id
    private String id;
    private Long postId;
    private Long userId;
    private String content;
    private LocalDateTime timeCreated;

    private List<CommentResponse> responses;


    public Comment() {
        this.timeCreated = LocalDateTime.now();
    }

}
