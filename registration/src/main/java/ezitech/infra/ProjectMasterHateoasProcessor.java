package ezitech.infra;

import ezitech.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProjectMasterHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ProjectMaster>> {

    @Override
    public EntityModel<ProjectMaster> process(
        EntityModel<ProjectMaster> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "//projects/{projectId}"
                )
                .withRel("/projects/{projectId}")
        );

        return model;
    }
}
