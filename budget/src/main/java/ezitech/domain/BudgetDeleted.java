package ezitech.domain;

import ezitech.domain.*;
import ezitech.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BudgetDeleted extends AbstractEvent {

    private String taskManagementNumber;

    public BudgetDeleted(Budget aggregate) {
        super(aggregate);
    }

    public BudgetDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
