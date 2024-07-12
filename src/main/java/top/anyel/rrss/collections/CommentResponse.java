package top.anyel.rrss.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
@AllArgsConstructor
public class CommentResponse {
    @Id
    private String id;
    private Long userId;
    private String content;
    private LocalDateTime timeCreated;
}
