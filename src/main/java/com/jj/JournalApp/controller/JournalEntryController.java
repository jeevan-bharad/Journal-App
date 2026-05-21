package com.jj.JournalApp.controller;

import com.jj.JournalApp.entity.Journalentry;
import com.jj.JournalApp.service.JournalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalService journalService;

    @GetMapping
    public List<Journalentry> getJournalEntries(@RequestParam(required = false,defaultValue = "1") Integer pageNumber,
                                                @RequestParam(required = false,defaultValue = "5") Integer pageSize,
                                                @RequestParam(required = false,defaultValue = "id") String sortingField,
                                                @RequestParam(required = false,defaultValue = "ASC") String sortingOrder,
                                                @RequestParam(required = false) String search) {

        Sort order=null;
        if( sortingOrder.equalsIgnoreCase("asc")) 
        {
             order = Sort.by(sortingField).ascending();
        }else if( sortingOrder.equalsIgnoreCase("desc"))
        {
            order = Sort.by(sortingField).descending();
        }
        
        
        List<Journalentry> allJournalEntries = this.journalService.getAllJournalEntries(PageRequest.of(pageNumber-1,pageSize,order),search);
        return allJournalEntries;

    }

    @PostMapping
    public Journalentry addJournalEntry(@Valid  @RequestBody Journalentry journalentry) {
        journalentry.setDate(LocalDateTime.now());
        return this.journalService.createJournalEntry(journalentry);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Journalentry> getJournalEntry(@PathVariable String id) {
        Journalentry journalEntryById = this.journalService.getJournalEntryById(id);
        if (journalEntryById != null) {
            return new ResponseEntity<>(journalEntryById, HttpStatus.OK);
        }
        // return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/{id}")
    public void deleteJournalEntry(@PathVariable String id) {
        journalService.deleteJournalEntryById(id);
    }

    @PutMapping
    public Journalentry updateJournalEntry(@RequestBody Journalentry journalentry) {
        return journalService.updateJournalEntry(journalentry);
    }

}
