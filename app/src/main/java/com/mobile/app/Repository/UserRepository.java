package com.mobile.app.Repository;

import com.mobile.app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    // You can add custom queries or methods here if needed
}
