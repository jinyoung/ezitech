package ezitech.domain;

import ezitech.정산Application;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Project_table")
@Data
//<<< DDD / Aggregate Root
public class Project {

    @Id
    private String projectNumber;

    private String projectCode;

    private String projectPeriod;

    private String projectName;

    private ExpenseTable expenseTable;

    private ExpenseTableId expenseTableId;

    public static ProjectRepository repository() {
        ProjectRepository projectRepository = 정산Application.applicationContext.getBean(
            ProjectRepository.class
        );
        return projectRepository;
    }
}
//>>> DDD / Aggregate Root
