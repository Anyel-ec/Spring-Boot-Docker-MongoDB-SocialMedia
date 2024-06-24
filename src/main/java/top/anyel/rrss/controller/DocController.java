package top.anyel.rrss.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/doc")
public class DocController {

    // redirigir a swagger: /swagger-ui. mediante url xfa

    @GetMapping("/")
    public ResponseEntity<Void> index() {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/swagger-ui.html")).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
