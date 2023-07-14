package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {

}
