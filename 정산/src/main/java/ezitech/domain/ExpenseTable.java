package ezitech.domain;

import ezitech.정산Application;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ExpenseTable_table")
@Data
//<<< DDD / Aggregate Root
public class ExpenseTable {

    @Id
    private String item;

    private Money plannedBudget;

    private Money budgetChange;

    private Money executionAmount;

    private Money approvedExecutionAmount;

    private Money balance;

    public static ExpenseTableRepository repository() {
        ExpenseTableRepository expenseTableRepository = 정산Application.applicationContext.getBean(
            ExpenseTableRepository.class
        );
        return expenseTableRepository;
    }
}
//>>> DDD / Aggregate Root
