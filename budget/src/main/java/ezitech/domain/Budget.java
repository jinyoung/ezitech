package ezitech.domain;

import ezitech.BudgetApplication;
import ezitech.domain.BudgetCreated;
import ezitech.domain.BudgetDeleted;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "Budget_table")
@Data
//<<< DDD / Aggregate Root
public class Budget {

    @Id
    private String issueManagementNumber;

    private Double privateBurdenRate;

    private Double privateCashBurdenRate;

    @Embedded
    private Money studentResearchExpenses;

    @Embedded
    private Money internalPersonnelExpenses;

    @Embedded
    private Money externalPersonnelExpenses;

    @Embedded
    private Money studentResearchExpenses;

    private MaterialExpenses materialExpenses;

    private ResearchFacilityExpenses researchFacilityExpenses;

    private ActivityExpenses activityExpenses;

    @Embedded
    private ProjectMasterId projectMasterId;

    @Embedded
    private Money governmentSupportFunds;

    @Embedded
    private Money personnelExpenses;

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
