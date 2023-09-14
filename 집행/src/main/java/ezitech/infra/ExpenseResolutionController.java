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
// @RequestMapping(value="/expenseResolutions")
@Transactional
public class ExpenseResolutionController {

    @Autowired
    ExpenseResolutionRepository expenseResolutionRepository;

    @RequestMapping(
        value = "expenseResolutions/{id}//resolutions/{resolutionNumber}",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ExpenseResolution updateExpenseResolution(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateExpenseResolutionCommand updateExpenseResolutionCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /expenseResolution/updateExpenseResolution  called #####"
        );
        Optional<ExpenseResolution> optionalExpenseResolution = expenseResolutionRepository.findById(
            id
        );

        optionalExpenseResolution.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        ExpenseResolution expenseResolution = optionalExpenseResolution.get();
        expenseResolution.updateExpenseResolution(
            updateExpenseResolutionCommand
        );

        expenseResolutionRepository.save(expenseResolution);
        return expenseResolution;
    }
}
//>>> Clean Arch / Inbound Adaptor
