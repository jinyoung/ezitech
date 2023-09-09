package ezitech.infra;

import ezitech.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ResearcherHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Researcher>> {

    @Override
    public EntityModel<Researcher> process(EntityModel<Researcher> model) {
        return model;
    }
}
