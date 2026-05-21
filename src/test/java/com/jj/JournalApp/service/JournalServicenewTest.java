package com.jj.JournalApp.service;

import com.jj.JournalApp.entity.Journalentry;
import com.jj.JournalApp.repository.JournalRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class JournalServicenewTest {

    @InjectMocks
    JournalService service;

    @Mock
    JournalRepo journalRepo;

    private Journalentry journalentry;

    @BeforeEach
    void setUp() {
        journalentry = new Journalentry();
        journalentry.setId("1");
    }


    @Test
    public void test(){

        Mockito.when(journalRepo.findById("1")).thenReturn(Optional.of(journalentry));

        Journalentry result = service.getJournalEntryById("1");

        Assertions.assertEquals("1", result.getId());
        verify(journalRepo, Mockito.times(1)).findById("1");

    }


}
