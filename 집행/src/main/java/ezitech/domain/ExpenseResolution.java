package ezitech.domain;

import ezitech.집행Application;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ExpenseResolution_table")
@Data
//<<< DDD / Aggregate Root
public class ExpenseResolution {

    @Id
    private String resolutionNumber;

    private String directOrIndirectExpense;

    private String item;

    private String resolutionName;

    private Money totalAmount;

    private String vendorName;

    private String bankName;

    private String bankAccountNumber;

    private String accountOwner;

    private String resolutionContent;

    private List<File> attachments;

    private String approvalStatus;

    private String approvalLine;

    public static ExpenseResolutionRepository repository() {
        ExpenseResolutionRepository expenseResolutionRepository = 집행Application.applicationContext.getBean(
            ExpenseResolutionRepository.class
        );
        return expenseResolutionRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateExpenseResolution(
        UpdateExpenseResolutionCommand updateExpenseResolutionCommand
    ) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
