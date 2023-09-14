package ezitech.infra;

import ezitech.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class InHireCostHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<InHireCost>> {

    @Override
    public EntityModel<InHireCost> process(EntityModel<InHireCost> model) {
        return model;
    }
}
