package com.example.demojpa.module.system.repository;

import com.example.demojpa.module.system.entity.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkManRepository extends JpaRepository<LinkMan, Long> {
}
