package com.shiv.user.repository;

import com.shiv.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public List<User> findAll();

    public Optional<User> findById(Long id);

}
