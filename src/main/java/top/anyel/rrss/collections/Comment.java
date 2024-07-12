package top.anyel.rrss.collections;


import lombok.Data;
import lombok.Generated;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document
public class Comment {

    @Id
    private String id;
    private Long postId;
    private Long userId;
    private String content;
    private LocalDateTime timeCreated;

    @DBRef // relations if one comment has many responses
    private List<CommentResponse> responses;


    public Comment() {
        this.timeCreated = LocalDateTime.now();
        if (responses != null) {
            responses.forEach(reply -> {
                if (reply.getId() == null) {
                    reply.setId(UUID.randomUUID().toString());
                }
            });
        }
    }
}
