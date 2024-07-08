package top.anyel.rrss.collections;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Comment {
    @Id
    @Indexed(unique = true)
    private Long id;
    private Long postId;
    private Long userId;
    private String content;
    private LocalDateTime timeCreated;
}
