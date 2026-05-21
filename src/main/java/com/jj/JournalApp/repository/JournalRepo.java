package com.jj.JournalApp.repository;

import com.jj.JournalApp.entity.Journalentry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepo extends JpaRepository<Journalentry, String> {
   Page<Journalentry> findByTitle(String name, Pageable pageable);
}
