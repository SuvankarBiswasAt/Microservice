package com.shiv.user.serviceImpl;

import com.shiv.user.model.User;
import com.shiv.user.repository.UserRepository;
import com.shiv.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser(){
        List<User> users = this.userRepository.findAll();
        return users;
    }

    @Override
    public User saveUser(User user) {
        user = this.userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }

    @Override
    public Boolean updateUser(User user) {
        if(user.getId() == null) return false;
        Optional<User> ifDBUser = this.userRepository.findById(user.getId());
        if(ifDBUser.isEmpty()) return false;
        User dbUser = ifDBUser.get();
        if(user.getEmail() != null)
            dbUser.setEmail(user.getEmail());
        if(user.getAge() != null)
            dbUser.setAge(user.getAge());
        this.userRepository.save(dbUser);
        return true;
    }

    @Override
    public Boolean deleteUser(User user) {
        if(user.getId() == null) return false;
        Optional<User> ifDBUser = this.userRepository.findById(user.getId());
        if(ifDBUser.isEmpty()) return false;
        User dbUser = ifDBUser.get();
        this.userRepository.delete(dbUser);
        return true;
    }

}
