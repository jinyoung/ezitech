package ezitech.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateProjectCommand {

    private String noticeProjectName;
    private String projectManager;
    private String projectName;
    private String rfpName;
    private String researchManager;
    private String participationType;
    private Boolean cashBurden;
    private Boolean materialBurden;
    private Long totalProjectCost;
    private Long currentYearProjectCost;
    private Integer totalProjectDuration;
    private String currentYearDuration;
    private String organName;
    private String organBusinessNumber;
    private String organDirector;
    private Date receiptDate;
    private Boolean selectionNotification;
    private Boolean accountAllocation;
    private File projectPlanFile;
}
