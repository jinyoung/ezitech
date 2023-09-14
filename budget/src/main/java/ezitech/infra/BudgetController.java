package ezitech.infra;

import ezitech.domain.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/budgets")
@Transactional
public class BudgetController {

    @Autowired
    BudgetRepository budgetRepository;

    @RequestMapping(
        value = "budgets/{id}//budgets/{taskManagementNumber}",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Budget updateBudget(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateBudgetCommand updateBudgetCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /budget/updateBudget  called #####");
        Optional<Budget> optionalBudget = budgetRepository.findById(id);

        optionalBudget.orElseThrow(() -> new Exception("No Entity Found"));
        Budget budget = optionalBudget.get();
        budget.updateBudget(updateBudgetCommand);

        budgetRepository.save(budget);
        return budget;
    }
}
//>>> Clean Arch / Inbound Adaptor
