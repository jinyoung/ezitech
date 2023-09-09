package ezitech.domain;

import ezitech.domain.*;
import ezitech.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ProjectDeleted extends AbstractEvent {

    private String noticeProjectName;

    public ProjectDeleted(ProjectMaster aggregate) {
        super(aggregate);
    }

    public ProjectDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
