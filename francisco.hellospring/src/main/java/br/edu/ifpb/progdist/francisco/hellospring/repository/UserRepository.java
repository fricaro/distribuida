package br.edu.ifpb.progdist.francisco.hellospring.repository;

import br.edu.ifpb.progdist.francisco.hellospring.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> usuarios = new ArrayList<>();

    public UserRepository() {
        this.usuarios.add(new User(1, "Ana", 20));
        this.usuarios.add(new User(2, "Carlos", 30));
        this.usuarios.add(new User(3, "João", 25));
        this.usuarios.add(new User(4, "José", 18));
    }

    public List<User> findAll() {
        return this.usuarios;
    }

    public void addUser(User user) {
        this.usuarios.add(user);
    }
}
