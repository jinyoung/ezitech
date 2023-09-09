package ezitech.domain;

import ezitech.ParticipationRateApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Researcher_table")
@Data
//<<< DDD / Aggregate Root
public class Researcher {

    @Id
    private String name;

    private String role;

    private String residentId;

    private String phoneNumber;

    private String highestEducation;

    private String highestEducationSchool;

    private String highestEducationMajor;

    @Embedded
    private Money monthlySalary;

    private Double physicalAllowanceRate;

    private Double cashAllowanceRate;

    private Integer duration;

    private String department;

    private String researcherNumber;

    @Embedded
    private ProjectMasterId projectMasterId;

    public static ResearcherRepository repository() {
        ResearcherRepository researcherRepository = ParticipationRateApplication.applicationContext.getBean(
            ResearcherRepository.class
        );
        return researcherRepository;
    }
}
//>>> DDD / Aggregate Root
