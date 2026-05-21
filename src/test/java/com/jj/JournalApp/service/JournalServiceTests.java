package com.jj.JournalApp.service;

import com.jj.JournalApp.repository.JournalRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JournalServiceTests {

    @Autowired
    JournalRepo repository;

    //@Disabled
    @Test
    public void getJournalEntryByIdTest()
    {
        //assertEquals(4,2+4);
        assertNotNull(repository.findById("1").get());
    }

    //@Disabled
    @ParameterizedTest
    @CsvSource({
            "2,2,4",
            "1,1,2",
            "3,3,6"
    })
    public void addTest2(int a, int b,int expected)
    {
        assertEquals(expected,a+b);
        assertNotNull(repository.findById("1").get());
    }

}
