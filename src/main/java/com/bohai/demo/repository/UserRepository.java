package com.bohai.demo.repository;

import com.bohai.demo.entity.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<JpaUser,Long> {

    List<JpaUser> findAllByUsername(String username);
}
