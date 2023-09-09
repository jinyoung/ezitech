package ezitech.domain;

import ezitech.BudgetApplication;
import ezitech.domain.BudgetCreated;
import ezitech.domain.BudgetDeleted;
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

    @Embedded
    private Money studentResearchCost;

    private Double privateRatio;

    private Double privateCashRatio;

    @Embedded
    private Money laborCost;

    @Embedded
    private Money internalLaborCost;

    @Embedded
    private Money externalLaborCost;

    @Embedded
    private Money studentResearchCost;

    private MaterialCost materialCost;

    private ResearchFacilityCost researchFacilityCost;

    private ActivityCost activityCost;

    private IndirectCost indirectCost;

    @Embedded
    private ProjectMasterId projectMasterId;

    @PostPersist
    public void onPostPersist() {
        BudgetCreated budgetCreated = new BudgetCreated(this);
        budgetCreated.publishAfterCommit();

        BudgetDeleted budgetDeleted = new BudgetDeleted(this);
        budgetDeleted.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

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
