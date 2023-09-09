package ezitech.domain;

import ezitech.domain.*;
import ezitech.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BudgetUpdated extends AbstractEvent {

    private String taskManagementNumber;
    private Money governmentSupportAmount;
    private Double privateRatio;
    private Double privateCashRatio;
    private Money laborCost;
    private Money internalLaborCost;
    private Money externalLaborCost;
    private Money studentResearchCost;
    private MaterialCost materialCost;
    private ResearchFacilityCost researchFacilityCost;
    private ActivityCost activityCost;
    private IndirectCost indirectCost;

    public BudgetUpdated(Budget aggregate) {
        super(aggregate);
    }

    public BudgetUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
