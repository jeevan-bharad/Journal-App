package com.jj.JournalApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class Journalentry {

    @Id
    @NotEmpty(message = "id cant be null and empty")
    private String id;
    @NotEmpty(message = "title cant be null and empty")
    private String title;
    @NotEmpty(message = "content cant be null and empty")
    private String content;
   // @NotEmpty(message = "date cant be null and empty")
    private LocalDateTime date;

}

