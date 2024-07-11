package top.anyel.rrss.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class Like {

    private Long likeId;
    private Long postId;
    private Long userId;
    private boolean liked;

}

