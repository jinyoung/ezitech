package ezitech.domain;

import ezitech.RegistrationApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ProjectMaster_table")
@Data
//<<< DDD / Aggregate Root
public class ProjectMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String projectId;

    private String noticeProjectName;

    private String projectManager;

    private String projectName;

    private String rfpName;

    private String researchManager;

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

    @Embedded
    private File projectPlanFile;

    private ParticipationType participationType;

    public static ProjectMasterRepository repository() {
        ProjectMasterRepository projectMasterRepository = RegistrationApplication.applicationContext.getBean(
            ProjectMasterRepository.class
        );
        return projectMasterRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateProject(UpdateProjectCommand updateProjectCommand) {
        //implement business logic here:

        ProjectUpdated projectUpdated = new ProjectUpdated(this);
        projectUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
