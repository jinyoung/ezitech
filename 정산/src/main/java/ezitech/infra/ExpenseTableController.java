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
// @RequestMapping(value="/expenseTables")
@Transactional
public class ExpenseTableController {

    @Autowired
    ExpenseTableRepository expenseTableRepository;
}
//>>> Clean Arch / Inbound Adaptor
