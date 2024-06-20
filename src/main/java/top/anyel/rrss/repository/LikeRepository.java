package top.anyel.rrss.repository;

import org.springframework.stereotype.Repository;
import top.anyel.rrss.model.Like;

import java.util.ArrayList;
import java.util.List;
@Repository
public class LikeRepository {

    List<Like> likes = new ArrayList<>();

    public Like addLike(Like like) {
        likes.add(like);
        return like;
    }

    public List<Like> getAll (){
        return likes;
    }


}
