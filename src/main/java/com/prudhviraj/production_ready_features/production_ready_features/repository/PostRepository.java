package com.prudhviraj.production_ready_features.production_ready_features.repository;

import com.prudhviraj.production_ready_features.production_ready_features.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
