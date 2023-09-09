package ezitech.domain;

import ezitech.domain.*;
import ezitech.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ProjectCreated extends AbstractEvent {

    private String noticeProjectName;

    public ProjectCreated(ProjectMaster aggregate) {
        super(aggregate);
    }

    public ProjectCreated() {
        super();
    }
}
//>>> DDD / Domain Event
