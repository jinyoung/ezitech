package ezitech.domain;

import ezitech.domain.*;
import ezitech.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ExpenseExecutionClosureCanceled extends AbstractEvent {

    public ExpenseExecutionClosureCanceled(Project aggregate) {
        super(aggregate);
    }

    public ExpenseExecutionClosureCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
