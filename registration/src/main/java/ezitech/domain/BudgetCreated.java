package ezitech.domain;

import ezitech.domain.*;
import ezitech.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class BudgetCreated extends AbstractEvent {

    private String taskManagementNumber;
    private Object governmentSupportAmount;
    private Double privateRatio;
    private Double privateCashRatio;
    private Object laborCost;
    private Object internalLaborCost;
    private Object externalLaborCost;
    private Object studentResearchCost;
    private Object materialCost;
    private Object researchFacilityCost;
    private Object activityCost;
    private Object indirectCost;
}
