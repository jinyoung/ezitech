package ezitech.domain;

import ezitech.domain.*;
import ezitech.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ExpenseResolutionCreated extends AbstractEvent {

    private String resolutionNumber;
    private String directOrIndirectExpense;
    private String item;
    private String resolutionName;
    private Money totalAmount;
    private String vendorName;
    private String bankName;
    private String bankAccountNumber;
    private String accountOwner;
    private String resolutionContent;
    private List<File> attachments;
    private String approvalStatus;
    private String approvalLine;

    public ExpenseResolutionCreated(ExpenseResolution aggregate) {
        super(aggregate);
    }

    public ExpenseResolutionCreated() {
        super();
    }
}
//>>> DDD / Domain Event
