package top.anyel.rrss.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    private String id;
    private Long postId;
    private Long userId;
    private boolean liked;

}

