package ezitech.infra;

import ezitech.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ExpenseResolutionHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ExpenseResolution>> {

    @Override
    public EntityModel<ExpenseResolution> process(
        EntityModel<ExpenseResolution> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "//resolutions/{resolutionNumber}"
                )
                .withRel("/resolutions/{resolutionNumber}")
        );

        return model;
    }
}
