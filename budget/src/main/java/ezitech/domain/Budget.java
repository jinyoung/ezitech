package ezitech.domain;

import ezitech.BudgetApplication;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Budget_table")
@Data
//<<< DDD / Aggregate Root
public class Budget {

    @Id
    private String taskManagementNumber;

    private Double privateRatio;

    private Double privateCashRatio;

    private BigDecimal materialCost;

    private BigDecimal researchFacilityCost;

    private BigDecimal activityCost;

    private BigDecimal indirectCost;

    @Embedded
    private ProjectMasterId projectMasterId;

    public static BudgetRepository repository() {
        BudgetRepository budgetRepository = BudgetApplication.applicationContext.getBean(
            BudgetRepository.class
        );
        return budgetRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateBudget(UpdateBudgetCommand updateBudgetCommand) {
        //implement business logic here:

        BudgetUpdated budgetUpdated = new BudgetUpdated(this);
        budgetUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
