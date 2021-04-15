package com.emilie.Lib7.Repositories;

import com.emilie.Lib7.Models.Entities.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {

    Optional<Copy> findById(Long id);

    Copy save(Copy copy);


}