package com.vitech.identity_service.repository;

import com.vitech.identity_service.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String email);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u " +
            "WHERE SIZE(u.role) = :priorityRole " +
            "AND (:search IS NULL OR u.username LIKE %:search% OR u.email LIKE %:search%)")
    Page<User> findByRoles_SizeAndSearch(@Param("priorityRole") int priorityRole,
                                         @Param("search") String search,
                                         Pageable pageable);

    @Query("SELECT u FROM User u WHERE SIZE(u.role) = :priorityRole")
    Page<User> findByRoles_Size(@Param("priorityRole") int priorityRole, Pageable pageable);
}
