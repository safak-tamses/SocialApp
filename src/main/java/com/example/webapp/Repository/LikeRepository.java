package com.example.webapp.Repository;

import com.example.webapp.Entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LikeRepository extends JpaRepository<Like,Long> {
}
