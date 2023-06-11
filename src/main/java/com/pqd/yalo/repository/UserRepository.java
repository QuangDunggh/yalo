package com.pqd.yalo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pqd.yalo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
