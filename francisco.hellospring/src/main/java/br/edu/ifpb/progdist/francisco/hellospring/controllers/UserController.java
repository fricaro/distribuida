package br.edu.ifpb.progdist.francisco.hellospring.controllers;

import br.edu.ifpb.progdist.francisco.hellospring.models.User;
import br.edu.ifpb.progdist.francisco.hellospring.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {

    UserService userService = new UserService();

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        System.out.println("Here!");
        return ResponseEntity.ok("Hello, Francisco!");
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<User> findAll(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Integer> addUser(@RequestBody User user) {
        this.userService.addUser(user);
        return ResponseEntity.ok(user.getCodigo());
    }
}
