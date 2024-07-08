package top.anyel.rrss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.anyel.rrss.service.LikeService;

@RestController
@RequestMapping("like")
public class LikeController {
    @Autowired
    private LikeService likeService;

}
