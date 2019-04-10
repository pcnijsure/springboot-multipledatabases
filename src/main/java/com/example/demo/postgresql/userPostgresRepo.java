package com.example.demo.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userPostgresRepo extends JpaRepository<User, Integer> {

}
