package br.edu.ifpb.progdist.francisco.hellospring.services;

import br.edu.ifpb.progdist.francisco.hellospring.models.User;
import br.edu.ifpb.progdist.francisco.hellospring.repository.UserRepository;

import java.util.List;


public class UserService {
    private UserRepository userRepository = new UserRepository();

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(int id) {
        return this.findAll().stream().filter(v -> v.getCodigo() == id).findFirst().orElseThrow();
    }

    public void addUser(User user) {
        this.userRepository.addUser(user);
    }
}
