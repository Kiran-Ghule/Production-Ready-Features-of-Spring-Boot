package com.week4.production_Ready.repositories;

import com.week4.production_Ready.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<PostEntity,Long> {

}
