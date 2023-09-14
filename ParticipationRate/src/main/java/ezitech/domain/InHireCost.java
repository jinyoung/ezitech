package ezitech.domain;

import ezitech.ParticipationRateApplication;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "InHireCost_table")
@Data
//<<< DDD / Aggregate Root
public class InHireCost {

    @Id
    private String name;

    private String role;

    private String residentRegistrationNumber;

    private String phoneNumber;

    private String finalEducation;

    private String finalEducationSchool;

    private String finalEducationMajor;

    private Money monthlySalary;

    private Double physicalRatio;

    private Double cashRatio;

    private Integer duration;

    private String department;

    private String nationalResearcherNumber;

    public static InHireCostRepository repository() {
        InHireCostRepository inHireCostRepository = ParticipationRateApplication.applicationContext.getBean(
            InHireCostRepository.class
        );
        return inHireCostRepository;
    }
}
//>>> DDD / Aggregate Root
