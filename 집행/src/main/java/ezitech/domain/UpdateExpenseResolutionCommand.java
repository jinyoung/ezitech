package ezitech.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateExpenseResolutionCommand {

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
}
