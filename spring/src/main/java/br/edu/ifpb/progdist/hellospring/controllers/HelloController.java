package br.edu.ifpb.progdist.hellospring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        String res = "Hello FRANCISCO!";
        return ResponseEntity.ok(res);
    }
}
