package ezitech.domain;

import ezitech.domain.*;
import ezitech.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ProjectUpdated extends AbstractEvent {

    private String noticeProjectName;

    public ProjectUpdated(ProjectMaster aggregate) {
        super(aggregate);
    }

    public ProjectUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
