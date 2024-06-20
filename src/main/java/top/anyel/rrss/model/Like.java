package top.anyel.rrss.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Like {

    private Long likeId;
    private Long postId;
    private Long userId;
    private boolean liked;

}

