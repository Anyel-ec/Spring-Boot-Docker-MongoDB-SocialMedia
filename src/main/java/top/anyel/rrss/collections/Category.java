package top.anyel.rrss.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Category {
    private Long id;
    private String name;
    private String description;
    private List<Post> posts;
}
