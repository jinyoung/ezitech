package ezitech.domain;

import ezitech.domain.*;
import ezitech.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ExpenseExecutionClosed extends AbstractEvent {

    public ExpenseExecutionClosed(Project aggregate) {
        super(aggregate);
    }

    public ExpenseExecutionClosed() {
        super();
    }
}
//>>> DDD / Domain Event
