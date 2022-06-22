package com.springboot.api.repository;

import com.springboot.api.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends
        PagingAndSortingRepository<Work, Long>,
        JpaRepository<Work, Long> {
    // all crud database methods
    List<Work> findByFilmId(String filmId);
    List<Work> findByActorId(String actorId);


}
