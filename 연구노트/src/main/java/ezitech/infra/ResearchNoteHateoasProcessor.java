package ezitech.infra;

import ezitech.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ResearchNoteHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ResearchNote>> {

    @Override
    public EntityModel<ResearchNote> process(EntityModel<ResearchNote> model) {
        return model;
    }
}
