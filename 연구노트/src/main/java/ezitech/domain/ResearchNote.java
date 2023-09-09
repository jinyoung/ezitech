package ezitech.domain;

import ezitech.연구노트Application;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ResearchNote_table")
@Data
//<<< DDD / Aggregate Root
public class ResearchNote {

    @Id
    private String researchNoteId;

    private LocalDate date;

    private String author;

    private String content;

    private String signature;

    private String approvalStatus;

    public static ResearchNoteRepository repository() {
        ResearchNoteRepository researchNoteRepository = 연구노트Application.applicationContext.getBean(
            ResearchNoteRepository.class
        );
        return researchNoteRepository;
    }
}
//>>> DDD / Aggregate Root
