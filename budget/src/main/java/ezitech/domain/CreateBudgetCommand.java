package ezitech.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateBudgetCommand {

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
}
