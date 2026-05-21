package com.jj.JournalApp.service;

import com.jj.JournalApp.entity.Journalentry;
import com.jj.JournalApp.repository.JournalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class JournalService {

    @Autowired
    private JournalRepo journalRepo;

    public Journalentry createJournalEntry(@RequestBody Journalentry journalentry) {
        Journalentry mujournal = this.journalRepo.save(journalentry);
        return mujournal;
    }

    public List<Journalentry> getAllJournalEntries(Pageable pageable,String search) {
       if(search!=null){
           return this.journalRepo.findByTitle(search,pageable).getContent();
       }
        return this.journalRepo.findAll(pageable).getContent();
    }

    public Journalentry getJournalEntryById(@RequestParam String id) {
        return this.journalRepo.findById(id).orElse(null);
    }

    public void deleteJournalEntryById(@RequestParam String id) {
        this.journalRepo.deleteById(id);
    }

    public Journalentry updateJournalEntry(@RequestBody Journalentry journalentry) {
        return this.journalRepo.save(journalentry);
    }

}
