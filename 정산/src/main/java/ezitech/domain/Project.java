package ezitech.domain;

import ezitech.domain.ExpenseExecutionClosed;
import ezitech.domain.ExpenseExecutionClosureCanceled;
import ezitech.정산Application;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
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

    @PostPersist
    public void onPostPersist() {
        ExpenseExecutionClosed expenseExecutionClosed = new ExpenseExecutionClosed(
            this
        );
        expenseExecutionClosed.publishAfterCommit();

        ExpenseExecutionClosureCanceled expenseExecutionClosureCanceled = new ExpenseExecutionClosureCanceled(
            this
        );
        expenseExecutionClosureCanceled.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ProjectRepository repository() {
        ProjectRepository projectRepository = 정산Application.applicationContext.getBean(
            ProjectRepository.class
        );
        return projectRepository;
    }
}
//>>> DDD / Aggregate Root
