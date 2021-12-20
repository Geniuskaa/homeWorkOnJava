package com.example.hw9.repositories;

import com.example.hw9.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Modifying
    @Query(value = "insert into authorities (username, authority) values (:username, :authority)",
            nativeQuery = true)
    void insertAuthority(@Param("username") String username, @Param("authority") String authority);
}